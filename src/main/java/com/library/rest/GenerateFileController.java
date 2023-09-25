package com.library.rest;

import com.library.service.businessEntityDebtor.BusinessEntityDebtorService;
import com.library.service.individualDebitor.IndividualDebitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("api/generate")
public class GenerateFileController {

    @Autowired
    IndividualDebitorService individualDebitorService;

    @Autowired
    BusinessEntityDebtorService businessEntityDebtorService;


    @GetMapping("/exportDataTxtD01")
    public ResponseEntity<File> doExportIndividualDebtor () throws IOException {

        String fileName = individualDebitorService.exportTxt();
        File file =  new File("C:\\Users\\user\\Documents\\project\\MiniApolo\\mini-apolo\\"+ fileName);

        return ResponseEntity.status(HttpStatus.OK).body(file);
    }
    @GetMapping("/exportDataTxtD02")
    public ResponseEntity<File> doExportBusinessEntityDebtor () throws IOException {

        String fileName = businessEntityDebtorService.exportTxt();
        File file =  new File("C:\\Users\\user\\Documents\\project\\MiniApolo\\mini-apolo\\"+ fileName);

        return ResponseEntity.status(HttpStatus.OK).body(file);
    }



}
