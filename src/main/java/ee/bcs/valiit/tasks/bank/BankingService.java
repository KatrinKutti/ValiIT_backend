package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class BankingService {

    @Autowired
    private BankingRepository bankingRepository;


    public void createCustomer(String firstName, String lastName, String address) {
        bankingRepository.createCustomer(firstName, lastName, address);
    }

    public void customerToAccount(String firstName, String lastName, String accountNr) {
        bankingRepository.customerToAccount(firstName, lastName, accountNr);
    }

    public String createAccount(String accountNr) {
        bankingRepository.createAccount(accountNr);
        return "Account created! Your account number is " + accountNr;
    }

    public String getBalance(String accountNr) {
        bankingRepository.getBalance(accountNr);
        return "Your balance on account " + accountNr + " is " + getBalance(accountNr) + "EUR";
    }

    public String makeDeposit(String accountNr, BigDecimal deposit) {
        BigDecimal dbBalance = bankingRepository.getBalance(accountNr);
        if (deposit.compareTo(BigDecimal.valueOf(0)) < 0) {
            return "Invalid amount. Please enter valid deposit amount";
        }
        dbBalance = bankingRepository.getBalance(accountNr).add(deposit);
        bankingRepository.updateBalance(accountNr, dbBalance);
        bankingRepository.addToHistory(accountNr, deposit, null, "null", "null", null, LocalDateTime.now().toString());
        return "Deposit processed. Your new balance on account " + accountNr + " is " + dbBalance + "EUR";
    }

    public String makeWithdrawal(String accountNr, BigDecimal withdraw) {
        BigDecimal dbBalance = bankingRepository.getBalance(accountNr);
        if (withdraw.compareTo(BigDecimal.valueOf(0)) < 0 || (withdraw.compareTo(dbBalance) > 0)) {
            return "Invalid amount or not enough funds. Please try again";
        }
        dbBalance = dbBalance.subtract(withdraw);
        bankingRepository.updateBalance(accountNr, dbBalance);
        bankingRepository.addToHistory(accountNr, null, withdraw.negate(), "null", "null", null, LocalDateTime.now().toString());
        return "Withdrawal processed! Your new balance on account " + accountNr + " is: " + dbBalance + "EUR";
    }

    public String makeTransfer(String fromAccount, String toAccount, BigDecimal transfer) {
        BigDecimal dbBalance = bankingRepository.getBalance(fromAccount);
        if (transfer.compareTo(BigDecimal.valueOf(0)) < 0 || (transfer.compareTo(dbBalance)) > 0) {
            return "Invalid amount or not enough funds. Please try again";
        }

        dbBalance = dbBalance.add(transfer);
        bankingRepository.updateBalance(fromAccount, dbBalance);
        bankingRepository.updateBalance(toAccount, dbBalance);
        bankingRepository.addToHistory("null", null, null, fromAccount, "null", transfer.negate(), LocalDateTime.now().toString());
        bankingRepository.addToHistory("null", null, null, "null", toAccount, transfer, LocalDateTime.now().toString());
        return "Transfer processed! You have transferred " + transfer + "EUR to account " + toAccount + " from account " + fromAccount;
    }
}


