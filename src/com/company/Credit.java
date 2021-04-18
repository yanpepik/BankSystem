package com.company;

public class Credit {
    private static int counter = 0;
    private int id;
    private double amount;
    private BankAccount bankAccount;
    private boolean isActive;

    public Credit(BankAccount bankAccount, double amount) {
        counter++;
        this.id = counter;
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.isActive = true;
    }

    public double getAmount() {
        return amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getId() {
        return id;
    }

    public void repay(double amount) {
        if (isActive) {
            if (this.amount >= amount) {
                this.amount -= amount;
                this.isActive = this.amount > 0;
            }
        } else {
            System.out.println("credit is already paid.");
        }
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", amount=" + amount +
                ", bankAccount=" + bankAccount +
                ", isActive=" + isActive +
                '}';
    }
}
