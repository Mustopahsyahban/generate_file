package com.library.dto.author;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AuthorGridDTO {

    @Getter @Setter private Long id;

    @Getter @Setter  private String title;


    @Getter @Setter  private String fullName;
    @Getter @Setter  private String authorName;


    @Getter @Setter  private LocalDate birthDate;

    @Getter @Setter private Long age;

    @Getter @Setter private String status;

    @Getter @Setter  private LocalDate deceasedDate;


    @Getter @Setter  private String education;

    @Getter @Setter  private String summary;

    public AuthorGridDTO(Long id, String title, String fullName, LocalDate birthDate, LocalDate deceasedDate, String education, String summary) {
        this.id = id;
        this.title = title;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.deceasedDate = deceasedDate;
        this.education = education;
        this.summary = summary;
    }
}


