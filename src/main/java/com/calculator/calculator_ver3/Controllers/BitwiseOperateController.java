package com.calculator.calculator_ver3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static com.calculator.calculator_ver3.GeneralFeatures.ChooseMode.chooseMode;
import static com.calculator.calculator_ver3.GeneralFeatures.ClearText.clearText;
import static com.calculator.calculator_ver3.GeneralFeatures.DeleteText.deleteText;
import static com.calculator.calculator_ver3.GeneralFeatures.MaxTextLength.maxTextLength;
import static com.calculator.calculator_ver3.GeneralFeatures.MenuNavigate.menuNavigate;
import static com.calculator.calculator_ver3.MathFeatures.BaseConverter.baseConversion;
import static com.calculator.calculator_ver3.MathFeatures.BitwiseOperate.bitwiseOperate;

public class BitwiseOperateController implements Initializable {
    @FXML
    private Button baseChoice;
    @FXML
    private Label binInput;

    @FXML
    private Button clearButton;

    @FXML
    private Label decInput;

    @FXML
    private Button deleteButton;

    @FXML
    private Label hexInput;

    @FXML
    private Label input;

    @FXML
    private AnchorPane menu;

    @FXML
    private Button menuOffButton;

    @FXML
    private Button menuOnButton;


    @FXML
    private Label octInput;

    @FXML
    private Label output;
    @FXML
    private Button num0;

    @FXML
    private Button num1;

    @FXML
    private Button num2;

    @FXML
    private Button num3;

    @FXML
    private Button num4;

    @FXML
    private Button num5;

    @FXML
    private Button num6;

    @FXML
    private Button num7;

    @FXML
    private Button num8;

    @FXML
    private Button num9;

    @FXML
    private Button numA;

    @FXML
    private Button numB;

    @FXML
    private Button numC;

    @FXML
    private Button numD;

    @FXML
    private Button numE;

    @FXML
    private Button numF;
    @FXML
    private Button binInputLabel;
    @FXML
    private Button octInputLabel;
    @FXML
    private Button decInputLabel;
    @FXML
    private Button hexInputLabel;
    private String textFocus; // The Text is on focus (input or output)
    private int inputLengthMax;
    private int outputLengthMax;
    private Boolean checkOutput; // check if we pressed the equal operator
    private String expression;
    private String baseInput; // Base of the input where we are writting
    private String baseInputLabel; // Base of input label (where display expression)
    private ArrayList<String> list;

    private ArrayList<String> operandBinList;
    private ArrayList<String> operandOctList;
    private ArrayList<String> operandDecList;
    private ArrayList<String> operandHexList;
    private ArrayList<String> operatorList;
    private boolean checkOperator;
    Map<String, String> switchBaseList = new HashMap<>() {{
        put("BIN", "OCT");
        put("OCT", "DEC");
        put("DEC", "HEX");
        put("HEX", "BIN");
    }};
    Map<String, Integer> baseNumber = new HashMap<>(){{
        put("BIN", 2);
        put("OCT", 8);
        put("DEC", 10);
        put("HEX", 16);
    }};
    void switchInput(){
        String tempBin = "";
        String temp = "";
        switch (baseInputLabel){
            case "BIN":
                for(int i = 0; i < operandBinList.size(); i++){
                    temp += " " + operandBinList.get(i);
                    if(i <= operatorList.size() - 1) temp += " "+operatorList.get(i);
                }
                break;
            case "OCT":
                for(int i = 0; i < operandOctList.size(); i++){
                    temp += " " +operandOctList.get(i);
                    if(i <= operatorList.size() - 1) temp += " " + operatorList.get(i);
                }
                break;
            case "DEC":
                for(int i = 0; i < operandDecList.size(); i++){
                    temp += " " + operandDecList.get(i);
                    if(i <= operatorList.size() - 1) temp += " " + operatorList.get(i);
                }
                break;
            case "HEX":
                for(int i = 0; i < operandHexList.size(); i++){
                    temp += " " + operandHexList.get(i);
                    if(i <= operatorList.size() - 1) temp += " " + operatorList.get(i);
                }
                break;
        }
        for(int i = 0; i < operandBinList.size(); i++){
            tempBin += " " + operandBinList.get(i);
            if(i <= operatorList.size() - 1) tempBin += " " + operatorList.get(i);
        }
        input.setText(temp);
        expression = tempBin;
    }
    @FXML
    void bitwiseOperator(ActionEvent event) {
        Button buttonTemp = (Button) event.getSource();
        String stringTemp = buttonTemp.getText();
        operandBinList.add(binInput.getText());
        operandOctList.add(octInput.getText());
        operandDecList.add(decInput.getText());
        operandHexList.add(hexInput.getText());
        operatorList.add(stringTemp);
        switchInput();
        binInput.setText("");
        decInput.setText("");
        octInput.setText("");
        hexInput.setText("");
    }

