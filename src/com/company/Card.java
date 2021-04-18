package com.company;

public class Card {
    private static int counter;
    private int number;
    private BankAccount account;
    private int amountOfMoney;

    private boolean isBlocked = false;

    public Card(BankAccount account, int amountOfMoney) {
        counter++;
        this.number = counter;
        this.account = account;
        this.amountOfMoney = amountOfMoney;
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

    public void writeOffMoney(int amountOfMoney) {
        this.amountOfMoney -= amountOfMoney;
    }

    public void putMoney(int amountOfMoney) {
        this.amountOfMoney += amountOfMoney;
    }



    public int getAmountOfMoney() {
        return this.amountOfMoney;
    }
}
