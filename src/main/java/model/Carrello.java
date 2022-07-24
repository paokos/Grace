package model;


import java.util.List;

public class Carrello {
  private int cartId;
  private List<Prodotto> contenuto;

  public int getCartId() {
    return cartId;
  }
  public List<Prodotto> getContenuto() {
    return contenuto;
  }

  public void setCartId(int cartId) {
    this.cartId = cartId;
  }
  public void setContenuto(List<Prodotto> contenuto) {
    this.contenuto = contenuto;
  }
  public void addContenuto(Prodotto p){
    contenuto.add(p);
  }
  public boolean isEmpty(){
    return contenuto.isEmpty();
  }
}
  
