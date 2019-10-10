package com.mmihaylov.model.util;

import com.mmihaylov.model.db.ImportCarTask;
import com.mmihaylov.model.dto.ImportCarTaskDto;

public final class ImportCarTaskMapper implements EntityDtoMapper<ImportCarTask, ImportCarTaskDto> {

    public ImportCarTaskMapper() {

    }

    @Override
    public ImportCarTaskDto toDto(ImportCarTask importCarTask) {
        if (importCarTask == null) {
            return null;
        } else {
            ImportCarTaskDto dto = new ImportCarTaskDto();
            dto.setId(importCarTask.getId());
            dto.setCarId(importCarTask.getCar() == null ? null : importCarTask.getCar().getId());
            dto.setError(importCarTask.getError());
            dto.setStatus(importCarTask.getStatus());
            dto.setCreated(importCarTask.getAudit().getCreated());
            dto.setUpdated(importCarTask.getAudit().getUpdated());
            return dto;
        }
    }
}
