package com.library.common;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;


@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CommonEntity {
    @Column(name ="STATUS")
    @Getter @Setter public String status;

    @Column(name ="DELETE_STATUS")
    @Getter @Setter public Long deleteStatus;

    @Column(name = "DATE_CREATED")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter public LocalDate dateCreated;

    @Column(name = "DATE_UPDATED")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter public LocalDate dateUpdated;

    @Column(name = "DATE_DELETED")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter public LocalDate dateDeleted;

}
