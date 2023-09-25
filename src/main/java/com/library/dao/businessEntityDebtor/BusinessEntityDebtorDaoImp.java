package com.library.dao.businessEntityDebtor;

import com.library.entity.BusinessEntityDebtorEntity;
import com.library.repository.BusinessEntityDebtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessEntityDebtorDaoImp implements BusinessEntityDebtorDao{

    @Autowired
    BusinessEntityDebtorRepository businessEntityDebtorRepository;


    public List<BusinessEntityDebtorEntity> findAll(){

        List<BusinessEntityDebtorEntity> list = businessEntityDebtorRepository.findAll();

        if (!list.isEmpty()){

            return list;
        }else{

            return null;
        }

    }
}
