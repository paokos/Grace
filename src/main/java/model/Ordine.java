package model;


import java.sql.Date;
import java.util.HashMap;

public class Ordine {
  private int ordineId;
  private String indirizzo;
  private Date data;
  private HashMap<Prodotto,Integer> contenuto;
  private int utente;

  public int getOrdineId() {
    return ordineId;
  }
  public HashMap<Prodotto,Integer> getContenuto() {
    return contenuto;
  }
  public String getIndirizzo() {
    return indirizzo;
  }
  public int getUtente() {
    return utente;
  }
  public Date getData() {
    return data;
  }

  public void setOrdineId(int ordineId) {
    this.ordineId = ordineId;
  }
  public void setContenuto(HashMap<Prodotto,Integer> contenuto) {
    this.contenuto = contenuto;
  }
  public void setUtente(int utente) {
    this.utente = utente;
  }
  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }
  public void setData(Date data) {
    this.data = data;
  }
}
  
