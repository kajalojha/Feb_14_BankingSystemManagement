package Feb14_BankingManagementSystem;

import java.util.*;
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws BankException {
       //  Creating an instance of our banking system
        BankingSystem bankS = new BankingSystem();

        System.out.println("--- WELCOME TO SKS BANK ---");
        // use this variable to generate unique IDs for transactions
        int i=100;
        while (true)// select any option for proceed further
        {
            System.out.println("Select an option");
            System.out.println(" 1 Add account");
            System.out.println(" 2 Deposit ammount");
            System.out.println(" 3 Withdraw ammount");
            System.out.println(" 4 Transfer ammount");
            System.out.println(" 5. Transaction history");

            int x = sc.nextInt();
            if (x == 0) // if x=0 then exit
            {
                System.out.println("Exiting");
            }
            switch (x)
            {
                case 1: // for add account
                {
                    BankAccount newuser = addAccount();// Calling the function to add an account
                    bankS.addAccount(newuser);
                    break;
                }
                case 2: // for ammount deposit
                {
                    System.out.println("Enter the account number :");
                    String AccNum = sc.next();
                    System.out.println("Enter the ammount you want to deposit");
                    double depAmmount = sc.nextDouble();
                    bankS.depositMoney(AccNum , depAmmount , i++);
                    break;
                }
                case 3:// for withdraw ammount
                {
                    System.out.println("Enter the account number :");
                    String AccNum = sc.next();
                    System.out.println("Enter the ammount you want to withdrawl");
                    double depAmmount = sc.nextDouble();
                    bankS.withdraw(AccNum , depAmmount,i++);
                    break;
                }
                case 4 :  // for transaction between two person
                {
                    System.out.println(" Enter your account number");
                    String AccNum= sc.next();
                    System.out.println("Enter the account number  of other person");
                    String AccNum1 = sc.next();
                    System.out.println("enter the amount you want to transfer");
                    double ammount = sc.nextDouble();
                    bankS.transferAmmount(AccNum , ammount , AccNum1,i++);
                    break;
                }
                case 5:  // for transaction history
                {
                    sc.nextLine();
                    System.out.println("enter id ");
                    String id = sc.nextLine();
                    // Finding the account and displaying its transaction history
                    for(BankAccount bankAccount : bankS.bankAccountslist)
                    {
                        if(bankAccount.getAccountNumber().equals(id)){
                            bankAccount.display();
                            break;
                        }
                    }
                }
                default: // default case
                {
                    System.out.println(" enter a valid choice ");
                    break;
                }
            }
        }

    }
    public static BankAccount addAccount() // fuction for add account
    {
        System.out.println("Enter the Account Number");
        String accountNum = sc.next();
        System.out.println("Enter the available balance");
        double ava_Balance = sc.nextDouble();
        BankAccount BankAcc = new BankAccount(accountNum , ava_Balance);
        return  BankAcc;
    }

}




