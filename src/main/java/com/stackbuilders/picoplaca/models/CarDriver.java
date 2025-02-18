package com.stackbuilders.picoplaca.models;

public class CarDriver {

    private String username;
    private Date date;
    private Time time;
    private LicensePlateNumber licensePlate;

    public CarDriver(String username, String date, String time, String licensePlate) {
        this.username = username;
        this.date = new Date(date);
        this.time = new Time(time);
        this.licensePlate = new LicensePlateNumber(licensePlate);
    }

    public String getUsername() {
        return username;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public LicensePlateNumber getLicensePlate() {
        return licensePlate;
    }
}
