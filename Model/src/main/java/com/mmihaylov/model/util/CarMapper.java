package com.mmihaylov.model.util;

import com.mmihaylov.model.db.Car;
import com.mmihaylov.model.dto.CarDto;

public class CarMapper implements EntityDtoMapper<Car, CarDto> {

    public CarMapper(){

    }

    @Override
    public CarDto toDto(Car car) {
        if (car == null) {
            return null;
        } else {
            CarDto carDto = new CarDto();
            carDto.setId(car.getId());
            carDto.setBrand(car.getBrand());
            carDto.setModel(car.getModel());
            carDto.setStatus(car.getStatus());
            carDto.setYear(car.getYear());
            carDto.setFirstRegistration(car.getFirstRegistration());
            carDto.setPrice(car.getPrice());
            carDto.setCurrency(car.getCurrency());
            carDto.setMileage(car.getMileage());
            return carDto;
        }
    }
}
