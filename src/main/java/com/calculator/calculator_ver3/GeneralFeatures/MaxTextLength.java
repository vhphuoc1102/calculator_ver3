package com.calculator.calculator_ver3.GeneralFeatures;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MaxTextLength {
    static double getTextWidth(String text, double fontSize, String fontName) {
        Text t = new Text(text);
        t.setFont(Font.font(fontName, fontSize));
        return t.getLayoutBounds().getWidth();
    }

    // Calculate the maximum length of text that can be displayed in a Label
    // without text overrun, based on the width of the Label and the font size
    // and style being used.
    public static double maxTextLength(Label label) {
        // Get the width of the Label
        double labelWidth = label.getWidth();

        // Get the font size and style being used by the Label
        Font font = label.getFont();
        double fontSize = font.getSize();
        String fontName = font.getName();

        // Calculate the width of a single character of text using the font size
        // and style being used
        double charWidth = getTextWidth("A", fontSize, fontName);  // use a capital A as an example

        // Calculate the maximum length of text that can be displayed in the Label
        // based on the width of the Label and the width of a single character
        // of text
        double maxLength = Math.floor(labelWidth / charWidth);
        return maxLength;
    }
}
