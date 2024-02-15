package Feb14_BankingManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class BankAccount
{
  private String accountNumber;
  private double balance;// current balance
    List<Transaction>transactionList = new ArrayList<>();
    public BankAccount(String accountNumber , double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    // create getter for get the value
    public String getAccountNumber()
    {
        return accountNumber;
    }
    public double getBalance()
    {
        return balance;
    }
    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    public void addTransaction(Transaction transaction)
    {
        transactionList.add(transaction);
    }
    public void display()
    {
        System.out.println("Account Number : " + getAccountNumber());
        System.out.println(" aBalance : " + getBalance());
        System.out.println(" transaction history : ");
        for(Transaction transaction : transactionList)
        {
            if(transaction != null)
            {
                System.out.println(transaction.getTransaction_id());
                System.out.println(transaction.getTransaction_type());
                System.out.println(getBalance());
            }
        }


    }
}
