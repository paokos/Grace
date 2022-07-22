package model;


public class Customer {
  private static int last = 0;
  private String firstName;
  private String lastName;
  private int id;
  private double balance;

  public Customer(int id, String firstName,String lastName,double balance){
    this.id = id;
    this.balance=balance;
    this.firstName=firstName;
    this.lastName=lastName;
  }

  public Customer(){

  }

  public Customer(String firstName,String lastName,double balance){
    this.id = last++;
    this.balance=balance;
    this.firstName=firstName;
    this.lastName=lastName;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return(firstName);
  }

  public String getLastName() {
    return(lastName);
  }

  public double getBalance() {
    return(balance);
  }


  public void setId(int id) {
    this.id = id;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
}
  
