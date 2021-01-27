package ee.bcs.valiit.tasks.bank;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setAccountId(resultSet.getInt("account_id"));
        account.setAccountNumber(resultSet.getString("account_number"));
        account.setBalance(resultSet.getBigDecimal("balance"));
        return account;
    }
}
