package com.library.controller;

import com.library.dto.category.CategoryGridDTO;
import com.library.dto.category.UpdateCategoryDTO;
import com.library.dto.category.UpsertCatogoryDTO;
import com.library.dto.customer.CustomerGridDTO;
import com.library.dto.customer.InsertCustomerDTO;
import com.library.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService service;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "") String membershipNumber,
                        @RequestParam(defaultValue = "") String fullName, Model model) {
        List<CustomerGridDTO> grid = service.getCustomerGrid(page, membershipNumber, fullName);
        Long totalPage = service.getTotalPage(membershipNumber, fullName);
        page = (totalPage > 0) ? page : 0;
        model.addAttribute("grid", grid);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("membershipNumber", membershipNumber);
        model.addAttribute("fullName", fullName);
        return "customer/customer-index";
    }

    //untuk menampilkan form
    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false) String membershipNumber,String fullName, Model model){
        InsertCustomerDTO dto = new InsertCustomerDTO();
        String actionType = "Insert";
        if(membershipNumber != null){//Edit
            dto = service.getUpdateCustomer(membershipNumber,fullName);
            actionType = "Update";
        }
        model.addAttribute("customer", dto);
        model.addAttribute("type", actionType);
        return "customer/customer-form";
    }

    //action untuk menerima data dari form
    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("customer") InsertCustomerDTO dto,
                         BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            String type = "Insert";
            type = (dto.getMembershipNumber() != null) ? "Update" : type;
            model.addAttribute("type", type);
            return "customer/customer-form";
        } else {
            service.saveCustomer(dto);
            return "redirect:/customer/index";
        }
    }

    @GetMapping("/extend")
    public String extend(@RequestParam(required = true) String membershipNumber, Model model){

        service.extendExpireDate(membershipNumber);
        return "redirect:/customer";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(required = true)String membershipNumber, Model model){
        Boolean successDelete = service.deleteCustomer(membershipNumber);
        if(successDelete){
            return "redirect:/customer/index";
        }
        Long totalDependentLoan = service.dependentLoan(membershipNumber);
        model.addAttribute("dependencies", totalDependentLoan);
        return "customer/customer-delete";
    }
}
