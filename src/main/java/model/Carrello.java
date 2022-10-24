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

    public void addProdotto(Prodotto p, int q){
        if(contenuto==null)
            contenuto= new HashMap<>();
        if(contenuto.containsKey(p)) {
            q=contenuto.get(p)+q;
            contenuto.replace(p, q);
        }
        else
            contenuto.put(p, q);
    }
    public void removeProdotto(Prodotto p){
        if(contenuto!=null) {
            contenuto.remove(p);
        }
    }
    public void svuotaCarrello(){
        contenuto= new HashMap<>();
    }
    public int getQuantProdotto(Prodotto p){
        int q=0;
        if(contenuto.containsKey(p))//check
            q=contenuto.get(p);
        return q;
    }
    public boolean isEmpty(){
        return contenuto.isEmpty();
    }
}
  
