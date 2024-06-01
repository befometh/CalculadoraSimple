package com.micasa.calculadora.CalculadoraModel;

import java.util.ArrayList;

public class Calculadora {

    public static String producirResultado(String texto) {
        String campo = texto;
        String resultado;
        if(texto.isEmpty())
            return "El campo se encuentra vacío";
        else {
            campo = tratarTexto(campo);
            ArrayList<Double> nums = separarNumeros(campo);
            ArrayList<Character> ops = separarSignos(campo);
            resultado = realizarOps(nums, ops);
        }
        return resultado;
    }

    private static String realizarOps(ArrayList<Double> nums, ArrayList<Character> ops) {
        if(ops.isEmpty()){
            return nums.getFirst().toString();
        } else{
            int contador = 0;
            if(ops.contains('*')||ops.contains('/')){
                while(contador < ops.size()){
                    if(ops.get(contador) == '*'){
                        nums.set(contador, nums.get(contador)*nums.get(contador+1));
                        ops.remove(contador);
                        nums.remove(contador+1);
                    }
                    else if(ops.get(contador) == '/'){
                        nums.set(contador, nums.get(contador)/nums.get(contador+1));
                        ops.remove(contador);
                        nums.remove(contador+1);
                    }
                    contador++;
                }
                return realizarOps(nums,ops);
            }else if(ops.contains('+')){
                while(contador < ops.size()){
                    if(ops.get(contador) == '+'){
                        nums.set(contador, nums.get(contador)+nums.get(contador+1));
                        ops.remove(contador);
                        nums.remove(contador+1);
                    }
                    contador++;
                }
                return realizarOps(nums,ops);
            }
        }
        return "Ha ocurrido un error";
    }

    private static ArrayList<Character> separarSignos(String texto) {
        ArrayList<Character> ops = new ArrayList<>();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == '+' || texto.charAt(i) == '*' || texto.charAt(i) == '/') {
                ops.add(texto.charAt(i));
            }
        }
        return ops;
    }

    private static ArrayList<Double> separarNumeros(String texto) throws NumberFormatException {
        ArrayList<Double> nums = new ArrayList<>();
        String[] datos = texto.split("[+*/]");
        for (String dato : datos)
            nums.add(Double.parseDouble(dato));
        return nums;
    }

    private static String tratarTexto(String texto) {
        String valor = texto.replace(",", ".");
        StringBuilder conSigno = new StringBuilder();
        if (valor.charAt(0) == '-') {
            conSigno.append(valor.charAt(0));
            valor = valor.substring(1);
        }
        valor = valor.replace("-","+-");
        conSigno.append(valor);
        return conSigno.toString();
    }


}
