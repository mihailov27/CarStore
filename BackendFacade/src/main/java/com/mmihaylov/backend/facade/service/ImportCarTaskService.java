package com.mmihaylov.backend.facade.service;

import com.mmihaylov.model.dto.ImportCarRequestDto;
import com.mmihaylov.model.dto.ImportCarTaskDto;

import javax.ejb.Local;

@Local
public interface ImportCarTaskService {

    ImportCarTaskDto createTask(ImportCarRequestDto importCarRequestDto);

    ImportCarTaskDto getImportTaskStatus(Long id);
}
