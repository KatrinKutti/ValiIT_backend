package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankingRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

//    public void createCusotmer(String firstName, String lastName, String address) {
//        String sql = "INSERT INTO customer(firstname, lastname, address) VALUES (:firstname, :lastname, :address)";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("firstname", firstName);
//        paramMap.put("lastname", lastName);
//        paramMap.put("address", address);
//        jdbcTemplate.update(sql, paramMap);
//    }
//
//    public void customerToAccount(String firstName, String lastName, String accountNr) {
//        Map<String, Object> paramMap = new HashMap<>();
//        String sql = "SELECT customer_id FROM customer WHERE firstname = :firstname AND lastname = :lastname";
//        paramMap.put("firstname", firstName);
//        paramMap.put("lastname", lastName);
//        Integer dbCustomer_id = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
//    }
//
//
//    public void updateCustomerToAccount(int dbCustomer_id, int dbAccount_id) {
//        String sql = "UPDATE account SET customer_id = :customer_id WHERE account_id = :account_id";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("customer_id", dbCustomer_id);
//        paramMap.put("account_id", dbAccount_id);
//        jdbcTemplate.update(sql, paramMap);
//
//    }

    public void createAccount(String accountNr) {
        String sql = "INSERT INTO account(account_number, balance)" + "VALUES (:accountNr, :balance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        paramMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
    }

    public BigDecimal getBalance(String accountNr) {
        String sql = "SELECT balance FROM account WHERE account_number = :account_number";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_number", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

    public void updateBalance(String accountNr, BigDecimal dbBalance) {
        String sql = "UPDATE account SET balance = :balance WHERE account_number = :account_number";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_number", accountNr);
        paramMap.put("balance", dbBalance);
        jdbcTemplate.update(sql, paramMap);
    }

    public void insertDepositToHistory(String accountNr, BigDecimal deposit, Object timestamp) {
        String sql = "INSERT INTO transaction_history(account_number, deposit, timestamp) VALUES (:account_number, :deposit, :timestamp)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_number", accountNr);
        paramMap.put("deposit", deposit);
        paramMap.put("timestamp", LocalDateTime.now().toString());
        jdbcTemplate.update(sql, paramMap);
    }

    public void insertWithdrawalToHistory(String accountNr, BigDecimal withdraw) {
        String sql = "INSERT INTO transaction_history(account_number, withdrawal, timestamp) VALUES (:account_number, :withdrawal, :timestamp)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_number", accountNr);
        paramMap.put("withdrawal", withdraw.negate());
        paramMap.put("timestamp", LocalDateTime.now().toString());
        jdbcTemplate.update(sql, paramMap);

    }

    public void insertTransferFromToHistory(String fromAccount, String toAccount, BigDecimal transfer, Object timestamp) {
        String sql = "INSERT INTO transaction_history(account_number, transfer, timestamp, to_account) VALUES (:account_number, :transfer, :timestamp, :to_account)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_number", fromAccount);
        paramMap.put("to_account", toAccount);
        paramMap.put("transfer", transfer.negate());
        paramMap.put("timestamp", LocalDateTime.now().toString());
        jdbcTemplate.update(sql, paramMap);
    }

    public void insertTransferToToHistory(String fromAccount, String toAccount, BigDecimal transfer, Object timestamp) {
        String sql = "INSERT INTO transaction_history(account_number, transfer, timestamp, from_account) VALUES (:account_number, :transfer, :timestamp, :from_account)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_number", toAccount);
        paramMap.put("from_account", fromAccount);
        paramMap.put("transfer", transfer);
        paramMap.put("timestamp", LocalDateTime.now().toString());
        jdbcTemplate.update(sql, paramMap);
    }
}

