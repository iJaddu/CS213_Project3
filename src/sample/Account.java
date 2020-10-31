package sample;

/**
 Abstract Account class to define an Account that stores the profile (firstname,lastname), date the account was opened, and the balance currently in the account.
 Methods include debit and credit which remove and add an amount from the account and toString to print the account in a clear way indicating account type and the data within it. Getters and setters to change values in accounts.
 @author Tanuj Desai, Nicholas Makar
 */


public abstract class Account {

    private Profile holder;
    private double balance;
    private Date dateOpen;


    /**
     Default Account Constructor: creates a new Account, containing a new holder, balance, and Date

     public Account() {

     this.holder = new Profile();
     this.balance = 0.0;
     this.dateOpen = new Date();
     }
     */

    /**
     Account Constructor: creates a new Account with the given values for holder, balance and dateOpended
     @param holder Account holder
     @param balance Account balance
     @param dateOpen Date the Account was opened
     */
    public Account(Profile holder, double balance, Date dateOpen) {
        this.holder = holder;
        this.balance = balance;
        this.dateOpen = dateOpen;
    }



    /**
     Removes the given amount from the current account balance
     @param amount the amoun to be removed from the account balance
     */
    public void debit(double amount) {
        balance = balance - amount;
    }

    /**
     Adds the given amount to the current account balance
     @param amount the amount to be added to the account balance
     */
    public void credit(double amount) {
        balance = (balance + amount);
    }

    @Override
    /**
     Converts Account information into a string for output
     */
    public String toString() {

        return "*" + holder.getFname() + " " +  holder.getLname() + "* $" + this.balance + "*" + dateOpen.toString() + "*";
    }

    public abstract double monthlyInterest();

    public abstract double monthlyFee();


    /**
     * Getter & Setter Methods
     */

    public Profile getHolder() {
        return holder;
    }

    public void setHolder(Profile holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(Date dateOpen) {
        this.dateOpen = dateOpen;
    }

}