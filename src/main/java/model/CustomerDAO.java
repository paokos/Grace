package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A small table of banking customers for testing.
 */

public class CustomerDAO {

    public Customer doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id, firstName, lastName, balance FROM Customer WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer p = new Customer();
                p.setId(rs.getInt(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                p.setBalance(rs.getDouble(4));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Customer customer) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Customer (firstName, lastName, balance) VALUES(?,?,?)"
        //            , Statement.RETURN_GENERATED_KEYS                   // questo codice è utile solo se si vuole restituire il bean customer completo di id
            );                                                            // in questo caso restituiamo  void per cui è inutile
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setDouble(3, customer.getBalance());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> doRetrieveAll(){
        ArrayList<Customer> customers = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Customer p;
        try (Connection con = ConPool.getConnection()) {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Customer WHERE 1=1");
            while(rs.next()) {
                p = new Customer();
                p.setId(rs.getInt(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                p.setBalance(rs.getDouble(4));
                customers.add(p);
            }
            con.close();
            return customers;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdateCustomer(Customer c){

        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();
            String query = "update Customer set firstName='" + c.getFirstName() + "', lastName='" +
                    c.getLastName() + "', balance=" + c.getBalance() + " where id=" + c.getId() + ";";
            st.executeUpdate(query);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


