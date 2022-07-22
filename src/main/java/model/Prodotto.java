package model;


public class Prodotto {
  private int codice;
  private String nome;
  private double prezzo;
  private String colore;
  private String taglia;
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
  public String getImgsrc() {
    return(imgsrc);
  }


  public void setCodice(int codice) {
    this.codice = codice;
  }

  public void setPrezzo(double prezzo) {
    this.prezzo = prezzo;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setColore(String colore) {
    this.colore = colore;
  }
  public void setTaglia(String taglia) {
    this.taglia = taglia;
  }
  public void setImgsrc(String imgsrc) {
    this.imgsrc = imgsrc;
  }
}

