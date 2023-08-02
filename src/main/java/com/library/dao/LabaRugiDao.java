package com.library.dao;

import com.library.StringNum.StringNum;
import com.library.entity.LabaRugiEntity;
import com.library.querySQL.QuerySQL;
import com.library.repository.LabaRugiRepository;
import com.library.repository.Rbb22C00Repository;
import com.library.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LabaRugiDao {


   
    @Autowired
    private LabaRugiRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private QuerySQL querySQL;

    private SimpleDateFormat io = new SimpleDateFormat(StringNum.FORMAT_DATE_STRIP_YYYYMMDD.getDescription());




    public LabaRugiEntity getByIdDao(Date tglLapor, String kdKomponen){

        LabaRugiEntity entity = repository.findByIdData(tglLapor, kdKomponen);

        return entity;
    }


    public List<LabaRugiEntity> findAllDataByTglLaporDao(Date tglLapor){


        List<LabaRugiEntity> listEntity =  repository.findAllData(tglLapor);

        return listEntity;
    }



    public void queryAddData(Date tglLapor){
    querySQL.setAddDataLabaRugi(tglLapor);

    }

    public LabaRugiEntity getUpdateData(Date tglLapor, String kdKomponen){
        LabaRugiEntity entity = repository.findByIdData(tglLapor, kdKomponen);
        return entity;
    }




    }


