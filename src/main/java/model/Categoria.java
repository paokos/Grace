package model;


public class Categoria {
  private String nome;
  private int parent;
  private int id;
  
  public int getId() {
    return id;
  }

  public int getParent() {
    return(parent);
  }

  public String getNome() {
    return(nome);
  }


  public void setId(int id) {
    this.id = id;
  }

  public void setParent(int parent) {
    this.parent = parent;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
  
