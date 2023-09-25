package com.library.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name="MST_DEBITUR_BADAN_USAHA")
public class BusinessEntityDebtorEntity {

    @Column(name = "FLG_DTL")
    private String flgDtl;

    @Id
    @Column(name = "CIF")
    private String cif;

    @Column(name = "BUSS_ENTITY_ID_NUMBER")
    private String bussEntityIdNumber;

    @Column(name = "BUSS_ENTITY_NAME")
    private String bussEntityName;

    @Column(name = "BUSS_ENTITY_TYPE_CODE")
    private String bussEntityTypeCode;

    @Column(name = "PLACE_OF_ESTABLISHMENT")
    private String placeOfEstablishment;

    @Column(name = "ESTABLISHMENT_DEED_DATE")
    private Date establishmentDeedDate;

    @Column(name = "LAST_AMENDMENT_DEED_NUMBER")
    private String lastAmendmentNumber;

    @Column(name = "LAST_AMENDMENT_DEED_DATE")
    private Date lastAmendmentDate;

    @Column(name = "TLP_NUMBER")
    private String tlpNumber;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "EMAIL")
    private  String email;

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

    @Column(name = "COUNTRY_CODE_OF_DOMICILE")
    private String countryCodeDomicile;

    @Column(name = "BUSINESS_FIELD_CODE")
    private String businessFieldCode;

    @Column(name = "RELATION_REPORTER_CODE")
    private String relationReporterCode;

    @Column(name = "Viol_BMPK_BMPD_BMPP")
    private String violBmpkBmpdBmpp;

    @Column(name = "Exce_BMPK_BMPD_BMPP")
    private String exceBmpBmpdBmpp;

    @Column(name = "GO_PUBLIC")
    private String goPublic;

    @Column(name = "DEBTOR_GROUP_CODE")
    private String debtorGroupCode;

    @Column(name = "DEBTOR_RATING")
    private String debtorRating;

    @Column(name = "RATING_AGENCY")
    private String ratingAgency;

    @Column(name = "RATING_DATE")
    private Date ratingDate;

    @Column(name = "DEBTOR_GROUP_NAME")
    private String debtorGroupName;

    @Column(name = "BRANCH_OFFICE_CODE")
    private String branchOfficeCode;

    @Column(name = "DATA_OPERATION")
    private String dataOperation;


    public String getFlgDtl() {
        return flgDtl;
    }

    public void setFlgDtl(String flgDtl) {
        this.flgDtl = flgDtl;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getBussEntityIdNumber() {
        return bussEntityIdNumber;
    }

    public void setBussEntityIdNumber(String bussEntityIdNumber) {
        this.bussEntityIdNumber = bussEntityIdNumber;
    }

    public String getBussEntityName() {
        return bussEntityName;
    }

    public void setBussEntityName(String bussEntityName) {
        this.bussEntityName = bussEntityName;
    }

    public String getBussEntityTypeCode() {
        return bussEntityTypeCode;
    }

    public void setBussEntityTypeCode(String bussEntityTypeCode) {
        this.bussEntityTypeCode = bussEntityTypeCode;
    }

    public String getPlaceOfEstablishment() {
        return placeOfEstablishment;
    }

    public void setPlaceOfEstablishment(String placeOfEstablishment) {
        this.placeOfEstablishment = placeOfEstablishment;
    }

    public Date getEstablishmentDeedDate() {
        return establishmentDeedDate;
    }

    public void setEstablishmentDeedDate(Date establishmentDeedDate) {
        this.establishmentDeedDate = establishmentDeedDate;
    }

    public String getLastAmendmentNumber() {
        return lastAmendmentNumber;
    }

    public void setLastAmendmentNumber(String lastAmendmentNumber) {
        this.lastAmendmentNumber = lastAmendmentNumber;
    }

    public Date getLastAmendmentDate() {
        return lastAmendmentDate;
    }

    public void setLastAmendmentDate(Date lastAmendmentDate) {
        this.lastAmendmentDate = lastAmendmentDate;
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

    public String getCountryCodeDomicile() {
        return countryCodeDomicile;
    }

    public void setCountryCodeDomicile(String countryCodeDomicile) {
        this.countryCodeDomicile = countryCodeDomicile;
    }

    public String getBusinessFieldCode() {
        return businessFieldCode;
    }

    public void setBusinessFieldCode(String businessFieldCode) {
        this.businessFieldCode = businessFieldCode;
    }

    public String getRelationReporterCode() {
        return relationReporterCode;
    }

    public void setRelationReporterCode(String relationReporterCode) {
        this.relationReporterCode = relationReporterCode;
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

    public String getGoPublic() {
        return goPublic;
    }

    public void setGoPublic(String goPublic) {
        this.goPublic = goPublic;
    }

    public String getDebtorGroupCode() {
        return debtorGroupCode;
    }

    public void setDebtorGroupCode(String debtorGroupCode) {
        this.debtorGroupCode = debtorGroupCode;
    }

    public String getDebtorRating() {
        return debtorRating;
    }

    public void setDebtorRating(String debtorRating) {
        this.debtorRating = debtorRating;
    }

    public String getRatingAgency() {
        return ratingAgency;
    }

    public void setRatingAgency(String ratingAgency) {
        this.ratingAgency = ratingAgency;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }

    public String getDebtorGroupName() {
        return debtorGroupName;
    }

    public void setDebtorGroupName(String debtorGroupName) {
        this.debtorGroupName = debtorGroupName;
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
