package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    public Prodotto doRetrieveByCodice(int cod) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT codice, nome, prezzo, colore, taglia, descrizione, disponibili, imgsrc FROM prodotto WHERE codice=?");
            ps.setInt(1, cod);
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
            st = con.createStatement();
            rs = st.executeQuery("SELECT codice, nome, prezzo, colore, taglia, descrizione, disponibili, imgsrc FROM prodotto");
            while (rs.next()) {
                p = new Prodotto();
                p.setCodice(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setColore(rs.getString(4));
                p.setTaglia(rs.getString(5));
                p.setDescrizione(rs.getString(6));
                p.setImgsrc(rs.getString(7));
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
                    con.prepareStatement("SELECT codice, nome, prezzo, colore, taglia, descrizione, disponibili, imgsrc FROM prodotto, procat WHERE codice=prod and cat=?");
            ps.setInt(1, c.getCatId());
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Prodotto();
                p.setCodice(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setColore(rs.getString(4));
                p.setTaglia(rs.getString(5));
                p.setDescrizione(rs.getString(6));
                p.setDisponibili(rs.getInt(7));
                p.setImgsrc(rs.getString(8));
                prodotti.add(p);
            }
            con.close();
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prodotto> doRetrieveByIdCategoria(int c) {
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        ResultSet rs;
        Prodotto p;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT codice, nome, prezzo, colore, taglia, descrizione, disponibili, imgsrc FROM prodotto, procat " +
                            "WHERE codice=prod and cat=?");
            ps.setInt(1, c);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Prodotto();
                p.setCodice(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setColore(rs.getString(4));
                p.setTaglia(rs.getString(5));
                p.setDescrizione(rs.getString(6));
                p.setDisponibili(rs.getInt(7));
                p.setImgsrc(rs.getString(8));
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
                    "INSERT INTO prodotto (nome, prezzo, colore, taglia, descrizione, disponibili, imgsrc) VALUES(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, prodotto.getNome());
            ps.setDouble(2, prodotto.getPrezzo());
            ps.setString(3, prodotto.getColore());
            ps.setString(4, prodotto.getTaglia());
            ps.setString(5, prodotto.getDescrizione());
            ps.setInt(6, prodotto.getDisponibili());
            ps.setString(7, prodotto.getImgsrc());
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

    public void doUpdateProdotto(Prodotto p) {

        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();
//            nome, prezzo, colore, taglia, imgsrc
            String query = "update Prodotto set nome='" + p.getNome() + "', prezzo=" +
                    p.getPrezzo() + ", colore='" + p.getColore() + "', taglia='" + p.getTaglia() + "', imgsrc='" + p.getImgsrc() + "' where codice=" + p.getCodice() + ";";
            st.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSaveProdottoCategoria(Prodotto p, List<Categoria> categorie) {
        try (Connection con = ConPool.getConnection()) {
            for (Categoria c : categorie) {
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO procat (prod, cat) VALUES(?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, p.getCodice());
                ps.setInt(2, c.getCatId());
                if (ps.executeUpdate() != 1) {
                    throw new RuntimeException("INSERT error.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSaveProdottoCategoriaId(Prodotto p, List<Integer> categorie) {
        try (Connection con = ConPool.getConnection()) {
            for (Integer c : categorie) {
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO procat (prod, cat) VALUES(?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, p.getCodice());
                ps.setInt(2, c);
                if (ps.executeUpdate() != 1) {
                    throw new RuntimeException("INSERT error.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public void doDelete(Prodotto p){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM prodotto WHERE codice=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p.getCodice());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prodotto> doRicerca(String q) {
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        ResultSet rs;
        Prodotto p;
        try (Connection con = ConPool.getConnection()) {
            String term="%"+q+"%";
            PreparedStatement ps =
                    con.prepareStatement("SELECT codice, nome, prezzo, colore, taglia, descrizione, disponibili, imgsrc FROM prodotto WHERE nome LIKE ?");
            ps.setString(1, term);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Prodotto();
                p.setCodice(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setColore(rs.getString(4));
                p.setTaglia(rs.getString(5));
                p.setDescrizione(rs.getString(6));
                p.setDisponibili(rs.getInt(7));
                p.setImgsrc(rs.getString(8));
                prodotti.add(p);
            }
            con.close();
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

