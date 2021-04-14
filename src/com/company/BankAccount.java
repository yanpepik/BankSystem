package com.company;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int amountOfMoney;
    private int accountNum;
    private List<Card> cards;

    private static int counter = 0;

    public BankAccount(int amountOfMoney) {
        counter++;
        this.amountOfMoney = amountOfMoney;
        this.accountNum = counter;
        this.cards = new ArrayList<>();
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public int getAccountNum(){
        return accountNum;
    }

    public void writeOffMoney(int amount) {
        this.amountOfMoney -= amount;
    }

    public void putMoney(int amount){
        this.amountOfMoney += amount;
    }

    public void addCard(int cardNum){
        cards.add(new Card(cardNum, this));
    }

    public void blockAllCards(){
        for(Card card : cards){
            card.block();
        }
    }

}
