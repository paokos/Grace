package model;

import java.sql.*;

public class test {
    public static void main(String args[]){
        try (Connection con = ConPool.getConnection()) {
            Ordine ord=new Ordine();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ordine (utente, data, indirizzo) VALUE(?,?,?)", Statement.RETURN_GENERATED_KEYS);
//            UtenteDAO ud= new UtenteDAO();
//            Utente u;
//            u=ud.doRetrieveByCartId(c.getCartId());
            ord.setUtente(1);
            ord.setData(new Date(new java.util.Date().getTime()));
            ord.setIndirizzo("AO");
//            ord.setContenuto(c.getContenuto());
            ps.setInt(1, ord.getUtente());
            ps.setDate(2, ord.getData());
            ps.setString(3, ord.getIndirizzo());
            if (ps.executeUpdate()!=1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            ord.setOrdineId(rs.getInt(1));
//            ps = con.prepareStatement(
//                    "SELECT prod, prezzo, quantita FROM carpro, prodotto WHERE cart=? and prod=prodotto.codice",
//                    Statement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, c.getCartId());
//            rs=ps.executeQuery();
//            while (rs.next()) {
//                PreparedStatement psIn = con.prepareStatement(
//                        "INSERT INTO ordpro (ord, prod, prezzo, quantita) VALUES(?, ?, ?, ?)");
//                psIn.setInt(1, ord.getOrdineId());
//                psIn.setInt(2, rs.getInt(1));
//                psIn.setInt(3, rs.getInt(2));
//                psIn.setInt(4, rs.getInt(3));
//                if (ps.executeUpdate() != 1) {
//                    throw new RuntimeException("INSERT error.");
//                }
//                psIn = con.prepareStatement(
//                        "UPDATE prodotto set disponibili=(disponibili - ?) where codice=?");
//                psIn.setInt(1, rs.getInt(3));
//                psIn.setInt(2, rs.getInt(1));
//                if (psIn.executeUpdate() != 1) {
//                    throw new RuntimeException("UPDATE error.");
//                }
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
