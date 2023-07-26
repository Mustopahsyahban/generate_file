package com.library.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name="Book")
public class Book {
    @Id
    @Column(name = "Code")
    @Getter @Setter private String id;

    @Column(name = "Title")
    @Getter @Setter private String title;

    @ManyToOne
    @JoinColumn(name = "CategoryName", insertable = true, updatable = true)
    @Getter @Setter private Category category;

    @Getter @Setter private String categoryName;

    @ManyToOne
    @JoinColumn(name = "AuthorId", insertable = true, updatable = true)
     @Getter @Setter private Author author;

    @Getter @Setter private Long authorId;

    @Column(name = "IsBorrowed")
    @Getter @Setter private Boolean isBorrowed = false;

    @Column(name = "Summary")
    @Getter @Setter private String summary;

    @Column(name = "ReleaseDate")
    @Getter @Setter private LocalDate releaseDate;

    @Column(name = "TotalPage")
    @Getter @Setter private Integer totalPage;

    public Book(String id, String title, String categoryName, Long authorId, Boolean isBorrowed, String summary, LocalDate releaseDate, Integer totalPage) {
        this.id = id;
        this.title = title;
        this.categoryName = categoryName;
        this.authorId = authorId;
        this.isBorrowed = isBorrowed;
        this.summary = summary;
        this.releaseDate = releaseDate;
        this.totalPage = totalPage;
    }
}