module com.calculator.calculator_ver3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign;

    requires MathParser.org.mXparser;
    requires javaluator;
    opens com.calculator.calculator_ver3 to javafx.fxml;
    opens com.calculator.calculator_ver3.Main to javafx.graphics;
    opens com.calculator.calculator_ver3.Controllers to javafx.fxml;
    exports com.calculator.calculator_ver3;
}