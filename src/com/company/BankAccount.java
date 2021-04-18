package com.company;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int accountNum;
    private List<Card> cards;
    private static int counter = 0;

    public BankAccount() {
        counter++;
        this.accountNum = counter;
        this.cards = new ArrayList<>();
    }

    public int getAccountNum(){
        return accountNum;
    }

    public void writeOffMoney(int cardNumb, int amount) {
        Card card = getCard(cardNumb);
        card.writeOffMoney(amount);
    }

    public void putMoney(int cardNumb, int amount) {
        Card card = getCard(cardNumb);
        card.putMoney(amount);
    }

    public int addCard() {
        Card card = new Card(this, 0);
        cards.add(card);
        return card.getNumber();
    }

    public void blockAllCards(){
        for(Card card : cards){
            card.block();
        }
    }

    public Card getCard(int cardNumb) {
        Card card =  cards.stream().filter(x -> x.getNumber() == cardNumb).findFirst().orElse(null);

        if (card != null) {
            return card;
        } else {
            throw new IllegalArgumentException("Card is not found.");
        }
    }

    public int getCardMoney(int cardNumb) {
        return getCard(cardNumb).getAmountOfMoney();
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNum=" + accountNum +
                '}';
    }
}
