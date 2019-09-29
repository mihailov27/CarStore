package com.mmihaylov.backend.impl.service;

import com.mmihaylov.backend.facade.CarStoreException;
import com.mmihaylov.backend.facade.dao.ImportCarTaskDao;
import com.mmihaylov.backend.facade.service.ImportCarTaskService;
import com.mmihaylov.model.db.ImportCarTask;
import com.mmihaylov.model.dto.ImportCarRequestDto;
import com.mmihaylov.model.enums.TaskStatus;

import javax.ejb.*;
import java.util.logging.Logger;

@Stateless
public class ImportCarTaskServiceImpl implements ImportCarTaskService {

    private static final Logger LOGGER = Logger.getLogger(ImportCarTaskServiceImpl.class.getName());

    @EJB
    private ImportCarTaskDao importCarTaskDao;

    public ImportCarTask createTask(ImportCarRequestDto importCarRequestDto) {
        LOGGER.fine("Creating a new ImportCarTask.");
        // create and save a new ImportCarTask into the DB.
        ImportCarTask importCarTask = new ImportCarTask();
        importCarTask.setStatus(TaskStatus.CREATED);
        importCarTask.setSource(importCarRequestDto.getSource());
        importCarTask = this.importCarTaskDao.create(importCarTask);

        // start a processing of the task in async method (different transaction)
        processTask(importCarTask.getId());

        return importCarTask;
    }

    public ImportCarTask getImportCarTask(Long id) {
        LOGGER.fine("Finding a ImportCarTask with id: " + id);
        return null;
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    private void processTask(Long id) {
        LOGGER.info("Start working on a ImportCarTask with id: " + id);
        ImportCarTask importCarTask = this.importCarTaskDao.find(id);
        if (importCarTask == null) {
            throw new CarStoreException("There is no ImportCarTask record with id: " + id);
        }

        if (importCarTask.getStatus() != TaskStatus.CREATED) {
            throw new CarStoreException("The ImportCarTask record with id: " + id +
                    " can't be processed. The status is: " + importCarTask.getStatus().name());
        }

        // start processing.
        importCarTask = this.setToPending(importCarTask);
        // working on the task.
        workOnTask(importCarTask);
    }

    /**
     * Setting the task to PENDING status.
     * @param importCarTask
     * @return
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    private ImportCarTask setToPending(ImportCarTask importCarTask) {
        LOGGER.fine("Setting ImportCarTask " + importCarTask.getId() + " to PENDING.");
        importCarTask.setStatus(TaskStatus.PENDING);
        return this.importCarTaskDao.update(importCarTask);
    }

    private void workOnTask(ImportCarTask importCarTask) {
        LOGGER.fine("Working on ImportCarTask entry " + importCarTask.getId());
        importCarTask.setStatus(TaskStatus.COMPLETED);


    }
}
