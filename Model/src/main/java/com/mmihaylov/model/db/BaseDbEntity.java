package com.mmihaylov.model.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public abstract class BaseDbEntity implements DbEntity {

	@Column(name = "CREATED")
	private Date created;
	
	@Column(name = "UPDATED")
	private Date updated;
	
	@Column(name = "VERSION")
	private Long version;
	
	public BaseDbEntity() {
		
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@PrePersist
	public void prePersist() {
		this.version = 0L;
		this.created = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		this.version++;
		this.updated = new Date();
	}
}
