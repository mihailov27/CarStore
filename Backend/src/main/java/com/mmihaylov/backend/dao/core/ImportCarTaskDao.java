package com.mmihaylov.backend.dao.core;

import com.mmihaylov.model.db.ImportCarTask;

import javax.ejb.Local;

@Local
public interface ImportCarTaskDao extends JpaDao<ImportCarTask, Long> {

}
