package com.micasa.calculadora.CalculadoraModel;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {
    private static ArrayList<Double>  nums = new ArrayList<>();
    private static ArrayList<String>  ops;

    public static String producirResultado(String ingreso){
        ingreso = ingreso.replace(",",".");
        try{
            nums = evaluarFlotantes(ingreso);
            ops = evaluarSignos(ingreso);
        }catch(Exception e){
            e.getStackTrace();
        }
        StringBuilder result = new StringBuilder(ops.toString());
        result.append(nums.toString());
        return result.toString();
    }

    private static ArrayList<String> evaluarSignos(String dato) {
        ArrayList<String> caracteres = new ArrayList<>(List.of(dato.split("")));
        ArrayList<String> signos = new ArrayList<>();
        for(String elem: caracteres){
            if(
                    elem.equals("+")|| elem.equals("-")||elem.equals("*")||elem.equals("/")
            ) signos.add(elem);
        }
        return signos;
    }

    private static ArrayList<Double> evaluarFlotantes(String dato) throws  Exception{
        ArrayList<Double> valores = new ArrayList<>();
        ArrayList<String> campos = new ArrayList<>(List.of(dato.split("[+\\-*/]")));
        for(String elem: campos) {
            valores.add(Double.parseDouble(elem));
        }
        return valores;
    }
}
