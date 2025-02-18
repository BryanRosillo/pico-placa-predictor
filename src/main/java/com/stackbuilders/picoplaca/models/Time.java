package com.stackbuilders.picoplaca.models;

import java.time.LocalTime;

public class Time {

    private LocalTime time;

    public Time(String time) {
        if (time==null || time.isEmpty() || !this.validateTime(time)) {
            throw new IllegalArgumentException("Invalid time, please enter a valid value.");
        }
        try {
            this.time = LocalTime.parse(time);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time, please enter a valid value.");
        }
    }

    private boolean validateTime(String time) {
        return time.matches("^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$");
    }

    public LocalTime getLocalTime() {
        return time;
    }

}
