package com.example.s5_zadanie_2;

public class Item {
    private String name;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        this.name = n;
    }

    @Override
    public String toString(){
        return name;
    }
}
