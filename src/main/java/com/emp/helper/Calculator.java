package com.emp.helper;

public class Calculator {
    public int doSum(int a, int b, int c){
        return a+b+c;
    }
    public int doMultiply(int a, int b){
        return a*b;
    }

    public static void main(String[] args) {
        Calculator calculator=new Calculator();
        int a=calculator.doSum(1, 2, 3);
        System.out.println(a);
    }
    public boolean compareNumbers(int a, int b){
        return a==b;
    }
}