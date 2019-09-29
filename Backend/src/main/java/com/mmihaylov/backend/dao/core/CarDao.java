package com.mmihaylov.backend.dao.core;

import javax.ejb.Local;

import com.mmihaylov.model.db.Car;

@Local
public interface CarDao extends JpaDao<Car, Long> {

}
