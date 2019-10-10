package com.mmihaylov.backend.impl.service;

import com.mmihaylov.backend.facade.CarStoreBusinessException;
import com.mmihaylov.backend.facade.dao.ImportCarTaskDao;
import com.mmihaylov.backend.facade.service.ImportCarTaskHandler;
import com.mmihaylov.backend.facade.service.ImportCarTaskService;
import com.mmihaylov.model.db.ImportCarTask;
import com.mmihaylov.model.dto.ImportCarRequestDto;
import com.mmihaylov.model.dto.ImportCarTaskDto;
import com.mmihaylov.model.enums.TaskStatus;
import com.mmihaylov.model.util.ImportCarTaskMapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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
    public ImportCarTaskDto createTask(ImportCarRequestDto importCarRequestDto) {
        LOGGER.fine("Creating a new ImportCarTask.");
        ImportCarTask importCarTask = new ImportCarTask();
        importCarTask.setStatus(TaskStatus.CREATED);
        importCarTask.setSource(importCarRequestDto.getSource());
        importCarTask = this.importCarTaskDao.create(importCarTask);

        // before exit the method, call the handler to start processing (Async bus. method in another transaction).
        importCarTaskHandler.processImporCarTask(importCarTask.getId());

        // map to Dto.
        return ImportCarTaskMapper.toDto(importCarTask);
    }

    @Override
    public ImportCarTaskDto getImportTaskStatus(Long id) {
        ImportCarTask importCarTask = this.importCarTaskDao.find(id);
        if (importCarTask == null) {
            throw new CarStoreBusinessException("No ImporTask found with id: " + id);
        } else {
            return ImportCarTaskMapper.toDto(importCarTask);
        }
    }
}
