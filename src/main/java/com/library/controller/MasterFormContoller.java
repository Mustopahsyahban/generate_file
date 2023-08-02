package com.library.controller;

import com.library.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MasterFormContoller {

    @Autowired
    FormService service;


    public String getNameForm(String kdForm){

        String nameForm = service.getNameForm(kdForm);

        return nameForm;

    }


}
