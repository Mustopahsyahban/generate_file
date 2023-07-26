package com.library.controller;

import com.library.repository.MasterJabatanRepositoty;
import com.library.entity.MasterJabatanEntity;
import com.library.service.priceProduct.MasterJabatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/jabatan")
public class MasterJabatanContoller {

    @Autowired
    MasterJabatanService service;

    @Autowired
    MasterJabatanRepositoty repositoty;

    @GetMapping("/index")
    public String index (Model model){
        List<MasterJabatanEntity>grid=service.findAll();
        model.addAttribute("grid", grid);
        return "jabatan/jabatan-index";
    }


    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false)Long id, Model model){
        MasterJabatanEntity dto = new MasterJabatanEntity();
        String actionType = "Insert";
        if(id != null){//Edit
            dto = service.getUpdateJabatan(id);
            actionType = "Update";
        }
        model.addAttribute("jabatan", dto);
        model.addAttribute("type", actionType);
        return "jabatan/jabatan-form";
    }

    //action untuk menerima data dari form
    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("jabatan") MasterJabatanEntity dto,
                         BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            String type = "Insert";
            type = (dto.getId() != null) ? "Update" : type;
            model.addAttribute("type", type);
            return "jabatan/jabatan-form";
        } else {
            service.save(dto);
            return "redirect:/jabatan/index";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(required = true)Long id, Model model) {
        repositoty.deleteById(id);
        return "redirect:/jabatan/index";
    }

}
