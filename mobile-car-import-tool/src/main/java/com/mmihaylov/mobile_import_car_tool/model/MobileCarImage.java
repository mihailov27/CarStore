package com.mmihaylov.mobile_import_car_tool.model;

public class MobileCarImage {

    private byte[] imgBytes;

    public MobileCarImage() {

    }

    public MobileCarImage(byte[] imgBytes) {
        this.imgBytes = imgBytes;
    }

    public byte[] getImgBytes() {
        return imgBytes;
    }

    public void setImgBytes(byte[] imgBytes) {
        this.imgBytes = imgBytes;
    }
}
