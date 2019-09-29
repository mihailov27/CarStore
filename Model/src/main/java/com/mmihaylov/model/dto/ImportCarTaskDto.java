package com.mmihaylov.model.dto;

import com.mmihaylov.model.enums.TaskStatus;

import java.io.Serializable;
import java.util.Date;

public class ImportCarTaskDto implements Serializable {

    private Long id;

    private TaskStatus status;

    private String error;

    private Date created;

    private Date updated;

    private Long carId;

    public ImportCarTaskDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}
