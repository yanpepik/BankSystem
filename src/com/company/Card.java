package com.company;

public class Card {
    private int number;
    private BankAccount account;

    private boolean isBlocked = false;

    public Card(int number, BankAccount account) {
        this.number = number;
        this.account = account;
    }

    public int getNumber() {
        return number;
    }

    public BankAccount getAccount() {
        return account;
    }

    public boolean isBlocked(){
        return isBlocked;
    }

    public void block(){
        isBlocked = true;
    }
}
