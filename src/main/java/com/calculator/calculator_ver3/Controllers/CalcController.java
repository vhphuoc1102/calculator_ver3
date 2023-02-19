package com.calculator.calculator_ver3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static com.calculator.calculator_ver3.GeneralFeatures.ChooseMode.chooseMode;
import static com.calculator.calculator_ver3.GeneralFeatures.MenuNavigate.menuNavigate;
import static com.calculator.calculator_ver3.MathFeatures.Calc.calc;

public class CalcController implements Initializable {
    @FXML
    private TextField aValue;

    @FXML
    private TextField bValue;

    @FXML
    private TextField cValue;

    @FXML
    private TextField dValue;

    @FXML
    private TextField eValue;

    @FXML
    private TextField fValue;

    @FXML
    private TextField gValue;

    @FXML
    private TextField hValue;

    @FXML
    private TextField input;

    @FXML
    private TextField mValue;

    @FXML
    private Button menuOnButton;

    @FXML
    private Button menuOnButtonOverlay;
    @FXML
    private AnchorPane menu;
    @FXML
    private TextField nValue;

    @FXML
    private Label output;

    @FXML
    private TextField tValue;

    @FXML
    private TextField xValue;

    @FXML
    private TextField yValue;

    @FXML
    private TextField zValue;
    private String experssion;

    @FXML
    void clear() {
        input.setText("");
        output.setText("");
        aValue.setText("");
        bValue.setText("");
        cValue.setText("");
        dValue.setText("");
        eValue.setText("");
        fValue.setText("");
        gValue.setText("");
        hValue.setText("");
        mValue.setText("");
        nValue.setText("");
        xValue.setText("");
        yValue.setText("");
        zValue.setText("");
        tValue.setText("");
    }

    @FXML
    void operator(ActionEvent event) {
        experssion = input.getText();
        output.setText(calc(experssion,
                aValue.getText(),
                bValue.getText(),
                cValue.getText(),
                dValue.getText(),
                eValue.getText(),
                fValue.getText(),
                gValue.getText(),
                hValue.getText(),
                mValue.getText(),
                nValue.getText(),
                xValue.getText(),
                yValue.getText(),
                zValue.getText(),
                tValue.getText()
        ));
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clear();
    }
}
