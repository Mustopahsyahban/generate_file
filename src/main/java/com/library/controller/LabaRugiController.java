package com.library.controller;


import com.library.StringNum.StringNum;
import com.library.entity.LabaRugiEntity;

import com.library.service.priceProduct.LabaRugiService;
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
@RequestMapping("/LabaRugi")
public class LabaRugiController {
    @Autowired
    LabaRugiService service;

    public Date tanggalAdd;
    SimpleDateFormat po = new SimpleDateFormat(StringNum.FORMAT_DATE_SLASH_YYYYMMDD.getDescription());

    SimpleDateFormat io = new SimpleDateFormat(StringNum.FORMAT_DATE_STRIP_YYYYMMDD.getDescription());

    @GetMapping("/index")
    public String get (@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date tglLapor, Model model) throws ParseException {
        String kdForm = "0002";
        String nameForm = service.getName(kdForm);
        String tglLaporanView = "(" + po.format(tglLapor) + ")";

            List<LabaRugiEntity>grid = service.findAll(tglLapor);
            model.addAttribute("grid",grid);
            model.addAttribute("nameForm", nameForm);
            model.addAttribute("tglLapor", tglLapor);
            model.addAttribute("tglPlas", io.format(tglLapor));
            model.addAttribute("tglLaporView", tglLaporanView );
            tanggalAdd= tglLapor;


        return "labaRugi/labaRugi-index";
    }


    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")Date tglLapor,@RequestParam(required = false)String kdKomponen, Model model){
        LabaRugiEntity dto = service.getById(tglLapor,kdKomponen);

            if (dto.getKdKomponen().equals("00000000") || dto.getKdKomponen().equals("00040000") ||
                    dto.getKdKomponen().equals("00050000") || dto.getKdKomponen().equals("00110000") ||
                    dto.getKdKomponen().equals("00120000") || dto.getKdKomponen().equals("00150000") ||
                    dto.getKdKomponen().equals("00160000") || dto.getKdKomponen().equals("00190000") ||
                    dto.getKdKomponen().equals("00200000") || dto.getKdKomponen().equals("00210000") ||
                    dto.getKdKomponen().equals("00220000") || dto.getKdKomponen().equals("00230000") ) {

                return "redirect:/LabaRugi/index?tglLapor=" + io.format(tanggalAdd);
            } else {
                LabaRugiEntity entity = service.getUpdateData(tglLapor, kdKomponen);
                String actionType = "Update";
                String tglView = io.format(entity.getTglPelaporan());

                model.addAttribute("labaRugi", entity);
                model.addAttribute("kdKomponenHi",entity.getKdKomponen());
                model.addAttribute("tglLaporView",tglView);
                model.addAttribute("type", actionType);
                return "labaRugi/labaRugi-form";
            }

    }
    @GetMapping("/addData")
    public String addData (){

        Boolean cek = service.cekAddData(tanggalAdd);

        if(cek == true){
            service.tambahData(tanggalAdd);
        }

        return "redirect:/LabaRugi/index?tglLapor="+io.format(tanggalAdd);

    }


    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("labaRugi") LabaRugiEntity dto,
                         BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){

            String type = "UPDATE";
            model.addAttribute("type", type);
            return "labaRugi/labaRugi-form";
        } else {
            dto.setTglPelaporan(tanggalAdd);
            Date tglPelaporan = service.getTglLaporById(dto.getTglPelaporan(),dto.getKdKomponen());
            service.save(dto);
            return "redirect:/LabaRugi/index?tglLapor="+ io.format(tglPelaporan);
        }
    }





}
