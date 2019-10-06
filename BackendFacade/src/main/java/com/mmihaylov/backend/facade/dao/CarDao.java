package com.mmihaylov.backend.facade.dao;

import com.mmihaylov.model.db.Car;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface CarDao extends JpaDao<Car, Long> {

}
