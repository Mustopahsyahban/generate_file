package com.library.dao.individualDebitor;

import com.library.entity.IndividualDebitorEnity;
import com.library.repository.IndividualDebitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualDebitorDaoImp implements IndividualDebitorDao{

    @Autowired
    IndividualDebitorRepository individualDebitorRepository;


    public List<IndividualDebitorEnity> findAll(){

        List<IndividualDebitorEnity> list = individualDebitorRepository.findAll();

        if (!list.isEmpty()){

            return list;
        }else{

            return null;
        }

    }
}
