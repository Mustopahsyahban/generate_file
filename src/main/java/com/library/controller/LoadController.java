package com.library.controller;


import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.dto.loan.InsertLoanDTO;
import com.library.dto.loan.LoanGridDTO;
import com.library.service.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/loan")
public class LoadController {
    @Autowired
    private LoanService service;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "") String membershipNumber,
                        @RequestParam(defaultValue = "") String title, Model model) {
        List<LoanGridDTO> grid = service.getLoanGrid(page, membershipNumber, title);
        Long totalPage = service.getTotalPage(membershipNumber, title);
        page = (totalPage > 0) ? page : 0;
        model.addAttribute("grid", grid);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("membershipNumber", membershipNumber);
        model.addAttribute("title", title);
        return "loan/loan-index";
    }

    @GetMapping("/return")
    public String extend(@RequestParam(required = true) Long id, Model model) {
        service.returnDate(id);
        return "redirect:/loan/index";
    }
/*
    @GetMapping("/insert")
    public String upsertFormDetail(@RequestParam(required = false) Long id,
                                   @RequestParam(defaultValue = "") String membershipNumber,
                                   @RequestParam(defaultValue = "") String title, Model model) {
        InsertLoanDTO dto = new InsertLoanDTO();
        List<DropDownDTO> customerDropDown = service.getDropDownCustomer();
        List<DropDownDTO> bookDropDown = service.getDropDownBook();
        String actionType = "Insert";
        model.addAttribute("customerDropDown", customerDropDown);
        model.addAttribute("bookDropDown", bookDropDown);
        model.addAttribute("bookDropDown", bookDropDown);
        model.addAttribute("bookDropDown", bookDropDown);
        model.addAttribute("book", dto);
        model.addAttribute("type", actionType);
        return "loan/loan-form";
    }
    */
    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false) Long id, Model model){
      InsertLoanDTO dto = new InsertLoanDTO();
        List<DropDownDTO> customerDropDown = service.getDropDownCustomer();
        List<DropDownDTO> bookDropDown = service.getDropDownBook();
        String type = "Insert";

        model.addAttribute("customerDropDown", customerDropDown);
        model.addAttribute("bookDropDown", bookDropDown);
        model.addAttribute("loan", dto);
        model.addAttribute("type", type);
        return "loan/loan-form";
    }

    //action untuk menerima data dari form
    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("loan") InsertLoanDTO dto,
                         BindingResult bindingResult, Model model){
            service.saveLoan(dto);
            return "redirect:/loan/index";
        }
    }

