package com.library.service.businessEntityDebtor;

import com.library.StringNum.StringNum;
import com.library.dao.businessEntityDebtor.BusinessEntityDebtorDao;
import com.library.entity.BusinessEntityDebtorEntity;
import com.library.service.generateFileService.GenerateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Service
public class BusinessEntityDebtorServiceImp implements BusinessEntityDebtorService {


    @Autowired
    BusinessEntityDebtorDao businessEntityDebtorDao;
    @Autowired
    GenerateFileService generateFileService;
    SimpleDateFormat iob = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat years = new SimpleDateFormat("yyyy");
    SimpleDateFormat month = new SimpleDateFormat("MM");
    @Override
    public List<BusinessEntityDebtorEntity> findAll() {
        List<BusinessEntityDebtorEntity>list = businessEntityDebtorDao.findAll();

        return list;
    }
    public String  exportFile(String format) {
        Date date = new Date();
        List<BusinessEntityDebtorEntity> ada = businessEntityDebtorDao.findAll();
        String judul = "0103.600816." + years.format(date) + "." + month.format(date) + ".D02.1" + format;
            if (format.equals(".txt")) {
                pathTxt(judul, ada);
                return judul;
            } else if (format.equals(".csv")) {

                pathExcel(judul,ada);
                return judul;
    }
    return null;
    }
    public void pathTxt(String fileName, List<BusinessEntityDebtorEntity> list) {
            File fileCreate = new File(StringNum.LOCATION_FILE_GENERATE_TXT.getDescription()+ fileName);
            Date date = new Date();
            String lineUp = "|";
            String headers;
            if(list != null) {
                headers = "H|0103|600816|" + years.format(date) + "|" + month.format(date) + "|D02|186|" + list.size() + "\n";

                List<String> listData = new ArrayList<>();
                for (BusinessEntityDebtorEntity BusinessEntityDebtorEntity : list) {

                    String datas = setValidationAndSetUpDatasTxt(BusinessEntityDebtorEntity, lineUp) + "\n";

                    listData.add(datas);
                }
                generateFileService.setFileTxtWriter(headers, listData, fileCreate);
            }else {
                headers = "H|0103|600816|" + years.format(date) + "|" + month.format(date) + "|D02|186|" + "0";
                generateFileService.setFileTxtNullDataWriter(headers,fileCreate);
            }
            File file = new File(StringNum.LOCATION_FILE_GENERATE_TXT.getDescription() + fileName);
            if (file.exists()) {
               generateFileService.setGenerateFile(file);
            }
    }

