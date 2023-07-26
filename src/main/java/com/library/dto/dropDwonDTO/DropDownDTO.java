package com.library.dto.dropDwonDTO;

import lombok.Getter;
import lombok.Setter;

public class DropDownDTO {
    @Getter
    @Setter
    private Long longValue;
    @Getter @Setter private String stringValue;
    @Getter @Setter private String text;

    public DropDownDTO(Long longValue, String text) {
        this.longValue = longValue;
        this.text = text;
    }

    public DropDownDTO(String stringValue, String text) {
        this.stringValue = stringValue;
        this.text = text;
    }

}
