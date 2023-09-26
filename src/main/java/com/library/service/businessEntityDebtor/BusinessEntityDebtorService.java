package com.library.service.businessEntityDebtor;

import com.library.entity.BusinessEntityDebtorEntity;
import com.library.entity.IndividualDebitorEnity;

import java.util.List;


public interface BusinessEntityDebtorService {

    List<BusinessEntityDebtorEntity> findAll();

    public String  exportFile(String format);
}
