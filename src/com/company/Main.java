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
            System.out.println("1.register");
            System.out.println("2.login");
            System.out.println("3.logout");
            System.out.println("4.add account");
            System.out.println("5.add card to account");
            System.out.println("6.put money to account's card");
            System.out.println("7.get money from account's card");
            System.out.println("8.put money from account's card to another card");
            System.out.println("9.take credit");
            System.out.println("10.show my credits");
            System.out.println("11.repay the loan");
            System.out.println("enter -1 to exit");
            System.out.print("Choose menu item: ");
            Scanner scanner = new Scanner(System.in);
            operation = scanner.nextInt();

            switch (operation){
                case 1:
                    System.out.println("\nusername: ");
                    scanner.nextLine();
                    String username = scanner.nextLine();
                    System.out.println("password: ");
                    String password = scanner.nextLine();
                    if (!username.equals("") && !password.equals("")) {
                        bank.addUser(username, password);
                    }
                    break;
                case 2:
                    System.out.println("\nusername: ");
                    scanner.nextLine();
                    currentUsername = scanner.nextLine();
                    System.out.println("password: ");
                    currentPassword = scanner.nextLine();
                    break;
                case 3:
                    currentUsername = "";
                    currentPassword = "";
                    break;
                case 4:
                    int ac = bank.addAccount(currentUsername, currentPassword);
                    System.out.println("created account with number: " + ac + "\nDON'T FORGET HIM.");
                    break;
                case 5:
                    if (!currentUsername.equals("") && !currentPassword.equals("")) {
                        System.out.print("enter account num: ");
                        int accountNum = scanner.nextInt();
                        int cardNumb = bank.getUser(currentUsername, currentPassword).getAccount(accountNum).addCard();
                        System.out.printf("Remember your card ID: %d.\n", cardNumb);
                    } else  {
                        System.out.println("login first!");
                    }
                    break;
                case 6:
                    System.out.print("enter account number: ");
                    int accNumb = scanner.nextInt();
                    System.out.print("enter card number: ");
                    int cardNumb = scanner.nextInt();
                    System.out.print("enter amount of money to send: ");
                    int amount = scanner.nextInt();
                    bank.putMoney(accNumb, cardNumb, amount);
                    System.out.println("SUCCESS!");
                    break;
                case 7:
                    System.out.print("enter account num: ");
                    int accountNum = scanner.nextInt();
                    System.out.print("enter card num: ");
                    cardNumb = scanner.nextInt();
                    int currentAmount = bank.getCardAccountMoney(currentUsername, currentPassword, accountNum, cardNumb);
                    System.out.printf("current amount of money: %d$\n", currentAmount);
                    break;
                case 8:
                    System.out.print("enter source account number: ");
                    int senderAccNum = scanner.nextInt();
                    System.out.print("enter source card number: ");
                    int senderCardNum = scanner.nextInt();
                    System.out.print("enter receiver account number: ");
                    int receiverAccNum = scanner.nextInt();
                    System.out.print("enter receiver card id: ");
                    int receiverCardNum = scanner.nextInt();
                    System.out.print("enter amount of money to send: ");
                    amount = scanner.nextInt();
                    bank.sendMoney(senderAccNum, senderCardNum, currentUsername, currentPassword, receiverAccNum, receiverCardNum, amount);
                    System.out.println("SUCCESS!");
                    break;
                case 9:
                    System.out.print("enter account number: ");
                    accNumb = scanner.nextInt();
                    System.out.print("enter amount of money: ");
                    double money = scanner.nextDouble();
                    bank.addCredit(accNumb, money);
                    break;
                case 10:
                    System.out.print("enter account number: ");
                    accNumb = scanner.nextInt();
                    bank.showAllCredits(accNumb);
                    break;
                case 11:
                    System.out.print("enter credit number: ");
                    int creditNumb = scanner.nextInt();
                    System.out.print("enter amount of money: ");
                    money = scanner.nextDouble();
                    bank.getCredit(creditNumb).repay(money);
                    break;

            }
        }
    }

}
