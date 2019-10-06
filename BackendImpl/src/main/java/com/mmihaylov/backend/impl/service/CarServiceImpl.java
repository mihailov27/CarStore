package com.mmihaylov.backend.impl.service;

import com.mmihaylov.backend.facade.dao.CarDao;
import com.mmihaylov.backend.facade.service.CarService;
import com.mmihaylov.model.db.Car;
import com.mmihaylov.model.dto.CarDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarServiceImpl implements CarService {
	
	private static final Logger LOGGER = Logger.getLogger(CarServiceImpl.class.getName());

	@EJB
	private CarDao carDao;

	public CarDto find(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<CarDto> get(int size, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	public Car update(CarDto carDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
	public long create(CarDto carDto) {
		// TODO Auto-generated method stub
		return 0;
	}
}
