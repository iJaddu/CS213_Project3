package sample;

/**
 Savings class to define a subclass of Account which also contains the data field to keep track of how many withdrawals from the account.
 Methods include monthlyInterest which calculates the monthly interest, and monthlyFee which calculates the monthly fee for account and deducts the fee if there is one.
 @author Tanuj Desai, Nicholas Makar
 */

public class Savings extends Account {

    private boolean isLoyal;

    public Savings(Profile holder, double balance, Date dateOpen) {

        super(holder,balance,dateOpen);
    }

    public Savings(Profile holder, double balance, Date dateOpen, boolean loyalty) {

        super(holder,balance,dateOpen);
        this.isLoyal = loyalty;
    }




    public double monthlyInterest(){

        double rate = .0025;

        if(isLoyal()) {
            rate = .0035;
        }

        double value = getBalance() * Math.pow(1 + (rate/12), 12);
        double interest = value - getBalance();

        return interest;
    }

    /**
     Calculates the monthly fee for the account and deducts the fee if applicable
     @return balance of account
     */
    public double monthlyFee() {

        double fee = 5.00;
        if(this.getBalance() >= 300) {  // waive fee in balance >= 300
            fee = 0.0;
        }

        return fee;
    }


    /**
     Getter & Setter Methods
     */
    public boolean isLoyal() {
        return isLoyal;
    }

    public void setLoyal(boolean loyal) {
        isLoyal = loyal;
    }
}

