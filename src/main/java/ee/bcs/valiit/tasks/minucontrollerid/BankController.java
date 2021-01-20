package ee.bcs.valiit.tasks.minucontrollerid;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("Katrin")
@RestController
public class BankController {
//    @GetMapping("bank")
//    public String createAccount(@RequestParam("account") int sisend) {
//        return;
//    }
//
//    public String getBalance(@RequestParam("balance") int sisend) {
//        return;
//    }
//
//    public String deposit(@RequestParam("deposit") int sisend) {
//        return;
//    }
//
//    public String withdraw(@RequestParam("withdraw") int sisend) {
//        return;
//    }
//
//    public String transfer(@RequestParam("transfer") int sisend) {
//        return answer;
//    }
//
//
//        if(sisend.equalsIgnoreCase("createAccount"){
//            System.out.println("Please enter account number: ");
//        System.out.println("Account created. Your account number is " + account);
//        accountBalanceMap.put(account, BigDecimal.ZERO);
//
//    } else if(sisend.equalsIgnoreCase("getBalance"))
//
//    {
//        System.out.println("Please enter account number for balance info: ");
//        BigDecimal balance = accountBalanceMap.get(account);
//        System.out.println("Your balance is " + balance);
//
//    } else if(sisend.equalsIgnoreCase("depositMoney"))
//
//    {
//        System.out.println("Please enter account number");
//        System.out.println("Please enter deposit amount");
//        while (deposit.compareTo(BigDecimal.valueOf(0)) < 0) {
//            System.out.println("Invalid amount. Please enter valid deposit amount");
//        }
//        BigDecimal balance = accountBalanceMap.get(account);
//        balance = balance.add(deposit);
//        accountBalanceMap.put(account, balance);
//        System.out.println(accountBalanceMap);
//        System.out.println("Deposit processed. Your new balance on account : " + account + " is: " + balance + "EUR");
//
//    } else if(sisend.equalsIgnoreCase("withdrawMoney"))
//
//    {
//        System.out.println("Please enter account number to make withdrawal");
//        System.out.println("Please enter withdrawal amount");
//        BigDecimal balance = accountBalanceMap.get(account);
//        while (withdraw.compareTo(BigDecimal.valueOf(0)) < 0 || (withdraw.compareTo(balance) > 0)) {
//            System.out.println("Invalid amount or not enough funds. Please try again");
//        }
//        balance = balance.subtract(withdraw);
//        accountBalanceMap.put(account, balance);
//        System.out.println("Withdrawal processed! Your new balance on account " + account + " is: " + balance + "EUR");
//        System.out.println(accountBalanceMap);
//
//    } else if(sisend.equalsIgnoreCase("transfer"))
//
//    {
//        System.out.println("Please enter account number from where you would like to make the transfer: ");
//        System.out.println("Please enter account number to where you would like to make the transfer: ");
//        System.out.println("Please enter the amount to transfer: ");
//        BigDecimal balance = accountBalanceMap.get(account);
//        while (transfer.compareTo(BigDecimal.valueOf(0)) < 0 || (transfer.compareTo(balance)) > 0) {
//            System.out.println("Invalid amount or not enough funds. Please try again");
//        }
//        balance = balance.subtract(transfer);
//        accountBalanceMap.put(account, balance);
//        accountBalanceMap.put(toAccount, transfer);
//        System.out.println(accountBalanceMap);
//        System.out.println("Transfer processed! You have transferred " + transfer + "EUR to account " + toAccount);
//    }
}


