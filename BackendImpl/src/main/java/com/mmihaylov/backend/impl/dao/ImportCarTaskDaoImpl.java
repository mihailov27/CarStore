package com.mmihaylov.backend.impl.dao;

import com.mmihaylov.backend.facade.dao.BaseJpaDao;
import com.mmihaylov.backend.facade.dao.ImportCarTaskDao;
import com.mmihaylov.model.db.ImportCarTask;

import javax.ejb.Stateless;

@Stateless
public class ImportCarTaskDaoImpl extends BaseJpaDao<ImportCarTask, Long> implements ImportCarTaskDao {

    @Override
    public Class<ImportCarTask> getClazz() {
        return ImportCarTask.class;
    }
}
