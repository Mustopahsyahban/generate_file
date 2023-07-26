package com.library.service;


import com.library.repository.MasterDevisiRepository;
import com.library.entity.MasterDevisiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterDevisiService {

    @Autowired
    MasterDevisiRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<MasterDevisiEntity> findAll (){
        String quer = "SELECT TOP (1000) [id] ,[name] FROM [43].[dbo].[MST_MASTER_DEVISI]";
        List<MasterDevisiEntity> grid= repository.findAll();
        return grid;
    }


    public String save(MasterDevisiEntity dto) {

            MasterDevisiEntity entity = repository.save(dto);
            return entity.getName();

        }



    public MasterDevisiEntity getUpdateDevisi(Long id) {
        MasterDevisiEntity entity = repository.findById(id).get();
        MasterDevisiEntity dto = new MasterDevisiEntity(
                entity.getId(), entity.getName())
                ;
        return dto;
    }
}
