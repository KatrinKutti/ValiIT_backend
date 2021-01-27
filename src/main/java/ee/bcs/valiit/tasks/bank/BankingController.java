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

    //http://localhost:8080/Katrin/customer?firstName=Nipi&lastName=Tiri&address=Kuskil
    @PostMapping("customer")
    public String customer(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("address") String address) {
        return bankingService.createCustomer(firstName, lastName, address);
    }

    // http://localhost:8080/Katrin/create?accountNr=EE405
    @PostMapping("create")
    public String create(@RequestParam("accountNr") String accountNr) {
        return bankingService.createAccount(accountNr);
    }

    // http://localhost:8080/Katrin/customerToAccount?customerId=2&accountId=4
    @PutMapping("customerToAccount")
    public String customerToAccount(@RequestParam("customerId") int dbCustomer_id, @RequestParam("accountId") int dbAccount_id) {
        return bankingService.customerToAccount(dbCustomer_id, dbAccount_id);
    }

    // http://localhost:8080/Katrin/balance?accountNr=EE325
    @GetMapping("balance")
    public String balance(@RequestParam("accountNr") String accountNr) {
        return bankingService.getBalance(accountNr);
    }

    // http://localhost:8080/Katrin/deposit?accountNr=EE123&deposit=100
    @PutMapping("deposit")
    public String deposit(@RequestParam("accountNr") String accountNr, @RequestParam("deposit") BigDecimal deposit) {
        return bankingService.makeDeposit(accountNr, deposit);
    }

    // http://localhost:8080/Katrin/withdraw?accountNr=EE456&withdraw=200
    @PutMapping("withdraw")
    public String withdraw(@RequestParam("accountNr") String accountNr, @RequestParam("withdraw") BigDecimal withdraw) {
        return bankingService.makeWithdrawal(accountNr, withdraw);
    }

    // http://localhost:8080/Katrin/transfer?fromAccount=EE456&toAccount=EE325&transfer=100

    @PutMapping("transfer")
    public String transfer(@RequestParam("fromAccount") String fromAccount, @RequestParam("toAccount") String toAccount, @RequestParam("transfer") BigDecimal transfer) {
        return bankingService.makeTransfer(fromAccount, toAccount, transfer);
    }

    //http://localhost:8080/Katrin/customerAccounts?firstName=Katrin&lastName=Kutti
    @GetMapping("customerAccounts")
    public List accountTransactions(Customer customer) {

        return bankingService.customerAccounts(customer);
    }
}



