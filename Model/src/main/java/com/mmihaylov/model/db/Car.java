package com.mmihaylov.model.db;

import com.mmihaylov.model.enums.Currency;
import com.mmihaylov.model.enums.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CAR")
public class Car extends BaseDbEntity implements DbEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "BRAND")
	private String brand;
	
	@Column(name = "MODEL")
	private String model;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "STATUS")
	private Status status;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "CURRENCY")
	private Currency currency;
	
	@Column(name = "YEAR")
	private int year;
	
	@Column(name = "MILEAGE")
	private long mileage;
	
	@Column(name = "FIRST_REGISTRATION")
	private Date firstRegistration;

	@OneToMany( mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Image> images = new ArrayList<Image>();
		
	public Car() {
		
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

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public void addImage(Image image) {
		this.images.add(image);
		image.setCar(this);
	}

	public void removeImage(Image image) {
		this.images.remove(image);
	}
}
