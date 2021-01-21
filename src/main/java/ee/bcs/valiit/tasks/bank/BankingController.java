package ee.bcs.valiit.tasks.bank;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("Katrin")
@RestController
public class BankingController {
    HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();

    // http://localhost:8080/bank/createCustomer?firstName=Katrin&lastName=Kutti&customerID=7
    //    @PostMapping("createCustomer")
    //    public void createCustomer(@RequestParam ("fistName") String firstName, @RequestParam ("lastName") String lastName, @RequestParam ("customerID") int id){
    //    }

    // http://localhost:8080/Katrin/createAccount?accountNr=EE123
    @PostMapping("createAccount")
    public String createAccount(@RequestParam("accountNr") String accountNr) {
        String answer = "Account created. Your account number is " + accountNr;
        accountBalanceMap.put(accountNr, BigDecimal.ZERO);
        return answer;

    }

    // http://localhost:8080/bank/accountBalance?accountNr=EE123
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        accountBalanceMap.get(accountNr);
        return BigDecimal.ZERO;
    }

    // http://localhost:8080/bank/depositMoney?accountNr=EE123&amount=12
    @PutMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        accountBalanceMap.put(accountNr, amount);
    }

    // http://localhost:8080/bank/withdrawMoney?accountNr=EE123&amount=12
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal withdraw) {
        accountBalanceMap.get(accountNr);

    }

    // http://localhost:8080/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String accountNr, @RequestParam("toAccount") String toAcount, @RequestParam("amount") BigDecimal amount) {
        accountBalanceMap.get(accountNr);
        accountBalanceMap.put(toAcount, amount);
    }
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


