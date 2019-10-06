package com.mmihaylov.backend.facade.service;

import javax.ejb.Local;

@Local
public interface ImportCarTaskHandler {

    void processImporCarTask(long importCarTaskId);

}
