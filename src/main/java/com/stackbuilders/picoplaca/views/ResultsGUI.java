package com.stackbuilders.picoplaca.views;

import javax.swing.*;

public class ResultsGUI implements GUI {
    private String message;
    @Override
    public void showElements() {
        JOptionPane.showMessageDialog(null, this.message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
