package sample;

/**
 MoneyMarket class to define a subclass of Account which also contains the data field to keep track of how many withdrawals from the account.
 Methods include monthlyInterest which calculates the monthly interest, and monthlyFee which calculates the monthly fee for account and deducts the fee if there is one.
 @author Tanuj Desai, Nicholas Makar
 */

public class MoneyMarket extends Account {

    private int withdrawals;

    public MoneyMarket(Profile holder, double balance, Date dateOpen, int withdrawals) {

        super(holder, balance, dateOpen);
        this.withdrawals = 0;
    }

    public MoneyMarket(Profile holder, double balance, Date dateOpen) {

        super(holder, balance, dateOpen);
        this.withdrawals = 0;
    }


    public double monthlyInterest(){

        double value = getBalance() * Math.pow(1 + (.0065/12), 12);
        double interest = value - getBalance();

        return interest;
    }

    /**
     Calculates the monthly fee for the Money Marketing account and deducts the fee if applicable
     @return balance of account
     */
    public double monthlyFee() {

        double fee = 12.00;

        if(this.getBalance() >= 2500 && withdrawals <= 6) {  // waive fee in balance >= 2500

            fee = 0.0;
        }
        return fee;
    }


    /**
     Getter & Setter Methods
     */

    public int getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(int withdrawals) {
        this.withdrawals = withdrawals;
    }
}

