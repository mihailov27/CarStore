package com.mmihaylov.backend.facade.dao;

import com.mmihaylov.model.db.ImportCarTask;

import javax.ejb.Remote;

@Remote
public interface ImportCarTaskDao extends JpaDao<ImportCarTask, Long> {

}
