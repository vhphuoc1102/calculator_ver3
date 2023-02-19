package com.calculator.calculator_ver3.GeneralFeatures;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import static com.calculator.calculator_ver3.Controllers.SceneController.setScene;

public class ChooseMode {
    public static void chooseMode(ActionEvent event){
        Button buttonTemp = (Button) event.getSource();
        String stringTemp = buttonTemp.getText();
        setScene(stringTemp);
    }
}
