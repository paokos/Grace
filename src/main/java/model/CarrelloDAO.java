package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class CarrelloDAO {

    public Carrello doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT cartID, prod, quantita FROM carrello, carpro WHERE cart=carrello.cartID and cartID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Carrello c = new Carrello();
            ProdottoDAO pd = new ProdottoDAO();
            Prodotto p;
            while (rs.next()) {
                c.setCartId(rs.getInt(1));
                p = pd.doRetrieveByCodice(rs.getInt(2));
//                for(int i=0; i< rs.getInt(3);i++)
                    c.addContenuto(p,rs.getInt(3));
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
            cart.setContenuto(new HashMap<Prodotto, Integer>());
            return cart;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Carrello cart) {
        try (Connection con = ConPool.getConnection()) {
//            PreparedStatement ps = con.prepareStatement(
//                    "INSERT INTO grace.carrello VALUES()",
//                    Statement.RETURN_GENERATED_KEYS);
//            if (ps.executeUpdate() != 1) {
//                throw new RuntimeException("INSERT error.");
//            }
//            ResultSet rs = ps.getGeneratedKeys();
//            rs.next();
//            int id = rs.getInt(1);
//            cart.setCartId(id);
            Set<Map.Entry<Prodotto, Integer>> set = cart.getContenuto().entrySet();
            for(Map.Entry<Prodotto, Integer> me: set){
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO grace.carpro (cart, prod, quantita) VALUES(?, ?, ?) ON DUPLICATE KEY UPDATE" +
                                " quantita=?");
                ps.setInt(1,cart.getCartId());
                ps.setInt(2,me.getKey().getCodice());
                ps.setInt(3,me.getValue());
                ps.setInt(4,me.getValue());
                if (ps.executeUpdate() != 1) {
                    throw new RuntimeException("INSERT error.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addToCart(Prodotto p, Carrello c, int quant){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO carpro (cart, prod, quantita) VALUES(?,?,?) ON DUPLICATE KEY UPDATE"+
                            " quantita=?+quantita", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,c.getCartId());
            ps.setInt(2,p.getCodice());
            ps.setInt(3,quant);
            ps.setInt(4,quant);
            if (ps.executeUpdate()!= 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            c.addContenuto(p, quant);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeFromCart(Prodotto p, Carrello c){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM carpro WHERE cart=? and prod=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,c.getCartId());
            ps.setInt(2,p.getCodice());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
