package com.mmihaylov.backend.impl.dao;


import com.mmihaylov.backend.facade.dao.BaseJpaDao;
import com.mmihaylov.backend.facade.dao.ImageDao;
import com.mmihaylov.model.db.Image;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ImageDaoImpl extends BaseJpaDao<Image, Long> implements ImageDao {

    @Override
    public Class<Image> getClazz() {
        return Image.class;
    }

    @Override
    public List<Long> getImageIdsByCarId(Long carId) {
        TypedQuery<Long> query = this.getEntityManager()
                .createNamedQuery(Image.GET_IMAGE_ID_BY_CAR_ID, Long.class);
        query.setParameter("carId", carId);
        return query.getResultList();
    }

    @Override
    public List<Image> getPageList(int page, int pageSize) {
        throw new UnsupportedOperationException("The page list query is not supported for Images.");
    }
}
