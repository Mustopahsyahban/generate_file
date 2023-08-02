package com.library.service.priceProduct;

import com.library.StringNum.StringNum;
import com.library.controller.MasterFormContoller;
import com.library.dao.LabaRugiDao;

import com.library.entity.LabaRugiEntity;
import com.library.querySQL.QuerySQL;

import com.library.repository.LabaRugiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LabaRugiService {

    @Autowired
    private LabaRugiRepository repository;

    @Autowired
    MasterFormContoller masterForm;


    @Autowired
    private LabaRugiDao dao;
    @Autowired
    QuerySQL querySQL;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleDateFormat io = new SimpleDateFormat(StringNum.FORMAT_DATE_STRIP_YYYYMMDD.getDescription());



    public LabaRugiEntity getById (Date tglLapor, String kdKomponen){
       LabaRugiEntity entity=  dao.getByIdDao(tglLapor, kdKomponen);

        return entity;
    }

    public String getName(String kdForm){

        String nameForm = masterForm.getNameForm(kdForm);

        return  nameForm;
    }

    public Date getTglLaporById (Date tglLapor, String kdKomponen){

        LabaRugiEntity entity=  dao.getByIdDao(tglLapor,kdKomponen);

        return entity.getTglPelaporan();
    }



    public Boolean cekAddData(Date tglLapor){
       List<LabaRugiEntity>list= dao.findAllDataByTglLaporDao(tglLapor);
        if (list.size()==0){
            return true;
        }else {

            return false;
        }
    }

    public  void tambahData(Date tglLapor){
        dao.queryAddData(tglLapor);
    }
    public List<LabaRugiEntity>findAll (Date tglLapor){

            List<LabaRugiEntity> list = dao.findAllDataByTglLaporDao(tglLapor);

            return list;

    }

    public void save(LabaRugiEntity dto) {


        //update

            LabaRugiEntity newEntity = dao.getByIdDao(dto.getTglPelaporan(), dto.getKdKomponen());
            newEntity.setMaxSum(dto.getMaxSum());
            newEntity.setDetail(dto.getDetail());

            newEntity.setDateUpdate(new Date());
            repository.save(newEntity);



            querySQL.setChangeAmountLabaRugi(newEntity.getTglPelaporan());


        }





    public LabaRugiEntity getUpdateData(Date tglLapor, String kdKomponen) {

        LabaRugiEntity entity = dao.getUpdateData(tglLapor, kdKomponen);
        LabaRugiEntity dto = new LabaRugiEntity(
                entity.getTglPelaporan(), entity.getKdKomponen(),entity.getNmKomponen(),
                entity.getDetail(),entity.getMaxSum());
        return dto;
    }


}
