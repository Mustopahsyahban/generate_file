package com.library.querySQL;

import com.library.StringNum.StringNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class QuerySQL {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private SimpleDateFormat io = new SimpleDateFormat(StringNum.FORMAT_DATE_STRIP_YYYYMMDD.getDescription());
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
                "      T4_PLUS_2=(SELECT SUM (T4_PLUS_2)  FROM RBB_22C00 rc WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('02','03', '04'))"
                +"      ,DATE_UPDATE = '"+io.format(new Date())+"' " +
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
                "      ,DATE_UPDATE = '"+io.format(new Date())+"' " +
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
                "       ,DATE_UPDATE = '"+io.format(new Date())+"' " +
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
                "       ,DATE_UPDATE = '"+io.format(new Date())+"' " +
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
                "       ,DATE_UPDATE = '"+io.format(new Date())+"' " +
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
                "       ,DATE_UPDATE = '"+io.format(new Date())+"' " +
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
                "       ,DATE_UPDATE = '"+io.format(new Date())+"' " +
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
                "       ,DATE_UPDATE = '"+io.format(new Date())+"' " +
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
                "       ,DATE_UPDATE = '"+io.format(new Date())+"' " +
                "      WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN = '220301990000'");
        jdbcTemplate.execute(no34);
        System.out.println(no34);
    }

    public void setAddDataRbb22C00(Date tglLapor){

        jdbcTemplate.execute("INSERT INTO RBB_22C00 " +
                "( TGL_PELAPORAN, KD_KOMPONEN, NO_KOMPONEN, PARENT_KODE, NM_KOMPONEN, REALISASI_T3, IS_REALISASI_T3, T4_MIN_1, IS_T4_MIN_1, T1, IS_T1, T2, IS_T2, T3, IS_T3, T4, IS_T4, T4_PLUS_1, IS_T4_PLUS_1, T4_PLUS_2, IS_T4_PLUS_2, STATUS, INCLUDE_TEXT, USER_ENTRY, DATE_ENTRY, USER_UPDATE, DATE_UPDATE, IS_FORMULA) " +
                "SELECT '"+io.format(tglLapor)+"' , KD_KOMPONEN, NO_KOMPONEN, PARENT_KODE, NM_KOMPONEN, REALISASI_T3, IS_REALISASI_T3, T4_MIN_1, IS_T4_MIN_1, T1, IS_T1, T2, IS_T2, T3, IS_T3, T4, IS_T4, T4_PLUS_1, IS_T4_PLUS_1, T4_PLUS_2, IS_T4_PLUS_2, STATUS, INCLUDE_TEXT, 'Admin', '"+io.format(new Date())+"', 'Admin', DATE_UPDATE, IS_FORMULA " +
                "FROM RBB_22C00_MASTER");
    }


    public void setAddDataLabaRugi(Date tglLapor){
        jdbcTemplate.execute("INSERT INTO LABA_RUGI " +
                "( TGL_PELAPORAN, KD_KOMPONEN, NO_KOMPONEN, PARENT_KODE, NM_KOMPONEN, DETAIL, MAX_SUM, STATUS,  USER_ENTRY, DATE_ENTRY, USER_UPDATE, DATE_UPDATE) " +
                "SELECT '"+io.format(tglLapor)+"' , KD_KOMPONEN, NO_KOMPONEN, PARENT_KODE, NM_KOMPONEN, DETAIL, MAX_SUM, STATUS, 'Admin', '"+io.format(new Date())+"', 'Admin', DATE_UPDATE " +
                "FROM LABA_RUGI_MASTER");

    }

    public void setChangeAmountLabaRugi (Date tglLapor){


        jdbcTemplate.execute("UPDATE LABA_RUGI " +
                "SET MAX_SUM = (SELECT SUM (DETAIL)  FROM LABA_RUGI WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('01','02','03')) " +
                "WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN='00040000'");

        jdbcTemplate.execute("UPDATE LABA_RUGI " +
                "SET MAX_SUM = (SELECT SUM (DETAIL)  FROM LABA_RUGI WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('06','07','08','09','10')) " +
                "WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN='00110000'");

        jdbcTemplate.execute("UPDATE LABA_RUGI " +
                "SET MAX_SUM = (SELECT SUM (DETAIL)  FROM LABA_RUGI WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('13','14')) " +
                "WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN='00150000'");

        jdbcTemplate.execute("UPDATE LABA_RUGI " +
                "SET MAX_SUM = (SELECT SUM (DETAIL)  FROM LABA_RUGI WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN IN ('17','18')) " +
                "WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN='00190000'");


        jdbcTemplate.execute("UPDATE LABA_RUGI " +
                "SET MAX_SUM = ((SELECT  MAX_SUM  FROM LABA_RUGI WHERE TGL_PELAPORAN = '2023-08-02' AND NO_KOMPONEN =  ('15')) - (SELECT  MAX_SUM  FROM LABA_RUGI WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN =  ('19')) ) " +
                "WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN='00200000'");


        Integer PlushAndMinus = jdbcTemplate.queryForObject("SELECT" +
                " SUM (MAX_SUM)" +
                " FROM " +
                " LABA_RUGI " +
                " WHERE " +
                " TGL_PELAPORAN = '"+io.format(tglLapor)+"' " +
                " AND NO_KOMPONEN IN ('11','20')", Integer.class);
        if(PlushAndMinus == null){
            PlushAndMinus = 0;
        }

        Integer hasil;
        if (PlushAndMinus <= 0){
            hasil =
            jdbcTemplate.queryForObject("SELECT " +
                    " (SUM (MAX_SUM)) + ( SELECT " +
                    " SUM (MAX_SUM) " +
                    " FROM " +
                    "  LABA_RUGI " +
                    " WHERE " +
                    "  TGL_PELAPORAN = '"+io.format(tglLapor)+"' " +
                    "  AND NO_KOMPONEN IN ('11','19')) " +
                    " FROM " +
                    "  LABA_RUGI " +
                    " WHERE " +
                    "  TGL_PELAPORAN = '"+io.format(tglLapor)+"' " +
                    "  AND NO_KOMPONEN IN ('15', '04') ", Integer.class);
        }else{
            hasil =
                    jdbcTemplate.queryForObject("SELECT " +
                    " (SUM (MAX_SUM)) - ( SELECT " +
                    " SUM (MAX_SUM) " +
                    " FROM " +
                    "  LABA_RUGI " +
                    " WHERE " +
                    "  TGL_PELAPORAN = '"+io.format(tglLapor)+"' " +
                    "  AND NO_KOMPONEN IN ('11','19')) " +
                    " FROM " +
                    "  LABA_RUGI " +
                    " WHERE " +
                    "  TGL_PELAPORAN = '"+io.format(tglLapor)+"' " +
                    "  AND NO_KOMPONEN IN ('15', '04') ", Integer.class);
        }

        jdbcTemplate.execute("UPDATE LABA_RUGI " +
                "SET MAX_SUM = "+hasil+
                " WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN='00210000'");

       Integer taskValidasi = jdbcTemplate.queryForObject("SELECT MAX_SUM FROM LABA_RUGI lr WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN = '00210000'", Integer.class);

       if (taskValidasi > 0){
           jdbcTemplate.execute("UPDATE LABA_RUGI"+
                   " SET MAX_SUM =  (SELECT (((MAX_SUM )*10)/100) FROM LABA_RUGI WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN =  ('21'))"+
                   "WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN='00220000'");

           jdbcTemplate.execute("UPDATE LABA_RUGI"+
                   " SET MAX_SUM = ( (SELECT MAX_SUM  FROM LABA_RUGI WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN =  ('21')) - (SELECT MAX_SUM  FROM LABA_RUGI WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND NO_KOMPONEN =  ('22')) )"+
                   "WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN='00230000'");
       }else {

           jdbcTemplate.execute("UPDATE LABA_RUGI" +
                   " SET MAX_SUM = 0  " +
                   "WHERE TGL_PELAPORAN = '" + io.format(tglLapor) + "' AND KD_KOMPONEN='00220000'");

           jdbcTemplate.execute("UPDATE LABA_RUGI"+
                   " SET MAX_SUM ="+taskValidasi +
                   "WHERE TGL_PELAPORAN = '"+io.format(tglLapor)+"' AND KD_KOMPONEN='00230000'");
       }

    }






}
