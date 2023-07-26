package com.library.repository;

import com.library.entity.EmployeeLeaveStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLeaveStockRepository extends JpaRepository<EmployeeLeaveStock,Long> {


}
