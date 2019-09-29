package com.mmihaylov.backend.dao.impl;

import com.mmihaylov.backend.dao.core.BaseJpaDao;
import com.mmihaylov.backend.dao.core.CarDao;
import com.mmihaylov.model.db.Car;

import javax.ejb.Stateless;

@Stateless
public class CarDaoImpl extends BaseJpaDao<Car, Long> implements CarDao {

	@Override
	public Class<Car> getClazz() {
		return Car.class;
	}
}
