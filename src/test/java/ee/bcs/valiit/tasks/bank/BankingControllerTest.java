package ee.bcs.valiit.tasks.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BankingControllerTest  {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createCustomer() throws Exception {
        http://localhost:8080/Katrin/createCustomer?firstName=Nipi&lastName=Tiri&address=Kuskil
        mockMvc.perform(MockMvcRequestBuilders.post("/Katrin/createCustomer?firstName=Nipi&lastName=Tiri&address=Kuskil")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createAccount() throws Exception{
        http://localhost:8080/Katrin/createAccount?accountNr=EE777
        mockMvc.perform(MockMvcRequestBuilders.post("/Katrin/createAccount?accountNr=EE777")
        .contentType("application/json")
        ).andExpect((MockMvcResultMatchers.status().isOk()));
    }

    @Test
    void customerToAccount() throws Exception{
        http://localhost:8080/Katrin/customerToAccount?customerId=2&accountId=4
        mockMvc.perform(MockMvcRequestBuilders.put("/Katrin/customerToAccount?customerId=2&accountId=4")
        .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getBalance() throws Exception{
        http://localhost:8080/Katrin/getBalance?accountNr=EE123
        mockMvc.perform(MockMvcRequestBuilders.get("/Katrin/getBalance?accountNr=EE123")
        .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void makeDeposit() throws Exception{
        http://localhost:8080/Katrin/makeDeposit?accountNr=EE123&deposit=100
        mockMvc.perform(MockMvcRequestBuilders.put("/Katrin/makeDeposit?accountNr=EE123&deposit=100")
        .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void withdraw() throws Exception{
        http://localhost:8080/Katrin/withdraw?accountNr=EE123&withdraw=10
        mockMvc.perform(MockMvcRequestBuilders.put("/Katrin/withdraw?accountNr=EE123&withdraw=10")
        .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void makeTransfer() throws Exception{
        http://localhost:8080/Katrin/makeTransfer?fromAccount=EE123&toAccount=EE789&transfer=100
        mockMvc.perform(MockMvcRequestBuilders.put("/Katrin/makeTransfer?fromAccount=EE123&toAccount=EE789&transfer=100")
        .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void accountTransactions() throws Exception{
        http://localhost:8080/Katrin/accountTransactions?customerId=2
        mockMvc.perform(MockMvcRequestBuilders.get("/Katrin/accountTransactions?customerId=2")
        .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

}