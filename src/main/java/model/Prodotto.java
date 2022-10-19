package model;


import java.util.Objects;

public class Prodotto {
  private int codice;
  private String nome;
  private double prezzo;
  private String colore;
  private String taglia;
  private String descrizione;
  private int disponibili;
  private String imgsrc;


  public int getCodice() {
    return codice;
  }
  public String getNome() {
    return(nome);
  }
  public double getPrezzo() {
    return(prezzo);
  }
  public String getColore() {
    return(colore);
  }
  public String getTaglia() {
    return(taglia);
  }
  public String getDescrizione() {
    return descrizione;
  }
  public int getDisponibili() {
    return disponibili;
  }
  public String getImgsrc() {
    return(imgsrc);
  }

  public void setCodice(int codice) {
    this.codice = codice;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setPrezzo(double prezzo) {
    this.prezzo = prezzo;
  }
  public void setColore(String colore) {
    this.colore = colore;
  }
  public void setTaglia(String taglia) {
    this.taglia = taglia;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  public void setDisponibili(int disponibili) {
    this.disponibili = disponibili;
  }
  public void setImgsrc(String imgsrc) {
    this.imgsrc = imgsrc;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Prodotto prodotto = (Prodotto) o;
    return codice == prodotto.codice;
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice);
  }
}

