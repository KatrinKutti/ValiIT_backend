package ee.bcs.valiit.tasks;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    static HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String sisend = scanner.nextLine();
//            String[] sisendParts = sisend.split(" ");

            if (sisend.equalsIgnoreCase("exit")) {
                break;
            } else if (sisend.equalsIgnoreCase("createAccount")) {
                System.out.println("Please enter account number: ");
                String account = scanner.nextLine();
                System.out.println("Account created. Your account number is " + account);
                accountBalanceMap.put(account, BigDecimal.ZERO);

            } else if (sisend.equalsIgnoreCase("getBalance")) {
                System.out.println("Please enter account number for balance info: ");
                String account = scanner.nextLine();
                BigDecimal balance = accountBalanceMap.get(account);
                System.out.println("Your balance is " + balance);

            } else if (sisend.equalsIgnoreCase("depositMoney")) {
                System.out.println("Please enter account number");
                String account = scanner.nextLine();
                System.out.println("Please enter deposit amount");
                BigDecimal deposit = scanner.nextBigDecimal();
                while (deposit.compareTo(BigDecimal.valueOf(0)) < 0) {
                    System.out.println("Invalid amount. Please enter valid deposit amount");
                    deposit = scanner.nextBigDecimal();
                }
                BigDecimal balance = accountBalanceMap.get(account);
                balance = balance.add(deposit);
                accountBalanceMap.put(account, balance);
                System.out.println(accountBalanceMap);
                System.out.println("Deposit processed. Your new balance on account : " + account + " is: " + balance + "EUR");
                scanner.nextLine();

            } else if (sisend.equalsIgnoreCase("withdrawMoney")) {
                System.out.println("Please enter account number to make withdrawal");
                String account = scanner.nextLine();
                System.out.println("Please enter withdrawal amount");
                BigDecimal withdraw = scanner.nextBigDecimal();
                BigDecimal balance = accountBalanceMap.get(account);
                while (withdraw.compareTo(BigDecimal.valueOf(0)) < 0 || (withdraw.compareTo(balance) > 0)) {
                    System.out.println("Invalid amount or not enough funds. Please try again");
                    withdraw = scanner.nextBigDecimal();
                }
                balance = balance.subtract(withdraw);
                accountBalanceMap.put(account, balance);
                System.out.println("Withdrawal processed! Your new balance on account " + account + " is: " + balance + "EUR");
                System.out.println(accountBalanceMap);
                scanner.nextLine();

            } else if (sisend.equalsIgnoreCase("transfer")) {
                System.out.println("Please enter account number from where you would like to make the transfer: ");
                String account = scanner.nextLine();
                System.out.println("Please enter account number to where you would like to make the transfer: ");
                String toAccount = scanner.nextLine();
                System.out.println("Please enter the amount to transfer: ");
                BigDecimal transfer = scanner.nextBigDecimal();
                BigDecimal balance = accountBalanceMap.get(account);
                while (transfer.compareTo(BigDecimal.valueOf(0)) < 0 || (transfer.compareTo(balance)) > 0) {
                    System.out.println("Invalid amount or not enough funds. Please try again");
                    transfer = scanner.nextBigDecimal();
                }
                balance = balance.subtract(transfer);
                accountBalanceMap.put(account, balance);
                accountBalanceMap.put(toAccount, transfer);
                System.out.println(accountBalanceMap);
                System.out.println("Transfer processed! You have transferred " + transfer + "EUR to account " + toAccount);
                break;
            } else {
                System.out.println("Unknown command");
                break;
            }
        }
    }
}


// TODO 1
// Add command: "createAccount ${accountNr}"
// this has to store accountNr with 0 balance
// TODO 2
// Add command: "getBalance ${accountNr}"
// this has to display account balance of specific account
// TODO 3
// Add command: "depositMoney ${accountNr} ${amount}
// this has to add specified amount of money to account
// You have to check that amount is positive number
// TODO 4
// Add command: "withdrawMoney ${accountNr} ${amount}
// This has to remove specified amount of money from account
// You have to check that amount is positive number
// You may not allow this transaction if account balance would become negative
// TODO 5
// Add command: "transfer ${fromAccount} ${toAccount} ${amount}
// This has to remove specified amount from fromAccount and add it to toAccount
// Your application needs to check that toAccount is positive
// And from account has enough money to do that transaction
