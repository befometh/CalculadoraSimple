package com.micasa.calculadora.CalculadoraController;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import com.micasa.calculadora.CalculadoraModel.Calculadora;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculadoraController {

    @FXML
    private TextField campoNumero, campoResultado;

    @FXML
    public void initialize() {
        campoResultado.setEditable(false);
        campoNumero.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
            if(e.getCode() != KeyCode.BACK_SPACE)
                filtrarTeclado(e.getText());
        });
    }

    private void filtrarTeclado(String elem) {
        String dato = campoNumero.getText();
        char ingreso = 0;
        try{
            ingreso = elem.charAt(0);
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            System.out.println("-".repeat(200));
        }
        String patron = "^([0-9\\-][0-9+\\-*/.,]*)$";
        Pattern regex = Pattern.compile(patron);
        Matcher matcher = regex.matcher(dato);
        boolean matchFound = matcher.find();
        if (matchFound) {
            agregarChar(ingreso);
        }
        else{
            String temp;
            if(dato.isEmpty())
                temp = "";
            else
                temp = dato.substring(0, dato.length()-1);
            campoNumero.setText(temp);
        }
        campoNumero.positionCaret(campoNumero.getText().length());
    }

    @FXML
    public void agregarChar(char valor){
        StringBuilder temp = new StringBuilder();
        boolean ultimoValido;
        if(campoNumero.getText().length()<=1) {
            ultimoValido=comprobarUltimo('x',valor);
        } else {
            temp.append(campoNumero.getText(), 0, campoNumero.getText().length()-1);
            ultimoValido= comprobarUltimo(temp.charAt(temp.length()-1),valor);
            campoNumero.clear();
        }
        if(ultimoValido){
            temp.append(valor);
        }
        campoNumero.setText(temp.toString());
        campoNumero.requestFocus();
        campoNumero.positionCaret(campoNumero.getText().length());
    }

    @FXML
    public void agregarSuma(){
        filtrarTeclado("+");
    }

    @FXML
    public void agregarResta(){
        filtrarTeclado("-");
    }

    @FXML
    public void agregarMult(){
        filtrarTeclado("*");
    }

    @FXML
    public void agregarDivision(){
        filtrarTeclado("/");
    }

    @FXML
    public void crearResultado(){
        String campo = campoNumero.getText();
        String resultado = (Calculadora.producirResultado(campo));
        campoResultado.setText(resultado);
    }

    private boolean comprobarUltimo(char ultimo, char valor) {
        return switch (valor) {
            case '+', '*', '/' -> {
                if (ultimo == '+' || ultimo == '-' || ultimo == '*' || ultimo == '/' || ultimo == '(' || ultimo == 'x')
                    yield false;
                yield true;
            }
            case '-' -> {
                if (ultimo == '-' || ultimo == '+')
                    yield false;
                yield true;
            }
            default -> true;
        };
    }

}
