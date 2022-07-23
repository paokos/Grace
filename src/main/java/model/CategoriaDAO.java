package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public Categoria doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT catid, nome, descrizione FROM grace.categoria WHERE catid=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categoria c = new Categoria();
                c.setCatId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setDescrizione(rs.getString(3));
                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Categoria getCategoriaByNome(String nome){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT catid, nome, descrizione FROM grace.categoria WHERE nome=?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categoria c = new Categoria();
                c.setCatId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setDescrizione(rs.getString(3));
                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // la funzione seguente � inutile perch� il DB � riempito tramite tool esterno
    // sarebbe utile se l'applicazione fornisse un form per riempirlo. IDEA! aggiungi questa feature all'applicazione
    // � un buon modo per verificare la sua correttezza

    public void doSave(Categoria categoria) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO grace.categoria (nome, descrizione) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getDescrizione());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            categoria.setCatId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> doRetrieveAll() {
        ArrayList<Categoria> categorie= new ArrayList<>();
        Statement st;
        ResultSet rs;
        Categoria c;
        try (Connection con = ConPool.getConnection()) {
            st= con.createStatement();
            rs=st.executeQuery("SELECT * FROM grace.categoria");
            while (rs.next()) {
                c = new Categoria();
                c.setCatId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setDescrizione(rs.getString(3));
                categorie.add(c);
            }
            con.close();
            return categorie;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


