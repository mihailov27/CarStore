package com.mmihaylov.backend.impl.service;

import com.mmihaylov.backend.facade.CarStoreException;
import com.mmihaylov.backend.facade.service.ImportCarTaskHandler;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.security.AlgorithmConstraints;
import java.util.logging.Logger;

@Stateless
public class ImportCarTaskHandlerImpl implements ImportCarTaskHandler {

    private static final Logger LOGGER = Logger.getLogger(ImportCarTaskHandlerImpl.class.getName());

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Asynchronous
    @Override
    public void processImporCarTask(long importCarTaskId) {

        LOGGER.info("Start processin a new import cart task with id: " + importCarTaskId);

        throw new CarStoreException("Failed to process the task with id:" + importCarTaskId);
    }
}
