package Feb14_BankingManagementSystem;

import java.util.List;


public class Transaction
{
    private int transaction_id;
    private String transaction_type ;
    private double ammount ;
    List<Transaction>transactionList;//transaction list
 public Transaction(int transaction_id ,String transaction_type,double ammount)// constructor of transaction class
 {
     this.transaction_id= transaction_id;
     this.transaction_type = transaction_type;
     this.ammount = ammount;
 }
 // getter for get the valuea
    public int getTransaction_id()
    {
        return transaction_id;
    }

    public String getTransaction_type()
    {
        return transaction_type;
    }

    public double getAmmount()
    {
        return ammount;
    }
    // setter for set the value
    public void setTransaction_id(int transaction_id)
    {
        this.transaction_id = transaction_id;
    }

    public void setTransaction_type(String transaction_type)
    {
        this.transaction_type = transaction_type;
    }

    public void setAmmount(double ammount)
    {
        this.ammount = ammount;
    }


}
