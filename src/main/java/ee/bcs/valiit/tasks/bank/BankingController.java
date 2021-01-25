package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("Katrin")
@RestController
public class BankingController {
    HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();

    @Autowired
    private BankingService bankingService;

    //http://localhost:8080/Katrin/customer?firstName=Nipi&lastName=Tiri&address=Kuskil
    @PostMapping("customer")
    public String customer(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("address") String address) {
        bankingService.createCustomer(firstName, lastName, address);
        return "Customer created";
    }

    // http://localhost:8080/Katrin/customerToAccount?firstName=Mida&lastName=Iganes&accountNr=EE567
    @PutMapping("customerToAccount")
    public String customerTaAccount(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("accountNr") String accountNr) {
        bankingService.customerToAccount(firstName, lastName, accountNr);
        return "Your profile has been added to your account";
    }

    // http://localhost:8080/Katrin/create?accountNr=EE405
    @PostMapping("create")
    public String create(@RequestParam("accountNr") String accountNr) {
        bankingService.createAccount(accountNr);
        return "Account created! Your account number is " + accountNr;
    }

    // http://localhost:8080/Katrin/balance?accountNr=EE325
    @GetMapping("balance")
    public String balance(@RequestParam("accountNr") String accountNr) {
        bankingService.getBalance(accountNr);
        return "Your balance on account " + accountNr + " is " + bankingService.getBalance(accountNr) + "EUR";
    }

    // http://localhost:8080/Katrin/deposit?accountNr=EE123&deposit=100
    @PutMapping("deposit")
    public String deposit(@RequestParam("accountNr") String accountNr, @RequestParam("deposit") BigDecimal deposit) {
        bankingService.makeDeposit(accountNr, deposit);
        return "Deposit processed";
    }

    // http://localhost:8080/Katrin/withdraw?accountNr=EE456&withdraw=200
    @PutMapping("withdraw")
    public String withdraw(@RequestParam("accountNr") String accountNr, @RequestParam("withdraw") BigDecimal withdraw) {
        bankingService.makeWithdrawal(accountNr, withdraw);
        return "Withdrawal processed";
    }

    // http://localhost:8080/Katrin/transfer?fromAccount=EE456&toAccount=EE325&transfer=100
    @PutMapping("transfer")
    public String transfer(@RequestParam("fromAccount") String fromAccount, @RequestParam("toAccount") String toAccount, @RequestParam("transfer") BigDecimal transfer) {
        bankingService.makeTransfer(fromAccount, toAccount, transfer);
        return "Transfer processed";
    }

    //http://localhost:8080/Katrin/allAccounts
//    @GetMapping("allAccounts")
//    public List<Account> getAccounts() {
//        String sql = "SELECT * FROM account";
//        List<Account> result = jdbcTemplate.query(sql, new HashMap<>(), new AccountRowMapper());
//        return result;
//    }
//
//    public class AccountRowMapper implements RowMapper<Account> {
//        @Override
//        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
//            Account account = new Account();
//            account.setAccount_id(resultSet.getInt("account_id"));
//            account.setAccount_number(resultSet.getString("account_number"));
//            account.setBalance(resultSet.getBigDecimal("balance"));
//            return account;
//        }
//    }

    //http://localhost:8080/Katrin/allCustomers
//    @GetMapping("allCustomers")
//    public List<Customer> getCustomers() {
//        String sql = "SELECT * FROM customer";
//        List<Customer> result = jdbcTemplate.query(sql, new HashMap<>(), new CustomerRowMapper());
//        return result;
//    }
//
//    public class CustomerRowMapper implements RowMapper<Customer> {
//        @Override
//        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
//            Customer customer = new Customer();
//            customer.setCustomerId(resultSet.getInt("customer_id"));
//            customer.setFirstName(resultSet.getString("firstname"));
//            customer.setLastName(resultSet.getString("lastname"));
//            customer.setAddress(resultSet.getString("address"));
//            return customer;
//        }
//    }
//
    // kuidas saaks ühe cusotmeri kõik kontod ja transaction history
//    @GetMapping("customerAccounts")
//    public List<Customer> getCustomer() {
//        String sql = "SELECT * FROM customer WHERE customer_id = :customer_id";
//        List<Customer> result = jdbcTemplate.query(sql, new HashMap<>(), new CustomerAccountsRowMapper());
//        return result;
//    }
//
//    public class CustomerAccountsRowMapper implements RowMapper<Customer> {
//        @Override
//        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
//            Customer customer = new Customer();
//            customer.setCustomerId(resultSet.getInt("customer_id"));
//            customer.setFirstName(resultSet.getString("firstname"));
//            customer.setLastName(resultSet.getString("lastname"));
//            customer.setAddress(resultSet.getString("address"));
////            customer.setAccount(resultSet.));
//            return customer;
//        }
//    }
}



