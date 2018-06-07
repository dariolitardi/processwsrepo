package com.laziodisu.bean;

import java.util.Date;

public class Registration {
    private User user;
    private StudentCareer studentCareer;
    private Integer bracket;
    private Double economicStatus;
    private Date expirationDate;
    private Date lastUpdate;
    private Date registrationDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StudentCareer getStudentCareer() {
        return studentCareer;
    }

    public void setStudentCareer(StudentCareer studentCareer) {
        this.studentCareer = studentCareer;
    }

    public Integer getBracket() {
        return bracket;
    }

    public void setBracket(Integer bracket) {
        this.bracket = bracket;
    }

    public Double getEconomicStatus() {
        return economicStatus;
    }

    public void setEconomicStatus(Double economicStatus) {
        this.economicStatus = economicStatus;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
