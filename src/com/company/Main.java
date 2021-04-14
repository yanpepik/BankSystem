package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addUser("user1", "passw1");
        bank.addUser("user2", "passw2");
        bank.addUser("user3", "passw3");
        bank.addUser("user4", "passw4");
        bank.setAdmin("admin", "admin", "user1");
        int operation = 0;
        String currentUsername = "";
        String currentPassword = "";

        while (operation != -1){
            System.out.println("Choose menu item:");
            System.out.println("1.login");
            System.out.println("2.logout");
            System.out.println("3.add account");
            System.out.println("4.put money from account to account");
            System.out.println("5.get money from account");
            System.out.println("enter -1 to exit");

            Scanner scanner = new Scanner(System.in);
            operation = scanner.nextInt();

            switch (operation){
                case 1:
                    System.out.println("\nusername: ");
                    scanner.nextLine();
                    currentUsername = scanner.nextLine();
                    System.out.println("password: ");
                    currentPassword = scanner.nextLine();
                    break;
                case 2:
                    currentUsername = "";
                    currentPassword = "";
                    break;
                case 3:
                    int ac = bank.addAccount(currentUsername, currentPassword);
                    System.out.println("created account with number: " + ac + "\nDON'T FORGET HIM.");
                    break;
                case 4:
                    System.out.print("enter source account number: ");
                    int senderAccNum = scanner.nextInt();
                    System.out.print("enter receiver: ");
                    int receiverAccNum = scanner.nextInt();
                    System.out.print("enter amount of money to send: ");
                    int amount = scanner.nextInt();
                    bank.sendMoney(senderAccNum, currentUsername, currentPassword, receiverAccNum, amount);
                    System.out.println("SUCCESS!");
                    break;
                case 5:
                    System.out.print("enter account num: ");
                    int accountNum = scanner.nextInt();
                    int currentAmount = bank.getAccountMoney(currentUsername, currentPassword, accountNum);
                    System.out.println("current amount of money: " + currentAmount);
                    break;
            }
        }
    }

}
