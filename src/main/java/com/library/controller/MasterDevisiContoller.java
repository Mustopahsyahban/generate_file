package com.library.controller;

import com.library.repository.MasterDevisiRepository;
import com.library.entity.MasterDevisiEntity;
import com.library.service.MasterDevisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/devisi")
public class MasterDevisiContoller {

    @Autowired
    MasterDevisiService service;

    @Autowired
    MasterDevisiRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/index")
    public String index (Model model){
        String quer= "SELECT B.NAMA_DEVISI FROM MST_MASTER_DEVISI AS B";
        List<MasterDevisiEntity>grid= null;
        grid = service.findAll();
        model.addAttribute("grid", grid);
        return "devisi/devisi-index";
    }


    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false)Long id, Model model){
        MasterDevisiEntity dto = new MasterDevisiEntity();
        String actionType = "Insert";
        if(id != null){//Edit
            dto = service.getUpdateDevisi(id);
            actionType = "Update";
        }
        model.addAttribute("devisi", dto);
        model.addAttribute("type", actionType);
        return "devisi/devisi-form";
    }

    //action untuk menerima data dari form
    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("devisi") MasterDevisiEntity dto,
                         BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            String type = "Insert";
            type = (dto.getId() != null) ? "Update" : type;
            model.addAttribute("type", type);
            return "devisi/devisi-form";
        } else {
            service.save(dto);
            return "redirect:/devisi/index";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(required = true)Long id, Model model) {
        repository.deleteById(id);
        return "redirect:/devisi/index";
    }

}
