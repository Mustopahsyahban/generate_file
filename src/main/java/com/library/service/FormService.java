package com.library.service;

import com.library.dao.MasterFormDao;
import com.library.entity.MasterForm;
import com.library.repository.MasterFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class FormService {

    @Autowired
    MasterFormDao dao;

    public String getNameForm (String kdForm){

        String nameForm = dao.getNameFormDao(kdForm);

        return nameForm;
    }
}
