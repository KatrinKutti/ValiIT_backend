package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.List;

@RequestMapping("Katrin")
@RestController
public class BankingController {

    @Autowired
    private BankingService bankingService;

    //http://localhost:8080/Katrin/createCustomer?firstName=Nipi&lastName=Tiri&address=Kuskil
    @PostMapping("createCustomer")
    public String createCustomer(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("address") String address) {
        return bankingService.createCustomer(firstName, lastName, address);
    }

    // http://localhost:8080/Katrin/createAccount?accountNr=EE123
    @PostMapping("createAccount")
    public String createAccount(@RequestParam("accountNr") String accountNr) {
        return bankingService.createAccount(accountNr);
    }

    // http://localhost:8080/Katrin/customerToAccount?customerId=2&accountId=4
    @PostMapping("customerToAccount")
    public String customerToAccount(@RequestParam("customerId") int dbCustomer_id, @RequestParam("accountId") int dbAccount_id) {
        return bankingService.customerToAccount(dbCustomer_id, dbAccount_id);
    }

    // http://localhost:8080/Katrin/getBalance?accountNr=EE123
    @GetMapping("getBalance")
    public String getBalance(@RequestParam("accountNr") String accountNr) {
        return bankingService.getBalance(accountNr);
    }

    // http://localhost:8080/Katrin/makeDeposit?accountNr=EE123&deposit=100
    @PutMapping("makeDeposit")
    public String makeDeposit(@RequestParam("accountNr") String accountNr, @RequestParam("deposit") BigDecimal deposit) {
        return bankingService.makeDeposit(accountNr, deposit);
    }

    // http://localhost:8080/Katrin/withdraw?accountNr=EE456&withdraw=200
    @PutMapping("withdraw")
    public String withdraw(@RequestParam("accountNr") String accountNr, @RequestParam("withdraw") BigDecimal withdraw) {
        return bankingService.makeWithdrawal(accountNr, withdraw);
    }

    // http://localhost:8080/Katrin/makeTransfer?fromAccount=EE456&toAccount=EE325&transfer=100

    @PutMapping("makeTransfer")
    public String makeTransfer(@RequestParam("fromAccount") String fromAccount, @RequestParam("toAccount") String toAccount, @RequestParam("transfer") BigDecimal transfer) {
        return bankingService.makeTransfer(fromAccount, toAccount, transfer);
    }

    //http://localhost:8080/Katrin/accountTransactions?customerId=2
    @GetMapping("accountTransactions")
    public List accountTransactions(int customerId) {
        return bankingService.customerAccounts(customerId);
    }

    //http://localhost:8080/Katrin/getAccounts

    @GetMapping("getAccounts")
    public List getAccounts() {
        return bankingService.getAccounts();
    }

    //http://localhost:8080/Katrin/getCustomers
    @GetMapping("getCustomers")
    public List getCustomers() {
        return bankingService.getCustomers();
    }

    //    http://localhost:8080/Katrin/getTransactions
    @GetMapping("getTransactions")
    public List getTransactions() {
        return bankingService.getTransactions();
    }


    //    http://localhost:8080/Katrin/getPassword?userName=KatrinKutti
    @GetMapping("getPassword")
    public String getPassword(@RequestParam("user_name") String userName) {
        return bankingService.findPasswordByUserName(userName);
    }

    @PostMapping("registerCustomer")
    public String registerCustomer(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("address") String address, @RequestParam("userName") String userName, @RequestParam("pswrd") String pswrd) {
        return bankingService.registerCustomer(firstName, lastName, address, userName, pswrd);
    }
}




