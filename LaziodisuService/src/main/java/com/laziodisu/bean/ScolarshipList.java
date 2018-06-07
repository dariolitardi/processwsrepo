package com.laziodisu.bean;

public class ScolarshipList {
    private Double CFNR;
    private String listType; //se se gradutorio posto aloggio o mensa premio laurea
    private String locationStatus;
    private Integer positionScore;
    private User user;

    public Double getCFNR() {
        return CFNR;
    }

    public void setCFNR(Double CFNR) {
        this.CFNR = CFNR;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(String locationStatus) {
        this.locationStatus = locationStatus;
    }

    public Integer getPositionScore() {
        return positionScore;
    }

    public void setPositionScore(Integer positionScore) {
        this.positionScore = positionScore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
