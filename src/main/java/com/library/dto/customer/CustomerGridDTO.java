package com.library.dto.customer;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CustomerGridDTO {

    @Getter @Setter private String membershipNumber;

    @Getter @Setter private String fullName;

    @Getter @Setter private LocalDate membershipExpireDate;
}
