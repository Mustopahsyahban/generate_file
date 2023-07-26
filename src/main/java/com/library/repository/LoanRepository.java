package com.library.repository;

import com.library.dto.author.AuthorGridDTO;
import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.dto.loan.LoanGridDTO;
import com.library.entity.Loan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,Long> {


    @Query("""
                SELECT new com.library.dto.loan.LoanGridDTO(cat.id, cus.membershipNumber,bo.title , cat.loanDate, cat.dueDate,cat.returnDate)
                FROM Loan AS cat
                    JOIN cat.customer AS cus
                    JOIN cat.book AS bo
                WHERE cus.membershipNumber LIKE %:membershipNumber% AND bo.title LIKE %:title%
           """)

    public List<LoanGridDTO> findAll(@Param("membershipNumber") String membershipNumber,
                                     @Param("title") String title,
                                     Pageable pageable);




    @Query("""
            SELECT COUNT(cus.membershipNumber)
            FROM Loan AS cat
           JOIN cat.customer AS cus
                    JOIN cat.book AS bo
                WHERE cus.membershipNumber LIKE %:membershipNumber% AND bo.title LIKE %:title%
            """)
    public Long count(@Param("membershipNumber") String membershipNumber,
                      @Param("title") String title);


    @Query("""
                    SELECT COUNT(cat.id)
            FROM Loan AS cat
            WHERE cat.customerNumber = :customerNumber
            """)
    public Long countByCustomerNumber(@Param("customerNumber") String customerNumber);

}
