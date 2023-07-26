package com.library.service;


import com.library.repository.MasterPeriodeRepositoty;
import com.library.entity.MasterPeriodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterPeriodeService {

    @Autowired
    MasterPeriodeRepositoty repository;

    public List<MasterPeriodeEntity> findAll (){
        List<MasterPeriodeEntity> grid = repository.findAll();
        return grid;
    }


    public String save(MasterPeriodeEntity dto) {

            MasterPeriodeEntity masterPeriodeEntity = repository.save(dto);
            return masterPeriodeEntity.getJenisPeriode();

        }


    public MasterPeriodeEntity getUpdatePeriode(Long id) {
        MasterPeriodeEntity entity = repository.findById(id).get();
        MasterPeriodeEntity dto = new MasterPeriodeEntity(
                entity.getId(), entity.getJenisPeriode())
                ;
        return dto;
    }
}
