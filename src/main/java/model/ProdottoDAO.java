package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A small table of banking customers for testing.
 */

public class ProdottoDAO {


    /**
     * Finds the customer with the given ID.
     * Returns null if there is no match.
     */

    public Prodotto doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT codice, nome, prezzo, colore, taglia, imgsrc FROM prodotto WHERE codice=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setCodice(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setColore(rs.getString(4));
                p.setTaglia(rs.getString(5));
                p.setImgsrc(rs.getString(6));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prodotto> doRetrieveAll() {
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Prodotto p;
        try (Connection con = ConPool.getConnection()) {
            st= con.createStatement();
            rs=st.executeQuery("SELECT codice, nome, prezzo, colore, taglia, imgsrc FROM prodotto LIMIT 0,10");
            while (rs.next()) {
                p = new Prodotto();
                p.setCodice(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setColore(rs.getString(4));
                p.setTaglia(rs.getString(5));
                p.setImgsrc(rs.getString(6));
                prodotti.add(p);
            }
            con.close();
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Prodotto> doRetrieveByCategoria(Categoria c) {
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        ResultSet rs;
        Prodotto p;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT codice, nome, prezzo, colore, taglia, imgsrc FROM prodotto WHERE codice in " +
                    "(SELECT prod FROM procat WHERE cat=?) LIMIT 0,10");
            ps.setInt(1, c.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Prodotto();
                p.setCodice(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setColore(rs.getString(4));
                p.setTaglia(rs.getString(5));
                p.setImgsrc(rs.getString(6));
                prodotti.add(p);
            }
            con.close();
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void doSave(Prodotto prodotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO customer (nome, prezzo, colore, taglia, imgsrc) VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, prodotto.getNome());
            ps.setDouble(2, prodotto.getPrezzo());
            ps.setString(3, prodotto.getColore());
            ps.setString(4, prodotto.getTaglia());
            ps.setString(5, prodotto.getImgsrc());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            prodotto.setCodice(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdateProdotto(Prodotto p){

        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();
//            nome, prezzo, colore, taglia, imgsrc
            String query = "update Prodotto set nome='" + p.getNome() + "', prezzo=" +
                    p.getPrezzo() + ", colore='" + p.getColore() + "', taglia='"+ p.getTaglia()+"', imgsrc='"+ p.getImgsrc() + "' where codice=" + p.getCodice() + ";";
            st.executeUpdate(query);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


