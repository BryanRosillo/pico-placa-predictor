package com.stackbuilders.picoplaca.models;

import java.time.LocalDate;

public class Date {
    private LocalDate localDate;

    public Date(String date){
        if(date == null || date.isEmpty()||!this.validateDate(date)){
            throw new IllegalArgumentException("Invalid date, please enter a valid value.");
        }
        try{
            this.localDate = LocalDate.parse(date);
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid date, please enter a valid value.");
        }

    }

    private boolean validateDate(String date){
        return date.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
    }

    public LocalDate getLocaDate(){
        return this.localDate;
    }
}
