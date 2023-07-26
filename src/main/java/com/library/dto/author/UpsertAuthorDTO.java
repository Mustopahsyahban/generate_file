package com.library.dto.author;

import com.library.validation.After;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@After(message="Kamu tidak Bisa memasukan kematian sebelum tanggal lahir.",
        previousDateField="birthDate", subsequentDateField="deceasedDate")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UpsertAuthorDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter @Setter private Long id;

    @Size(max = 10, message = "Masukan title tidak lebih dari 10, Masukan Lagi")
    @NotBlank(message = "Mohon Masukan tillte")

    @Getter @Setter  private String title;

    @NotBlank (message = "Masukan Nama Depan")
    @Size (max = 50 , message = "Masukan nama depan tidak boleh lebih dari 50")

    @Getter @Setter  private String firstName;

    @Size(max = 50, message = "masukan Nama belakang tidak boleh lebih dari 50")

    @Getter @Setter  private String lastName;

   //@NotBlank(message = "masukan Tanggal, tanggal tidak boleh kosong")
    @NotNull
   @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "BirthDate")

    @Getter @Setter  private LocalDate birthDate;


    @Column(name = "DeceasedDate")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Getter @Setter  private LocalDate deceasedDate;

    @Size(max = 50, message = "masukan Education tidak boleh lebih dari 50")

    @Getter @Setter  private String education;

    @Size(max = 500, message = "Summary tidak boleh lebih dari 500")

    @Getter @Setter  private String summary;
}
