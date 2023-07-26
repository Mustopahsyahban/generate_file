package com.library.dao;

import com.library.repository.MasterFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterFormDao {

    @Autowired
    MasterFormRepository repository;

    public String getNameFormDao(String kdForm){

        String nameFormDao = repository.getDecriptionByKdForm(kdForm);

        return nameFormDao;
    }
}
