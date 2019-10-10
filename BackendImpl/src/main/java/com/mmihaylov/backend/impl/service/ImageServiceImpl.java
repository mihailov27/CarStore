package com.mmihaylov.backend.impl.service;

import com.mmihaylov.backend.facade.CarStoreBusinessException;
import com.mmihaylov.backend.facade.dao.CarDao;
import com.mmihaylov.backend.facade.dao.ImageDao;
import com.mmihaylov.backend.facade.service.ImageService;
import com.mmihaylov.model.db.Car;
import com.mmihaylov.model.db.Image;
import com.mmihaylov.model.dto.CarImagesDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ImageServiceImpl implements ImageService {

    @EJB
    private ImageDao imageDao;

    @EJB
    private CarDao carDao;

    @Override
    public CarImagesDto getCarImagesDto(Long carId) {
        Car car = this.carDao.find(carId);
        if (car == null) {
            throw new CarStoreBusinessException("Not exisiting car with id: " + carId);
        }
        List<Long> imageIds = this.imageDao.getImageIdsByCarId(carId);
        return new CarImagesDto(carId, imageIds);
    }

    @Override
    public byte[] getImageData(Long imageId) {
        Image image = this.imageDao.find(imageId);
        if (image == null) {
            throw new CarStoreBusinessException("No image found with ID: " + imageId);
        }
        return image.getData();
    }

    @Override
    public Long createImage(Long carId, byte[] data) {
        Image image = new Image();
        Car car = this.carDao.find(carId);
        image.setCar(car);
        image.setData(data);
        this.imageDao.create(image);

        car.addImage(image);
        return image.getId();
    }

    @Override
    public void deleteImageId(Long imageId) {
        this.imageDao.delete(imageId);
    }

    @Override
    public void updateImage(Long imageId, byte[] data) {
        Image image = imageDao.find(imageId);
        if (image == null) {
            throw new CarStoreBusinessException("No image found with id: " + imageId);
        }
        image.setData(data);
    }
}
