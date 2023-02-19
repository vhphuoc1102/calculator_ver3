package com.calculator.calculator_ver3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static com.calculator.calculator_ver3.GeneralFeatures.ChooseMode.chooseMode;
import static com.calculator.calculator_ver3.GeneralFeatures.DeleteText.deleteText;
import static com.calculator.calculator_ver3.GeneralFeatures.MenuNavigate.menuNavigate;
import static com.calculator.calculator_ver3.MathFeatures.ScientificCalculate.scientificCalculate;

public class ScientificController implements Initializable {
    @FXML
    private Button arrow_leftButton;

    @FXML
    private Button arrow_rightButton;

    @FXML
    private Button cos;

    @FXML
    private Button deleteButton;

    @FXML
    private Button deriative;

    @FXML
    private Button exponent;

    @FXML
    private Label input;

    @FXML
    private Button loga;

    @FXML
    private Button logaE;

    @FXML
    private Button menuOffButton;

    @FXML
    private Button menuOffButtonOverlay;

    @FXML
    private Button menuOnButton;

    @FXML
    private Button menuOnButtonOverlay;

    @FXML
    private Label output;

    @FXML
    private Button rad;

    @FXML
    private Button sin;

    @FXML
    private Button square;
    @FXML
    private AnchorPane menu;

    @FXML
    private Button sum;

    @FXML
    private Button tan;
    @FXML
    private Button combination;
    private Boolean inverse;
    private String expression;
    private String unit;
    @FXML
    void clear(ActionEvent event) {
        output.setText("");
        input.setText("");
        expression = "";
    }


    @FXML
    void clickOnInput(MouseEvent event) {

    }

    @FXML
    void clickOnOutput(MouseEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {
        deleteText(input, output);
    }
    @FXML
    void inputDigit(ActionEvent event) {
        Button button = (Button) event.getSource();
        String stringTemp = button.getText();
        input.setText(input.getText() + stringTemp);
        System.out.println(input.getText());
        expression = input.getText();
    }
    @FXML
    void changeUnit(ActionEvent event) {
        Button buttonTemp = (Button) event.getSource();
        String stringTemp = buttonTemp.getText();
        if(stringTemp.equals("rad")) {
            unit = "degree";
            rad.setText("deg");
            rad.setStyle("-fx-textfill-color: orange");
        }
        else {
            rad.setStyle("-fx-textfill-color: #ffffff");
            unit = "radian";
            rad.setText("rad");
        }
    }
    @FXML
    void inverseButton() {
        if(inverse){
            sin.setText("arcsin");
            cos.setText("arccos");
            tan.setText("arctan");
            loga.setText("10^");
            logaE.setText("e^");
            deriative.setText("int");
            sum.setText("sum");
            combination.setText("nPk");
            inverse = false;
        }
        else {
            sin.setText("sin");
            cos.setText("cos");
            tan.setText("tan");
            loga.setText("log");
            logaE.setText("ln");
            deriative.setText("der");
            sum.setText("prod");
            combination.setText("nCk");
            inverse = true;
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
    void switchMode(ActionEvent event) {
        chooseMode(event);
    }
    @FXML
    void operator() {
        output.setText(scientificCalculate(expression, unit));
    }
    @FXML
    void transverse(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuNavigate(menu);
        inverse = true;
        expression = "";
        unit = "radian";
    }
}
