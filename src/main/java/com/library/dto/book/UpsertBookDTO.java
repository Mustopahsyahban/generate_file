package com.library.dto.book;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UpsertBookDTO {

    @NotBlank(message = "masukan Id, Id tidak boleh kosong")
    @Size (max = 20, message = "Id tidak boleh lebih dari 20")
    @Getter @Setter private String id;

    @NotBlank(message = "masukan Title, Title tidak boleh kosong")
    @Size (max = 100, message = "Tittle tidak boleh lebih dari 100")
    @Getter @Setter private String title;

    @NotBlank(message = "masukan Title, Title tidak boleh kosong")

    @Getter @Setter private String categoryName;

    @NotBlank(message = "masukan Title, Title tidak boleh kosong")

    @Getter @Setter private Long authorId;

    @NotBlank(message = "masukan Title, Title tidak boleh kosong")

    @Getter @Setter private Boolean isBorrowed ;
    @Setter @Getter private String borrowed;


    @Size (max = 100, message = "Tittle tidak boleh lebih dari 100")
    @Getter @Setter private String summary;


    @Getter @Setter private LocalDate releaseDate;


    @Getter @Setter private Integer totalPage;

}
