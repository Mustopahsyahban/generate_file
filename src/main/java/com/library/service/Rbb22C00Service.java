package com.library.service;

import com.library.controller.MasterFormContoller;
import com.library.dao.Rbb22C00Dao;
import com.library.querySQL.QuerySQL;
import com.library.repository.Rbb22C00Repository;
import com.library.entity.RBB_22C00Entity;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public void exportExcel (Date tanggalLapor){

        List<RBB_22C00Entity> ada = repository.findAllData(tanggalLapor);
        if (ada.size()>0) {
            String judul = "Laporan Data Keuangan";
            String form = "RBB_22C00";
            XSSFWorkbook workbook = getWorkbook(form, judul,tanggalLapor);

            pathExcel(judul, workbook);
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

    public XSSFWorkbook getWorkbook(String form, String judul,Date tglLapor) {
        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet1 = workbook.createSheet("Tab1");
        Sheet sheet1 = workbook.createSheet(judul);

        XSSFFont titleFont = (XSSFFont) workbook.createFont();
        titleFont.setBold(true);
        titleFont.setFontHeightInPoints((short) 12);

        XSSFFont headerFont = (XSSFFont) workbook.createFont();
        headerFont.setBold(true);

        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFont(titleFont);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
        headerStyle.setBorderRight(CellStyle.BORDER_THIN);
        headerStyle.setBorderTop(CellStyle.BORDER_THIN);
        headerStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);

        CellStyle decStyle = workbook.createCellStyle();
        decStyle.setBorderBottom(CellStyle.BORDER_THIN);
        decStyle.setBorderLeft(CellStyle.BORDER_THIN);
        decStyle.setBorderRight(CellStyle.BORDER_THIN);
        decStyle.setBorderTop(CellStyle.BORDER_THIN);
        decStyle.setAlignment(CellStyle.ALIGN_RIGHT);

        // sheet 1

        int startCol = 0;
        int headerRow = 0;

        Sheet sheet = sheet1;
        Row row = sheet.createRow(headerRow);
        Cell cell;
        List<String> listColumn = new ArrayList<>();
        listColumn.add("Kode Komponen");
        listColumn.add("Nama Komponen");
        listColumn.add("Realisasi T3");
        listColumn.add("T4 Min 1");
        listColumn.add("T1");
        listColumn.add("T2");
        listColumn.add("T3");
        listColumn.add("T4");
        listColumn.add("T4 Plush 1");
        listColumn.add("T4 Plus 2");


        String sql = "", cols = "";
        int headerCol = startCol;
        HashMap<Integer, Object> mapCol = new HashMap<Integer, Object>();
        List<String> urut = new ArrayList<String>();
        int idx = 0;
        for (String col : listColumn) {
            cell = row.createCell(headerCol++);
            cell.setCellValue(col);
            cell.setCellStyle(headerStyle);
            urut.add(col);

            cols += col + ", ";

            mapCol.put(idx++, col);
        }
        List<RBB_22C00Entity> listDataGen = repository.findAllData(tglLapor);
        int isi = 1;

        int isi1 = isi;
        if (listDataGen.size() > 0) {
            for (int x = 0; x < listDataGen.size(); x++) {
                RBB_22C00Entity deb = listDataGen.get(x);
                sheet = sheet1;
                row = sheet.createRow(isi1++);

                int colNumber = 0, ix = 0;
                for (int y = 0; y < listColumn.size(); y++) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    cell = row.createCell(colNumber++);
                    String v = "";
                    Object cellValue = null;
                    if(x == 0){
                    cellValue = deb.getKdKomponen();
                    }else if(x == 1){
                        cellValue= deb.getNmKomponen();
                    }else if(x == 2){
                        cellValue= deb.getRealisaiT3();
                    }else if(x == 3){
                        cellValue= deb.getT4Min1();
                    }else if(x == 4){
                        cellValue= deb.getT1();
                    }else if(x == 5){
                        cellValue= deb.getT2();
                    }else if(x == 6){
                        cellValue= deb.getT3();
                    }else if(x == 7){
                        cellValue= deb.getT4();
                    }else if(x == 8){
                        cellValue= deb.getT4Plus1();
                    }else if(x == 9){
                        cellValue= deb.getT4Plus2();
                    }
//					System.out.print(cellValue);
                    if (cellValue instanceof Date) {
                        v = cellValue == null || String.valueOf(cellValue) == "" ? "" : sdf.format(cellValue);
                    } else {
                        v = cellValue == null || String.valueOf(cellValue) == "" ? "" : String.valueOf(cellValue);
                    }
                    cell.setCellValue(v);
                    cell.setCellStyle(style);
                }
//				System.out.println("");

                int end = sheet.getRow(headerRow).getLastCellNum();
                for (int i = 0; i < end; i++){
                    sheet.autoSizeColumn(i);
                }
            }

            return (XSSFWorkbook) workbook;
        } else {

            return null;
        }
    }

    public static void pathExcel(String fileName, XSSFWorkbook sxssfWorkbook) {

        File file = new File(fileName + ".xlsx");

        try {
            FileOutputStream streamOut = new FileOutputStream(file);
            sxssfWorkbook.write(streamOut);
            streamOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
