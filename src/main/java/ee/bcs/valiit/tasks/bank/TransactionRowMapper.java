package ee.bcs.valiit.tasks.bank;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<TransactionHistory> {
    @Override
    public TransactionHistory mapRow(ResultSet resultSet, int i) throws SQLException {
        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setTransactionId(resultSet.getInt("transaction_id"));
        transactionHistory.setAccountNr(resultSet.getString("account_number"));
        transactionHistory.setDeposit(resultSet.getBigDecimal("deposit"));
        transactionHistory.setWithdrawal(resultSet.getBigDecimal("withdrawal"));
        transactionHistory.setTransfer(resultSet.getBigDecimal("transfer"));
        transactionHistory.setFromAccount(resultSet.getString("from_account"));
        transactionHistory.setToAccount(resultSet.getString("to_account"));
        transactionHistory.setLocalDateTime(resultSet.getString("timestamp"));
        return transactionHistory;
    }
}
