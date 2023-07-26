package com.library.controller;

import com.library.repository.MasterPeriodeRepositoty;
import com.library.entity.MasterPeriodeEntity;
import com.library.service.MasterPeriodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/periode")
public class MasterPeriodeContoller {

    @Autowired
    MasterPeriodeService service;

    @Autowired
    MasterPeriodeRepositoty repositoty;

    @GetMapping("/index")
    public String index (Model model){
        List<MasterPeriodeEntity>grid=service.findAll();
        model.addAttribute("grid", grid);
        return "periode/periode-index";
    }


    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false)Long id, Model model){
        MasterPeriodeEntity dto = new MasterPeriodeEntity();
        String actionType = "Insert";
        if(id != null){//Edit
            dto = service.getUpdatePeriode(id);
            actionType = "Update";
        }
        model.addAttribute("periode", dto);
        model.addAttribute("type", actionType);
        return "periode/periode-form";
    }

    //action untuk menerima data dari form
    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("periode") MasterPeriodeEntity dto,
                         BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            String type = "Insert";
            type = (dto.getId() != null) ? "Update" : type;
            model.addAttribute("type", type);
            return "periode/periode-form";
        } else {
            service.save(dto);
            return "redirect:/periode/index";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(required = true)Long id, Model model) {
        repositoty.deleteById(id);
        return "redirect:/periode/index";
    }

}
