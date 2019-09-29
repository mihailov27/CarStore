package com.mmihaylov.backend.impl.dao;


import com.mmihaylov.backend.facade.dao.BaseJpaDao;
import com.mmihaylov.backend.facade.dao.ImageDao;
import com.mmihaylov.model.db.Image;

import javax.ejb.Stateless;

@Stateless
public class ImageDaoImpl extends BaseJpaDao<Image, Long> implements ImageDao {

    @Override
    public Class<Image> getClazz() {
        return Image.class;
    }
}
