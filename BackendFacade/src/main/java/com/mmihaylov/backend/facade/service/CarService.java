package com.mmihaylov.backend.facade.service;

import java.util.List;

import javax.ejb.Local;

import com.mmihaylov.model.db.Car;
import com.mmihaylov.model.dto.CarDto;

@Local
public interface CarService {

	long create(CarDto carDto);
	
	Car update(CarDto carDto);
	
	void delete(long id);
	
	CarDto find(long id);
	
	List<CarDto> get(int size, int page);
	
}
