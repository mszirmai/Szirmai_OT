package com.example.s6_zadanie_2;

public class Account {
    private double balance;

    public Account(double b){
        balance = b;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double b){
        this.balance = b;
    }
}
