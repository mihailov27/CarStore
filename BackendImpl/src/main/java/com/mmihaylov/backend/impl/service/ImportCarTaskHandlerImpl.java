package com.mmihaylov.backend.impl.service;

import com.mmihaylov.backend.facade.CarStoreBusinessException;
import com.mmihaylov.backend.facade.dao.ImportCarTaskDao;
import com.mmihaylov.backend.facade.service.ImportCarTaskHandler;
import com.mmihaylov.model.db.ImportCarTask;

import javax.ejb.*;
import java.util.logging.Logger;

@Stateless
public class ImportCarTaskHandlerImpl implements ImportCarTaskHandler {

    private static final Logger LOGGER = Logger.getLogger(ImportCarTaskHandlerImpl.class.getName());

    @EJB
    private ImportCarTaskDao importCarTaskDao;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Asynchronous
    @Override
    public void processImporCarTask(long importCarTaskId) {

        LOGGER.info("Start processin a new import cart task with id: " + importCarTaskId);
        ImportCarTask importCarTask = this.importCarTaskDao.find(importCarTaskId);

        if (importCarTask == null) {
            throw new CarStoreBusinessException("No existing task with id: " + importCarTaskId);
        }



    }
}
