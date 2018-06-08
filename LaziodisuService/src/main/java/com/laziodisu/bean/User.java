package com.laziodisu.bean;

import java.io.Serializable;

public class User implements Serializable {
    private Integer coins;
    private Integer currBracket;
    private Double currentEconomicStatus;
    private Boolean exemption;
    private String IBAN;
    private String PIN;
    private String taxCode;
    private String universityID;
private Long employee;
private Document document;

    public User(Integer coins, Integer currBracket, Double currentEconomicStatus, Boolean exemption, String IBAN, String PIN, String taxCode, String universityID, Long employee, Document document) {
        this.coins = coins;
        this.currBracket = currBracket;
        this.currentEconomicStatus = currentEconomicStatus;
        this.exemption = exemption;
        this.IBAN = IBAN;
        this.PIN = PIN;
        this.taxCode = taxCode;
        this.universityID = universityID;
        this.employee = employee;
        this.document = document;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getCurrBracket() {
        return currBracket;
    }

    public void setCurrBracket(Integer currBracket) {
        this.currBracket = currBracket;
    }

    public Double getCurrentEconomicStatus() {
        return currentEconomicStatus;
    }

    public void setCurrentEconomicStatus(Double currentEconomicStatus) {
        this.currentEconomicStatus = currentEconomicStatus;
    }

    public Boolean getExemption() {
        return exemption;
    }

    public void setExemption(Boolean exemption) {
        this.exemption = exemption;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getUniversityID() {
        return universityID;
    }

    public void setUniversityID(String universityID) {
        this.universityID = universityID;
    }

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}