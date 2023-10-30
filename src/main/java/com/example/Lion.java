package com.example;

import java.util.List;

public class Lion extends Feline {

    boolean hasMane;
    Feline feline;
    public Lion(Feline feline, String sex) throws Exception {
        if ("самец".equalsIgnoreCase(sex)) {
            hasMane = true;
        } else if ("самка".equalsIgnoreCase(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.feline=feline;
    }

    public Lion(){
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.eatMeat();
    }
}