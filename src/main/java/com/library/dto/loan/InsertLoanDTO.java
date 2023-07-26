package com.library.dto.loan;

import com.library.entity.Book;
import com.library.entity.Customer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class InsertLoanDTO {


    @Getter @Setter private Long id;

    @NotBlank(message = "tidak boleh kosong")
    @Getter @Setter private String customerNumber;

    @NotBlank (message = "tidak boleh kosong")
    @Getter @Setter private String bookCode;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Getter @Setter  private LocalDate loanDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Getter @Setter  private LocalDate dueDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Getter @Setter private LocalDate returnDate;

    @Size (message = "maksimal 500", max = 500)
    @Getter @Setter  private String note;
}