    @FXML
    void chooseBaseInput(ActionEvent event) {
        Button buttonTemp = (Button) event.getSource();
        String stringTemp = buttonTemp.getText();
        baseInput = stringTemp;
        switch (baseInput){
            case "BIN":
                binInputLabel.setStyle("fx-background-color: #e6e6e6");
                octInputLabel.setStyle(null);
                decInputLabel.setStyle(null);
                hexInputLabel.setStyle(null);
                num2.setDisable(true); num2.setStyle("fx-background-color: #e6e6e6");
                num3.setDisable(true); num3.setStyle("fx-background-color: #e6e6e6");
                num4.setDisable(true); num4.setStyle("fx-background-color: #e6e6e6");
                num5.setDisable(true); num5.setStyle("fx-background-color: #e6e6e6");
                num6.setDisable(true); num6.setStyle("fx-background-color: #e6e6e6");
                num7.setDisable(true); num7.setStyle("fx-background-color: #e6e6e6");
                num8.setDisable(true); num8.setStyle("fx-background-color: #e6e6e6");
                num9.setDisable(true); num9.setStyle("fx-background-color: #e6e6e6");
                numA.setDisable(true); numA.setStyle("fx-background-color: #e6e6e6");
                numB.setDisable(true); numB.setStyle("fx-background-color: #e6e6e6");
                numC.setDisable(true); numC.setStyle("fx-background-color: #e6e6e6");
                numD.setDisable(true); numD.setStyle("fx-background-color: #e6e6e6");
                numE.setDisable(true); numE.setStyle("fx-background-color: #e6e6e6");
                numF.setDisable(true); numF.setStyle("fx-background-color: #e6e6e6");
                break;
            case "OCT":
                binInputLabel.setStyle(null);
                octInputLabel.setStyle("fx-background-color: #e6e6e6");
                decInputLabel.setStyle(null);
                hexInputLabel.setStyle(null);
                num2.setDisable(false); num2.setStyle(null);
                num3.setDisable(false); num3.setStyle(null);
                num4.setDisable(false); num4.setStyle(null);
                num5.setDisable(false); num5.setStyle(null);
                num6.setDisable(false); num6.setStyle(null);
                num7.setDisable(false); num7.setStyle(null);
                num8.setDisable(true); num8.setStyle("fx-background-color: #e6e6e6");
                num9.setDisable(true); num9.setStyle("fx-background-color: #e6e6e6");
                numA.setDisable(true); numA.setStyle("fx-background-color: #e6e6e6");
                numB.setDisable(true); numB.setStyle("fx-background-color: #e6e6e6");
                numC.setDisable(true); numC.setStyle("fx-background-color: #e6e6e6");
                numD.setDisable(true); numD.setStyle("fx-background-color: #e6e6e6");
                numE.setDisable(true); numE.setStyle("fx-background-color: #e6e6e6");
                numF.setDisable(true); numF.setStyle("fx-background-color: #e6e6e6");
                break;
            case "DEC":
                binInputLabel.setStyle(null);
                octInputLabel.setStyle(null);
                decInputLabel.setStyle("fx-background-color: #e6e6e6");
                hexInputLabel.setStyle(null);
                num2.setDisable(false); num2.setStyle(null);
                num3.setDisable(false); num3.setStyle(null);
                num4.setDisable(false); num4.setStyle(null);
                num5.setDisable(false); num5.setStyle(null);
                num6.setDisable(false); num6.setStyle(null);
                num7.setDisable(false); num7.setStyle(null);
                num8.setDisable(false); num8.setStyle(null);
                num9.setDisable(false); num9.setStyle(null);
                numA.setDisable(true); numA.setStyle("fx-background-color: #e6e6e6");
                numB.setDisable(true); numB.setStyle("fx-background-color: #e6e6e6");
                numC.setDisable(true); numC.setStyle("fx-background-color: #e6e6e6");
                numD.setDisable(true); numD.setStyle("fx-background-color: #e6e6e6");
                numE.setDisable(true); numE.setStyle("fx-background-color: #e6e6e6");
                numF.setDisable(true); numF.setStyle("fx-background-color: #e6e6e6");
                break;
            case "HEX":
                binInputLabel.setStyle(null);
                octInputLabel.setStyle(null);
                decInputLabel.setStyle(null);
                hexInputLabel.setStyle("fx-background-color: #e6e6e6");
                num2.setDisable(false); num2.setStyle(null);
                num3.setDisable(false); num3.setStyle(null);
                num4.setDisable(false); num4.setStyle(null);
                num5.setDisable(false); num5.setStyle(null);
                num6.setDisable(false); num6.setStyle(null);
                num7.setDisable(false); num7.setStyle(null);
                num8.setDisable(false); num8.setStyle(null);
                num9.setDisable(false); num9.setStyle(null);
                numA.setDisable(false); numA.setStyle(null);
                numB.setDisable(false); numB.setStyle(null);
                numC.setDisable(false); numC.setStyle(null);
                numD.setDisable(false); numD.setStyle(null);
                numE.setDisable(false); numE.setStyle(null);
                numF.setDisable(false); numF.setStyle(null);
                break;
        }
    }

