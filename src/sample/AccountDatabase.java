package sample;



/**
 AccountDatabase class is for the management of the database array of all accounts. It takes command inputs from TransactionManager to perform the given command/operation on the array.
 The commands are finding an account in the array, growing the array size by 5, adding an account to the database, removing an account from the database, deposit funds into an account, remove an amount from an account,
 print the array, sort and print the array in ascending order by date, and sort and print the array in ascending order by last name.
 @author Tanuj Desai, Nicholas Makar
 */


public class AccountDatabase {

    private Account[] accounts;
    private int size;


    public AccountDatabase(){
        accounts = new Account[5];
        size = 0;
    }

    /**
     Given a GroceryItem object, finds if it is in the shopping bag or not.
     @param account1 account object to compare.
     @param account2 second account object to compare to first
     @return true if they are of same type (Checkings, Savings, MoneyMarket), false otherwise
     */
    public boolean equalsTo(Account account1, Account account2){
        if(account1 instanceof Checking && account2 instanceof Checking){
            return true;
        }

        if(account1 instanceof Savings && account2 instanceof Savings){
            return true;
        }

        if(account1 instanceof MoneyMarket && account2 instanceof MoneyMarket){
            return true;
        }
        return false;
    }

    /**
     Find out the account type of an account object. (Checking, Savings, or MoneyMarket)
     @param account account object to determine the type of.
     @return one char string that indicates account type, "C" for checkin, "S" for savings, "M" for moneymarket
     */
    public String accountType(Account account){
        if(account instanceof Checking){
            String c = "C";
            return c;
        }
        if(account instanceof Savings){
            String s = "S";
            return s;
        }
        if(account instanceof MoneyMarket){
            String m = "M";
            return m;
        }
        return "/";
    }

