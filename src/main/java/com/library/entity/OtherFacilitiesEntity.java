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
@Table(name="MST_OTHER_FACILITIES")
public class OtherFacilitiesEntity {


    @Column(name = "FLG_DTL")
    private String flgDtl;

    @Id
    @Column(name = "ANC")
    private String anc;

    @Column(name = "CIF_DEBITUR")
    private String cifDebitur;

    @Column(name = "OFT_CODE")
    private String oftCode;

    @Column(name = "SOURCE_OF_FUNDS")
    private String sourceOfFunds;

    @Column(name = "STAR_DATE")
    private Date startDate;

    @Column(name = "DUE_DATE")
    private Date dueDate;

    @Column(name = "INTEREST")
    private Integer interest;

    @Column(name = "CURRENCY_CODE")
    private String currencyCode;

    @Column(name = "NOMINAL")
    private Integer nominal;

    @Column(name = "ORIGINAL_CURENNCY")
    private Integer originalCurrency;

    @Column(name = "COLLECTIBILITY_CODE")
    private String collectibilityCode;

    @Column(name = "DEFAULT_DATE")
    private Date defaultDate;

    @Column(name = "DEFAULT_REASON_CODE")
    private String defaultReasonCode;

    @Column(name = "ARREARS")
    private Integer arrears;

    @Column(name = "DAYS_ARREARS")
    private Integer daysArrears;

    @Column(name = "CONDITION_CODE")
    private String conditionCode;

    @Column(name = "CONDITION_DATE")
    private Date conditionDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "BRANCH_OFFICIAL_CODE")
    private String branchOfficialCode;

    @Column(name = "DATA_OPERATION")
    private String dataOperation;


    public String getFlgDtl() {
        return flgDtl;
    }

    public void setFlgDtl(String flgDtl) {
        this.flgDtl = flgDtl;
    }

    public String getAnc() {
        return anc;
    }

    public void setAnc(String anc) {
        this.anc = anc;
    }

    public String getCifDebitur() {
        return cifDebitur;
    }

    public void setCifDebitur(String cifDebitur) {
        this.cifDebitur = cifDebitur;
    }

    public String getOftCode() {
        return oftCode;
    }

    public void setOftCode(String oftCode) {
        this.oftCode = oftCode;
    }

    public String getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(String sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getInterest() {
        return interest;
    }

    public void setInterest(Integer interest) {
        this.interest = interest;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public Integer getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(Integer originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getCollectibilityCode() {
        return collectibilityCode;
    }

    public void setCollectibilityCode(String collectibilityCode) {
        this.collectibilityCode = collectibilityCode;
    }

    public Date getDefaultDate() {
        return defaultDate;
    }

    public void setDefaultDate(Date defaultDate) {
        this.defaultDate = defaultDate;
    }

    public String getDefaultReasonCode() {
        return defaultReasonCode;
    }

    public void setDefaultReasonCode(String defaultReasonCode) {
        this.defaultReasonCode = defaultReasonCode;
    }

    public Integer getArrears() {
        return arrears;
    }

    public void setArrears(Integer arrears) {
        this.arrears = arrears;
    }

    public Integer getDaysArrears() {
        return daysArrears;
    }

    public void setDaysArrears(Integer daysArrears) {
        this.daysArrears = daysArrears;
    }

    public String getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(String conditionCode) {
        this.conditionCode = conditionCode;
    }

    public Date getConditionDate() {
        return conditionDate;
    }

    public void setConditionDate(Date conditionDate) {
        this.conditionDate = conditionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBranchOfficialCode() {
        return branchOfficialCode;
    }

    public void setBranchOfficialCode(String branchOfficialCode) {
        this.branchOfficialCode = branchOfficialCode;
    }

    public String getDataOperation() {
        return dataOperation;
    }

    public void setDataOperation(String dataOperation) {
        this.dataOperation = dataOperation;
    }
}
