package com.mmihaylov.model.util;

import com.mmihaylov.model.db.DbEntity;

import java.io.Serializable;

public interface EntityDtoMapper<E extends DbEntity, D extends Serializable> {

    D toDto(E entity);
}
