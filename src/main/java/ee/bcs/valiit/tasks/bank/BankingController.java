package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("Katrin")
@RestController
public class BankingController {
    HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/Katrin/create?accountNr=EE405
    @PostMapping("create")
    public String create(@RequestParam("accountNr") String accountNr) {
        String sql = "INSERT INTO account(account_number, balance)" + "VALUES (:accountNr, :balance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        paramMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
//        accountBalanceMap.put(accountNr, BigDecimal.ZERO);
        return "Account created! Your account number is " + accountNr;
    }

    // http://localhost:8080/Katrin/balance?accountNr=EE325
    @GetMapping("balance")
    public String balance(@RequestParam("accountNr") String accountNr) {
        String sql = "SELECT balance FROM account WHERE account_number = :account_number";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_number", accountNr);
        BigDecimal dbBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        return "Your balance on account " + accountNr + " is " + dbBalance + "EUR";
    }

    // http://localhost:8080/Katrin/deposit?accountNr=EE123&deposit=100
    @PutMapping("deposit")
    public String deposit(@RequestParam("accountNr") String accountNr, @RequestParam("deposit") BigDecimal deposit) {
        if (deposit.compareTo(BigDecimal.valueOf(0)) < 0) {
            return "Invalid amount. Please enter valid deposit amount";
        }
        String sql = "SELECT balance FROM account WHERE account_number = :account_number";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_number", accountNr);
        BigDecimal dbBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        dbBalance = dbBalance.add(deposit);
        sql = "UPDATE account SET balance = :balance WHERE account_number = :account_number";
        paramMap.put("account_number", accountNr);
        paramMap.put("balance", dbBalance);
        jdbcTemplate.update(sql, paramMap);

        return "Deposit processed. Your new balance on account : " + accountNr + " is: " + dbBalance + "EUR";
    }

    // http://localhost:8080/Katrin/withdraw?accountNr=EE456&withdraw=200
    @PutMapping("withdraw")
    public String withdraw(@RequestParam("accountNr") String accountNr, @RequestParam("withdraw") BigDecimal withdraw) {
        String sql = "SELECT balance FROM account WHERE account_number = :account_number";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_number", accountNr);
        BigDecimal dbBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        dbBalance = dbBalance.subtract(withdraw);
        sql = "UPDATE account SET balance = :balance WHERE account_number = :account_number";
        paramMap.put("account_number", accountNr);
        paramMap.put("balance", dbBalance);
        jdbcTemplate.update(sql, paramMap);

        if (withdraw.compareTo(BigDecimal.valueOf(0)) < 0 || (withdraw.compareTo(dbBalance) > 0)) {
            return "Invalid amount or not enough funds. Please try again";
        }

        return "Withdrawal processed! Your new balance on account " + accountNr + " is: " + dbBalance + "EUR";

    }

    // http://localhost:8080/Katrin/transfer?fromAccount=EE456&toAccount=EE325&transfer=100
    @PutMapping("transfer")
    public String transfer(@RequestParam("fromAccount") String fromAccount, @RequestParam("toAccount") String toAccount, @RequestParam("transfer") BigDecimal transfer) {
        String sql = "SELECT balance FROM account WHERE account_number = :account_number";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_number", fromAccount);
        BigDecimal dbBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        dbBalance = dbBalance.subtract(transfer);
        sql = "UPDATE account SET balance = :balance WHERE account_number = :account_number";
        paramMap.put("account_number", fromAccount);
        paramMap.put("balance", dbBalance);
        jdbcTemplate.update(sql, paramMap);

        sql = "SELECT balance FROM account WHERE account_number = :account_number";
        paramMap.put("account_number", toAccount);
        dbBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        dbBalance = dbBalance.add(transfer);
        sql = "UPDATE account SET balance = :balance WHERE account_number = :account_number";
        paramMap.put("account_number", toAccount);
        paramMap.put("balance", dbBalance);
        jdbcTemplate.update(sql, paramMap);

        if (transfer.compareTo(BigDecimal.valueOf(0)) < 0 || (transfer.compareTo(dbBalance)) > 0) {
            return "Invalid amount or not enough funds. Please try again";
        }
        return "Transfer processed! You have transferred " + transfer + "EUR to account " + toAccount;
    }


}



