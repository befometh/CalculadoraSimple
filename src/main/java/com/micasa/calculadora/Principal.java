package com.micasa.calculadora;

import com.micasa.calculadora.CalculadoraController.CalculadoraController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Principal extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/micasa/calculadora/CalculadoraView/VistaCalculadora.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Calculadora Simple");
        stage.setScene(scene);
        stage.show();

        /*scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
            }
        });*/
    }

    public static void main(String[] args) {
        launch();
    }
}