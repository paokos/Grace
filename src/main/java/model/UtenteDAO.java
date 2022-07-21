package model;

import java.sql.*;

/**
 * A small table of banking customers for testing.
 */

public class UtenteDAO {


    /**
     * Finds the customer with the given ID.
     * Returns null if there is no match.
     */

    public Customer doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id, nome, cognome, indirizzo, email, password FROM customer WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setCognome(rs.getString(3));
                u.setEmail(rs.getDouble(4));
                u.setPass(rs.getDouble(4));
                return u;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    // la funzione seguente � inutile perch� il DB � riempito tramite tool esterno
    // sarebbe utile se l'applicazione fornisse un form per riempirlo. IDEA! aggiungi questa feature all'applicazione
    // � un buon modo per verificare la sua correttezza

    public void doSave(Customer customer) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utente (nome, cognome, indirizzo, email, password) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setDouble(3, customer.getBalance());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            customer.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}


