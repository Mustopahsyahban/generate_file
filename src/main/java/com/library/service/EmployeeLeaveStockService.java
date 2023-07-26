package com.library.service;

import com.library.repository.EmployeeLeaveStockRepository;
import com.library.entity.EmployeeLeaveStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLeaveStockService {

    @Autowired
    EmployeeLeaveStockRepository repository;
    public List<EmployeeLeaveStock>findAll(){
         List<EmployeeLeaveStock> result = repository.findAll();

         return result;
     }
}
