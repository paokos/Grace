package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A small table of banking customers for testing.
 */

@SuppressWarnings("DuplicatedCode")
public class UtenteDAO {

    public List<Utente> doRetrieveAll(){
        ArrayList<Utente> utenti = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Utente u;
        try (Connection con = ConPool.getConnection()) {
            st = con.createStatement();
            rs = st.executeQuery("SELECT id, nome, cognome, indirizzo, email, password, admin, carrello FROM utente");
            while (rs.next()) {
                u = new Utente();
                u.setId(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setCognome(rs.getString(3));
                u.setIndirizzo(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setPass(rs.getString(6));
                u.setAdmin(rs.getBoolean(7));
                u.setCarrello(rs.getInt(8));
                utenti.add(u);
            }
            con.close();
            return utenti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utente doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id, nome, cognome, indirizzo, email, password, admin, carrello FROM grace.utente WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setCognome(rs.getString(3));
                u.setIndirizzo(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setPass(rs.getString(6));
                u.setAdmin(rs.getBoolean(7));
                u.setCarrello(rs.getInt(8));
                return u;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utente doRetrieveByCartId(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id, nome, cognome, indirizzo, email, password, admin, carrello FROM grace.utente WHERE carrello=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setCognome(rs.getString(3));
                u.setIndirizzo(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setPass(rs.getString(6));
                u.setAdmin(rs.getBoolean(7));
                u.setCarrello(rs.getInt(8));
                return u;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utente doRetrieveByEmailPassword(String email, String password) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id, nome, cognome, indirizzo, email, password, admin, carrello FROM grace.utente " +
                            "WHERE email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setCognome(rs.getString(3));
                u.setIndirizzo(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setPass(rs.getString(6));
                u.setAdmin(rs.getBoolean(7));
                u.setCarrello(rs.getInt(8));
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

    public void doSave(Utente utente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO grace.utente (nome, cognome, indirizzo, email, password, admin, carrello) VALUES(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getCognome());
            ps.setString(3, utente.getIndirizzo());
            ps.setString(4, utente.getEmail());
            ps.setString(5, utente.getPass());
            ps.setBoolean(6, utente.getAdmin());
            ps.setInt(7, utente.getCarrello());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            utente.setId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdateUtente(Utente u){

        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();
                String query = "update grace.utente set nome='" + u.getNome() + "', cognome='" + u.getCognome()+
                    "', indirizzo='" + u.getIndirizzo()+ "', email='" + u.getEmail()+
                    "', password='" + u.getPass()+ "', admin=" + u.getAdmin() + ", carrello="+ u.getCarrello() +
                    " where id=" + u.getId() + ";";
            st.executeUpdate(query);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


