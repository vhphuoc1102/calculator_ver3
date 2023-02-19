package com.calculator.calculator_ver3.GeneralFeatures;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MenuNavigate {
    private static Boolean menuDisplayed = true;
    public static void menuNavigate(AnchorPane menu){
        if (menuDisplayed) {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.3));
            slide.setNode(menu);

            slide.setToX(-200);
            slide.play();

            menu.setTranslateX(0);
            menuDisplayed = false;
        } else {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.3));
            slide.setNode(menu);

            slide.setToX(0);
            slide.play();

            menu.setTranslateX(-200);
            menuDisplayed = true;
        }
    }
}
