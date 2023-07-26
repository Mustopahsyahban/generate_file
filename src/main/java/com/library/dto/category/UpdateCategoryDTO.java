package com.library.dto.category;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UpdateCategoryDTO {

    @NotBlank(message = "Nama Category tidak boleh Sama, masukan Kembali")
    @Size(max = 100, message = "Nama Category Tidak boleh lebih dari 100, masukan kembali")
    @Getter
    @Setter private String name;


    @Getter @Setter private Long floor;
    @NotNull(message = "tidak boleh kosong")
    @NotBlank(message = "Masukan Floor, Floor Tidak Boleh Kosong")
    @Size(max = 10, message = "Isle Tidak lebih dari 10")
    @Getter @Setter private String isle;

    @NotBlank(message = "Masukan Floor, Floor Tidak Boleh Kosong")
    @Size(max = 10, message = "Bay Tidak lebih dari 10")
    @Getter @Setter private String bay;
}

