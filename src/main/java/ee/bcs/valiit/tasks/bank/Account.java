package ee.bcs.valiit.tasks.bank;

import java.math.BigDecimal;

public class Account {
    private int account_id;
    private String account_number;
    private BigDecimal balance;
    private String TransactionHistory;

    public String getTransactionHistory() {
        return TransactionHistory;
    }

    public void setTransactionHistory(String transactionHistory) {
        TransactionHistory = transactionHistory;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
