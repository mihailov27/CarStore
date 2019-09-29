package com.mmihaylov.model.db;

import java.util.Date;

import javax.persistence.Column;

public abstract class BaseDbEntity implements DbEntity {

	@Column
	private Date created;
	
	@Column
	private String createdBy;
	
	@Column
	private Date updated;
	
	@Column
	private String updatedBy;
	
	@Column(name = "version")
	private Long version;
	
	public BaseDbEntity() {
		
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
