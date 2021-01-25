package ee.bcs.valiit.tasks.bank;

import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private String address;
    private int customerId;
    private List<Account> Account;

    public List<ee.bcs.valiit.tasks.bank.Account> getAccount() {
        return Account;
    }

    public void setAccount(List<ee.bcs.valiit.tasks.bank.Account> account) {
        Account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

}