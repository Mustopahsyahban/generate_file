package com.library.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name="MST_INDIVIDUAL_DEBTOR")
public class IndividualDebitorEnity {

    @Column(name = "FLG_DTL")
    private String flgDtl;

    @Id
    @Column(name = "CIF")
    private String Cif;

    @Column(name = "ID_TYPE")
    private String idType;

    @Column(name = "ID_NUMBER")
    private String idNumber;

    @Column(name = "NAME_BY_ID_CARD")
    private String nameByIdCard;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "EDUCATION_CODE")
    private String educationCode;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "PLACE_BIRTH")
    private String placeBirth;

    @Column(name = "DATE_BIRTH")
    private Date brithDate;

    @Column(name = "TIN")
    private String tin;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "SUB_DISTRICT")
    private String subDistrict;

    @Column(name = "DISTRICT")
    private String district;

    @Column(name = "CITY_CODE")
    private String cityCode;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "TLP_NUMBER")
    private String tlpNumber;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "COUNTRY_CODE_OF_DOMICILE")
    private String countryCodeDomicile;

    @Column(name = "Occupation_Code")
    private String occupationCode;

    @Column(name = "Workplace")
    private String workPlace;

    @Column(name = "Field_Code_OF_Workplace")
    private String fieldCodeOfWorkplace;

    @Column(name = "Workplace_Address")
    private String workplaceAddress;

    @Column(name = "Gross_Annual_Income")
    private BigInteger grossAnnualIncome;

    @Column(name = "Income_Source_Code")
    private String incomeSourceCode;

    @Column(name = "Num_of_Dependents")
    private Integer numOfDependents;

    @Column(name = "Relationship_Reporter_CODE")
    private String relationshipReporterCode;

    @Column(name = "Deb_Group_Code")
    private String debGroupCode;

    @Column(name = "Marital_StatuS_Debtor")
    private String maritalStatuSDebtor;

    @Column(name = "Spouses_Id_Number")
    private String spousesIdNumber;

    @Column(name = "Spouses_Name")
    private String spousesName;

    @Column(name = "Sp_Date_Birth")
    private Date spDateBirth;

    @Column(name = "Prop_Separation_Agreement")
    private String propSeparationAgreement;

    @Column(name = "Viol_BMPK_BMPD_BMPP")
    private String violBmpkBmpdBmpp;

    @Column(name = "Exce_BMPK_BMPD_BMPP")
    private String exceBmpBmpdBmpp;

    @Column(name = "Mother_Maiden_Name")
    private String motherMaidenName;

    @Column(name = "Branch_Office_Code")
    private String branchOfficeCode;

    @Column(name = "Data_Operation")
    private String dataOperation;




    public String getFlgDtl() {
        return flgDtl;
    }

    public void setFlgDtl(String flgDtl) {
        this.flgDtl = flgDtl;
    }

    public String getCif() {
        return Cif;
    }

    public void setCif(String cif) {
        Cif = cif;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getNameByIdCard() {
        return nameByIdCard;
    }

    public void setNameByIdCard(String nameByIdCard) {
        this.nameByIdCard = nameByIdCard;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEducationCode() {
        return educationCode;
    }

    public void setEducationCode(String educationCode) {
        this.educationCode = educationCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlaceBirth() {
        return placeBirth;
    }

    public void setPlaceBirth(String placeBirth) {
        this.placeBirth = placeBirth;
    }

    public Date getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(Date brithDate) {
        this.brithDate = brithDate;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTlpNumber() {
        return tlpNumber;
    }

    public void setTlpNumber(String tlpNumber) {
        this.tlpNumber = tlpNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryCodeDomicile() {
        return countryCodeDomicile;
    }

    public void setCountryCodeDomicile(String countryCodeDomicile) {
        this.countryCodeDomicile = countryCodeDomicile;
    }

    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getFieldCodeOfWorkplace() {
        return fieldCodeOfWorkplace;
    }

    public void setFieldCodeOfWorkplace(String fieldCodeOfWorkplace) {
        this.fieldCodeOfWorkplace = fieldCodeOfWorkplace;
    }

    public String getWorkplaceAddress() {
        return workplaceAddress;
    }

    public void setWorkplaceAddress(String workplaceAddress) {
        this.workplaceAddress = workplaceAddress;
    }

    public BigInteger getGrossAnnualIncome() {
        return grossAnnualIncome;
    }

    public void setGrossAnnualIncome(BigInteger grossAnnualIncome) {
        this.grossAnnualIncome = grossAnnualIncome;
    }

    public String getIncomeSourceCode() {
        return incomeSourceCode;
    }

    public void setIncomeSourceCode(String incomeSourceCode) {
        this.incomeSourceCode = incomeSourceCode;
    }

    public Integer getNumOfDependents() {
        return numOfDependents;
    }

    public void setNumOfDependents(Integer numOfDependents) {
        this.numOfDependents = numOfDependents;
    }

    public String getRelationshipReporterCode() {
        return relationshipReporterCode;
    }

    public void setRelationshipReporterCode(String relationshipReporterCode) {
        this.relationshipReporterCode = relationshipReporterCode;
    }

    public String getDebGroupCode() {
        return debGroupCode;
    }

    public void setDebGroupCode(String debGroupCode) {
        this.debGroupCode = debGroupCode;
    }

    public String getMaritalStatuSDebtor() {
        return maritalStatuSDebtor;
    }

    public void setMaritalStatuSDebtor(String maritalStatuSDebtor) {
        this.maritalStatuSDebtor = maritalStatuSDebtor;
    }

    public String getSpousesIdNumber() {
        return spousesIdNumber;
    }

    public void setSpousesIdNumber(String spousesIdNumber) {
        this.spousesIdNumber = spousesIdNumber;
    }

    public String getSpousesName() {
        return spousesName;
    }

    public void setSpousesName(String spousesName) {
        this.spousesName = spousesName;
    }

    public Date getSpDateBirth() {
        return spDateBirth;
    }

    public void setSpDateBirth(Date spDateBirth) {
        this.spDateBirth = spDateBirth;
    }

    public String getPropSeparationAgreement() {
        return propSeparationAgreement;
    }

    public void setPropSeparationAgreement(String propSeparationAgreement) {
        this.propSeparationAgreement = propSeparationAgreement;
    }

    public String getViolBmpkBmpdBmpp() {
        return violBmpkBmpdBmpp;
    }

    public void setViolBmpkBmpdBmpp(String violBmpkBmpdBmpp) {
        this.violBmpkBmpdBmpp = violBmpkBmpdBmpp;
    }

    public String getExceBmpBmpdBmpp() {
        return exceBmpBmpdBmpp;
    }

    public void setExceBmpBmpdBmpp(String exceBmpBmpdBmpp) {
        this.exceBmpBmpdBmpp = exceBmpBmpdBmpp;
    }

    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    public String getBranchOfficeCode() {
        return branchOfficeCode;
    }

    public void setBranchOfficeCode(String branchOfficeCode) {
        this.branchOfficeCode = branchOfficeCode;
    }

    public String getDataOperation() {
        return dataOperation;
    }

    public void setDataOperation(String dataOperation) {
        this.dataOperation = dataOperation;
    }
}
