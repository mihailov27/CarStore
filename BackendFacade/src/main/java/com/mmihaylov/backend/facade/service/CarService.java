package com.mmihaylov.backend.facade.service;

import java.util.List;

import javax.ejb.Local;

import com.mmihaylov.model.db.Car;
import com.mmihaylov.model.dto.CarDto;

@Local
public interface CarService {

	Long create(CarDto carDto);
	
	Car update(Long id, CarDto carDto);
	
	void delete(Long id);
	
	CarDto getCar(Long id);
	
	List<CarDto> getCars(int page, int pageSize);
	
}
