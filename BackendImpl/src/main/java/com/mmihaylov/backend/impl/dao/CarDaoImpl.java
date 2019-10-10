package com.mmihaylov.backend.impl.dao;

import com.mmihaylov.backend.facade.dao.BaseJpaDao;
import com.mmihaylov.backend.facade.dao.CarDao;
import com.mmihaylov.model.db.Car;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class CarDaoImpl extends BaseJpaDao<Car, Long> implements CarDao {

	@Override
	public Class<Car> getClazz() {
		return Car.class;
	}

	@Override
	public List<Car> getPageList(int page, int pageSize) {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
		Root<Car> from = criteriaQuery.from(Car.class);
		CriteriaQuery<Car> select = criteriaQuery.select(from);
		TypedQuery<Car> typedQuery = getEntityManager().createQuery(select);
		typedQuery.setFirstResult(page);
		typedQuery.setMaxResults(pageSize);
		return typedQuery.getResultList();
	}
}
