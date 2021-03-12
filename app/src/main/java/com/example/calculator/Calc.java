package com.example.calculator;

public class Calc {

    public double solveEquation(String s){
        if (s.contains("+")) return sum(s);
        else if (s.contains("*")) return mul(s);
        else if (s.contains("/")) return div(s);
        else if (s.contains("-")) return sub(s);
        return 0;
    }

    private double sum(String s){
        double a, b;
        String[] splitS = s.split("\\+");
        if (!splitS[0].equals(".")) {
            a = Double.parseDouble(splitS[0]);
        } else a = 0;
        if (!splitS[1].equals(".")) {
            b = Double.parseDouble(splitS[1]);
        } else b = 0;
        return a + b;
    }

    private double div(String s){
        double a, b;
        String[] splitS = s.split("/");
        if (!splitS[0].equals(".")) {
            a = Double.parseDouble(splitS[0]);
        } else a = 0;
        if (!splitS[1].equals(".")) {
            b = Double.parseDouble(splitS[1]);
        } else b = 0;
        if (b == 0) throw new RuntimeException();
        return a / b;
    }

    private double mul(String s){
        double a, b;
        String[] splitS = s.split("\\*");
        if (!splitS[0].equals(".")) {
            a = Double.parseDouble(splitS[0]);
        } else a = 0;
        if (!splitS[1].equals(".")) {
            b = Double.parseDouble(splitS[1]);
        } else b = 0;
        return a * b;
    }

    private double sub(String s){
        double a, b;
        String[] splitS = s.split("-");
        if (!splitS[0].equals(".")) {
            a = Double.parseDouble(splitS[0]);
        } else a = 0;
        if (!splitS[1].equals(".")) {
            b = Double.parseDouble(splitS[1]);
        } else b = 0;
        return a - b;
    }
}
