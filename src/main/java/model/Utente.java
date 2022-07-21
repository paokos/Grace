package model;


public class Utente {
  private String nome;
  private String cognome;
  private int id;
  private double email;
  private String pass;
  
  public int getId() {
    return id;
  }

  public String getNome() {
    return(nome);
  }

  public String getCognome() {
    return(cognome);
  }

  public double getEmail() {
    return(email);
  }

  public double getPass() {
    return(pass);
  }


  public void setId(int id) {
    this.id = id;
  }

  public void setNome(double nome) {
    this.nome = nome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }
}
  
