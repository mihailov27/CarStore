package com.mmihaylov.model.db;

import javax.persistence.*;
import java.util.Date;

public abstract class BaseDbEntity implements DbEntity {


	@Column(name = "VERSION")
	@Version
	private Long version;

	@Embedded
	private Audit audit = new Audit();
	
	public BaseDbEntity() {
		
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	@PrePersist
	public void prePersist() {
		this.audit.setCreated(new Date());
	}

	@PreUpdate
	public void preUpdate() {
		this.audit.setUpdated(new Date());
	}

}
