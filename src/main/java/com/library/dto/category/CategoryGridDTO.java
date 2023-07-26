package com.library.dto.category;

import lombok.*;

import javax.persistence.Column;


@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CategoryGridDTO {


    @Getter @Setter private String name;


    @Getter @Setter private Long floor;


    @Getter @Setter private String isle;


    @Getter @Setter private String bay;

    public CategoryGridDTO(String name, Long floor, String isle, String bay) {
        this.name = name;
        this.floor = floor;
        this.isle = isle;
        this.bay = bay;
    }

    @Getter  @Setter private Long totalBook;
}
