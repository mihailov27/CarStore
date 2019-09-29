package com.mmihaylov.model.dto;

import java.io.Serializable;
import java.util.Date;

public class CarDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String brand;
	
	private String model;
	
	private Status status;
	
	private Double price;
	
	private Currency currency;
	
	private byte[] image;
	
	private int year;
	
	private long mileage;
	
	private Date added;
	
	public CarDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public long getMileage() {
		return mileage;
	}

	public void setMileage(long mileage) {
		this.mileage = mileage;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof CarDto)) {
			return false;
		}
		CarDto other = (CarDto) obj;
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