    /**
     Find out if an account exists in the database,
     @param account account object to compare.
     @return index of item in the array if it exists, -1 otherwise
     */
    private int find(Account account) {
        if(size == 0){
            return -1;
        }

        for(int i = 0; i < size; i++){
            if((account.getHolder().getFname()).equals(accounts[i].getHolder().getFname()) && (account.getHolder().getLname()).equals(accounts[i].getHolder().getLname())){
                if(equalsTo(account, accounts[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     Increases the size of the database by 5
     */
    private void grow() {
        Account[] temp;
        temp = new Account[accounts.length + 5];
        System.arraycopy(accounts, 0, temp, 0, accounts.length);
        accounts = temp;
    }

    /**
     Adds an account to the database.
     @param account account object to add.
     @return true if account was added, false if account already exists
     */
    public boolean add(Account account) {   // return false if account exists

        if(find(account) != -1){
            return false;
        }

        String type = accountType(account);

        if(type.equals("C")){
            Checking temp1 = new Checking(account.getHolder(), account.getBalance(), account.getDateOpen(), ((Checking) account).isDirectDeposit());
            accounts[size] = temp1;
            size = size + 1;
            if(size+1 == accounts.length){
                grow();
            }
            return true;
        }
        if(type.equals("S")){
            accounts[size] = new Savings(account.getHolder(), account.getBalance(), account.getDateOpen(), ((Savings) account).isLoyal());
            size = size + 1;
            if(size+1 == accounts.length){
                grow();
            }
            return true;
        }
        if(type.equals("M")){
            accounts[size] = new MoneyMarket(account.getHolder(), account.getBalance(), account.getDateOpen(),0);
            size = size + 1;
            if(size+1 == accounts.length){
                grow();
            }
            return true;
        }
        return false;
    }

    /**
     Remove an account from the database
     @param account account object to remove
     @return true if account removed, false if account doesn't exist
     */
    public boolean remove(Account account) {    // return false if account doesn't exist

        boolean accountFound = false;
        if(size == 0){
            return false;
        }
        if(find(account) < 0){
            return false;
        }

        Account[] temp = new Account[accounts.length];

        for(int i = 0, j = 0; i < accounts.length; i++){
            if(i == find(account)){
                accountFound = true;
                continue;
            }
            temp[j++] = accounts[i];
        }
        accounts = temp;
        size = size -1;
        return accountFound;
    }

    /**
     Deposit money into an existing account.
     @param account account object to deposit money into.
     @param amount amount to be added to the account.
     @return return true if account was credited by the amount, false otherwise
     */
    public boolean deposit(Account account, double amount) {
        for(int i = 0; i < size; i++){
            if((account.getHolder().getFname()).equals(accounts[i].getHolder().getFname()) && (account.getHolder().getLname()).equals(accounts[i].getHolder().getLname())){
                if(equalsTo(account, accounts[i])){
                    accounts[i].credit(amount);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     Withdraw money from an existing account.
     @param account account object to deposit money into.
     @param amount amount to be withdrawn to the account.
     @return 0 if withdrawal successful, 1 if insufficient funds, -1 if account doesn't exist
     */
    public int withdrawal(Account account, double amount) { // return 0: withdrawal successful, 1: insufficient funds, -1: account doesn't exist
        if(find(account) == -1){
            return -1;
        }
        for(int i = 0; i < size; i++){
            if((account.getHolder().getFname()).equals(accounts[i].getHolder().getFname()) && (account.getHolder().getLname()).equals(accounts[i].getHolder().getLname())){
                if(equalsTo(account, accounts[i])){
                    if(accounts[i].getBalance() < amount){ // not enough money in account
                        if(accountType(account) == "M"){
                            int x = ((MoneyMarket) account).getWithdrawals();
                            x = x + 1;
                            ((MoneyMarket) account).setWithdrawals(x);
                        }
                        return 1;
                    }else{
                        accounts[i].debit(amount);
                        return 0;
                    }
                }
            }
        }
        return -1;
    }

    /**
    Sort the Account Database by the openDate of the account
     */
    private void sortByDateOpen() {     // sort in ascending order

        Account temp;

        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                if(accounts[i].getDateOpen().compareTo(accounts[j].getDateOpen()) > 0) {
                    temp = accounts[i];
                    accounts[i] = accounts[j];
                    accounts[j] = temp;
                }
            }
        }

    }

    /**
    Sort the Account Database by the last name of the Account holder
     */
    private void sortByLastName() {     // sort in ascending order

        Account temp;

        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                if(accounts[i].getHolder().getLname().toString().compareTo(accounts[j].getHolder().getLname().toString()) > 0) {
                    temp = accounts[i];
                    accounts[i] = accounts[j];
                    accounts[j] = temp;
                }
            }
        }

    }

    /**
    Returns a string of the accounts in Account database sorted by the date opened
    @return msg
    */
    public String printByDateOpen() {

        String msg = "";

        if(size == 0){
            msg = "Database is Empty";
            return msg;
        }

        sortByDateOpen();
       // msg = "--Printing Statement by Date Opened-- \n";

        for(int i = 0; i < size; i++) {
            msg = msg.concat(accounts[i].toString());
            msg = msg.concat("  - Interest: $" + accounts[i].monthlyInterest() + "\n");
            msg = msg.concat("  - Fee: $" + accounts[i].monthlyFee() + "\n");
            msg = msg.concat("  - New Balance: $" + (accounts[i].getBalance() + accounts[i].monthlyFee() + accounts[i].monthlyInterest() + "\n"));
        }
        //msg = msg + "--End of printing--\n";
        return msg;
    }

    /**
    Returns a string of the accounts in Account database sorted by the last name of the account holder
    @return msg
    */
    public String printByLastName() {

        String msg = "";

        if(size == 0){
            msg = "Database is empty.\n";
            return msg;
        }

        sortByLastName();
        //msg = msg + "--Printing Statement by Last Name--\n";

        for(int i = 0; i < size; i++) {
            msg = msg.concat(accounts[i].toString()) ;
            msg = msg.concat( "  - Interest: $" + accounts[i].monthlyInterest() + "\n" );
            msg = msg.concat("  - Fee: $" + accounts[i].monthlyFee() + "\n");
            msg = msg.concat("  - New Balance: $" + (accounts[i].getBalance() + accounts[i].monthlyFee() + accounts[i].monthlyInterest() + "\n"));
        }
       // msg = msg + "--End of printing--\n";
        return msg;
    }

    /**
    Returns a string of all accounts in Account database
    @return msg
    */
    public String printAccounts() {

        String msg = "";

        if(size == 0){
            msg = "Database is empty.\n";
            return msg;
        }
        // msg = "--Listing Accounts in the Database--\n";
        for(int i = 0; i < size; i++) {
            if(accountType(accounts[i]).equals("C")){
                msg = msg.concat(((Checking)accounts[i]).toString());
            } else if (accountType(accounts[i]).equals("S")){
                msg = msg.concat(((Savings)accounts[i]).toString());
            }else{
                msg = msg.concat(((MoneyMarket)accounts[i]).toString());
            }
        }
        //msg = msg + "--End of Listing--\n";
        return msg;
    }

}

