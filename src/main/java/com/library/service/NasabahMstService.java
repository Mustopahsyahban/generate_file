package com.library.service;


import com.library.repository.NasabahMstRepository;
import com.library.entity.NasabahMstEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NasabahMstService {

    @Autowired
    NasabahMstRepository repository;

    private Integer rowsInPage = 8;



    public List<NasabahMstEntity> getGrid() {
        List<NasabahMstEntity>grid = repository.findAll();
        return grid;
    }

    public String save(NasabahMstEntity dto) {
       List <NasabahMstEntity> val = repository.findByIdCustomer(dto.getIdCustomer());
       if(dto.getJenisNasabah()!="") {
           if (dto.getId() == null) {
               if (val.size() == 0) {
                   NasabahMstEntity nasabahMstEntity = repository.save(dto);
                   return nasabahMstEntity.getName();
               }
           } else {

               NasabahMstEntity nasabahMstEntity = repository.save(dto);
               return nasabahMstEntity.getName();
           }
       }
       else {
           return null;
       }
        return null;
    }


    public NasabahMstEntity getUpdateNasabah(Integer Id) {
        NasabahMstEntity entity = repository.findById(Id).get();
        NasabahMstEntity dto = new NasabahMstEntity(
                entity.getId(),
                entity.getName(),
                entity.getTempatLahir(),
                entity.getTanggalLahir(),
        entity.getAlamat(),
        entity.getPenghasilan(),
        entity.getJenisNasabah(),
        entity.getIdCustomer())
        ;
        return dto;
    }
}
