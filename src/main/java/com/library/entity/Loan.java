package com.library.entity;

import com.library.validation.After;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;



@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
   @Getter @Setter private Long id;

    @Column(name = "CustomerNumber")
    @Getter @Setter private String customerNumber;
    @ManyToOne
    @JoinColumn(name = "CustomerNumber", insertable = false, updatable = false)
    @Getter @Setter  private Customer customer;


    @Column(name = "BookCode")
    @Getter @Setter private String bookCode;

    @ManyToOne
    @JoinColumn(name = "BookCode", insertable = false, updatable = false)
    @Getter @Setter  private Book book;


    @Column(name = "LoanDate")
    @Getter @Setter  private LocalDate loanDate;

    @Column(name = "DueDate")
    @Getter @Setter  private LocalDate dueDate;

    @Column(name = "ReturnDate")
    @Getter @Setter private LocalDate returnDate;

    @Column(name = "Note")
    @Getter @Setter  private String note;


 public Loan(Long id, String customerNumber, String bookCode, LocalDate loanDate, LocalDate dueDate, LocalDate returnDate, String note) {
  this.id = id;
  this.customerNumber = customerNumber;
  this.bookCode = bookCode;
  this.loanDate = loanDate;
  this.dueDate = dueDate;
  this.returnDate = returnDate;
  this.note = note;
 }
}