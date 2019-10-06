package com.mmihaylov.backend.facade.service;

import com.mmihaylov.model.db.ImportCarTask;
import com.mmihaylov.model.dto.ImportCarRequestDto;

import javax.ejb.Local;

@Local
public interface ImportCarTaskService {

    ImportCarTask createTask(ImportCarRequestDto importCarRequestDto);


    ImportCarTask processTask(Long id);
}
