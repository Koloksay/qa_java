package com.example;

import java.util.List;

public class Alex extends Lion {

    public Alex() throws Exception {
        super(new Feline(), "самец");
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0; // У Алекса нет львят, поэтому возвращает 0
    }
}