    public void pathExcel (String fileName, List<BusinessEntityDebtorEntity> list) {
        File fileCreate = new File(StringNum.LOCATION_FILE_GENERATE_TXT.getDescription()+ fileName);
        Date date = new Date();

        String[] headers;
        if(list != null) {
            Integer sizeDataint = list.size();
            String sizeData = sizeDataint.toString();
            headers = new String[]{"H","0103","600816" , years.format(date) , month.format(date) , "D02","186" , sizeData};

            List<String[]> listData = new ArrayList<>();
            for (BusinessEntityDebtorEntity BusinessEntityDebtorEntity : list) {

                String[] datas = setValidationAndSetUpDatasCsv(BusinessEntityDebtorEntity);

                listData.add(datas);
            }
            generateFileService.setFileCsvWriter(headers, listData, fileCreate);
        }else {
            headers = new String[]{"H","0103","600816" , years.format(date) , month.format(date) , "D02","186" , "0" , "\n"};

            generateFileService.setFileCsvNullDataWriter(headers,fileCreate);
        }
        File file = new File(StringNum.LOCATION_FILE_GENERATE_TXT.getDescription() + fileName);
        if (file.exists()) {
            generateFileService.setGenerateFile(file);
        }
    }
    public String setValidationAndSetUpDatasTxt(BusinessEntityDebtorEntity entity, String lineUp){
        String FLG_DTL = "",
                CIF = "",
                BUSS_ENTITY_ID_NUMBER= "",
                BUSS_ENTITY_NAME= "",
                BUSS_ENTITY_TYPE_CODE = "",
                PLACE_OF_ESTABLISHMENT= "",
                ESTABLISHMENT_DEED_DATE= "",
                LAST_AMENDMENT_DEED_NUMBER= "",
                LAST_AMENDMENT_DEED_DATE= "",
                TLP_NUMBER= "",
                MOBILE_NUMBER= "",
                EMAIL= "",
                ADDRESS= "",
                SUB_DISTRICT= "",
                DISTRICT= "",
                CITY_CODE= "",
                POSTAL_CODE= "",
                COUNTRY_CODE_OF_DOMICILE= "",
                BUSINESS_FIELD_CODE= "",
                RELATION_REPORTER_CODE= "",
                VIOL_BMPK_BMPD_BMPP= "",
                EXCE_BMPK_BMPD_BMPP= "",
                GO_PUBLIC= "",
                DEBTOR_GROUP_CODE= "",
                DEBTOR_RATING= "",
                RATING_AGENCY= "",
                RATING_DATE= "",
                DEBTOR_GROUP_NAME= "",
                BRANCH_OFFICE_CODE= "",
                DATA_OPERATION= "";

        if (entity.getFlgDtl()!= null){
            FLG_DTL = entity.getFlgDtl().trim();
        }if (entity.getCif() != null){
            CIF = entity.getCif().trim();
        }if(entity.getBussEntityIdNumber() != null){
            BUSS_ENTITY_ID_NUMBER = entity.getBussEntityIdNumber().trim();
        }if(entity.getBussEntityName() != null){
            BUSS_ENTITY_NAME = entity.getBussEntityName().trim();
        }if(entity.getBussEntityTypeCode() != null){
            BUSS_ENTITY_TYPE_CODE = entity.getBussEntityTypeCode().trim();
        }if(entity.getPlaceOfEstablishment() != null){
            PLACE_OF_ESTABLISHMENT = entity.getPlaceOfEstablishment().trim();
        }if (entity.getEstablishmentDeedDate()!=null){
            ESTABLISHMENT_DEED_DATE = iob.format(entity.getEstablishmentDeedDate()).trim();
        }if(entity.getLastAmendmentNumber()!=null){
            LAST_AMENDMENT_DEED_NUMBER = entity.getLastAmendmentNumber().trim();
        }if (entity.getLastAmendmentDate()!=null){
            LAST_AMENDMENT_DEED_DATE = iob.format(entity.getLastAmendmentDate()).trim();
        }if(entity.getTlpNumber() != null){
            TLP_NUMBER = entity.getTlpNumber().trim();
        }if(entity.getMobileNumber()!= null) {
            MOBILE_NUMBER = entity.getMobileNumber().trim();
        }if(entity.getEmail()!=null) {
            EMAIL = entity.getEmail().trim();
        }if (entity.getAddress()!= null){
            ADDRESS = entity.getAddress().trim();
        }if(entity.getSubDistrict()!= null){
            SUB_DISTRICT = entity.getSubDistrict().trim();
        }if (entity.getDistrict()!=null){
            DISTRICT = entity.getDistrict().trim();
        }if(entity.getCityCode()!= null){
            CITY_CODE = entity.getCityCode().trim();
        }if(entity.getPostalCode()!= null){
            POSTAL_CODE = entity.getPostalCode().trim();
        }if (entity.getCountryCodeDomicile()!=null) {
            COUNTRY_CODE_OF_DOMICILE = entity.getCountryCodeDomicile().trim();
        }if (entity.getBusinessFieldCode()!= null){
            BUSINESS_FIELD_CODE = entity.getBusinessFieldCode().trim();
        }if (entity.getRelationReporterCode()!=null){
            RELATION_REPORTER_CODE = entity.getRelationReporterCode().trim();
        }if(entity.getViolBmpkBmpdBmpp()!= null){
            VIOL_BMPK_BMPD_BMPP = entity.getViolBmpkBmpdBmpp().trim();
        }if(entity.getExceBmpBmpdBmpp()!=null) {
            EXCE_BMPK_BMPD_BMPP = entity.getExceBmpBmpdBmpp().trim();
        }if(entity.getGoPublic() !=null){
            GO_PUBLIC = entity.getGoPublic().trim();
        }if (entity.getDebtorGroupCode()!=null){
            DEBTOR_GROUP_CODE = entity.getDebtorGroupCode().trim();
        }if(entity.getDebtorRating() !=null){
            DEBTOR_RATING = entity.getDebtorRating().trim();
        }if(entity.getRatingAgency() != null){
            RATING_AGENCY = entity.getRatingAgency().trim();
        }if(entity.getRatingDate()!=null){
            RATING_DATE = iob.format(entity.getRatingDate()).trim();
        }if(entity.getDebtorGroupName()!=null){
            DEBTOR_GROUP_NAME = entity.getDebtorGroupName().trim();
        }if (entity.getBranchOfficeCode() != null) {
            BRANCH_OFFICE_CODE = entity.getBranchOfficeCode().trim();
        } if (entity.getDataOperation()!=null){
            DATA_OPERATION = entity.getDataOperation().trim();
        }
        String result = (FLG_DTL + lineUp +
                    CIF + lineUp +
                    BUSS_ENTITY_ID_NUMBER + lineUp +
                    BUSS_ENTITY_NAME + lineUp +
                    BUSS_ENTITY_TYPE_CODE + lineUp +
                    PLACE_OF_ESTABLISHMENT + lineUp +
                    ESTABLISHMENT_DEED_DATE + lineUp +
                    LAST_AMENDMENT_DEED_NUMBER + lineUp +
                    LAST_AMENDMENT_DEED_DATE + lineUp +
                    TLP_NUMBER + lineUp +
                    MOBILE_NUMBER + lineUp +
                    EMAIL + lineUp +
                    ADDRESS + lineUp +
                    SUB_DISTRICT + lineUp +
                    DISTRICT + lineUp +
                    CITY_CODE + lineUp +
                    POSTAL_CODE + lineUp +
                    COUNTRY_CODE_OF_DOMICILE + lineUp +
                    BUSINESS_FIELD_CODE + lineUp +
                    RELATION_REPORTER_CODE + lineUp +
                    VIOL_BMPK_BMPD_BMPP + lineUp +
                    EXCE_BMPK_BMPD_BMPP + lineUp +
                    GO_PUBLIC + lineUp +
                    DEBTOR_GROUP_CODE + lineUp +
                    DEBTOR_RATING + lineUp +
                    RATING_AGENCY + lineUp +
                    RATING_DATE + lineUp +
                    DEBTOR_GROUP_NAME + lineUp +
                    BRANCH_OFFICE_CODE + lineUp +
                    DATA_OPERATION);
        return result;
    }

