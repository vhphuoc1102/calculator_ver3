package com.calculator.calculator_ver3.GeneralFeatures;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClearText {
    @FXML
    public static void clearText(Label input, Label output) {
        input.setText("");
        output.setText("");
    }
}
