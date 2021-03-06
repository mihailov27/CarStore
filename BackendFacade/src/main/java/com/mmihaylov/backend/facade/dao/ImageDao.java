package com.mmihaylov.backend.facade.dao;

import com.mmihaylov.model.db.Image;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ImageDao extends JpaDao<Image, Long> {

    List<Long> getImageIdsByCarId(Long carId);

}
