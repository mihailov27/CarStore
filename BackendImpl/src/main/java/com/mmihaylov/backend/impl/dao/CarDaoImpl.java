package com.mmihaylov.backend.impl.dao;

import com.mmihaylov.backend.facade.dao.BaseJpaDao;
import com.mmihaylov.backend.facade.dao.CarDao;
import com.mmihaylov.model.db.Car;

import javax.ejb.Stateless;

@Stateless
public class CarDaoImpl extends BaseJpaDao<Car, Long> implements CarDao {

	@Override
	public Class<Car> getClazz() {
		return Car.class;
	}
}
