package com.library.controller;

import com.library.repository.NasabahMstRepository;
import com.library.entity.NasabahMstEntity;
import com.library.service.NasabahMstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/nasabah")
@Controller
public class NasabahMstContoller {


    @Autowired
    private NasabahMstService service;


    @Autowired
    private NasabahMstRepository repository;


    @GetMapping("/index")
    public String index( Model model) {
        List<NasabahMstEntity> grid = service.getGrid();
        model.addAttribute("grid", grid);
        return "nasabah/nasabah-index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(required = true)Integer id, Model model) {
        repository.deleteById(id);
        return "redirect:/nasabah/index";
    }

    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false)Integer id, Model model){
        NasabahMstEntity dto = new NasabahMstEntity();
        String actionType = "Insert";
        if(id != null){//Edit
            dto = service.getUpdateNasabah(id);
            actionType = "Update";
        }
        model.addAttribute("nasabah", dto);
        model.addAttribute("type", actionType);
        return "nasabah/nasabah-form";
    }

    //action untuk menerima data dari form
    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("nasabah") NasabahMstEntity dto,
                         BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            String type = "Insert";
            type = (dto.getId() != null) ? "Update" : type;
            model.addAttribute("type", type);
            return "nasabah/nasabah-form";
        } else {
            service.save(dto);
            return "redirect:/nasabah/index";
        }
    }


}
