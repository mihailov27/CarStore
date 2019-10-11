package com.mmihaylov.backend.impl.service;

import com.mmihaylov.backend.facade.CarStoreBusinessException;
import com.mmihaylov.backend.facade.dao.CarDao;
import com.mmihaylov.backend.facade.service.CarService;
import com.mmihaylov.model.db.Car;
import com.mmihaylov.model.dto.CarDto;
import com.mmihaylov.model.util.CarMapper;
import com.mmihaylov.model.util.EntityDtoMapper;
import sun.security.krb5.internal.PAData;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class CarServiceImpl implements CarService {
	
	private static final Logger LOGGER = Logger.getLogger(CarServiceImpl.class.getName());

	private static final EntityDtoMapper<Car, CarDto> CAR_MAPPER = new CarMapper();

	private static final int MAX_PAGE_SIZE = 100;

	@EJB
	private CarDao carDao;

	public CarDto getCar(Long id) {
		// find the entity from db.
		Car car = this.carDao.find(id);
		return CAR_MAPPER.toDto(car);
	}

	public List<CarDto> getCars(int page, int pageSize) {

		if (page < 0) {
			throw new CarStoreBusinessException("Invalid page number: " + page);
		}
		if (page <= 0 || pageSize > MAX_PAGE_SIZE) {
			throw new CarStoreBusinessException("Invalid page size: " + pageSize);
		}

		List<Car> cars = carDao.getPageList(page, pageSize);
		return cars.stream().map(CAR_MAPPER::toDto)
				.collect(Collectors.toList());
	}

	public Car update(Long id, CarDto carDto) {
		Car car = carDao.find(id);
		if (shouldUpdate(car.getStatus(), carDto.getStatus())) {
			car.setStatus(carDto.getStatus());
		}

		if (shouldUpdate(car.getFirstRegistration(), carDto.getFirstRegistration())) {
			car.setFirstRegistration(carDto.getFirstRegistration());
		}

		if (shouldUpdate(car.getCurrency(), carDto.getCurrency())) {
			car.setCurrency(carDto.getCurrency());
		}

		if (shouldUpdate(car.getPrice(), carDto.getPrice())) {
			car.setPrice(carDto.getPrice());
		}

		if (shouldUpdate(car.getModel(), carDto.getModel())) {
			car.setModel(carDto.getModel());
		}

		if (shouldUpdate(car.getBrand(), carDto.getBrand())) {
			car.setBrand(carDto.getBrand());
		}

		if (shouldUpdate(car.getMileage(), carDto.getMileage())) {
			car.setMileage(carDto.getMileage());
		}

		return this.carDao.update(car);
	}
	
	public void delete(Long id) {
		LOGGER.info("Deleting Cat with ID: " + id);
		Car car = this.carDao.find(id);
		if (car == null) {
			throw new CarStoreBusinessException("The Car with ID " + id + " does not exist.");
		} else {
			this.carDao.delete(id);
		}
	}

	public Long create(CarDto carDto)  {
		Car car = new Car();
		car.setBrand(carDto.getBrand());
		car.setModel(carDto.getModel());
		car.setPrice(carDto.getPrice());
		car.setCurrency(carDto.getCurrency());
		car.setFirstRegistration(carDto.getFirstRegistration());
		car.setMileage(carDto.getMileage());
		car.setStatus(carDto.getStatus());
		// save to db
		Car persistedCar = this.carDao.create(car);
		return persistedCar.getId();
	}

	private static <T> boolean shouldUpdate(T o1, T o2) {
		return o1 == null || !o1.equals(o2);
	}

}
