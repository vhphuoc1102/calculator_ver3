package com.calculator.calculator_ver3.GeneralFeatures;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DeleteText {
    @FXML
    public static void deleteText(Label input, Label output) {
        String stringTemp = input.getText();
        stringTemp = stringTemp.substring(0, stringTemp.length() - 1);
        input.setText(stringTemp);
        output.setText("");
    }
}
