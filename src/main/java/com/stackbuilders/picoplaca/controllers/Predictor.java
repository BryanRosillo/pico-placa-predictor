package com.stackbuilders.picoplaca.controllers;

import com.stackbuilders.picoplaca.models.CarDriver;

import java.time.LocalTime;
import java.util.Map;

public class Predictor {

    private CarDriver carDriver;
    public boolean canBeOnTheRoad;
    private final Map<String, Integer[] > DAYS = Map.of("MONDAY", new Integer[]{1, 2}, "TUESDAY", new Integer[]{3, 4}, "WEDNESDAY", new Integer[]{5, 6}, "THURSDAY", new Integer[]{7, 8}, "FRIDAY", new Integer[]{9, 0});
    private final Map<String, LocalTime> FIRST_SCHEDULE = Map.of("begin", LocalTime.of(7, 0), "end", LocalTime.of(9, 30));
    private final Map<String, LocalTime> SECOND_SCHEDULE = Map.of("begin", LocalTime.of(16, 0), "end", LocalTime.of(19, 30));


    public Predictor(CarDriver carDriver) {
        this.carDriver = carDriver;
    }

    public void predict(){
        String numbers = carDriver.getLicensePlate().getNumbers();
        String dayOfTheWeek = carDriver.getDate().getLocaDate().getDayOfWeek().name();
        LocalTime time = carDriver.getTime().getLocalTime();
        Integer lastDigit = Integer.parseInt(numbers.substring(numbers.length() - 1));
        this.canBeOnTheRoad = true;
        DAYS.forEach((day, digits) -> {
            if(digits[0] == lastDigit || digits[1] == lastDigit){
                if(day.equals(dayOfTheWeek)){
                    if(isTimeRange(time, FIRST_SCHEDULE) || isTimeRange(time, SECOND_SCHEDULE)){
                        this.canBeOnTheRoad = false;
                    }
                }
            }
        });
    }

    private boolean isTimeRange(LocalTime time, Map<String, LocalTime> schedule){
        return time.isAfter(schedule.get("begin")) && time.isBefore(schedule.get("end"));
    }

}
