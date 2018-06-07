package com.laziodisu.bean;

import java.util.Date;

public class ScolarshipPayments {
    private Double firstPayment;
    private Double secondPayment;
    private Date firstDate;
    private Date  secondDate;
    private User user;

    public Double getFirstPayment() {
        return firstPayment;
    }

    public void setFirstPayment(Double firstPayment) {
        this.firstPayment = firstPayment;
    }

    public Double getSecondPayment() {
        return secondPayment;
    }

    public void setSecondPayment(Double secondPayment) {
        this.secondPayment = secondPayment;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(Date secondDate) {
        this.secondDate = secondDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
