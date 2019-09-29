package com.mmihaylov.model.db;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

public class Image extends BaseDbEntity {

	@Column
	private Long id;
	
	@Lob
	@Column(columnDefinition = "BLOB")
	private byte[] imageBytes;
	
	@Column
	@ManyToOne
	private Car car;
	
	public Image() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImageBytes() {
		return imageBytes;
	}

	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
