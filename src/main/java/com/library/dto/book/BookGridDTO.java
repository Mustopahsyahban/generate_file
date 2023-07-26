package com.library.dto.book;


import lombok.*;


import java.time.LocalDate;
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class BookGridDTO {


    @Getter @Setter private String id;

    @Getter @Setter private String title;

    @Getter @Setter private String categoryName;

    @Getter @Setter private String fullNameAuthor;

    @Getter @Setter private Boolean isBorrowed ;
    @Setter @Getter private String borrowed;

    @Getter @Setter private String summary;

    public BookGridDTO(String id, String title, String categoryName, String fullNameAuthor, Boolean isBorrowed, String summary, LocalDate releaseDate, Integer totalPage) {
        this.id = id;
        this.title = title;
        this.categoryName = categoryName;
        this.fullNameAuthor = fullNameAuthor;
        this.isBorrowed = isBorrowed;
        this.summary = summary;
        this.releaseDate = releaseDate;
        this.totalPage = totalPage;
    }

    @Getter @Setter private LocalDate releaseDate;

    @Getter @Setter private Integer totalPage;

}
