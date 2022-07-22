package model;

import java.sql.*;


public class CarrelloDAO {

   public Carrello doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT cartID, utente FROM carrello WHERE cartID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Carrello c = new Carrello();
                c.setCartId(rs.getInt(1));
                c.setUtente(rs.getInt(2));
                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Carrello cart) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO carrello (utente) VALUES(?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cart.getUtente());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            cart.setCartId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addToCart(){

    }
}


