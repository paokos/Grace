package model;

import java.sql.*;
import java.util.List;

/**
 * A small table of banking customers for testing.
 */

public class CategoriaDAO {
    /**
     * Finds the customer with the given ID.
     * Returns null if there is no match.
     */

    public Categoria doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT catID, name, parent FROM categoria WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setParent(rs.getInt(3));
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
                    "INSERT INTO customer (catID, nome, parent) VALUES(NULL,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, categoria.catID());
            ps.setString(2, customer.parent());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            categoria.setId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> doRetrieveAll() {
    }
}


