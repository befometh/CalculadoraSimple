module com.micasa.calculadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;


    opens com.micasa.calculadora.CalculadoraController;
    exports com.micasa.calculadora.CalculadoraController to javafx.fxml;
    exports com.micasa.calculadora to javafx.graphics;
}