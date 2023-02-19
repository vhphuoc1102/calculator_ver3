package com.calculator.calculator_ver3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static com.calculator.calculator_ver3.GeneralFeatures.ChooseMode.chooseMode;
import static com.calculator.calculator_ver3.GeneralFeatures.ClearText.clearText;
import static com.calculator.calculator_ver3.GeneralFeatures.MenuNavigate.menuNavigate;
import static com.calculator.calculator_ver3.MathFeatures.FloatPresent.getBin32;
import static com.calculator.calculator_ver3.MathFeatures.FloatPresent.getFloat;

public class FloatPresentController implements Initializable {
    @FXML
    private Label binInput_1;

    @FXML
    private Label binInput_2;

    @FXML
    private Label decInput_1;

    @FXML
    private Label decInput_2;

    @FXML
    private AnchorPane menu;

    @FXML
    private Button menuOffButton;

    @FXML
    private Button menuOffButtonOverlay;

    @FXML
    private Button menuOnButton;

    @FXML
    private Button menuOnButtonOverlay;
    private String inputFocus;
    private int countBit;
    private String expressionBin;
    private String expressionDec;
    @FXML
    void chooseBaseInput(ActionEvent event) {
        Button buttonTemp = (Button) event.getSource();
        String stringTemp = buttonTemp.getText();
        inputFocus = stringTemp;
    }

    @FXML
    void clear(ActionEvent event) {
        clearText(binInput_1, binInput_2);
        clearText(decInput_1, decInput_2);
        countBit = 0;
        expressionBin = "";
        expressionDec = "";
    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void inputDigit(ActionEvent event) {
        Button buttonTemp = (Button) event.getSource();
        String stringTemp = buttonTemp.getText();
        if(inputFocus.equals("BIN")){
            if(countBit == 32) {
                decInput_1.setText(getFloat(expressionBin));
                return;
            }
            if(binInput_1.getText().length() < 29){
                binInput_1.setText(binInput_1.getText() + stringTemp);
                if(countBit % 4 == 0) binInput_1.setText(binInput_1.getText()+ " ");
            } else{
                binInput_2.setText(binInput_2.getText() + stringTemp);
                if(countBit % 4 == 0) binInput_2.setText(binInput_2.getText()+ " ");
            }
            expressionBin += stringTemp;
            countBit++;
        }else{
            if(decInput_1.getText().length() <= 29)
                decInput_1.setText(decInput_1.getText() + stringTemp);
            else
                decInput_2.setText(decInput_2.getText() + stringTemp);
            expressionDec += stringTemp;
            expressionBin = getBin32(expressionDec);
            String temp = expressionBin.replaceAll("(.{4})", "$1 ");
            binInput_1.setText(temp.substring(0, 29));
            binInput_2.setText(temp.substring(29));
        }
    }

    @FXML
    void menuOff(ActionEvent event) {
        menuNavigate(menu);
    }

    @FXML
    void menuOn(ActionEvent event) {
        menuNavigate(menu);
    }

    @FXML
    void switchMode(ActionEvent event) {
        chooseMode(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputFocus = "DEC";
        countBit = 0;
        expressionBin = "";
        expressionDec = "";
    }
}
