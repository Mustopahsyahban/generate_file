package com.library.querySQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class QuerySQL {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private SimpleDateFormat io = new SimpleDateFormat("yyyy-MM-dd");
    public void setDoChangeAmountRbb22C(Date tglLapor){


        String no05 = ("UPDATE RBB_22C00 " +
                "      SET " +
                "      REALISASI_T3= (SELECT SUM (REALISASI_T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN ='"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('02','03', '04'))," +
                "      T4_MIN_1=(SELECT SUM (T4_MIN_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('02','03', '04')), " +
                "      T1=(SELECT SUM (T1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('02','03', '04')), " +
                "      T2=(SELECT SUM (T2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('02','03', '04')), " +
                "      T3=(SELECT SUM (T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('02','03', '04')), " +
                "      T4=(SELECT SUM (T4)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('02','03', '04')), " +
                "      T4_PLUS_1=(SELECT SUM (T4_PLUS_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('02','03', '04')), " +
                "      T4_PLUS_2=(SELECT SUM (T4_PLUS_2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('02','03', '04')) " +
                "      WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN = '220301010199'");
        //noKomponen = 05
        jdbcTemplate.execute(no05);
        System.out.println(no05);


        //noKomponen = 10
        String no10 = ("UPDATE RBB_22C00 " +
                "      SET " +
                "      REALISASI_T3= (SELECT SUM (REALISASI_T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN ='"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('07','08', '09'))," +
                "      T4_MIN_1=(SELECT SUM (T4_MIN_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('07','08', '09')), " +
                "      T1=(SELECT SUM (T1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('07','08', '09')), " +
                "      T2=(SELECT SUM (T2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('07','08', '09')), " +
                "      T3=(SELECT SUM (T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('07','08', '09')), " +
                "      T4=(SELECT SUM (T4)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('07','08', '09')), " +
                "      T4_PLUS_1=(SELECT SUM (T4_PLUS_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('07','08', '09')), " +
                "      T4_PLUS_2=(SELECT SUM (T4_PLUS_2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('07','08', '09')) " +
                "      WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN = '220301010299'");
        jdbcTemplate.execute(no10);
        System.out.println(no10);

        String no15 = ("UPDATE RBB_22C00 " +
                "      SET " +
                "      REALISASI_T3= (SELECT SUM (REALISASI_T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN ='"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('12','13', '14'))," +
                "      T4_MIN_1=(SELECT SUM (T4_MIN_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('12','13', '14')), " +
                "      T1=(SELECT SUM (T1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('12','13', '14')), " +
                "      T2=(SELECT SUM (T2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('12','13', '14')), " +
                "      T3=(SELECT SUM (T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('12','13', '14')), " +
                "      T4=(SELECT SUM (T4)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('12','13', '14')), " +
                "      T4_PLUS_1=(SELECT SUM (T4_PLUS_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('12','13', '14')), " +
                "      T4_PLUS_2=(SELECT SUM (T4_PLUS_2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('12','13', '14')) " +
                "      WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN = '220301010399'");
