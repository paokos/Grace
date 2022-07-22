package model;

import java.sql.*;

/**
 * A small table of banking customers for testing.
 */

public class CarProDAO {
    /**
     * Finds the customer with the given ID.
     * Returns null if there is no match.
     */
    public CarPro doRetrieveByCart(Carrello c) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT cart, prod, quantita FROM carpro WHERE cart=?");
            ps.setInt(1, c.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CarPro p = new CarPro();
                p.setCart(rs.getInt(1));
                p.setProd(rs.getInt(2));
                p.setQuantita(rs.getInt(3));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(CarPro cp) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO carpro (cart, prod, quantita) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cp.getCart());
            ps.setInt(2, cp.getProd());
            ps.setInt(3, cp.getQuantita());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addCart(){

    }
}


