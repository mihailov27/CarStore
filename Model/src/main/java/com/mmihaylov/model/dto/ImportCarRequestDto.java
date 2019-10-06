package com.mmihaylov.model.dto;

import java.io.Serializable;

public class ImportCarRequestDto implements Serializable {

    /**
     * It should be a link from website mobile.de
     * For example:
     * https://suchen.mobile.de/auto-inserat/audi-a4-avant-s-line-sportpaket-shz-klimaautomatik-rosbach/281297408.html?coId=5cd15557-2d60-4d61-813a-bb4ea21e8591&action=homeSponsoredProfileReco
     */
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
