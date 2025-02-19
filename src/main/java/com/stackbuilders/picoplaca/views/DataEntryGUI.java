package com.stackbuilders.picoplaca.views;

import com.stackbuilders.picoplaca.controllers.Predictor;
import com.stackbuilders.picoplaca.models.CarDriver;

import javax.swing.*;

public class DataEntryGUI implements GUI {
    private ResultsGUI resultsGUI = new ResultsGUI();
    private Predictor predictor;
    private CarDriver carDriver;

    @Override
    public void showElements() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Please, enter the following data to make a prediction:"));

        panel.add(new JLabel("License plate (XYZ-123 o XYZ-1234):"));
        JTextField licensePlateField = new JTextField();
        panel.add(licensePlateField);

        panel.add(new JLabel("Date (yyyy-mm-dd):"));
        JTextField dateField = new JTextField();
        panel.add(dateField);

        panel.add(new JLabel("Time (hh:mm:ss):"));
        JTextField timeField = new JTextField();
        panel.add(timeField);

        String[] options = {"Make prediction", "Quit"};

        int optionSelected = 0;
        while (optionSelected!=1){
            optionSelected = JOptionPane.showOptionDialog(
                    null,
                    panel,
                    "Pico & placa predictor",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if(optionSelected==0){
                try{
                    receiveData(licensePlateField.getText(), dateField.getText(), timeField.getText());
                    if(predictor.canBeOnTheRoad){
                        this.resultsGUI.setMessage("Nice, you can be on the road :D");
                    }else{
                        this.resultsGUI.setMessage("Oh no, you cannot be on the road :c");
                    }
                }catch (Exception e){
                    this.resultsGUI.setMessage(e.getMessage());
                }
                this.resultsGUI.showElements();
            }
        }
        this.resultsGUI.setMessage("Goodbye, thanks for using this app!");
        this.resultsGUI.showElements();
    }

    public void receiveData(String licensePlate, String date, String time) {
        carDriver = new CarDriver("Bryan", date, time, licensePlate);
        predictor = new Predictor(carDriver);
        predictor.predict();
    }
}
