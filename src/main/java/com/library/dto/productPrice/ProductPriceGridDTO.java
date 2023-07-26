package com.library.dto.productPrice;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ProductPriceGridDTO {


    @Getter @Setter private Long id;

    @Getter @Setter private String productName;

    @Getter @Setter private Long productPrice;

    @Getter @Setter private Long stock;

    @Getter @Setter private LocalDate dateUpdate;

}
