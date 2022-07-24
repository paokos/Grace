package model;

import java.sql.*;


public class CarrelloDAO {

    public Carrello doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT cartID, prod, quantita FROM carrello, carpro WHERE cartID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Carrello c = new Carrello();
            ProdottoDAO pd = new ProdottoDAO();
            Prodotto p;
            while (rs.next()) {
                c.setCartId(rs.getInt(1));
                p = pd.doRetrieveById(rs.getInt(2));
                for(int i=0; i< rs.getInt(3);i++)
                    c.addContenuto(p);
            }
            con.close();
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Carrello doCreateCarrello(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO grace.carrello VALUES()",
                    Statement.RETURN_GENERATED_KEYS);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            Carrello cart=new Carrello();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            cart.setCartId(id);
            return cart;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Carrello cart) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO grace.carrello VALUES()",
                    Statement.RETURN_GENERATED_KEYS);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            cart.setCartId(id);
            for( Prodotto p: cart.getContenuto()){
                ps = con.prepareStatement(
                        "INSERT INTO grace.carpro (cart, prod, quantita) VALUES(?, ?, ?) ON DUPLICATE KEY UPDATE" +
                                " quantita=?");
                if (ps.executeUpdate() != 1) {
                    throw new RuntimeException("INSERT error.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addToCart(Prodotto p){

    }
}


