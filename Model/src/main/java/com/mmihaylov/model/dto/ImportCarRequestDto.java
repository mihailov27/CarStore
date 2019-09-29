package com.mmihaylov.model.dto;

import java.io.Serializable;

public class ImportCarRequestDto implements Serializable {

    private String source;

    public ImportCarRequestDto() {

    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
