package com.library.service;

import com.library.controller.MasterFormContoller;
import com.library.dao.Rbb22C00Dao;
import com.library.querySQL.QuerySQL;
import com.library.repository.Rbb22C00Repository;
import com.library.entity.RBB_22C00Entity;
import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
@Service
public class Rbb22C00Service {

    @Autowired
    private Rbb22C00Repository repository;

    @Autowired
    HttpServletResponse response;

    @Autowired
    MasterFormContoller masterForm;

    @Autowired
    public Rbb22C00Repository rbb22C00Repository;


    @Autowired
    private Rbb22C00Dao dao;
    @Autowired
    QuerySQL querySQL;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleDateFormat io = new SimpleDateFormat("yyyy-MM-dd");


    public RBB_22C00Entity getById(Long id) {
        RBB_22C00Entity entity = dao.getByIdDao(id);

        return entity;
    }

    public String getName(String kdForm) {

        String nameForm = masterForm.getNameForm(kdForm);

        return nameForm;
    }

    public Date getTglLaporById(Long id) {

        RBB_22C00Entity entity = dao.getByIdDao(id);

        return entity.getTglPelaporan();
    }


    public Boolean cekAddData(Date tglLapor) {
        List<RBB_22C00Entity> list = dao.findAllDataByTglLaporDao(tglLapor);
        if (list.size() == 0) {
            return true;
        } else {

            return false;
        }
    }

    public void exportExcel(Date tanggalLapor) {

        List<RBB_22C00Entity> ada = repository.findAllData(tanggalLapor);
        if (ada.size() > 0) {
            String judul = "Laporan Data Keuangan.csv";

          pathExcel(judul, ada);

        }

    }

    public void exportTxt(Date tanggalLapor) {

        List<RBB_22C00Entity> ada = repository.findAllData(tanggalLapor);
        if (ada.size() > 0) {
            String judul = "Laporan Data Keuangan.txt";

            pathExcelTxt(judul, ada);

        }

    }

    public void tambahData(Date tglLapor) {
        dao.queryAddData(tglLapor);
    }

    public List<RBB_22C00Entity> findAll(Date tglLapor) {

        List<RBB_22C00Entity> list = dao.findAllDataByTglLaporDao(tglLapor);

        return list;

    }

    public void save(RBB_22C00Entity dto) {


        //update
        if (dto.getId() != null) {
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

        } else {
            //Crate
            RBB_22C00Entity entity = repository.save(dto);

        }

    }

    public RBB_22C00Entity getUpdateData(Long id) {

        RBB_22C00Entity entity = dao.getUpdateData(id);
        RBB_22C00Entity dto = new RBB_22C00Entity(
                entity.getId(), entity.getTglPelaporan(), entity.getKdKomponen(), entity.getNmKomponen(),
                entity.getRealisaiT3(), entity.getT4Min1(), entity.getT1(), entity.getT2(),
                entity.getT3(), entity.getT4(), entity.getT4Plus1(), entity.getT4Plus2());
        return dto;
    }

