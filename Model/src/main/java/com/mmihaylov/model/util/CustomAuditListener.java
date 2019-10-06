package com.mmihaylov.model.util;

import com.mmihaylov.model.db.BaseDbEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class CustomAuditListener {

    @PrePersist
    public void prePersist(BaseDbEntity baseDbEntity) {
        baseDbEntity.getAudit().setCreated(new Date());
    }

    @PreUpdate
    public void preUpdate(BaseDbEntity baseDbEntity) {
        baseDbEntity.getAudit().setUpdated(new Date());
    }
}
