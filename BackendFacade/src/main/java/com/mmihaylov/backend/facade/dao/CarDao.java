package com.mmihaylov.backend.facade.dao;

import javax.ejb.Local;

import com.mmihaylov.model.db.Car;

@Local
public interface CarDao extends JpaDao<Car, Long> {

}
