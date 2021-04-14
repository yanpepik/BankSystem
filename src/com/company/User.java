package com.company;


import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private Privileges privileges;

    private List<BankAccount> accounts;

    // Конструктор который принимает логин и пароль
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.privileges = Privileges.USER;
        this.accounts = new ArrayList<>();
    }

    // Перегруженный конструктор который принимает логин, пароль и привилегия
    public User(String username, String password, Privileges privileges) {
        this.username = username;
        this.password = password;
        this.privileges = privileges;
        this.accounts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }
    public void setPrivileges(Privileges privileges){
        this.privileges = privileges;
    }

    public String getPassword() {
        return password;
    }
    public List<BankAccount> getAccounts(){
        return accounts;
    }

    public BankAccount getAccount(int accountNum){
        for (BankAccount account : accounts){
            if(account.getAccountNum() == accountNum){
                return account;
            }
        }
        throw new IllegalArgumentException("User " + username + " do not have such account");
    }

    public Privileges getPrivileges() {
        return privileges;
    }

    public static void printClassName() {
        System.out.println("USER class");
    }
}
