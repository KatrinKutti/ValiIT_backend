package ee.bcs.valiit.tasks.bank;

import liquibase.pro.packaged.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BankingService {

    @Autowired
    private BankingRepository bankingRepository;


    public String createCustomer(String firstName, String lastName, String address) {
        bankingRepository.createCustomer(firstName, lastName, address);
        return "Customer created";
    }

    public String createAccount(String accountNr) {
        bankingRepository.createAccount(accountNr);
        return "Account created";
    }

    public String customerToAccount(int dbCustomer_id, int dbAccount_id) {
        bankingRepository.customerToAccount(dbCustomer_id, dbAccount_id);
        return "Your profile has been added to your account";
    }

    public String getBalance(String accountNr) {
        bankingRepository.getBalance(accountNr);
        return "Your balance is " + bankingRepository.getBalance(accountNr) + "EUR";
    }

    public String makeDeposit(String accountNr, BigDecimal deposit) {
        if (deposit.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new BankException("Invalid amount. Please try again");
        }
        bankingRepository.updateBalance(accountNr, bankingRepository.getBalance(accountNr).add(deposit));
        bankingRepository.addToHistory(accountNr, deposit, null, "null", "null", null, LocalDateTime.now().toString());
        return "Deposit processed";
    }

    @Transactional
    public String makeWithdrawal(String accountNr, BigDecimal withdraw) {
        BigDecimal dbBalance = bankingRepository.getBalance(accountNr);
        if (withdraw.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new BankException("Invalid amount. Please try again");
        } else if (withdraw.compareTo(dbBalance) > 0) {
            throw new BankException("Not enough funds. Please try again");
        }
        bankingRepository.updateBalance(accountNr, bankingRepository.getBalance(accountNr).subtract(withdraw));
        bankingRepository.addToHistory(accountNr, null, withdraw.negate(), "null", "null", null, LocalDateTime.now().toString());
        return "Withdrawal processed";
    }

    @Transactional
    public String makeTransfer(String fromAccount, String toAccount, BigDecimal transfer) {
        BigDecimal dbBalance = bankingRepository.getBalance(fromAccount);
        if (transfer.compareTo(dbBalance) > 0) {
            throw new BankException("Not enough funds. Please try again");
        } else if (transfer.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new BankException("Invalid amount. Please try again");
        }
        bankingRepository.updateBalance(fromAccount, bankingRepository.getBalance(fromAccount).subtract(transfer));
        bankingRepository.updateBalance(toAccount, bankingRepository.getBalance(toAccount).add(transfer));
        bankingRepository.addToHistory(fromAccount, null, null, fromAccount, "null", transfer.negate(), LocalDateTime.now().toString());
        bankingRepository.addToHistory(toAccount, null, null, "null", toAccount, transfer, LocalDateTime.now().toString());
        return "Transfer processed";
    }

    public List customerAccounts(int customerId) {
        List<Account> accountList = bankingRepository.customerAccounts(customerId);
        for (Account account : accountList) {
            List<TransactionHistory> transactions = bankingRepository.accountTransactions(account);
            account.setTransactionHistoryList(transactions);
        }
        return accountList;
    }

    public List getAccounts() {
        return bankingRepository.accountsList();
    }

    public List getCustomers() {
        return bankingRepository.customerList();

    }
    public List getTransactions(){
        return  bankingRepository.transactionHistoryList();
    }
}



