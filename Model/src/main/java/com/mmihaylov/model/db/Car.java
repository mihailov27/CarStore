package com.mmihaylov.model.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.mmihaylov.model.dto.Currency;
import com.mmihaylov.model.dto.Status;

@Entity
@Table(name = "car")
public class Car extends BaseDbEntity implements DbEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "model")
	private String model;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	@Column(name = "price")
	private Double price;
	
	@Enumerated(EnumType.ORDINAL)
	private Currency currency;
	
	@Lob
	@Column(columnDefinition = "BLOB")
	private byte[] image;
	
	@Column(name = "year")
	private int year;
	
	@Column
	private long mileage;
	
	@Column
	private Date firstRegistration;
		
	public Car() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Date getFirstRegistration() {
		return firstRegistration;
	}

	public void setFirstRegistration(Date firstRegistration) {
		this.firstRegistration = firstRegistration;
	}
}
