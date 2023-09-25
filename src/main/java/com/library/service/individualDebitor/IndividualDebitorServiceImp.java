package com.library.service.individualDebitor;

import com.library.dao.individualDebitor.IndividualDebitorDao;
import com.library.entity.IndividualDebitorEnity;
import com.library.service.generateFileService.GenerateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class IndividualDebitorServiceImp implements IndividualDebitorService{

    @Autowired
    IndividualDebitorDao individualDebitorDao;
    @Autowired
    GenerateFileService generateFileService;
    SimpleDateFormat iob = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat years = new SimpleDateFormat("yyyy");
    SimpleDateFormat month = new SimpleDateFormat("MM");

    @Override
    public List<IndividualDebitorEnity> findAll() {

        List<IndividualDebitorEnity>list = individualDebitorDao.findAll();
        return list;
    }
    public String  exportTxt() {
        Date date = new Date();
        List<IndividualDebitorEnity> ada = individualDebitorDao.findAll();

            String judul = "0103.600816."+years.format(date)+"."+month.format(date)+".D01.1.txt";

            pathExcelTxt(judul, ada);
            return judul;
    }
    public void pathExcelTxt(String fileName, List<IndividualDebitorEnity> list) {
        Date date = new Date();
        File fileCreate = new File("C:\\Users\\user\\Documents\\project\\MiniApolo\\mini-apolo\\"+ fileName);
        String lineUp = "|";

        String headers;
        if(list != null) {
            headers = "H|0103|600816|" + years.format(date) + "|" + month.format(date) + "|D01|186|" + list.size() + "\n";

            List<String> listData = new ArrayList<>();

            for (IndividualDebitorEnity individualDebitorEnity : list) {

                String datas = setValidationAndSetUpDatas(individualDebitorEnity,lineUp) +"\n";

                listData.add(datas);
            }
            generateFileService.setFileTxtWriter(headers,listData,fileCreate);
        }else {
            headers = "H|0103|600816|" + years.format(date) + "|" + month.format(date) + "|D01|186|" + "0";

            generateFileService.setFileTxtNullDataWriter(headers,fileCreate);
        }
            File file = new File("C:\\Users\\user\\Documents\\project\\MiniApolo\\mini-apolo\\" + fileName);
        if (file.exists()) {
            generateFileService.setGenerateFileTxt(file);
            }
    }
    public String setValidationAndSetUpDatas(IndividualDebitorEnity entity, String lineUp){
        String FLG_DTL = "",
                CIF = "",
                ID_TYPE = "",
                ID_NUMBER = "",
                NAME_BY_ID_CARD = "",
                FULL_NAME = "",
                EDUCATION_CODE = "",
                GENDER = "",
                PLACE_BIRTH = "",
                DATE_BIRTH = "",
                TIN = "",
                ADDRESS= "",
                SUB_DISTRICT= "",
                DISTRICT= "",
                CITY_CODE= "",
                POSTAL_CODE= "",
                TLP_NUMBER= "",
                MOBILE_NUMBER= "",
                EMAIL= "",
                COUNTRY_CODE_OF_DOMICILE = "",
                Occupation_Code= "",
                Workplace= "",
                Field_Code_OF_Workplace= "",
                Workplace_Address= "",
                Gross_Annual_Income= "",
                Income_Source_Code= "",
                Num_of_Dependents= "",
                Relationship_Reporter_CODE= "",
                Deb_Group_Code= "",
                Marital_StatuS_Debtor= "",
                Spouses_Id_Number= "",
                Spouses_Name= "",
                Sp_Date_Birth= "",
                Prop_Separation_Agreement= "",
                Viol_BMPK_BMPD_BMPP= "",
                Exce_BMPK_BMPD_BMPP= "",
                Mother_Maiden_Name= "",
                Branch_Office_Code= "",
                Data_Operation= "";

        if(entity.getFlgDtl() != null) {
            FLG_DTL = entity.getFlgDtl().trim();
        }if (entity.getCif()!=null){
            CIF = entity.getCif().trim();
        }if(entity.getIdType()!=null){
            ID_TYPE = entity.getIdType().trim();
        }if (entity.getIdNumber()!= null){
            ID_NUMBER = entity.getIdNumber().trim();
        }if (entity.getNameByIdCard()!=null){
            NAME_BY_ID_CARD = entity.getNameByIdCard().trim();
        }if (entity.getFullName()!=null){
            FULL_NAME= entity.getFullName().trim();
        }if(entity.getEducationCode()!=null){
            EDUCATION_CODE = entity.getEducationCode().trim();
        }if(entity.getGender()!=null){
            GENDER= entity.getGender().trim();
        }if(entity.getPlaceBirth()!= null){
            PLACE_BIRTH = entity.getPlaceBirth().trim();
        }if (entity.getBrithDate()!= null){
            DATE_BIRTH = iob.format(entity.getBrithDate()).trim();
        }if (entity.getTin()!=null){
            TIN = entity.getTin().trim();
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
        }if(entity.getTlpNumber() != null){
            TLP_NUMBER = entity.getTlpNumber().trim();
        }if(entity.getMobileNumber()!= null){
            MOBILE_NUMBER = entity.getMobileNumber().trim();
        }if(entity.getEmail()!=null){
            EMAIL = entity.getEmail().trim();
        }if (entity.getCountryCodeDomicile()!=null){
            COUNTRY_CODE_OF_DOMICILE = entity.getCountryCodeDomicile().trim();
        }if(entity.getOccupationCode()!= null){
            Occupation_Code = entity.getOccupationCode().trim();
        }if(entity.getWorkPlace() != null){
            Workplace = entity.getWorkPlace().trim();
        }if (entity.getFieldCodeOfWorkplace()!=null){
            Field_Code_OF_Workplace = entity.getFieldCodeOfWorkplace().trim();
        }if (entity.getWorkplaceAddress()!=null){
            Workplace_Address = entity.getWorkplaceAddress().trim();
        }if (entity.getGrossAnnualIncome()!=null){
            Gross_Annual_Income = (entity.getGrossAnnualIncome()).toString().replace(".00","").trim();
        }if (entity.getIncomeSourceCode()!=null){
            Income_Source_Code = entity.getIncomeSourceCode().trim();
        }if (entity.getNumOfDependents() != null){
            Num_of_Dependents = (entity.getNumOfDependents()).toString().replace(".00","").trim();
        }if (entity.getRelationshipReporterCode() !=null){
            Relationship_Reporter_CODE = entity.getRelationshipReporterCode().trim();
        }if(entity.getDebGroupCode() != null){
            Deb_Group_Code = entity.getDebGroupCode().trim();
        }if(entity.getMaritalStatuSDebtor() !=null){
            Marital_StatuS_Debtor = entity.getMaritalStatuSDebtor().trim();
        }if (entity.getSpousesIdNumber()!=null){
            Spouses_Id_Number = entity.getSpousesIdNumber().trim();
        }if(entity.getSpousesName() !=null){
            Spouses_Name = entity.getSpousesName().trim();
        }if(entity.getSpDateBirth()!=null){
            Sp_Date_Birth = iob.format(entity.getSpDateBirth()).trim();
        }if (entity.getPropSeparationAgreement()!=null){
            Prop_Separation_Agreement = entity.getPropSeparationAgreement().trim();
        }if(entity.getViolBmpkBmpdBmpp()!= null){
            Viol_BMPK_BMPD_BMPP = entity.getViolBmpkBmpdBmpp().trim();
        }if(entity.getExceBmpBmpdBmpp()!=null){
            Exce_BMPK_BMPD_BMPP = entity.getExceBmpBmpdBmpp().trim();
        }if (entity.getMotherMaidenName()!= null){
            Mother_Maiden_Name = entity.getMotherMaidenName().trim();
        }if (entity.getBranchOfficeCode()!= null){
            Branch_Office_Code = entity.getBranchOfficeCode().trim();
        }if(entity.getDataOperation()!= null){
            Data_Operation = entity.getDataOperation().trim();
        }

        String result = (FLG_DTL+lineUp+
                CIF+lineUp+
                ID_TYPE+lineUp+
                ID_NUMBER+lineUp+
                NAME_BY_ID_CARD+lineUp+
                FULL_NAME+lineUp+
                EDUCATION_CODE+lineUp+
                GENDER+lineUp+
                PLACE_BIRTH+lineUp+
                DATE_BIRTH+lineUp+
                TIN+lineUp+
                ADDRESS+lineUp+
                SUB_DISTRICT+lineUp+
                DISTRICT+lineUp+
                CITY_CODE+lineUp+
                POSTAL_CODE+lineUp+
                TLP_NUMBER+lineUp+
                MOBILE_NUMBER+lineUp+
                EMAIL+lineUp+
                COUNTRY_CODE_OF_DOMICILE+lineUp+
                Occupation_Code+lineUp+
                Workplace+lineUp+
                Field_Code_OF_Workplace+lineUp+
                Workplace_Address+lineUp+
                Gross_Annual_Income+lineUp+
                Income_Source_Code+lineUp+
                Num_of_Dependents+lineUp+
                Relationship_Reporter_CODE+lineUp+
                Deb_Group_Code+lineUp+
                Marital_StatuS_Debtor+lineUp+
                Spouses_Id_Number+lineUp+
                Spouses_Name+lineUp+
                Sp_Date_Birth+lineUp+
                Prop_Separation_Agreement+lineUp+
                Viol_BMPK_BMPD_BMPP+lineUp+
                Exce_BMPK_BMPD_BMPP+lineUp+
                Mother_Maiden_Name+lineUp+
                Branch_Office_Code+ lineUp+
        Data_Operation);


        return result;
    }
}
