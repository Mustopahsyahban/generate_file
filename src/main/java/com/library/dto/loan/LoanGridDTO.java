package com.library.dto.loan;

import com.library.entity.Book;
import com.library.entity.Customer;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class LoanGridDTO {

    @Getter@Setter private Long id;


    @Getter @Setter private String customer;


    @Getter @Setter private String book;


    @Getter @Setter private LocalDate loanDate;


    @Getter @Setter private LocalDate dueDate;

    @Getter @Setter private LocalDate returnDate;

}
