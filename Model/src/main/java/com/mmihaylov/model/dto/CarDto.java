package com.mmihaylov.model.dto;

import com.mmihaylov.model.db.Car;
import com.mmihaylov.model.enums.Currency;
import com.mmihaylov.model.enums.Status;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class CarDto implements Serializable {

	private Long id;

	@NotNull
	private String brand;

	@NotNull
	private String model;

	@NotNull
	private Status status;

	@NotNull
	private Long price;

	@NotNull
	private Currency currency;

	@NotNull
	private Long mileage;

	private Date firstRegistration;
	
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Date getFirstRegistration() {
		return firstRegistration;
	}

	public void setFirstRegistration(Date firstRegistration) {
		this.firstRegistration = firstRegistration;
	}

	public Long getMileage() {
		return mileage;
	}

	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(brand)
				.append(model)
				.append(status)
				.append(price)
				.append(currency)
				.append(mileage)
				.append(firstRegistration)
				.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CarDto)) {
			return false;
		}
		CarDto other = (CarDto) obj;
		return new EqualsBuilder()
				.append(this.id, other.id)
				.append(this.brand, other.brand)
				.append(this.status, other.status)
				.append(this.model, other.model)
				.append(this.price, other.price)
				.append(this.currency, other.currency)
				.append(this.mileage, other.mileage)
				.append(this.firstRegistration, other.firstRegistration)
				.build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(id)
				.append(brand)
				.append(model)
				.append(status)
				.append(price)
				.append(currency)
				.append(mileage)
				.append(firstRegistration)
				.toString();
	}
}
