package com.library.entity;

import com.library.validation.UniqueCategoryName;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name="Category")
public class Category {

    @Id
    @Column(name = "Name")
    @Getter @Setter private String name;

    @Column(name = "Floor")
    @Getter @Setter private Long floor;

    @Column(name = "Isle")
    @Getter @Setter private String isle;

    @Column(name = "Bay")
    @Getter @Setter private String bay;



}
