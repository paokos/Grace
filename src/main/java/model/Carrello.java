package model;


import java.util.HashMap;

public class Carrello {
    private int cartId;
    private HashMap<Prodotto, Integer> contenuto;

    public int getCartId() {
        return cartId;
    }
    public HashMap<Prodotto, Integer> getContenuto() {
       return contenuto;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    public void setContenuto(HashMap<Prodotto, Integer> contenuto) {
        this.contenuto = contenuto;
    }
    public void addContenuto(Prodotto p, int q){
        if(contenuto==null)
            contenuto=new HashMap<Prodotto,Integer>();
        if(contenuto.containsKey(p)) {
            contenuto.put(p, contenuto.get(p)+q);
        }
        else
            contenuto.put(p, q);
    }
    public void removeContenuto(Prodotto p){
        if(contenuto!=null) {
            contenuto.remove(p);
        }
    }
    public boolean isEmpty(){
        return contenuto.isEmpty();
    }
}
  
