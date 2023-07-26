package com.library.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "PriceProduct")
public class PriceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @Getter @Setter private Long id;

    @Column(name = "Product_Name")
    @NotNull(message = "Mohon Masukan Nama Product")
    @Size(max = 50, message = "Nama Product Tidak Boleh Lebih dari 50")
    @Getter @Setter private String productName;


    @Column(name = "Product_Price")
    @NotNull(message = "Mohon Masukan Harga Product")
    @Getter @Setter private Long productPrice;

    @Column(name = "Stock")
    @Getter @Setter private Long stock;


    @Column(name = "Date_Update")
    @Getter @Setter private LocalDate dateUpdate;

    @Column(name = "description")
    @Getter @Setter private String description;


    public PriceProduct(Long id, String productName, Long productPrice,Long stock, String description) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.stock=stock;
        this.description = description;
    }
}
