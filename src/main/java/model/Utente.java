package model;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utente {
  private int id;
  private String nome;
  private String cognome;
  private String indirizzo;
  private String email;
  private String pass;
  private boolean admin;
  
  public int getId() {
    return id;
  }

  public String getNome() {
    return(nome);
  }

  public String getCognome() {
    return(cognome);
  }

  public String getIndirizzo() {
    return indirizzo;
  }

  public String getEmail() {
    return(email);
  }

  public String getPass() {
    return(pass);
  }

  public boolean getAdmin(){
    return(admin);
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPass(String pass) {
    try {
      MessageDigest digest =
              MessageDigest.getInstance("SHA-1");
      digest.reset();
      digest.update(pass.getBytes(StandardCharsets.UTF_8));
      this.pass = String.format("%040x", new
              BigInteger(1, digest.digest()));
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }
}
