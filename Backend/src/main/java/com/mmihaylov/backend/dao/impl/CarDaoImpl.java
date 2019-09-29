package com.mmihaylov.backend.dao.impl;

import com.mmihaylov.backend.dao.core.BaseJpaDao;
import com.mmihaylov.backend.dao.core.JpaDao;
import com.mmihaylov.model.db.Car;

import javax.ejb.Stateless;

@Stateless(name = "carDao")
public class CarDaoImpl extends BaseJpaDao<Car, Long> implements JpaDao<Car, Long> {

	@Override
	public Class<Car> getClazz() {
		return Car.class;
	}
}
