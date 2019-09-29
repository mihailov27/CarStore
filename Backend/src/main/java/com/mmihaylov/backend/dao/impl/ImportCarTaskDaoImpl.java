package com.mmihaylov.backend.dao.impl;

import com.mmihaylov.backend.dao.core.BaseJpaDao;
import com.mmihaylov.backend.dao.core.ImportCarTaskDao;
import com.mmihaylov.model.db.ImportCarTask;

import javax.ejb.Stateless;

@Stateless
public class ImportCarTaskDaoImpl extends BaseJpaDao<ImportCarTask, Long> implements ImportCarTaskDao {

    @Override
    public Class<ImportCarTask> getClazz() {
        return ImportCarTask.class;
    }
}
