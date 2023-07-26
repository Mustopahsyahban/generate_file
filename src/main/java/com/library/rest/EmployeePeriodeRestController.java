package com.library.rest;

import com.library.repository.MstEmployeePeriodeRespository;
import com.library.entity.EmployeePeriode;
import com.library.service.MasterEmployeePeriodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeePeriode")
public class EmployeePeriodeRestController {

    @Autowired
    MasterEmployeePeriodeService service;

    @Autowired
    MstEmployeePeriodeRespository respository;
    @GetMapping()
    public ResponseEntity<Object>get(){
        List<EmployeePeriode>gird = service.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(gird);
    }

    @PostMapping()
    public ResponseEntity<Object>save (@RequestBody EmployeePeriode dto){

        String b= service.save(dto);
        return ResponseEntity.status(HttpStatus.OK).body(b);
    }


}
