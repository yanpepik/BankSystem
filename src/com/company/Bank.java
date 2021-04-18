package com.company;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bank {
    private List<BankAccount> accounts;
    private List<User> users;
    private List<Credit> credits;

    public static int counter = 0;

    public Bank(){
        accounts = new ArrayList<>();
        users = new ArrayList<>();
        credits = new ArrayList<>();
        User admin = new User("admin", "admin", Privileges.ADMIN);
        users.add(admin);
        admin.getAccounts().add(new BankAccount());
    }

    public void addUser(String username, String password){
        User user = new User(username, password);
        users.add(user);
        accounts.addAll(user.getAccounts());
    }

    private BankAccount getAccount(int accountNum){
        for(BankAccount account : accounts){
            if(account.getAccountNum() == accountNum)
                return account;
        }
        throw new IllegalArgumentException("No such account in Bank");
    }

    public User getUser(String username, String password){
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        throw new IllegalArgumentException("Bad credentials");
    }

    public int addAccount(String username, String password){
        User user = getUser(username, password);
        BankAccount account = new BankAccount();
        user.getAccounts().add(account);
        accounts.add(account);
        return account.getAccountNum();
    }
    public void setAdmin(String username, String password, String usernameToAdmin){
        User adminUser = getUser(username, password);
        if(!adminUser.getPrivileges().equals(Privileges.ADMIN))
            throw new IllegalArgumentException("User " + username + " do not have permission to set admin");
        getUser(username, password).setPrivileges(Privileges.ADMIN);
    }

    public void putMoney(int accNumb, int cardNumb, int amount) {
        BankAccount acc = getAccount(accNumb);
        acc.getCard(cardNumb).putMoney(amount);
    }

    public void sendMoney(int accountNumSender, int cardNum, String senderUsername,
                          String senderPassword, int accNumbReceiver, int cardNumbReceiver, int amount){
        User user = getUser(senderUsername, senderPassword);
        BankAccount accountSender = null;
        for(BankAccount currAccount : user.getAccounts()){
            if(currAccount.getAccountNum() == accountNumSender)
                accountSender = currAccount;
        }
        if(accountSender == null)
            throw new IllegalArgumentException("No such senderAccount");

        BankAccount accountReceiver = getAccount(accNumbReceiver);
        accountSender.writeOffMoney(cardNum, amount);
        accountReceiver.putMoney(cardNumbReceiver, amount);
    }

    public void blockAccount(String username, String password, int numAccountToBlock){
        User user = getUser(username, password);
        if(!user.getPrivileges().equals(Privileges.ADMIN))
            throw new IllegalArgumentException("You not allowed to block account");
    }

    public int getCardAccountMoney(String username, String password, int accountNum, int cardNum) {
        User user = getUser(username, password);
        return user.getAccount(accountNum).getCardMoney(cardNum);
    }

    public void addCredit(int accNum, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Credit amount must be positive.");
        }

        BankAccount acc = getAccount(accNum);
        Credit credit = new Credit(acc, amount);
        credits.add(credit);
        System.out.printf("Your credit card number is %d.", credit.getId());
    }

    public Credit getCredit(int creditNumb) {
        for (Credit credit : credits) {
            if (credit.getId() == creditNumb)
                return credit;
        }
        throw new IllegalArgumentException("Credit with such id does not exist.");
    }

    public void showAllCredits(int accNumb) {
        for (Credit credit : credits) {
            if (credit.getBankAccount().getAccountNum() == accNumb)
                System.out.println(credit);
        }
    }




//    public int getAccountMoney(String username, String password, int accountNum){
//        User user = getUser(username, password);
//        return user.getAccount(accountNum).getAmountOfMoney();
//    }

}
