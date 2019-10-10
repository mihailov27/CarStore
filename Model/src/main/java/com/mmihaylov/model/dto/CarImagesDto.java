package com.mmihaylov.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarImagesDto implements Serializable {

    private Long carId;

    private List<Long> images = new ArrayList<>();

    private int countImages;

    public CarImagesDto() {

    }

    public CarImagesDto(Long carId, List<Long> images) {
        this.carId = carId;
        this.images = images;
        this.countImages = images == null ? 0 : images.size();
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public List<Long> getImages() {
        return images;
    }

    public void setImages(List<Long> images) {
        this.images = images;
    }

    public int getCountImages() {
        return countImages;
    }

    public void setCountImages(int countImages) {
        this.countImages = countImages;
    }
}
