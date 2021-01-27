package ee.bcs.valiit.tasks.bank;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(resultSet.getInt("customer_id"));
        customer.setFirstName(resultSet.getString("firstname"));
        customer.setLastName(resultSet.getString("lastname"));
        customer.setAddress(resultSet.getString("address"));
        return customer;
    }
}
