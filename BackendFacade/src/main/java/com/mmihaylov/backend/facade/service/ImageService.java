package com.mmihaylov.backend.facade.service;

import com.mmihaylov.model.dto.CarImagesDto;

import javax.ejb.Local;

@Local
public interface ImageService {

    CarImagesDto getCarImagesDto(Long carId);

    byte[] getImageData(Long imageId);

    Long createImage(Long carId, byte[] data);

    void deleteImageId(Long imageId);

    void updateImage(Long imageId, byte[] data);
}
