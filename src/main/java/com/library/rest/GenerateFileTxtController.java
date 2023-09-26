package com.library.rest;

import com.library.StringNum.StringNum;
import com.library.service.businessEntityDebtor.BusinessEntityDebtorService;
import com.library.service.individualDebitor.IndividualDebitorService;
import com.library.service.otherFacilities.OtherFacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("api/generate/txt")
public class GenerateFileTxtController {

    @Autowired
    IndividualDebitorService individualDebitorService;

    @Autowired
    BusinessEntityDebtorService businessEntityDebtorService;

    @Autowired
    OtherFacilitiesService otherFacilitiesService;

    String format = ".txt";


    @GetMapping("/exportDataD01")
    public ResponseEntity<File> doExportIndividualDebtor () throws IOException {

        String fileName = individualDebitorService.exportFile(format);
        File file =  new File(StringNum.LOCATION_FILE_GENERATE_TXT.getDescription() + fileName);

        return ResponseEntity.status(HttpStatus.OK).body(file);
    }
    @GetMapping("/exportDataD02")
    public ResponseEntity<File> doExportBusinessEntityDebtor () throws IOException {

        String fileName = businessEntityDebtorService.exportFile(format);
        File file =  new File(StringNum.LOCATION_FILE_GENERATE_TXT.getDescription()+ fileName);

        return ResponseEntity.status(HttpStatus.OK).body(file);
    }
    @GetMapping("/exportDataF06")
    public ResponseEntity<File> doOtherFacilities() throws IOException {

        String fileName = otherFacilitiesService.exportFile(format);
        File file =  new File(StringNum.LOCATION_FILE_GENERATE_TXT.getDescription()+ fileName);

        return ResponseEntity.status(HttpStatus.OK).body(file);
    }




}
