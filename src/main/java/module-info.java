module com.micasa.calculadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;


    exports com.micasa.calculadora.CalculadoraController to javafx.fxml;
    exports com.micasa.calculadora to javafx.graphics;
    opens com.micasa.calculadora.CalculadoraController;
}