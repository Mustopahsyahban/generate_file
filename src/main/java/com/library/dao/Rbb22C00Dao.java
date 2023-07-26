package com.library.dao;

import com.library.entity.RBB_22C00Entity;
import com.library.StringNum.StringNum;
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
        jdbcTemplate.execute("INSERT INTO RBB_22C00\n" +
                "( TGL_PELAPORAN, KD_KOMPONEN, NO_KOMPONEN, PARENT_KODE, NM_KOMPONEN, REALISASI_T3, IS_REALISASI_T3, T4_MIN_1, IS_T4_MIN_1, T1, IS_T1, T2, IS_T2, T3, IS_T3, T4, IS_T4, T4_PLUS_1, IS_T4_PLUS_1, T4_PLUS_2, IS_T4_PLUS_2, STATUS, INCLUDE_TEXT, USER_ENTRY, DATE_ENTRY, USER_UPDATE, DATE_UPDATE, IS_FORMULA)\n" +
                "SELECT '"+io.format(tglLapor)+"' , KD_KOMPONEN, NO_KOMPONEN, PARENT_KODE, NM_KOMPONEN, REALISASI_T3, IS_REALISASI_T3, T4_MIN_1, IS_T4_MIN_1, T1, IS_T1, T2, IS_T2, T3, IS_T3, T4, IS_T4, T4_PLUS_1, IS_T4_PLUS_1, T4_PLUS_2, IS_T4_PLUS_2, STATUS, INCLUDE_TEXT, 'Admin', '"+io.format(new Date())+"', 'Admin', DATE_UPDATE, IS_FORMULA\n" +
                "FROM RBB_22C00_MASTER");

    }

    public RBB_22C00Entity getUpdateData(Long id){
        RBB_22C00Entity entity = repository.findById(id).get();
        return entity;
    }

    public String getNameForm (String kdForm){
        String nameForm = formService.getNameForm(kdForm);

        return nameForm;
    }

    public List<RBB_22C00Entity>getDataDoChangeAmount(Date tglPelPoran){

        List<RBB_22C00Entity>list = repository.findAllDataWhitParentCode(tglPelPoran);

        return list;
    }





}
