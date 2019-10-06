package com.mmihaylov.backend.facade.dao;

import com.mmihaylov.model.db.DbEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public abstract class BaseJpaDao<T extends DbEntity, P extends Serializable>
		implements JpaDao<T, P> {
	
	@PersistenceContext(unitName = "CarStore")
	private EntityManager entityManager;
	
	public T find(P key) {
		return this.entityManager.find(getClazz(), key);
	}

	public void delete(P key) {
		T entity = this.find(key);
		this.entityManager.remove(entity);
	}

	public T update(T entity) {
		return this.entityManager.merge(entity);
	}

	public T create(T entity) {
		this.entityManager.persist(entity);
		this.entityManager.flush();
		return entity;
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	public abstract Class<T> getClazz();
}
