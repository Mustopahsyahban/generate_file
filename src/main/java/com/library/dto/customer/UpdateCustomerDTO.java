package com.library.dto.customer;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UpdateCustomerDTO {

    @NotBlank (message =" tidak Boleh Kosong" )
    @Size(max = 20 , message = "tidak Boleh lebih dari 20")
    @Getter @Setter private String membershipNumber;

    @NotBlank(message = "Tidak boleh Kosong")
    @Size(max = 50, message = "Maksimal 50")
    @Getter @Setter private String firstName;

    @Size(max = 50, message = "Maksimal 50")
    @Getter @Setter private String lastName;

    @NotNull
    @DateTimeFormat (pattern = "yyyy/MM/dd")
    @Getter @Setter private LocalDate birthDate;

    @NotBlank(message = "tidak boleh kosong")
    @Size(max = 10, message = "Maksimal 50")
    @Getter @Setter private String gender;

    @Size(max = 20, message = "maksimal 20")
    @Getter @Setter private String phone;

    @Size(max = 500, message = "maksimal 500")
    @Getter @Setter private String address;

    @DateTimeFormat (pattern = "yyyy/MM/dd")
    @Getter @Setter private LocalDate membershipExpireDate ;
}
