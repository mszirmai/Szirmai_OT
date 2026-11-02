package com.example.s6_zadanie_2;

public class Client {
    private int client_id;
    private Account account;

    public Client(Account a){
        client_id = ++HelloController.id;
        account = a;
    }

    @Override
    public String toString(){
      return "Client " + Integer.toString(client_id);
    };
}
