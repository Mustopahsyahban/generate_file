package com.library.rest;

import com.library.dto.category.CategoryGridDTO;
import com.library.dto.customer.CustomerGridDTO;
import com.library.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustoomerRestAPI {


    @Autowired
    private CustomerService service;


    @GetMapping
    public ResponseEntity<Object> get(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "") String membershipNumber,
                                      @RequestParam(defaultValue = "") String fullName){
        List<CustomerGridDTO> dtos = service.getCustomerGrid(page, membershipNumber, fullName);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}