    public void pathExcel(String fileName, List<RBB_22C00Entity> list) {

        try {

            FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\Documents\\project\\MiniApolo\\mini-apolo\\"+fileName);
            OutputStreamWriter writerOutput = new OutputStreamWriter(fos);
            CSVWriter writer = new CSVWriter(writerOutput, '|',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            String[] headers = {"Kode Komponen", "Nama Komonen", "Reaslisai T3", "T4 Min 1", "T1", "T2", "T3", "T4", "T4 Plus1", "T4 Plush 2"};

            String realisasiT3, t4min1,t1,t2,t3,t4,t4plus1,t4plus2;

            System.out.println(headers);
            writer.writeNext(headers);
            for (RBB_22C00Entity rbb22C00Entity : list) {
                String kdKomponen = rbb22C00Entity.getKdKomponen();
                String namaKomponen = rbb22C00Entity.getNmKomponen();

                //Realisai T3
                if (rbb22C00Entity.getRealisaiT3() == null) {
                    realisasiT3 = "";
                }else{
                    realisasiT3 = rbb22C00Entity.getRealisaiT3().toString().replace(".00", "");
                }

                //T4min1
                if (rbb22C00Entity.getT4Min1() == null) {
                    t4min1 = "";
                }else{
                    t4min1 = rbb22C00Entity.getT4Min1().toString().replace(".00", "");
                }

                //T1
                if (rbb22C00Entity.getT1() == null) {
                    t1 = "";
                }else{
                    t1 = rbb22C00Entity.getT1().toString().replace(".00", "");
                }

                //T2
                if (rbb22C00Entity.getT2() == null) {
                    t2 = "";
                }else{
                    t2 = rbb22C00Entity.getT2().toString().replace(".00", "");
                }

                //T3
                if (rbb22C00Entity.getT3() == null) {
                    t3 = "";
                }else{
                    t3 = rbb22C00Entity.getT3().toString().replace(".00", "");
                }

                //T4
                if (rbb22C00Entity.getT4() == null) {
                   t4 = "";
                }else{
                    t4 = rbb22C00Entity.getT4().toString().replace(".00", "");
                }

                //T4Plus1
                if (rbb22C00Entity.getT4Plus1() == null) {
                    t4plus1 = "";
                }
                else{
                    t4plus1 = rbb22C00Entity.getT4Plus1().toString().replace(".00", "");
                }
                if (rbb22C00Entity.getT4Plus2() == null) {
                    t4plus2 = "";
                }else{
                    t4plus2 = rbb22C00Entity.getT4Plus2().toString().replace(".00", "");
                }

                String[] datas = {kdKomponen, namaKomponen, realisasiT3,t4min1,t1, t2,t3, t4,t4plus1, t4plus2};
                writer.writeNext(datas);
                System.out.println(datas);

            }
            writer.flush();
            writerOutput.close();
            fos.close();

            File file = new File("C:\\Users\\user\\Documents\\project\\MiniApolo\\mini-apolo\\" + fileName);
            if (file.exists()) {
                String url = URLConnection.guessContentTypeFromName(file.getName());
                if (url == null) {

                    url = "application/octet-stream";
                }
                response.setContentType(url);

                response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName()));

                response.setContentLength((int) file.length());

                InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

                FileCopyUtils.copy(inputStream, response.getOutputStream());

                System.out.println(writer);


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void pathExcelTxt(String fileName, List<RBB_22C00Entity> list) {

            try {

                File fileCreate = new File("C:\\Users\\user\\Documents\\project\\MiniApolo\\mini-apolo\\"+ fileName);

                FileWriter writer = new FileWriter(fileCreate);
                String lineUp = "|";

                String headers = "Kode Komponen"+lineUp+ "Nama Komonen"+lineUp+ "Reaslisai T3"+lineUp+ "T4 Min 1"+lineUp+ "T1"+lineUp+"T2"+lineUp+ "T3"+lineUp+ "T4"+lineUp+ "T4 Plus1"+lineUp+ "T4 Plush 2"+"\n";

                System.out.println(headers);
                writer.write(headers);
                for (RBB_22C00Entity rbb22C00Entity : list) {

                    String realisasiT3, t4min1,t1,t2,t3,t4,t4plus1,t4plus2;
                    String kdKomponen = rbb22C00Entity.getKdKomponen();
                    String namaKomponen = rbb22C00Entity.getNmKomponen();

                    //Realisai T3
                    if (rbb22C00Entity.getRealisaiT3() == null) {
                        realisasiT3 = "";
                    }else{
                        realisasiT3 = rbb22C00Entity.getRealisaiT3().toString().replace(".00", "");
                    }

                    //T4min1
                    if (rbb22C00Entity.getT4Min1() == null) {
                        t4min1 = "";
                    }else{
                        t4min1 = rbb22C00Entity.getT4Min1().toString().replace(".00", "");
                    }

                    //T1
                    if (rbb22C00Entity.getT1() == null) {
                        t1 = "";
                    }else{
                        t1 = rbb22C00Entity.getT1().toString().replace(".00", "");
                    }

                    //T2
                    if (rbb22C00Entity.getT2() == null) {
                        t2 = "";
                    }else{
                        t2 = rbb22C00Entity.getT2().toString().replace(".00", "");
                    }

                    //T3
                    if (rbb22C00Entity.getT3() == null) {
                        t3 = "";
                    }else{
                        t3 = rbb22C00Entity.getT3().toString().replace(".00", "");
                    }

                    //T4
                    if (rbb22C00Entity.getT4() == null) {
                        t4 = "";
                    }else{
                        t4 = rbb22C00Entity.getT4().toString().replace(".00", "");
                    }

                    //T4Plus1
                    if (rbb22C00Entity.getT4Plus1() == null) {
                        t4plus1 = "";
                    }
                    else{
                        t4plus1 = rbb22C00Entity.getT4Plus1().toString().replace(".00", "");
                    }
                    if (rbb22C00Entity.getT4Plus2() == null) {
                        t4plus2 = "";
                    }else{
                        t4plus2 = rbb22C00Entity.getT4Plus2().toString().replace(".00", "");
                    }

                    String datas = kdKomponen+lineUp+ namaKomponen+lineUp+ realisasiT3+lineUp+ t4min1+lineUp+ t1+lineUp+
                            t2+lineUp+ t3+lineUp+ t4+lineUp+ t4plus1+lineUp+t4plus2+"\n";
                    writer.write(datas);
                    System.out.println(datas);

                }
                writer.flush();
                writer.close();

                File file = new File("C:\\Users\\user\\Documents\\project\\MiniApolo\\mini-apolo\\"+ fileName);
                if(file.exists()) {
                    String url = URLConnection.guessContentTypeFromName(file.getName());


                        url = "application/octet-stream";

                    response.setContentType(url);

                    response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName()));

                    response.setContentLength((int) file.length());

                    InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

                    FileCopyUtils.copy(inputStream, response.getOutputStream());

                    System.out.println(writer);


                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }



}
