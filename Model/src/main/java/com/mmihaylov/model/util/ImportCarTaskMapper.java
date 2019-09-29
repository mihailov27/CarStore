package com.mmihaylov.model.util;

import com.mmihaylov.model.db.ImportCarTask;
import com.mmihaylov.model.dto.ImportCarTaskDto;

public final class ImportCarTaskMapper {

    private ImportCarTaskMapper() {

    }

    public static ImportCarTaskDto toDto(ImportCarTask entity) {
        if (entity == null) {
            return null;
        } else {
            ImportCarTaskDto dto = new ImportCarTaskDto();
            dto.setId(entity.getId());
            dto.setCarId(entity.getCar() == null ? null : entity.getCar().getId());
            dto.setError(entity.getError());
            dto.setTaskStatus(entity.getStatus());
            dto.setCreated(entity.getCreated());
            dto.setUpdated(entity.getUpdated());
            return dto;
        }
    }

}
