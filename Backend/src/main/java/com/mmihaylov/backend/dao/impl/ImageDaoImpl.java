package com.mmihaylov.backend.dao.impl;


import com.mmihaylov.backend.dao.core.BaseJpaDao;
import com.mmihaylov.backend.dao.core.ImageDao;
import com.mmihaylov.model.db.Image;

import javax.ejb.Stateless;

@Stateless
public class ImageDaoImpl extends BaseJpaDao<Image, Long> implements ImageDao {

    @Override
    public Class<Image> getClazz() {
        return Image.class;
    }
}
