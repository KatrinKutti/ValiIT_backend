package ee.bcs.valiit.tasks;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class Lesson4switch {
    static HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("createAccount");
        String sisend = scanner.nextLine();
//            String[] sisendParts = sisend.split(" ");
            BigDecimal balance = new BigDecimal("0");

        switch (sisend) {
            case "exit":
                if (sisend.equalsIgnoreCase("exit")) {
                    break;
                }
            case "createAccount":
                if (sisend.equalsIgnoreCase("createAccount")) {
                    System.out.println("Please enter account number: ");
                    String account = scanner.nextLine();
                    System.out.println("Account created. Your account number is " + account);
                    accountBalanceMap.put(account, balance);
                } else {
                    System.out.println("Unknown command");
                    break;
                }
            case "getBalance":
                System.out.println("getBalance");
                sisend = scanner.nextLine();
                if (sisend.equalsIgnoreCase("getBalance")) {
                    System.out.println("Please enter account number for balance info: ");
                    String account = scanner.nextLine();
                    accountBalanceMap.get(account);
                    System.out.println(accountBalanceMap);
                    System.out.println("Your balance is " + balance);
                } else {
                    System.out.println("Unknown command");
                    break;
                }
            case "depositMoney":
                System.out.println("depositMoney");
                sisend = scanner.nextLine();
                if (sisend.equalsIgnoreCase("depositMoney")) {
                    System.out.println("Please enter account number");
                    String account = scanner.nextLine();
                    System.out.println("Please enter deposit amount");
                    BigDecimal deposit = scanner.nextBigDecimal();
                    if (deposit.compareTo(BigDecimal.valueOf(0)) < 0) {
                        System.out.println("Invalid amount. Please enter valid deposit amount");
                        deposit = scanner.nextBigDecimal();
                    }
                    accountBalanceMap.getOrDefault(account, balance);
                    balance = balance.add(deposit);
                    accountBalanceMap.put(account, balance);
                    System.out.println(accountBalanceMap);
                    System.out.println("Deposit processed. Your new balance on account : " + account + " is: " + balance + "EUR");
                } else {
                    System.out.println("Unknown command");
                    break;
                }
            case "withdrawMoney":
                System.out.println("withdrawMoney");
                sisend = scanner.nextLine();
                if (sisend.equalsIgnoreCase("withdrawMoney")) {
                    System.out.println("Please enter account number to make withdrawal");
                    String account = scanner.nextLine();
                    System.out.println("Please enter withdrawal amount");
                    BigDecimal withdraw = scanner.nextBigDecimal();
                    if (withdraw.compareTo(BigDecimal.valueOf(0)) < 0) {
                        System.out.println("Invalid amount. Please try again");
                        withdraw = scanner.nextBigDecimal();
                    }
                    accountBalanceMap.getOrDefault(account, balance);
                    if (withdraw.compareTo(balance) > 0) {
                        System.out.println("You don't have enough money on your account " + account + " to withdraw " + withdraw + "EUR");
                        System.out.println("Please enter another amount");
                        withdraw = scanner.nextBigDecimal();
                    }
                    balance = balance.remainder(withdraw);
                    accountBalanceMap.put(account, balance);
                    System.out.println("Withdrawal processed! Your new balance on account " + account + " is: " + balance + "EUR");
                    System.out.println(accountBalanceMap);
                } else {
                    System.out.println("Unknown command");
                    break;
                }
            case "transfer":
                System.out.println("transfer");
                sisend = scanner.nextLine();
                if (sisend.equalsIgnoreCase("transfer")) {
                    System.out.println("Please enter account number from where you would like to make the transfer: ");
                    String fromAccount = scanner.nextLine();
                    System.out.println("Please enter account number to where you would like to make the transfer: ");
                    String toAccount = scanner.nextLine();
                    System.out.println("Please enter the amount to transfer: ");
                    BigDecimal transfer = scanner.nextBigDecimal();
                    if (transfer.compareTo(BigDecimal.valueOf(0)) < 0) {
                        System.out.println("Invalid amount. Please try again");
                        transfer = scanner.nextBigDecimal();
                    }

                    accountBalanceMap.getOrDefault(fromAccount, balance);

                    if (transfer.compareTo(balance) > 0) {
                        System.out.println("You don't have enough money on your account " + fromAccount + " to transfer " + transfer + "EUR");
                        System.out.println("Please enter another amount");
                        transfer = scanner.nextBigDecimal();
                    }
                    balance = balance.remainder(transfer);
                    accountBalanceMap.put(fromAccount, balance);
                    accountBalanceMap.put(toAccount, transfer);
                    System.out.println(accountBalanceMap);
                    System.out.println("Transfer processed! You have transferred " + transfer + "EUR to account " + toAccount);
                } else {
                    System.out.println("Unknown command");
                    break;
                }
        }
    }
}

