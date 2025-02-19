package com.stackbuilders.picoplaca.models;

public class LicensePlateNumber {

    private String letters;
    private String numbers;

    public LicensePlateNumber(String licencePlateNumber) {
        if (licencePlateNumber==null||licencePlateNumber.isEmpty()||!validateLicencePlateNumber(licencePlateNumber)) {
            throw new IllegalArgumentException("Invalid licence plate number, please enter a valid value.");
        }
        String [] parts = licencePlateNumber.split("-");
        this.letters = parts[0];
        this.numbers = parts[1];
    }

    private boolean validateLicencePlateNumber(String licensePlateNumber) {
        return licensePlateNumber.matches("^[A-Z]{3}-\\d{3,4}$");
    }

    public String getLetters() {
        return letters;
    }

    public String getNumbers() {
        return numbers;
    }

}
