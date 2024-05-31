package com.micasa.calculadora.CalculadoraController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import com.micasa.calculadora.CalculadoraModel.Calculadora;

public class CalculadoraController {

    @FXML
    private TextField campoNumero, campoResultado;



    @FXML
    private Button suma, resta, mmult, igual, division;

@FXML
public void initialize() {
    campoResultado.setEditable(false);
}

    @FXML
    public void agregarSuma(){
        StringBuilder temp=new StringBuilder(campoNumero.getText());
        try{
            temp.append("+");
            campoNumero.setText(temp.toString());
        }catch (Exception e){
            System.err.println("Valor inválido");
        }
        campoNumero.requestFocus();
        campoNumero.positionCaret(campoNumero.getText().length());
    }

    @FXML
    public void agregarResta(){
        StringBuilder temp=new StringBuilder(campoNumero.getText());
        try{
            temp.append("-");
            campoNumero.setText(temp.toString());
        }catch (Exception e){
            System.err.println("Valor inválido");
        }
        campoNumero.requestFocus();
        campoNumero.positionCaret(campoNumero.getText().length());
    }

    @FXML
    public void agregarMult(){
        StringBuilder temp=new StringBuilder(campoNumero.getText());
        try{
            temp.append("*");
            campoNumero.setText(temp.toString());
        }catch (Exception e){
            System.err.println("Valor inválido");
        }
        campoNumero.requestFocus();
        campoNumero.positionCaret(campoNumero.getText().length());
    }

    //@FXML
    public void agregarDivision(){
        StringBuilder temp=new StringBuilder(campoNumero.getText());
        try{
            temp.append("/(");
            campoNumero.setText(temp.toString());
        }catch (Exception e){
            System.err.println("Valor inválido");
        }
        campoNumero.requestFocus();
        campoNumero.positionCaret(campoNumero.getText().length());
    }

    @FXML
    public void crearResultado(){
        String campo = campoNumero.getText();
        String resultado = (Calculadora.producirResultado(campo));
        campoResultado.setText(resultado);
    }
}
