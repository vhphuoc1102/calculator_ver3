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
import static com.calculator.calculator_ver3.GeneralFeatures.DeleteText.deleteText;
import static com.calculator.calculator_ver3.GeneralFeatures.MaxTextLength.maxTextLength;
import static com.calculator.calculator_ver3.GeneralFeatures.MenuNavigate.menuNavigate;
import static com.calculator.calculator_ver3.GeneralFeatures.TransverseText.transverseText;
import static com.calculator.calculator_ver3.MathFeatures.BasicCalculate.basicCalculate;
import static com.calculator.calculator_ver3.MathFeatures.BasicCalculate.intOrDouble;

public class BasicController implements Initializable {
    @FXML
    private Label input;
    @FXML
    private Label output;
    @FXML
    private Button clearButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button arrow_leftButton;
    @FXML
    private Button arrow_rightButton;

    @FXML
    private AnchorPane menu;

    @FXML
    private Button menuOffButton;


    @FXML
    private Button menuOnButton;

    private String textFocus; // The Text is on focus (input or output)
    private int inputLengthMax;
    private int outputLengthMax;
    private Boolean checkOutput;
    private String expression;
    private int inputPosition;
    private int outputPosition;
    @FXML
    void inputDigit(ActionEvent event) {
        Button buttonTemp = (Button) event.getSource();
        String stringTemp = buttonTemp.getText();
        if(checkOutput){
            expression = stringTemp;
            input.setText(stringTemp);
            checkOutput = false;
            output.setText("");
        }
        else {
            expression += stringTemp;
            input.setText(input.getText() + stringTemp);
        }
    }
    @FXML
    void menuOff() {
        menuNavigate(menu);
    }

    @FXML
    void menuOn() {
        menuNavigate(menu);
    }
    @FXML
    void operator(ActionEvent event) {
        Button buttonTemp = (Button) event.getSource();
        String stringTemp = buttonTemp.getText();
        if(stringTemp.equals("=")){
            double result = basicCalculate(expression);
            String res = intOrDouble(result);
            output.setText(res+"");
            checkOutput = true;
        }
        else{
            String temp = input.getText();
            expression += stringTemp;
            input.setText(temp + stringTemp);
            output.setText("");
            checkOutput = false;
        }
    }
    @FXML
    void clear(ActionEvent event) {
        clearText(input, output);
    }
    @FXML
    void clickOnInput() {
        textFocus = "input";
        // Create border for input pane
    }

    @FXML
    void clickOnOutput() {
        textFocus = "output";
        // Create border for output pane
    }
    @FXML
    void delete(ActionEvent event) {
        deleteText(input, output);
    }
    @FXML
    void transverse(ActionEvent event) {
        Button buttonTemp = (Button) event.getSource();
        String stringTemp = buttonTemp.getText();
        String direction = "";
        if(stringTemp.equals("arrow_leftButton")) direction = "left";
        else direction = "right";
        if(textFocus.equals("input")){
            String temp = input.getText();
            transverseText(input, temp.length(), inputLengthMax, inputPosition,direction );
        }
        else {
            String temp = output.getText();
            transverseText(output, temp.length(), outputLengthMax, outputPosition, direction);
        }
    }

    @FXML
    void switchMode(ActionEvent event) {
        chooseMode(event);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuNavigate(menu);
        textFocus = "input";
        inputLengthMax = (int)maxTextLength(input);
        outputLengthMax = (int)maxTextLength(output);
        inputPosition = inputLengthMax;
        outputPosition = outputLengthMax;
        checkOutput = true;
        expression = "";
    }
}
