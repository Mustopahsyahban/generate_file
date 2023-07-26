package com.library.dto.productPrice;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ProductPriceUpdateDTO {

    @Getter @Setter private Long id;


    @Size(max = 50, message = "Masukan nama product tidak lebih dari 50 char")
    @Getter @Setter private String productName;

    @NotNull(message = "Masukan harga product")
    @Getter @Setter private Long productPrice;


    @Getter @Setter private Long stock;

    @Getter @Setter private LocalDate dateUpdate;

    @Size(max = 500, message = "Description tidak lebid dari 500 char")
    @Getter @Setter private String desription;


    public ProductPriceUpdateDTO(Long id, String productName, Long productPrice,Long stock, String desription) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.stock=stock;
        this.desription = desription;
    }
}
