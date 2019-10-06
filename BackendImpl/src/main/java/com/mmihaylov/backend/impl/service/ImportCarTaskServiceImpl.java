package com.mmihaylov.backend.impl.service;

import com.mmihaylov.backend.facade.CarStoreException;
import com.mmihaylov.backend.facade.dao.ImportCarTaskDao;
import com.mmihaylov.backend.facade.service.ImportCarTaskHandler;
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

    @EJB
    private ImportCarTaskHandler importCarTaskHandler;

    // EJB public methods

    @Override
    public ImportCarTask createTask(ImportCarRequestDto importCarRequestDto) {
        LOGGER.fine("Creating a new ImportCarTask.");
        ImportCarTask importCarTask = new ImportCarTask();
        importCarTask.setStatus(TaskStatus.CREATED);
        importCarTask.setSource(importCarRequestDto.getSource());
        importCarTask = this.importCarTaskDao.create(importCarTask);

        // before exit the method, call the handler to start processing (Async bus. method in another transaction).
        importCarTaskHandler.processImporCarTask(importCarTask.getId());

        return importCarTask;
    }

    @Override
    public ImportCarTask processTask(Long id) {

        LOGGER.info("Start working on a ImportCarTask with id: " + id);
        ImportCarTask importCarTask = this.importCarTaskDao.find(id);

        if (importCarTask == null) {
            throw new CarStoreException("No import task found with id: " + id);
        }
        if (importCarTask.getStatus() != TaskStatus.CREATED) {
            throw new CarStoreException("The ImportCarTask record with id: " + id +
                    " can't be processed. The status is: " + importCarTask.getStatus().name());
        }

        importCarTask.setStatus(TaskStatus.PENDING);

        // working on the task.
        workOnTask(importCarTask);

        return importCarTask;
    }

    // Private Methods

    private void workOnTask(ImportCarTask importCarTask) {
        LOGGER.fine("Working on ImportCarTask entry " + importCarTask.getId());

        throw new CarStoreException("failure.");
        //importCarTask.setStatus(TaskStatus.COMPLETED);
    }
}
