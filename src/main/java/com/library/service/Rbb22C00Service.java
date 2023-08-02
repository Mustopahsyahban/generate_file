package com.library.service;

import com.library.controller.MasterFormContoller;
import com.library.dao.Rbb22C00Dao;
import com.library.querySQL.QuerySQL;
import com.library.repository.Rbb22C00Repository;
import com.library.entity.RBB_22C00Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class Rbb22C00Service {

    @Autowired
    private Rbb22C00Repository repository;

    @Autowired
    MasterFormContoller masterForm;


    @Autowired
    private Rbb22C00Dao dao;
    @Autowired
    QuerySQL querySQL;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleDateFormat io = new SimpleDateFormat("yyyy-MM-dd");



    public RBB_22C00Entity getById (Long id){
       RBB_22C00Entity entity=  dao.getByIdDao(id);

        return entity;
    }

    public String getName(String kdForm){

        String nameForm = masterForm.getNameForm(kdForm);

        return  nameForm;
    }

    public Date getTglLaporById (Long id){

        RBB_22C00Entity entity=  dao.getByIdDao(id);

        return entity.getTglPelaporan();
    }



    public Boolean cekAddData(Date tglLapor){
       List<RBB_22C00Entity>list= dao.findAllDataByTglLaporDao(tglLapor);
        if (list.size()==0){
            return true;
        }else {

            return false;
        }
    }

    public  void tambahData(Date tglLapor){
        dao.queryAddData(tglLapor);
    }
    public List<RBB_22C00Entity>findAll (Date tglLapor){

            List<RBB_22C00Entity> list = dao.findAllDataByTglLaporDao(tglLapor);

            return list;

    }

    public void save(RBB_22C00Entity dto) {


        //update
        if(dto.getId()!= null) {
            RBB_22C00Entity newEntity = dao.getByIdDao(dto.getId());
            newEntity.setRealisaiT3(dto.getRealisaiT3());
            newEntity.setT4Min1(dto.getT4Min1());
            newEntity.setT1(dto.getT1());
            newEntity.setT2(dto.getT2());
            newEntity.setT3(dto.getT3());
            newEntity.setT4(dto.getT4());
            newEntity.setT4Plus1(dto.getT4Plus1());
            newEntity.setT4Plus2(dto.getT4Plus2());
            newEntity.setDateUpdate(new Date());
            RBB_22C00Entity entity = repository.save(newEntity);



            querySQL.setDoChangeAmountRbb22C(newEntity.getTglPelaporan());

        }else {
            //Crate
            RBB_22C00Entity entity = repository.save(dto);

        }

    }



    public RBB_22C00Entity getUpdateData(Long id) {

        RBB_22C00Entity entity = dao.getUpdateData(id);
        RBB_22C00Entity dto = new RBB_22C00Entity(
                entity.getId(),entity.getTglPelaporan(), entity.getKdKomponen(),entity.getNmKomponen(),
                entity.getRealisaiT3(),entity.getT4Min1(),entity.getT1(),entity.getT2(),
                entity.getT3(),entity.getT4(),entity.getT4Plus1(),entity.getT4Plus2());
        return dto;
    }


}
