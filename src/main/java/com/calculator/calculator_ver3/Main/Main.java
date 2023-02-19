package com.calculator.calculator_ver3.Main;

import com.calculator.calculator_ver3.Controllers.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        new SceneController(stage, "Basic Mode");
    }
}
