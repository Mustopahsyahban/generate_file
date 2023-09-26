package com.library.service.otherFacilities;

import com.library.StringNum.StringNum;
import com.library.dao.otherFacilities.OtherFacilitiesDao;
import com.library.entity.OtherFacilitiesEntity;
import com.library.entity.OtherFacilitiesEntity;
import com.library.service.generateFileService.GenerateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class OtherFacilitiesServiceImp implements OtherFacilitiesService {

    @Autowired
    OtherFacilitiesDao otherFacilitiesDao;
    @Autowired
    GenerateFileService generateFileService;
    SimpleDateFormat iob = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat years = new SimpleDateFormat("yyyy");
    SimpleDateFormat month = new SimpleDateFormat("MM");

    @Override
    public List<OtherFacilitiesEntity> findAll() {

        List<OtherFacilitiesEntity>list = otherFacilitiesDao.findAll();
        return list;
    }
    public String  exportFile(String format) {
        Date date = new Date();
        List<OtherFacilitiesEntity> ada = otherFacilitiesDao.findAll();
        String judul = "0103.600816." + years.format(date) + "." + month.format(date) + ".F06.1" + format;
        if(format.equals(".txt")) {
            pathTxt(judul, ada);
            return judul;
        }else if (format.equals(".csv")){
            pathCsv(judul,ada);
            return judul;
        }
        return null;
    }
    public void pathTxt(String fileName, List<OtherFacilitiesEntity> list) {
        Date date = new Date();
        File fileCreate = new File(StringNum.LOCATION_FILE_GENERATE_TXT.getDescription() + fileName);
        String lineUp = "|";

        String headers;
        if(list != null) {
            headers = "H|0103|600816|" + years.format(date) + "|" + month.format(date) + "|F06|186|" + list.size() + "\n";

            List<String> listData = new ArrayList<>();

            for (OtherFacilitiesEntity OtherFacilitiesEntity : list) {

                String datas = setValidationAndSetUpDatasTxt(OtherFacilitiesEntity,lineUp) +"\n";

                listData.add(datas);
            }
            generateFileService.setFileTxtWriter(headers,listData,fileCreate);
        }else {
            headers = "H|0103|600816|" + years.format(date) + "|" + month.format(date) + "|F06|186|" + "0";

            generateFileService.setFileTxtNullDataWriter(headers,fileCreate);
        }
            File file = new File(StringNum.LOCATION_FILE_GENERATE_TXT.getDescription() + fileName);
        if (file.exists()) {
            generateFileService.setGenerateFile(file);
            }
    }

    public void pathCsv(String fileName, List<OtherFacilitiesEntity> list) {
        Date date = new Date();
        File fileCreate = new File(StringNum.LOCATION_FILE_GENERATE_TXT.getDescription() + fileName);
        String [] headers;
        if(list != null) {
            Integer sizeDataint = list.size();
            String sizeData = sizeDataint.toString();
            headers = new String[]{"H","0103","600816",  years.format(date) , month.format(date) ,"F06","186" , sizeData};
            List<String[]> listData = new ArrayList<>();

            for (OtherFacilitiesEntity OtherFacilitiesEntity : list) {

                String[] datas = setValidationAndSetUpDatasCsv(OtherFacilitiesEntity) ;

                listData.add(datas);
            }
            generateFileService.setFileCsvWriter(headers,listData,fileCreate);
        }else {
            headers = new String[]{"H","0103","600816", years.format(date), month.format(date),"F06","186","0"};

            generateFileService.setFileCsvNullDataWriter(headers,fileCreate);
        }
        File file = new File(StringNum.LOCATION_FILE_GENERATE_TXT.getDescription() + fileName);
        if (file.exists()) {
            generateFileService.setGenerateFile(file);
        }
    }
    public String setValidationAndSetUpDatasTxt(OtherFacilitiesEntity entity, String lineUp){
        String 	FLG_DTL= "",
                ANC= "",
                CIF_DEBITUR= "",
                OFT_CODE= "",
                SOURCE_OF_FUNDS= "",
                STAR_DATE= "",
                DUE_DATE= "",
                INTEREST= "",
                CURRENCY_CODE= "",
                NOMINAL= "",
                ORIGINAL_CURENNCY= "",
                COLLECTIBILITY_CODE= "",
                DEFAULT_DATE= "",
                DEFAULT_REASON_CODE= "",
                ARREARS= "",
                DAYS_ARREARS= "",
                CONDITION_CODE= "",
                CONDITION_DATE= "",
                DESCRIPTION= "",
                BRANCH_OFFICIAL_CODE= "",
                DATA_OPERATION = "";

        if(entity.getFlgDtl() != null) {
            FLG_DTL = entity.getFlgDtl().trim();
        }if (entity.getAnc()!=null){
            ANC = entity.getAnc().trim();
        }if (entity.getCifDebitur()!=null){
            CIF_DEBITUR = entity.getCifDebitur().trim();
        }if(entity.getOftCode()!= null){
            OFT_CODE = entity.getOftCode().trim();
        }if (entity.getSourceOfFunds()!=null){
            SOURCE_OF_FUNDS = entity.getSourceOfFunds().trim();
        }if(entity.getStartDate() != null){
            STAR_DATE = (iob.format(entity.getStartDate())).trim();
        }if(entity.getDueDate() !=null){
            DUE_DATE = (iob.format(entity.getDueDate())).trim();
        }if (entity.getInterest()!=null){
            INTEREST = (entity.getInterest()).toString().trim();
        }if (entity.getCurrencyCode()!=null){
            CURRENCY_CODE = entity.getCurrencyCode().trim();
        }if(entity.getNominal() !=null){
            NOMINAL = entity.getNominal().toString().trim();
        }if(entity.getOriginalCurrency()!=null){
            ORIGINAL_CURENNCY = entity.getOriginalCurrency().toString().trim();
        }if(entity.getCollectibilityCode()!=null){
            COLLECTIBILITY_CODE = entity.getCollectibilityCode();
        }if (entity.getDefaultDate()!= null){
            DEFAULT_DATE = (iob.format(entity.getDefaultDate())).trim();
        }if(entity.getDefaultReasonCode()!=null){
            DEFAULT_REASON_CODE = entity.getDefaultReasonCode();
        }if (entity.getArrears()!=null){
            ARREARS = (entity.getArrears()).toString().trim();
        }if (entity.getDaysArrears()!=null){
            DAYS_ARREARS = (entity.getDaysArrears()).toString().trim();
        }if (entity.getConditionCode() != null){
            CONDITION_CODE = entity.getConditionCode().trim();
        }if (entity.getConditionDate() != null){
            CONDITION_DATE = (iob.format(entity.getConditionDate())).trim();
        }if (entity.getDescription()!=null){
            DESCRIPTION = entity.getDescription();
        }if (entity.getBranchOfficialCode()!=null){
            BRANCH_OFFICIAL_CODE = entity.getBranchOfficialCode().trim();
        }if (entity.getDataOperation()!= null){
            DATA_OPERATION = entity.getDataOperation();
        }

        String result = (
                FLG_DTL+lineUp+
                ANC+lineUp+
                CIF_DEBITUR+lineUp+
                OFT_CODE+lineUp+
                SOURCE_OF_FUNDS+lineUp+
                STAR_DATE+lineUp+
                DUE_DATE+lineUp+
                INTEREST+lineUp+
                CURRENCY_CODE+lineUp+
                NOMINAL+lineUp+
                ORIGINAL_CURENNCY+lineUp+
                COLLECTIBILITY_CODE+lineUp+
                DEFAULT_DATE+lineUp+
                DEFAULT_REASON_CODE+lineUp+
                ARREARS+lineUp+
                DAYS_ARREARS+lineUp+
                CONDITION_CODE+lineUp+
                CONDITION_DATE+lineUp+
                DESCRIPTION+lineUp+
                BRANCH_OFFICIAL_CODE+lineUp+
                DATA_OPERATION);


        return result;
    }

    public String[] setValidationAndSetUpDatasCsv(OtherFacilitiesEntity entity){
        String 	FLG_DTL= "",
                ANC= "",
                CIF_DEBITUR= "",
                OFT_CODE= "",
                SOURCE_OF_FUNDS= "",
                STAR_DATE= "",
                DUE_DATE= "",
                INTEREST= "",
                CURRENCY_CODE= "",
                NOMINAL= "",
                ORIGINAL_CURENNCY= "",
                COLLECTIBILITY_CODE= "",
                DEFAULT_DATE= "",
                DEFAULT_REASON_CODE= "",
                ARREARS= "",
                DAYS_ARREARS= "",
                CONDITION_CODE= "",
                CONDITION_DATE= "",
                DESCRIPTION= "",
                BRANCH_OFFICIAL_CODE= "",
                DATA_OPERATION = "";

        if(entity.getFlgDtl() != null) {
            FLG_DTL = entity.getFlgDtl().trim();
        }if (entity.getAnc()!=null){
            ANC = entity.getAnc().trim();
        }if (entity.getCifDebitur()!=null){
            CIF_DEBITUR = entity.getCifDebitur().trim();
        }if(entity.getOftCode()!= null){
            OFT_CODE = entity.getOftCode().trim();
        }if (entity.getSourceOfFunds()!=null){
            SOURCE_OF_FUNDS = entity.getSourceOfFunds().trim();
        }if(entity.getStartDate() != null){
            STAR_DATE = (iob.format(entity.getStartDate())).trim();
        }if(entity.getDueDate() !=null){
            DUE_DATE = (iob.format(entity.getDueDate())).trim();
        }if (entity.getInterest()!=null){
            INTEREST = (entity.getInterest()).toString().trim();
        }if (entity.getCurrencyCode()!=null){
            CURRENCY_CODE = entity.getCurrencyCode().trim();
        }if(entity.getNominal() !=null){
            NOMINAL = entity.getNominal().toString().trim();
        }if(entity.getOriginalCurrency()!=null){
            ORIGINAL_CURENNCY = entity.getOriginalCurrency().toString().trim();
        }if(entity.getCollectibilityCode()!=null){
            COLLECTIBILITY_CODE = entity.getCollectibilityCode();
        }if (entity.getDefaultDate()!= null){
            DEFAULT_DATE = (iob.format(entity.getDefaultDate())).trim();
        }if(entity.getDefaultReasonCode()!=null){
            DEFAULT_REASON_CODE = entity.getDefaultReasonCode();
        }if (entity.getArrears()!=null){
            ARREARS = (entity.getArrears()).toString().trim();
        }if (entity.getDaysArrears()!=null){
            DAYS_ARREARS = (entity.getDaysArrears()).toString().trim();
        }if (entity.getConditionCode() != null){
            CONDITION_CODE = entity.getConditionCode().trim();
        }if (entity.getConditionDate() != null){
            CONDITION_DATE = (iob.format(entity.getConditionDate())).trim();
        }if (entity.getDescription()!=null){
            DESCRIPTION = entity.getDescription();
        }if (entity.getBranchOfficialCode()!=null){
            BRANCH_OFFICIAL_CODE = entity.getBranchOfficialCode().trim();
        }if (entity.getDataOperation()!= null){
            DATA_OPERATION = entity.getDataOperation();
        }

        String[] result = {FLG_DTL,
                ANC,
                CIF_DEBITUR,
                OFT_CODE,
                SOURCE_OF_FUNDS,
                STAR_DATE,
                DUE_DATE,
                INTEREST,
                CURRENCY_CODE,
                NOMINAL,
                ORIGINAL_CURENNCY,
                COLLECTIBILITY_CODE,
                DEFAULT_DATE,
                DEFAULT_REASON_CODE,
                ARREARS,
                DAYS_ARREARS,
                CONDITION_CODE,
                CONDITION_DATE,
                DESCRIPTION,
                BRANCH_OFFICIAL_CODE,
                DATA_OPERATION};


        return result;
    }
}
