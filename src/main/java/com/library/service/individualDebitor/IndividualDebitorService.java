package com.library.service.individualDebitor;

import com.library.entity.IndividualDebitorEnity;

import java.util.List;


public interface IndividualDebitorService {

    List<IndividualDebitorEnity> findAll();

    public String  exportTxt();
}
