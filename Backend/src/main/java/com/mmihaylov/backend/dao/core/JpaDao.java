package com.mmihaylov.backend.dao.core;

import com.mmihaylov.model.db.DbEntity;

import java.io.Serializable;

public interface  JpaDao<T extends DbEntity, P extends Serializable> {

	/** Finding an entity by key. */
	T find(P key);

	/** Deletng an entity by key. */
	void delete(P key);

	/** Updating an entity. */
	T update(T entity);

	/** Creating an entity. */
	T create(T entity);
}
