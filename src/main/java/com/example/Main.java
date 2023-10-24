package com.example;
public class Main {
    public static void main(String[] args) throws Exception {
        Feline filine = new Feline();
        Lion lion = new Lion(filine,"Самец");
        System.out.println(lion.getFood());
    }
}