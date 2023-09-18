package com.library.controller;


import com.library.entity.RBB_22C00Entity;
import com.library.service.Rbb22C00Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/rbb22C00")
public class Rbb22C00Controller {
    @Autowired
    Rbb22C00Service service;

    public Date tanggalAdd;
    SimpleDateFormat po = new SimpleDateFormat("dd/MM/yyyy");

    SimpleDateFormat io = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/index")
    public String get (@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date tglLapor, Model model) throws ParseException {
        String kdForm = "0001";
        String nameForm = service.getName(kdForm);
        String tglLaporanView = "(" + po.format(tglLapor) + ")";

            List<RBB_22C00Entity>grid = service.findAll(tglLapor);
            model.addAttribute("grid",grid);
            model.addAttribute("nameForm", nameForm);
            model.addAttribute("tglLapor", tglLapor);
            model.addAttribute("tglPlas", tglLapor);
            model.addAttribute("tglLaporView", tglLaporanView );
            tanggalAdd= tglLapor;


        return "rbb22C000/rbb22C00-index";
    }


    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false)Long id, Model model){
        RBB_22C00Entity dto = service.getById(id);

            if (dto.getKdKomponen().equals("220301010000") || dto.getKdKomponen().equals("220301010100") ||
                    dto.getKdKomponen().equals("220301010199") || dto.getKdKomponen().equals("220301010200") ||
                    dto.getKdKomponen().equals("220301010299") || dto.getKdKomponen().equals("220301010300") ||
                    dto.getKdKomponen().equals("220301010399") || dto.getKdKomponen().equals("220301019900") ||
                    dto.getKdKomponen().equals("220301020000") || dto.getKdKomponen().equals("220301020100") ||
                    dto.getKdKomponen().equals("220301020199") || dto.getKdKomponen().equals("220301020200") ||
                    dto.getKdKomponen().equals("220301990000") ||
                    dto.getKdKomponen().equals("220301020299") || dto.getKdKomponen().equals("220301020300") ||
                    dto.getKdKomponen().equals("220301020399") || dto.getKdKomponen().equals("220301029900")) {

                return "redirect:/rbb22C00/index?tglLapor=" + io.format(tanggalAdd);
            } else {
                RBB_22C00Entity entity = service.getUpdateData(id);
                String actionType = "Update";
                String tglView = io.format(entity.getTglPelaporan());

                model.addAttribute("rbb22C00", entity);
                model.addAttribute("tglLaporView",tglView);
                model.addAttribute("type", actionType);
                return "rbb22C000/rbb22C00-form";
            }

    }
    @GetMapping("/addData")
    public String addData (){

        Boolean cek = service.cekAddData(tanggalAdd);

        if(cek == true){
            service.tambahData(tanggalAdd);
        }

        return "redirect:/rbb22C00/index?tglLapor="+io.format(tanggalAdd);

    }


    @GetMapping("/exportData")
    public void doExport (){

            service.exportExcel(tanggalAdd);
    }


    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("devisi") RBB_22C00Entity dto,
                         BindingResult bindingResult, Model model){
        SimpleDateFormat io = new SimpleDateFormat("yyyy-MM-dd");
        if(bindingResult.hasErrors()){

            String type = "Insert";
            type = (dto.getId() != null) ? "Update" : type;
            model.addAttribute("type", type);
            return "rbb22C000/rbb22C00-form";
        } else {
            Date tglPelaporan = service.getTglLaporById(dto.getId());
            service.save(dto);
            return "redirect:/rbb22C00/index?tglLapor="+ io.format(tglPelaporan);
        }
    }

}
