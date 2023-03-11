package softwaretwo.data.repositories;

import softwaretwo.data.access.ClientScheduleContext;
import softwaretwo.data.models.Customer;

import java.sql.*;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * A repository for Customer database interactions.
 */
public class CustomerRepository implements ICustomerRepository {
    /**
     * @inheritDocs
     */
    @Override
    public boolean deleteCustomer(int customerId) {
        final String sql = """
                DELETE FROM client_schedule.customers WHERE Customer_ID = ?;
                """;
        try {
            ClientScheduleContext.OpenConnection();
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
            return false;
        } finally {
            ClientScheduleContext.CloseConnection();
        }
    }

    /**
     * @inheritDocs
     */
    @Override
    public boolean deleteCustomer(String customerName) {
        final String sql = """
                DELETE FROM client_schedule.customers WHERE Customer_Name = ?;
                """;
        try {
            ClientScheduleContext.OpenConnection();
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ps.setString(1, customerName);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
            return false;
        } finally {
            ClientScheduleContext.CloseConnection();
        }
    }

    /**
     * @inheritDocs
     */
    @Override
    public boolean insertCustomer(Customer customer) {
        final String sql = """
                INSERT INTO client_schedule.customers (Customer_Name,Address,Postal_Code,Phone,Create_Date,Created_By,Last_Update,Last_Updated_By, Division_ID)
                VALUES (?,?,?,?,?,?,?,?,?);
                """;
        try {
            ClientScheduleContext.OpenConnection();
            Timestamp createDate = Timestamp.from(Instant.now());
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getPostalCode());
            ps.setString(4, customer.getPhone());
            ps.setTimestamp(5, createDate);
            ps.setString(6, customer.getCreatedBy());
            ps.setTimestamp(7, createDate);
            ps.setString(8, customer.getLastUpdatedBy());
            ps.setInt(9, customer.getDivisionId());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
            return false;
        } finally {
            ClientScheduleContext.CloseConnection();
        }
    }

    /**
     * @inheritDocs
     */
    public boolean updateCustomer(Customer customer) {
        final Timestamp updatedDate = Timestamp.from(Instant.now());
        final String sql = """
                UPDATE customers
                SET Customer_Name=?, Address=?, Postal_Code=?, Phone=?, Last_Update=?,
                    Last_Updated_By=?, Division_ID=?
                WHERE Customer_ID = ?;
                """;
        try {
            ClientScheduleContext.OpenConnection();
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getPostalCode());
            ps.setString(4, customer.getPhone());
            ps.setTimestamp(5, updatedDate);
            ps.setString(6, customer.getLastUpdatedBy());
            ps.setInt(7, customer.getDivisionId());
            ps.setInt(8, customer.getCustomerId());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Couldn't update customer ["
                    + customer.getCustomerName() + "], reason: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Error occurred while attempting update: customer ["
                    + customer.getCustomerName() + "], reason: " + ex.getMessage());
            return false;
        }
    }

    /**
     * @inheritDocs
     */
    @Override
    public List<Customer> getAllCustomers() {
        final String sql = """
                SELECT * FROM customers;
                """;
        try {
            ClientScheduleContext.OpenConnection();
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ResultSet results = ps.executeQuery();

            ArrayList<Customer> customers = new ArrayList<>();
            while (results.next()) {
                // setup all non-date properties
                Customer customer = new Customer();
                customer.setCustomerId(results.getInt("Customer_ID"));
                customer.setCustomerName(results.getString("Customer_Name"));
                customer.setAddress(results.getString("Address"));
                customer.setPostalCode(results.getString("Postal_Code"));
                customer.setPhone(results.getString("Phone"));
                customer.setCreatedBy(results.getString("Created_By"));
                customer.setLastUpdatedBy(results.getString("Last_Updated_By"));
                customer.setDivisionId(results.getInt("Division_ID"));

                // manage the date times
                Timestamp createdDateTimestamp = results.getTimestamp("Create_Date");
                customer.setCreatedDate(createdDateTimestamp.toLocalDateTime().atZone(ZoneId.of("UTC")));
                Timestamp lastUpdateTimestamp = results.getTimestamp("Last_Update");
                customer.setLastUpdate(lastUpdateTimestamp.toLocalDateTime().atZone(ZoneId.of("UTC")));

                customers.add(customer);
            }
            return customers;
        } catch (SQLException ex) {
            System.out.println("Could not get customers, reason: " + ex.getMessage());
            return new ArrayList<Customer>();
        } catch (Exception ex) {
            System.out.println("Error occurred while getting customers, reason: " + ex.getMessage());
            return new ArrayList<Customer>();
        }
    }

    /**
     * @inheritDocs
     */
    @Override
    public Customer getCustomer(int id) {
        final String sql = """
                SELECT * FROM customers WHERE Customer_ID=? LIMIT 1;
                """;
        try {
            ClientScheduleContext.OpenConnection();
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ps.setInt(id, 1);
            ResultSet results = ps.executeQuery();

            Customer customer = new Customer();
            while (results.next()) {
                // setup all non-date properties
                customer.setCustomerId(results.getInt(1));
                customer.setCustomerName(results.getString(2));
                customer.setAddress(results.getString(3));
                customer.setPostalCode(results.getString(4));
                customer.setPhone(results.getString(5));
                customer.setCreatedBy(results.getString(7));
                customer.setLastUpdatedBy(results.getString(9));
                customer.setDivisionId(results.getInt(10));

                // manage the date times
                Timestamp createdDateTimestamp = results.getTimestamp(6);
                customer.setCreatedDate(createdDateTimestamp.toLocalDateTime().atZone(ZoneId.of("UTC")));
                Timestamp lastUpdateTimestamp = results.getTimestamp(8);
                customer.setCreatedDate(lastUpdateTimestamp.toLocalDateTime().atZone(ZoneId.of("UTC")));
            }

            return customer;
        } catch (SQLException ex) {
            System.out.println("Could not get customer, reason: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error occurred while getting customer, reason: " + ex.getMessage());
            return null;
        }
    }
}
