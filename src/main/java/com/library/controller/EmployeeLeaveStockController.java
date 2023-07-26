package com.library.controller;

import com.library.entity.EmployeeLeaveStock;
import com.library.service.EmployeeLeaveStockService;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/leaveStock")
public class EmployeeLeaveStockController {

    @Autowired
    EmployeeLeaveStockService service;
    @GetMapping("/index")
    private String findAll (Model model){

        List<EmployeeLeaveStock>gird = service.findAll();

        model.addAttribute("grid", gird);


        return "employee/employeeLeave-index";
    }
}
