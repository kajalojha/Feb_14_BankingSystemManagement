package Feb14_BankingManagementSystem;

import java.util.ArrayList;
import java.util.List;



public class BankingSystem {
    List<BankAccount> bankAccountslist; // bank account list

    public BankingSystem() {
        bankAccountslist = new ArrayList<>();
    }

    // Method to add an account into the bank account list
    public void addAccount(BankAccount b_accounts) {
        bankAccountslist.add(b_accounts);
    }

    // Method for depositing money
    public void depositMoney(String Accnum, double Amount, int id) throws BankException {
        BankAccount depositAccount = null;
        for (BankAccount bankAccount : bankAccountslist) {
            if (Accnum.equals(bankAccount.getAccountNumber())) {
                depositAccount = bankAccount;
                break;
            }
        }
        if (depositAccount != null) {
            if (Amount < 0) {
                throw new BankException("Cannot deposit a negative amount.");
            }
            double newAmount = depositAccount.getBalance() + Amount;
            depositAccount.setBalance(newAmount);
            Transaction t = new Transaction(id, "deposit", Amount);
            depositAccount.addTransaction(t);
            System.out.println("Amount is successfully deposited.");
            System.out.println("Your current amount is: " + newAmount);
        } else {
            throw new BankException("Account does not exist.");
        }
    }

    // Method for withdrawing money
    public void withdraw(String Accnum, double Amount, int id) throws BankException {
        BankAccount withdrawalAccount = null;
        for (BankAccount bankAccount : bankAccountslist) {
            if (Accnum.equals(bankAccount.getAccountNumber())) {
                withdrawalAccount = bankAccount;
                break;
            }
        }
        if (withdrawalAccount != null) {
            // Checking if the amount to withdraw is valid
            if (Amount < 0)
            {
                throw new BankException("Cannot withdraw a negative amount.");
            }
            // Checking if there are sufficient funds
            if (withdrawalAccount.getBalance() < Amount) {
                throw new BankException("Insufficient funds.");
            }
            double currentAmount = withdrawalAccount.getBalance() - Amount;
            withdrawalAccount.setBalance(currentAmount);
            Transaction t = new Transaction(id, "withdrawal", Amount);
            withdrawalAccount.addTransaction(t);
            System.out.println("Withdrawal is successful.");
            System.out.println("Your current available amount is: " + currentAmount);
        } else {
            throw new BankException("Invalid account number.");
        }
    }

    // Method for transferring amount between two accounts
    public void transferAmmount(String fromAccNum, double amount, String toAccNum, int id) throws BankException {
        BankAccount fromAccount = null;
        BankAccount toAccount = null;
        // Finding the sender and receiver accounts in the list
        for (BankAccount bankAccount : bankAccountslist) {
            if (fromAccNum.equals(bankAccount.getAccountNumber())) {
                fromAccount = bankAccount;
            }
            if (toAccNum.equals(bankAccount.getAccountNumber())) {
                toAccount = bankAccount;
            }
            if (fromAccount != null && toAccount != null) {
                break;
            }
        }
        // Checking if both accounts exist
        if (fromAccount == null || toAccount == null) {
            throw new BankException("One or both accounts do not exist.");
        }
        // Checking if the amount to transfer is valid
        if (amount < 0) {
            throw new BankException("Cannot transfer a negative amount.");
        }
        // Checking if there are sufficient funds in the sender's account
        if (fromAccount.getBalance() < amount) {
            throw new BankException("Insufficient funds for the transfer.");
        }
        double fromBalance = fromAccount.getBalance() - amount;
        double toBalance = toAccount.getBalance() + amount;
        fromAccount.setBalance(fromBalance);
        toAccount.setBalance(toBalance);
        Transaction tFrom = new Transaction(id, "withdrawal", amount);
        Transaction tTo = new Transaction(id, "deposit", amount);
        fromAccount.addTransaction(tFrom);
        toAccount.addTransaction(tTo);
        System.out.println("Amount is successfully transferred.");
        System.out.println("Your current amount after transaction is: " + fromBalance);
    }
}


