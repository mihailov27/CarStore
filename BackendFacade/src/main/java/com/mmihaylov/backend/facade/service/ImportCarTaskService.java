package com.mmihaylov.backend.facade.service;

import com.mmihaylov.model.db.ImportCarTask;
import com.mmihaylov.model.dto.ImportCarRequestDto;

import javax.ejb.Local;

@Local
public interface ImportCarTaskService {

    /**
     * Creating a new ImportCarTask entry by the given request.
     * @param importCarRequestDto
     * @return
     */
    ImportCarTask createTask(ImportCarRequestDto importCarRequestDto);

    /**
     * Returns the ImportCarTask entry by the id.
     * @param id
     * @return
     */
    ImportCarTask getImportCarTask(Long id);
}
