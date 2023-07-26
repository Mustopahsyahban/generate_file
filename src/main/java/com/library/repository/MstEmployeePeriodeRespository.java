package com.library.repository;

import com.library.dto.category.CategoryGridDTO;
import com.library.entity.EmployeePeriode;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MstEmployeePeriodeRespository extends JpaRepository<EmployeePeriode, Long> {

    @Query(value = """
               SELECT * fROM MST_EMPLOYEE_PERIODE WHERE DELETE_STATUS = :criteria
           """, nativeQuery = true)

    public List<EmployeePeriode> findAllData( @Param("criteria") Long criteria);

    @Query(value = "SELECT * fROM MST_EMPLOYEE_PERIODE WHERE ID =:id  ", nativeQuery = true)
    EmployeePeriode finfByIdData(@Param("id") Long id);
}
