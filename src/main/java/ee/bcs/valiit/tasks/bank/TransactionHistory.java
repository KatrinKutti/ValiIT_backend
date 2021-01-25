package ee.bcs.valiit.tasks.bank;

import java.math.BigDecimal;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TransactionHistory {
    private int accountId;
    private String accountNr;
    private BigDecimal deposit;
    private BigDecimal withdrawal;
    private BigDecimal transfer;
    private String LocalDateTime;

    public String getLocalDateTime() {
        return LocalDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        LocalDateTime = localDateTime;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(BigDecimal withdrawal) {
        this.withdrawal = withdrawal;
    }

    public BigDecimal getTransfer() {
        return transfer;
    }

    public void setTransfer(BigDecimal transfer) {
        this.transfer = transfer;
    }
}

