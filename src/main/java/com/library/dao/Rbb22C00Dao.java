package com.library.dao;

import com.library.entity.RBB_22C00Entity;
import com.library.StringNum.StringNum;
import com.library.querySQL.QuerySQL;
import com.library.repository.Rbb22C00Repository;
import com.library.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class Rbb22C00Dao {


    @Autowired
    private FormService formService;
    @Autowired
    private Rbb22C00Repository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private QuerySQL querySQL;

    private SimpleDateFormat io = new SimpleDateFormat(StringNum.FORMAT_DATE_STRIP_YYYYMMDD.getDescription());




    public RBB_22C00Entity getByIdDao(Long id){

        RBB_22C00Entity entity = repository.findByIdData(id);

        return entity;
    }


    public List<RBB_22C00Entity> findAllDataByTglLaporDao(Date tglLapor){


        List<RBB_22C00Entity> listEntity =  repository.findAllData(tglLapor);

        return listEntity;
    }



    public void queryAddData(Date tglLapor){
     querySQL.setAddDataRbb22C00(tglLapor);

    }

    public RBB_22C00Entity getUpdateData(Long id){
        RBB_22C00Entity entity = repository.findById(id).get();
        return entity;
    }



    public List<RBB_22C00Entity>getDataDoChangeAmount(Date tglPelPoran){

        List<RBB_22C00Entity>list = repository.findAllDataWhitParentCode(tglPelPoran);

        return list;
    }





}
