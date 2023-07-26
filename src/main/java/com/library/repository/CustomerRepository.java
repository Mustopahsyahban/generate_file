package com.library.repository;

import com.library.dto.category.CategoryGridDTO;
import com.library.dto.customer.CustomerGridDTO;
import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("""
                 SELECT new com.library.dto.customer.CustomerGridDTO(cat.membershipNumber, CONCAT(cat.firstName,' ', cat.lastName), cat.membershipExpireDate)
                 FROM Customer AS cat
                 WHERE cat.membershipNumber LIke %:membershipNumber% AND
                 (cat.firstName LIKE %:fullName% OR cat.lastName LIKE %:fullName%)
            """)

    public List<CustomerGridDTO> findAll(@Param("membershipNumber") String membershipNumber,
                                         @Param("fullName") String fullName,
                                         Pageable pageable);

    @Query("""
            SELECT COUNT(cat.membershipNumber)
            FROM Customer AS cat
            WHERE cat.membershipNumber = :membershipNumber AND
            (cat.firstName LIKE %:fullName% OR cat.lastName LIKE %:fullName%)
            """)
    public Long count(@Param("membershipNumber") String membershipNumber,
                      @Param("fullName") String fullName);

    @Query("""
            SELECT new com.library.dto.dropDwonDTO.DropDownDTO(cat.membershipNumber, CONCAT(cat.firstName,' ', cat.lastName)) 
            FROM Customer AS cat
            ORDER By cat.membershipNumber """)
    public List<DropDownDTO> findAllLoan();
}
