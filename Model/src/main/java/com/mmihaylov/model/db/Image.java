package com.mmihaylov.model.db;

import javax.persistence.*;

@Entity(name = "IMAGE")
public class Image extends BaseDbEntity implements DbEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Lob
	@Column(name = "DATA")
	private byte[] data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAR_ID")
	private Car car;
	
	public Image() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