    @FXML
    void chooseBaseInputLabel(ActionEvent event) {
        Button buttonTemp = (Button)event.getSource();
        String stringTemp = buttonTemp.getText();
        baseInputLabel = switchBaseList.get(stringTemp);

        baseChoice.setText(baseInputLabel);
        switchInput();

    }

    @FXML
    void clear(ActionEvent event) {
        clearText(input, output);
        operandBinList.clear();
        operandDecList.clear();
        operandOctList.clear();
        operandHexList.clear();
        operatorList.clear();
        expression = "";
        binInput.setText("");
        octInput.setText("");
        decInput.setText("");
        hexInput.setText("");
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
        // Need fix for bitwise expression.
    }

    @FXML
    void inputDigit(ActionEvent event) {
        Button buttonTemp = (Button) event.getSource();
        String stringTemp= buttonTemp.getText();
        String temp;
        switch (baseInput){
                case "BIN":
                    binInput.setText(binInput.getText() + stringTemp);
                    if(checkOutput){
                        binInput.setText(stringTemp);
                    }
                    temp = binInput.getText();
                    octInput.setText(baseConversion(temp, 2,8));
                    decInput.setText(baseConversion(temp, 2,10));
                    hexInput.setText(baseConversion(temp, 2,16));
                    break;
                case "OCT":
                    octInput.setText(octInput.getText() + stringTemp);
                    if(checkOutput){
                        octInput.setText(stringTemp);
                    }
                    temp = octInput.getText();
                    binInput.setText(baseConversion(temp, 8,2));
                    decInput.setText(baseConversion(temp, 8,10));
                    hexInput.setText(baseConversion(temp, 8,16));
                    break;
                case "DEC":
                    decInput.setText(decInput.getText() + stringTemp);
                    if(checkOutput){
                        decInput.setText(stringTemp);
                    }
                    temp = decInput.getText();
                    binInput.setText(baseConversion(temp, 10,2));
                    octInput.setText(baseConversion(temp, 10,8));
                    hexInput.setText(baseConversion(temp, 10,16));
                    break;
                case "HEX":
                    hexInput.setText(hexInput.getText() + stringTemp);
                    if(checkOutput){
                        hexInput.setText(stringTemp);
                    }
                    temp = hexInput.getText();
                    binInput.setText(baseConversion(temp, 16,2));
                    octInput.setText(baseConversion(temp, 16,8));
                    decInput.setText(baseConversion(temp, 16,10));
                    break;
        }
        checkOutput = false;

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
    void operator() {
        operandBinList.add(binInput.getText());
        operandOctList.add(octInput.getText());
        operandDecList.add(decInput.getText());
        operandHexList.add(hexInput.getText());
        switchInput();
        System.out.println("testOperator");
        expression = expression.substring(1);
        System.out.println("*" + expression);
        String res = bitwiseOperate(expression);
        output.setText(baseConversion(res,2,baseNumber.get(baseInputLabel)));
        binInput.setText(res);
        octInput.setText(baseConversion(res,2,8));
        decInput.setText(baseConversion(res,2,10));
        hexInput.setText(baseConversion(res,2,16));
    }

    @FXML
    void switchMode(ActionEvent event) {
        chooseMode(event);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textFocus = "input";
        inputLengthMax = (int)maxTextLength(input);
        outputLengthMax = (int)maxTextLength(output);
        checkOutput = true;
        expression = "";
        baseInput = "DEC";
        baseInputLabel = "DEC";

        checkOperator = false;
        list = new ArrayList<>();
        operandBinList = new ArrayList<>();
        operandOctList = new ArrayList<>();
        operandDecList = new ArrayList<>();
        operandHexList = new ArrayList<>();
        operatorList = new ArrayList<>();
    }
}
