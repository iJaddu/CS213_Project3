package sample;

/**
 Checking class to define a subclass of Account which also contains the data field of whether the account holder has directDeposit or not.
 Methods include monthlyInterest which calculates the monthly interest, and monthlyFee which calculates the monthly fee for account and deducts the fee if there is one.
 @author Tanuj Desai, Nicholas Makar
 */


public class Checking extends Account {

    private boolean directDeposit;

    public Checking(Profile holder, double balance, Date dateOpen) {

        super(holder, balance, dateOpen);

    }

    public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {

        super(holder, balance, dateOpen);
        this.directDeposit = directDeposit;
    }




    public double monthlyInterest(){

        double value = getBalance() * Math.pow(1 + (.0005/12), 12);
        double interest = value - getBalance();

        return interest;
    }

    /**
     Calculates the monthly fee for the account and deducts the fee if applicable
     @return balance of account
     */
    public double monthlyFee() {

        double fee = 25.00;

        if(this.getBalance() >= 1500) {  // waive fee in balance >= 1500

            fee = 0.0;
        }
        return fee;
    }

    @Override
    public String toString() {

        if(isDirectDeposit()) {
            return "*Checking" + super.toString() + "Direct Deposit Account*";
        }

        return "*Checking" + super.toString();
    }

    /**
     Getter & Setter Methods
     */
    public boolean isDirectDeposit() {
        return directDeposit;
    }

    public void setDirectDeposit(boolean directDeposit) {
        this.directDeposit = directDeposit;
    }
}