//15
        jdbcTemplate.execute(no15);
        System.out.println(no15);

        String no22 = ("UPDATE RBB_22C00 " +
                "      SET " +
                "      REALISASI_T3= (SELECT SUM (REALISASI_T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN ='"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('19','20', '21'))," +
                "      T4_MIN_1=(SELECT SUM (T4_MIN_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('19','20', '21')), " +
                "      T1=(SELECT SUM (T1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('19','20', '21')), " +
                "      T2=(SELECT SUM (T2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('19','20', '21')), " +
                "      T3=(SELECT SUM (T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('19','20', '21')), " +
                "      T4=(SELECT SUM (T4)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('19','20', '21')), " +
                "      T4_PLUS_1=(SELECT SUM (T4_PLUS_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('19','20', '21')), " +
                "      T4_PLUS_2=(SELECT SUM (T4_PLUS_2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('19','20', '21')) " +
                "      WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN = '220301020199'");
        //22
        jdbcTemplate.execute(no22);
        System.out.println(no22);


        String no27 =  ("UPDATE RBB_22C00 " +
                "      SET " +
                "      REALISASI_T3= (SELECT SUM (REALISASI_T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN ='"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('24','25', '26'))," +
                "      T4_MIN_1=(SELECT SUM (T4_MIN_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('24','25', '26')), " +
                "      T1=(SELECT SUM (T1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('24','25', '26')), " +
                "      T2=(SELECT SUM (T2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('24','25', '26')), " +
                "      T3=(SELECT SUM (T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('24','25', '26')), " +
                "      T4=(SELECT SUM (T4)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('24','25', '26')), " +
                "      T4_PLUS_1=(SELECT SUM (T4_PLUS_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('24','25', '26')), " +
                "      T4_PLUS_2=(SELECT SUM (T4_PLUS_2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('24','25', '26')) " +
                "      WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN = '220301020299'");
        //27
        jdbcTemplate.execute(no27);
        System.out.println(no27);
        //27

        String no32= ("UPDATE RBB_22C00 " +
                "      SET " +
                "      REALISASI_T3= (SELECT SUM (REALISASI_T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN ='"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('29','30', '31'))," +
                "      T4_MIN_1=(SELECT SUM (T4_MIN_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('29','30', '31')), " +
                "      T1=(SELECT SUM (T1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('29','30', '31')), " +
                "      T2=(SELECT SUM (T2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('29','30', '31')), " +
                "      T3=(SELECT SUM (T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('29','30', '31')), " +
                "      T4=(SELECT SUM (T4)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('29','30', '31')), " +
                "      T4_PLUS_1=(SELECT SUM (T4_PLUS_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('29','30', '31')), " +
                "      T4_PLUS_2=(SELECT SUM (T4_PLUS_2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('29','30', '31')) " +
                "      WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN = '220301020399'");
        jdbcTemplate.execute(no32);
        System.out.println(no32);
//16
        String no16 = ("UPDATE RBB_22C00 " +
                "      SET " +
                "      REALISASI_T3= (SELECT SUM (REALISASI_T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN ='"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('05','10', '15'))," +
                "      T4_MIN_1=(SELECT SUM (T4_MIN_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('05','10', '15')), " +
                "      T1=(SELECT SUM (T1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('05','10', '15')), " +
                "      T2=(SELECT SUM (T2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('05','10', '15')), " +
                "      T3=(SELECT SUM (T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('05','10', '15')), " +
                "      T4=(SELECT SUM (T4)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('05','10', '15')), " +
                "      T4_PLUS_1=(SELECT SUM (T4_PLUS_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('05','10', '15')), " +
                "      T4_PLUS_2=(SELECT SUM (T4_PLUS_2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('05','10', '15')) " +
                "      WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN = '220301019900'");
        jdbcTemplate.execute(no16);
        System.out.println(no16);
        //33

        String no33 = ("UPDATE RBB_22C00 " +
                "      SET " +
                "      REALISASI_T3= (SELECT SUM (REALISASI_T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN ='"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('22','27', '32'))," +
                "      T4_MIN_1=(SELECT SUM (T4_MIN_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('22','27', '32')), " +
                "      T1=(SELECT SUM (T1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('22','27', '32')), " +
                "      T2=(SELECT SUM (T2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('22','27', '32')), " +
                "      T3=(SELECT SUM (T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('22','27', '32')), " +
                "      T4=(SELECT SUM (T4)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('22','27', '32')), " +
                "      T4_PLUS_1=(SELECT SUM (T4_PLUS_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('22','27', '32')), " +
                "      T4_PLUS_2=(SELECT SUM (T4_PLUS_2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('22','27', '32')) " +
                "      WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN = '220301029900'");
        jdbcTemplate.execute(no33);
        System.out.println(no33);
//43

        String no34 = ("UPDATE RBB_22C00 " +
                "      SET " +
                "      REALISASI_T3= (SELECT SUM (REALISASI_T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN ='"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('16','33'))," +
                "      T4_MIN_1=(SELECT SUM (T4_MIN_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('16','33')), " +
                "      T1=(SELECT SUM (T1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('16','33')), " +
                "      T2=(SELECT SUM (T2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('16','33')), " +
                "      T3=(SELECT SUM (T3)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('16','33')), " +
                "      T4=(SELECT SUM (T4)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('16','33')), " +
                "      T4_PLUS_1=(SELECT SUM (T4_PLUS_1)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('16','33')), " +
                "      T4_PLUS_2=(SELECT SUM (T4_PLUS_2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('16','33')) " +
                "      WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN = '220301990000'");
        jdbcTemplate.execute(no34);
        System.out.println(no34);
    }
}
