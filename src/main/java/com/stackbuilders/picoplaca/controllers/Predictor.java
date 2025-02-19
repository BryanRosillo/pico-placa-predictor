package com.stackbuilders.picoplaca.controllers;

import com.stackbuilders.picoplaca.models.CarDriver;
import java.time.LocalTime;
import java.util.Map;

public class Predictor {

    private CarDriver carDriver;
    public boolean canBeOnTheRoad;
    private final Map<String, Integer[] > days = Map.of("MONDAY", new Integer[]{1, 2}, "TUESDAY", new Integer[]{3, 4}, "WEDNESDAY", new Integer[]{5, 6}, "THURSDAY", new Integer[]{7, 8}, "FRIDAY", new Integer[]{9, 0});
    private final Map<String, LocalTime> firstSchedule = Map.of("begin", LocalTime.of(7, 0), "end", LocalTime.of(9, 30));
    private final Map<String, LocalTime> secondSchedule = Map.of("begin", LocalTime.of(16, 0), "end", LocalTime.of(19, 30));


    public Predictor(CarDriver carDriver) {
        this.carDriver = carDriver;
    }

    public void predict(){
        String numbers = carDriver.getLicensePlate().getNumbers();
        String dayOfTheWeek = carDriver.getDate().getLocaDate().getDayOfWeek().name();
        LocalTime time = carDriver.getTime().getLocalTime();
        Integer lastDigit = Integer.parseInt(numbers.substring(numbers.length() - 1));
        this.canBeOnTheRoad = true;
        days.forEach((day, digits) -> {
            if(digits[0].equals(lastDigit) || digits[1].equals(lastDigit)){
                if(day.equals(dayOfTheWeek)){
                    if(isTimeRange(time, firstSchedule) || isTimeRange(time, secondSchedule)){
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
