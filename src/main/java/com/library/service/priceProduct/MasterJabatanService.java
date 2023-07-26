package com.library.service.priceProduct;


import com.library.repository.MasterJabatanRepositoty;
import com.library.entity.MasterJabatanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterJabatanService {

    @Autowired
    MasterJabatanRepositoty repository;

    public List<MasterJabatanEntity> findAll (){
        List<MasterJabatanEntity> grid = repository.findAll();
        return grid;
    }


    public String save(MasterJabatanEntity dto) {

            MasterJabatanEntity masterJabatanEntity = repository.save(dto);
            return masterJabatanEntity.getName();

        }


    public MasterJabatanEntity getUpdateJabatan(Long id) {
        MasterJabatanEntity entity = repository.findById(id).get();
        MasterJabatanEntity dto = new MasterJabatanEntity(
                entity.getId(), entity.getName())
                ;
        return dto;
    }
}