    public String[] setValidationAndSetUpDatasCsv(BusinessEntityDebtorEntity entity){
        String FLG_DTL = "",
                CIF = "",
                BUSS_ENTITY_ID_NUMBER= "",
                BUSS_ENTITY_NAME= "",
                BUSS_ENTITY_TYPE_CODE = "",
                PLACE_OF_ESTABLISHMENT= "",
                ESTABLISHMENT_DEED_DATE= "",
                LAST_AMENDMENT_DEED_NUMBER= "",
                LAST_AMENDMENT_DEED_DATE= "",
                TLP_NUMBER= "",
                MOBILE_NUMBER= "",
                EMAIL= "",
                ADDRESS= "",
                SUB_DISTRICT= "",
                DISTRICT= "",
                CITY_CODE= "",
                POSTAL_CODE= "",
                COUNTRY_CODE_OF_DOMICILE= "",
                BUSINESS_FIELD_CODE= "",
                RELATION_REPORTER_CODE= "",
                VIOL_BMPK_BMPD_BMPP= "",
                EXCE_BMPK_BMPD_BMPP= "",
                GO_PUBLIC= "",
                DEBTOR_GROUP_CODE= "",
                DEBTOR_RATING= "",
                RATING_AGENCY= "",
                RATING_DATE= "",
                DEBTOR_GROUP_NAME= "",
                BRANCH_OFFICE_CODE= "",
                DATA_OPERATION= "";

        if (entity.getFlgDtl()!= null){
            FLG_DTL = entity.getFlgDtl().trim();
        }if (entity.getCif() != null){
            CIF = entity.getCif().trim();
        }if(entity.getBussEntityIdNumber() != null){
            BUSS_ENTITY_ID_NUMBER = entity.getBussEntityIdNumber().trim();
        }if(entity.getBussEntityName() != null){
            BUSS_ENTITY_NAME = entity.getBussEntityName().trim();
        }if(entity.getBussEntityTypeCode() != null){
            BUSS_ENTITY_TYPE_CODE = entity.getBussEntityTypeCode().trim();
        }if(entity.getPlaceOfEstablishment() != null){
            PLACE_OF_ESTABLISHMENT = entity.getPlaceOfEstablishment().trim();
        }if (entity.getEstablishmentDeedDate()!=null){
            ESTABLISHMENT_DEED_DATE = iob.format(entity.getEstablishmentDeedDate()).trim();
        }if(entity.getLastAmendmentNumber()!=null){
            LAST_AMENDMENT_DEED_NUMBER = entity.getLastAmendmentNumber().trim();
        }if (entity.getLastAmendmentDate()!=null){
            LAST_AMENDMENT_DEED_DATE = iob.format(entity.getLastAmendmentDate()).trim();
        }if(entity.getTlpNumber() != null){
            TLP_NUMBER = entity.getTlpNumber().trim();
        }if(entity.getMobileNumber()!= null) {
            MOBILE_NUMBER = entity.getMobileNumber().trim();
        }if(entity.getEmail()!=null) {
            EMAIL = entity.getEmail().trim();
        }if (entity.getAddress()!= null){
            ADDRESS = entity.getAddress().trim();
        }if(entity.getSubDistrict()!= null){
            SUB_DISTRICT = entity.getSubDistrict().trim();
        }if (entity.getDistrict()!=null){
            DISTRICT = entity.getDistrict().trim();
        }if(entity.getCityCode()!= null){
            CITY_CODE = entity.getCityCode().trim();
        }if(entity.getPostalCode()!= null){
            POSTAL_CODE = entity.getPostalCode().trim();
        }if (entity.getCountryCodeDomicile()!=null) {
            COUNTRY_CODE_OF_DOMICILE = entity.getCountryCodeDomicile().trim();
        }if (entity.getBusinessFieldCode()!= null){
            BUSINESS_FIELD_CODE = entity.getBusinessFieldCode().trim();
        }if (entity.getRelationReporterCode()!=null){
            RELATION_REPORTER_CODE = entity.getRelationReporterCode().trim();
        }if(entity.getViolBmpkBmpdBmpp()!= null){
            VIOL_BMPK_BMPD_BMPP = entity.getViolBmpkBmpdBmpp().trim();
        }if(entity.getExceBmpBmpdBmpp()!=null) {
            EXCE_BMPK_BMPD_BMPP = entity.getExceBmpBmpdBmpp().trim();
        }if(entity.getGoPublic() !=null){
            GO_PUBLIC = entity.getGoPublic().trim();
        }if (entity.getDebtorGroupCode()!=null){
            DEBTOR_GROUP_CODE = entity.getDebtorGroupCode().trim();
        }if(entity.getDebtorRating() !=null){
            DEBTOR_RATING = entity.getDebtorRating().trim();
        }if(entity.getRatingAgency() != null){
            RATING_AGENCY = entity.getRatingAgency().trim();
        }if(entity.getRatingDate()!=null){
            RATING_DATE = iob.format(entity.getRatingDate()).trim();
        }if(entity.getDebtorGroupName()!=null){
            DEBTOR_GROUP_NAME = entity.getDebtorGroupName().trim();
        }if (entity.getBranchOfficeCode() != null) {
            BRANCH_OFFICE_CODE = entity.getBranchOfficeCode().trim();
        } if (entity.getDataOperation()!=null){
            DATA_OPERATION = entity.getDataOperation().trim();
        }
        String [] result = {FLG_DTL ,
                CIF ,
                BUSS_ENTITY_ID_NUMBER ,
                BUSS_ENTITY_NAME ,
                BUSS_ENTITY_TYPE_CODE ,
                PLACE_OF_ESTABLISHMENT ,
                ESTABLISHMENT_DEED_DATE ,
                LAST_AMENDMENT_DEED_NUMBER ,
                LAST_AMENDMENT_DEED_DATE ,
                TLP_NUMBER ,
                MOBILE_NUMBER ,
                EMAIL ,
                ADDRESS ,
                SUB_DISTRICT ,
                DISTRICT ,
                CITY_CODE ,
                POSTAL_CODE ,
                COUNTRY_CODE_OF_DOMICILE,
                BUSINESS_FIELD_CODE ,
                RELATION_REPORTER_CODE ,
                VIOL_BMPK_BMPD_BMPP ,
                EXCE_BMPK_BMPD_BMPP ,
                GO_PUBLIC ,
                DEBTOR_GROUP_CODE ,
                DEBTOR_RATING ,
                RATING_AGENCY ,
                RATING_DATE ,
                DEBTOR_GROUP_NAME ,
                BRANCH_OFFICE_CODE ,
                DATA_OPERATION};
        return result;
    }
}
