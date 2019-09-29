package com.mmihaylov.backend.dao.core;

import com.mmihaylov.model.db.Image;

import javax.ejb.Local;

@Local
public interface ImageDao extends JpaDao<Image, Long> {

}
