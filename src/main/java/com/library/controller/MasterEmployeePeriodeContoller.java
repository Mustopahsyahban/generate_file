package com.library.controller;

import com.library.repository.MasterDevisiRepository;
import com.library.repository.MasterJabatanRepositoty;
import com.library.repository.MasterPeriodeRepositoty;
import com.library.repository.MstEmployeePeriodeRespository;
import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.entity.EmployeePeriode;
import com.library.service.MasterEmployeePeriodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/employeePeriode")
public class MasterEmployeePeriodeContoller {

    @Autowired
    MasterEmployeePeriodeService service;

    @Autowired
    MstEmployeePeriodeRespository repository;

    @Autowired
    MasterDevisiRepository devisiRepository;

    @Autowired
    MasterPeriodeRepositoty periodeRepositoty;

    @Autowired
    MasterJabatanRepositoty jabatanRepositoty;

    @GetMapping("/index")
    public String index (Model model){

            List<EmployeePeriode>grid=service.findAll();

            model.addAttribute("grid", grid);
            return "employeePeriode/employeePeriode-index";
    }


    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false)Long id,
                             Model model){
        List<DropDownDTO> devisiDropDown = devisiRepository.findAllDevisiName();
        List<DropDownDTO>periodeDropDown = periodeRepositoty.findAllPeriodeName();
        List<DropDownDTO>jabatanDropDown = jabatanRepositoty.findAllJabatanName();
        EmployeePeriode dto = new EmployeePeriode();
        String actionType = "Insert";
        if(id != null){//Edit
            dto = service.getUpdateDevisi(id);
            actionType = "Update";
        }
        model.addAttribute("jabatanDropDown", jabatanDropDown);
        model.addAttribute("devisiDropDown", devisiDropDown);
        model.addAttribute("periodeDropDown", periodeDropDown);
        model.addAttribute("employeePeriode", dto);
        model.addAttribute("type", actionType);
        return "employeePeriode/employeePeriode-form";
    }

    //action untuk menerima data dari form
    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("employeePeriode") EmployeePeriode dto,
                         BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            String type = "Insert";
            type = (dto.getId() != null) ? "Update" : type;
            model.addAttribute("type", type);
            return "employeePeriode/employeePeriode-form";
        } else {
            service.save(dto);
            return "redirect:/employeePeriode/index";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Long id, Model model) {
        EmployeePeriode employeePeriode = repository.getById(id);
        employeePeriode.setDeleteStatus(1L);
        employeePeriode.setDateDeleted(new Date());
        repository.save(employeePeriode);
        return "redirect:/employeePeriode/index";
    }

}
