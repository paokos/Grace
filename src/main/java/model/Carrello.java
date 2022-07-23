package model;


import java.util.List;

public class Carrello {
  private int cartId;
  private List<Prodotto> contenuto;
  private int utente;

  public int getCartId() {
    return cartId;
  }
  public List<Prodotto> getContenuto() {
    return contenuto;
  }
  public int getUtente() {
    return utente;
  }

  public void setCartId(int cartId) {
    this.cartId = cartId;
  }
  public void setContenuto(List<Prodotto> contenuto) {
    this.contenuto = contenuto;
  }
  public void setUtente(int utente) {
    this.utente = utente;
  }
  public void addCarrello(Prodotto p){

  }
}
  
