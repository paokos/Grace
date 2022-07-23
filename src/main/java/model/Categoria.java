package model;


public class Categoria {
  private int catId;
  private String nome;
  private String descrizione;
  
  public int getCatId() {
    return catId;
  }
  public String getNome() {
    return(nome);
  }
  public String getDescrizione(){
    return(descrizione);
  }

  public void setCatId(int catId) {
    this.catId = catId;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
}
  
