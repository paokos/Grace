package model;

import com.oracle.wls.shaded.org.apache.xpath.axes.HasPositionalPredChecker;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class OrdineDAO {

    public Ordine doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ordineID, indirizzo, data, utente FROM ordine WHERE ordineID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Ordine o = new Ordine();
                o.setOrdineId(rs.getInt(1));
                o.setIndirizzo(rs.getString(2));
                o.setData(rs.getDate(3));
                o.setUtente(rs.getInt(4));
                return o;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSaveByCart(Carrello c) {
        try (Connection con = ConPool.getConnection()) {
            Ordine ord=new Ordine();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ordine (utente, data, indirizzo) VALUE(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            UtenteDAO ud= new UtenteDAO();
            Utente u;
            u=ud.doRetrieveByCartId(c.getCartId());
            ord.setUtente(u.getId());
            ord.setData(new Date(new java.util.Date().getTime()));
            ord.setIndirizzo(u.getIndirizzo());
            ord.setContenuto(c.getContenuto());
            ps.setInt(1, ord.getUtente());
            ps.setDate(2, ord.getData());
            ps.setString(3, ord.getIndirizzo());
            if (ps.executeUpdate()!=1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            ord.setOrdineId(rs.getInt(1));
            ps = con.prepareStatement(
                    "SELECT prod, prezzo, quantita FROM carpro, prodotto WHERE cart=? and prod=prodotto.codice",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getCartId());
            rs=ps.executeQuery();
            while (rs.next()) {
                PreparedStatement psIn = con.prepareStatement(
                    "INSERT INTO ordpro (ord, prod, prezzo, quantita) VALUES(?, ?, ?, ?)");
                psIn.setInt(1, ord.getOrdineId());
                psIn.setInt(2, rs.getInt(1));
                psIn.setInt(3, rs.getInt(2));
                psIn.setInt(4, rs.getInt(3));
                if (psIn.executeUpdate() != 1) {
                    throw new RuntimeException("INSERT error.");
                }
                psIn = con.prepareStatement(
                        "UPDATE prodotto set disponibili=(disponibili - ?) where codice=?");
                psIn.setInt(1, rs.getInt(3));
                psIn.setInt(2, rs.getInt(1));
                if (psIn.executeUpdate() != 1) {
                    throw new RuntimeException("UPDATE error.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int controlloDisponibili(int idProd, int quantita){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT codice, disponibili from prodotto where codice=?");
            ps.setInt(1, idProd);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            if(rs.getInt(2)>=quantita)
                return 0;
            else
                return rs.getInt(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Ordine> doRetriveByUtente(int user){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT o.ordineID, o.indirizzo, o.data " +
                            "FROM ordine o where utente=? order by o.ordineID desc;");
            ps.setInt(1, user);
            ResultSet rs = ps.executeQuery();
            ArrayList<Ordine> ordini=new ArrayList<>();
            HashMap<Prodotto, Integer> p;
            Ordine o;
            while(rs.next()) {
                o=new Ordine();
                p=doRetriveContenuto(rs.getInt(1));
                o.setContenuto(p);
                o.setOrdineId(rs.getInt(1));
                o.setIndirizzo(rs.getString(2));
                o.setData(rs.getDate(3));
                ordini.add(o);
            }
            return ordini;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public HashMap<Prodotto,Integer> doRetriveContenuto(int ord){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT op.prod, p.nome, op.quantita, op.prezzo " +
                            "FROM ordpro op, prodotto p where prod=codice and ord=?;");
            ps.setInt(1, ord);
            ResultSet rs = ps.executeQuery();
            HashMap<Prodotto, Integer> p=new HashMap<>();
            Prodotto pt;
            while(rs.next()) {
                pt=new Prodotto();
                pt.setCodice(rs.getInt(1));
                pt.setNome(rs.getString(2));
                pt.setPrezzo(rs.getDouble(4));
                p.put(pt, rs.getInt(3));
            }
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


