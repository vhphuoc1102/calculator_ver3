package com.calculator.calculator_ver3.GeneralFeatures;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TransverseText {
    @FXML
    public static void transverseText(Label labelText, int labelTextLength, int labelTextLengthMax, int position, String transverseDirection) {
        String stringTemp = labelText.getText();
        switch (transverseDirection){
            case "left":
                if(position > labelTextLengthMax){
                    position--;

                }
                else{

                }
        }

    }
}
