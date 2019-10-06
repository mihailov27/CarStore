package com.mmihaylov.model.db;

import java.io.Serializable;

public interface DbEntity extends Serializable {
	
	Long getId();

	void setId(Long id);

}
