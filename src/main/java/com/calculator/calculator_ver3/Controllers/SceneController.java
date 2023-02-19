package com.calculator.calculator_ver3.Controllers;

import com.calculator.calculator_ver3.Main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneController {
    private static Stage stage;

    private static Map<String, Scene> sceneMap = new HashMap<>() {{

        try {
            put("Basic Mode", new Scene((new FXMLLoader(Main.class.getResource("/Fxml/Basic_1.fxml"))).load()));
            put("Float Present Mode", new Scene((new FXMLLoader(Main.class.getResource("/Fxml/FloatPresent.fxml"))).load()));
            put("Scientific Mode", new Scene((new FXMLLoader(Main.class.getResource("/Fxml/Scientific.fxml"))).load()));
            put("Bitwise Operation Mode", new Scene((new FXMLLoader(Main.class.getResource("/Fxml/BitwiseOperate_1.fxml"))).load()));
            put("Calculate Mode", new Scene((new FXMLLoader(Main.class.getResource("/Fxml/Calc.fxml"))).load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }};

    public SceneController(Stage stage, String sceneKey){
        this.stage = stage;
        setScene(sceneKey);
    }
    public static void setScene(String sceneKey){
        System.out.println(sceneKey);
        Scene sceneCurrent = sceneMap.get(sceneKey);
        System.out.println(sceneCurrent);
        sceneCurrent.setFill(Color.TRANSPARENT);
        stage.setScene(sceneCurrent);
        stage.show();
    }
}
