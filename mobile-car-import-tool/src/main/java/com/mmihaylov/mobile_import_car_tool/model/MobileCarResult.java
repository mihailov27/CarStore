package com.mmihaylov.mobile_import_car_tool.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mmihaylov.model.enums.Currency;

public class MobileCarResult implements Serializable {

    private String brand;

    private String model;

    private Currency currency;

    private Long price;

    private Long mileage;

    private String color;

    private Date firstRegistration;

    private List<MobileCarImage> mobileCarImageList = new ArrayList<>();

    public MobileCarResult() {

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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public List<MobileCarImage> getMobileCarImageList() {
        return mobileCarImageList;
    }

    public void setMobileCarImageList(List<MobileCarImage> mobileCarImageList) {
        this.mobileCarImageList = mobileCarImageList;
    }
}
