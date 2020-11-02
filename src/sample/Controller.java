package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Controller {
    AccountDatabase accDB = new AccountDatabase();

    @FXML
    private TextField firstNameOpen, lastNameOpen, balanceOpen, firstNameClose, lastNameClose, balanceClose, firstNameDeposit, firstNameWithdraw, lastNameDeposit, lastNameWithdraw, amountDeposit, amountWithdraw, monthOpen, dayOpen, yearOpen, monthClose, dayClose, yearClose;

    @FXML
    private Button openAccountButton, closeAccountButton, clearButtonOpen, accountType, clearButtonClose, depositButton, withdrawButton, importButton, exportButton, printAccountsButton, printAccountsByNameButton, printAccountsByDateButton;

    @FXML
    private RadioButton CheckingRadioButton, SavingsRadioButton, MMRadioButton;

    @FXML
    private CheckBox directDepositOpen, loyalCustomerOpen, directDepositClose, loyalCustomerClose;

    @FXML
    private TextArea outputArea;

    @FXML
    private ToggleGroup acctype;



    /**
     * Clear button hit in any tab, clears all text fields.
     * @param event
     */
    @FXML
    void clearTextFields(ActionEvent event) {
        firstNameOpen.clear();
        firstNameClose.clear();
        firstNameDeposit.clear();
        firstNameWithdraw.clear();
        lastNameOpen.clear();
        lastNameClose.clear();
        lastNameDeposit.clear();
        lastNameWithdraw.clear();
        monthClose.clear();
        monthOpen.clear();
        dayOpen.clear();
        dayClose.clear();
        yearClose.clear();
        yearOpen.clear();
        balanceOpen.clear();
        balanceClose.clear();
        amountDeposit.clear();
        amountWithdraw.clear();
        outputArea.clear();
        loyalCustomerOpen.setDisable(false);
        directDepositOpen.setDisable(false);
        loyalCustomerClose.setDisable(false);
        directDepositOpen.setDisable(false);
    }


    /**
     * MoneyMarket account type button clicked in the open account tab
     * @param event
     */
    @FXML
    void mmButtonOnClickedOpen(ActionEvent event) {
        MMRadioButton.setSelected(true);
        loyalCustomerOpen.setDisable(true);
        directDepositOpen.setDisable(true);
    }

    /**
     * Savings account type button clicked in the open account tab
     * @param event
     */
    @FXML
    void savingsButtonOnClickedOpen(ActionEvent event) {
        SavingsRadioButton.setSelected(true);
        directDepositOpen.setDisable(true);
        loyalCustomerOpen.setDisable(false);
    }

    /**
     * Checking account type button clicked in the open account tab
     * @param event
     */
    @FXML
    void checkingButtonOnClickedOpen(ActionEvent event) {
        loyalCustomerOpen.setDisable(true);
        directDepositOpen.setDisable(false);
        CheckingRadioButton.setSelected(true);
    }

    /**
     * MoneyMarket account type button clicked in the close account tab
     * @param event
     */
    @FXML
    void mmButtonOnClickedClose(ActionEvent event) {
        MMRadioButton.setSelected(true);
        loyalCustomerClose.setDisable(true);
        directDepositClose.setDisable(true);
    }

    /**
     * Savings account type button clicked in the close account tab
     * @param event
     */
    @FXML
    void savingsButtonOnClickedClose(ActionEvent event) {
        SavingsRadioButton.setSelected(true);
        directDepositClose.setDisable(true);
        loyalCustomerClose.setDisable(false);
    }

    /**
     * Checking account type button clicked in the close account tab
     * @param event
     */
    @FXML
    void checkingButtonOnClickedClose(ActionEvent event) {
        CheckingRadioButton.setSelected(true);
        loyalCustomerClose.setDisable(true);
        directDepositClose.setDisable(false);
    }

    /**
     * Checking account type button clicked in the deposit tab
     * @param event
     */
    @FXML
    void checkingButtonOnClickedDeposit(ActionEvent event) {
        CheckingRadioButton.setSelected(true);
    }

    /**
     * Checking account type button clicked in the withdraw tab
     * @param event
     */
    @FXML
    void checkingButtonOnClickedWithdraw(ActionEvent event) {
        CheckingRadioButton.setSelected(true);
    }

    /**
     * MoneyMarket account type button clicked in the deposit tab
     * @param event
     */
    @FXML
    void mmButtonOnClickedDeposit(ActionEvent event) {
        MMRadioButton.setSelected(true);
    }

    /**
     * MoneyMarket account type button clicked in the withdraw tab
     * @param event
     */
    @FXML
    void mmButtonOnClickedWithdraw(ActionEvent event) {
        MMRadioButton.setSelected(true);
    }

    /**
     * Savings account type button clicked in the deposit tab
     * @param event
     */
    @FXML
    void savingsButtonOnClickedDeposit(ActionEvent event) {
        SavingsRadioButton.setSelected(true);
    }


    /**
     * Savings account type button clicked in the withdraw tab
     * @param event
     */
    @FXML
    void savingsButtonOnClickedWithdraw(ActionEvent event) {
        SavingsRadioButton.setSelected(true);
    }

    /**
     * Close an existing Checking, Savings, or MoneyMarket account.
     * @param event
     */
    @FXML
    void closeAccount(ActionEvent event) {

        try {
            Profile prof = new Profile();
            prof.setFname(firstNameClose.getText());
            prof.setLname(lastNameClose.getText());
            Date tempDate = new Date(1, 1, 1);

            if (MMRadioButton.isSelected() == true) {
                MoneyMarket temp = new MoneyMarket(prof, 0.0, tempDate, 0);
                boolean x = accDB.remove(temp);

            } else if (SavingsRadioButton.isSelected() == true) {
                Savings temp = new Savings(prof, 0.0, tempDate);
                boolean x = accDB.remove(temp);

            } else if (CheckingRadioButton.isSelected() == true) {
                Checking temp = new Checking(prof, 0.0, tempDate);
                boolean x = accDB.remove(temp);
            } else {
                //print error
            }


        } catch (Exception e) {

        }


    }

    /**
     * Open a new Checking, Savings, or MoneyMarket account.
     * @param event
     */
    @FXML
    void openAccount(ActionEvent event) {
        try {

            Profile prof = new Profile(firstNameOpen.getText(),lastNameOpen.getText() );

            int year = Integer.parseInt(yearOpen.getText());
            int month = Integer.parseInt(monthOpen.getText());
            int day = Integer.parseInt(dayOpen.getText());
            Date tempDate = new Date(year, month, day);

            boolean a = tempDate.isValid();
            // PRINT ERROR IF NOT

            double amount = Double.parseDouble(balanceOpen.getText());


            if (MMRadioButton.isSelected() == true) {
                int withdraw = 0;
                MoneyMarket temp = new MoneyMarket(prof, amount, tempDate, withdraw);
                boolean x = accDB.add(temp);

            } else if (SavingsRadioButton.isSelected() == true) {
                boolean loyalty = loyalCustomerOpen.isSelected();
                Savings temp = new Savings(prof, amount, tempDate, loyalty);
                boolean x = accDB.add(temp);

            } else if (CheckingRadioButton.isSelected() == true) {
                boolean dDeposit = directDepositOpen.isSelected();
                Checking temp = new Checking(prof, amount, tempDate, dDeposit);
                boolean x = accDB.add(temp);
            }

        } catch (Exception e) {

        }

    }

    /**
     * Deposit funds into an existing account
     * @param event
     */
    @FXML
    void deposit(ActionEvent event) {
        try {
            Profile prof = new Profile();
            prof.setFname(firstNameDeposit.getText());
            prof.setLname(lastNameDeposit.getText());
            Date tempDate = new Date(1, 1, 1);


            double depositAmount = Double.parseDouble(amountDeposit.getText()); // Temp

            if (MMRadioButton.isSelected()) {
                MoneyMarket temp = new MoneyMarket(prof, 0.0, tempDate, 0);
                boolean x = accDB.deposit(temp, depositAmount);

                if(x) {
                    outputArea.appendText("Deposit Successful...");
                }
                else{
                    outputArea.appendText("Deposit Failed...");
                }

            } else if (SavingsRadioButton.isSelected()) {
                Savings temp = new Savings(prof, 0.0, tempDate);
                boolean x = accDB.deposit(temp, depositAmount);

                if(x) {
                    outputArea.appendText("Deposit Successful...");
                }
                else{
                    outputArea.appendText("Deposit Failed...");
                }

            } else if (CheckingRadioButton.isSelected()) {
                Checking temp = new Checking(prof, 0.0, tempDate);
                boolean x = accDB.deposit(temp, depositAmount);

                if(x) {
                    outputArea.appendText("Deposit Successful...");
                }
                else{
                    outputArea.appendText("Deposit Failed...");
                }
            }


        } catch (Exception e) {

        }

    }

    /**
     * Withdraw an amount from an existing account.
     * @param event
     */
    @FXML
    void withdraw(ActionEvent event) {
        try {
            Profile prof = new Profile();
            prof.setFname(firstNameWithdraw.getText());
            prof.setLname(lastNameWithdraw.getText());
            Date tempDate = new Date(1, 1, 1);
            double withdrawalAmount = Double.parseDouble(amountWithdraw.getText());


            if (MMRadioButton.isSelected()) {
                MoneyMarket temp = new MoneyMarket(prof, 0.0, tempDate);
                int x = accDB.withdrawal(temp, withdrawalAmount);
                // IF X == -1 PRINT INSUFFICIENT FUNDS, IF X==0 THEN SUCCESSFUL WITHDRAWAL, IF X==(any other number) PRINT ACCOUNT DOESN'T EXIST
                if(x == -1) {
                    outputArea.appendText("Insufficient Funds...\n");
                }
                else if(x == 0) {
                    outputArea.appendText("Withdrawal Successful...");
                }
                else {
                    outputArea.appendText("Account Does Not Exist...");
                }

            } else if (SavingsRadioButton.isSelected()) {
                Savings temp = new Savings(prof, 0.0, tempDate);
                int x = accDB.withdrawal(temp, withdrawalAmount);
                // IF X == -1 PRINT INSUFFICIENT FUNDS, IF X==0 THEN SUCCESSFUL WITHDRAWAL, IF X==(any other number) PRINT ACCOUNT DOESN'T EXIST
                if(x == -1) {
                    outputArea.appendText("Insufficient Funds...\n");
                }
                else if(x == 0) {
                    outputArea.appendText("Withdrawal Successful...");
                }
                else {
                    outputArea.appendText("Account Does Not Exist...");
                }

            } else if (CheckingRadioButton.isSelected()) {
                Checking temp = new Checking(prof, 0.0, tempDate);
                int x = accDB.withdrawal(temp, withdrawalAmount);
                // IF X == -1 PRINT INSUFFICIENT FUNDS, IF X==0 THEN SUCCESSFUL WITHDRAWAL, IF X==(any other number) PRINT ACCOUNT DOESN'T EXIST
                if(x == -1) {
                    outputArea.appendText("Insufficient Funds...\n");
                }
                else if(x == 0) {
                    outputArea.appendText("Withdrawal Successful...");
                }
                else {
                    outputArea.appendText("Account Does Not Exist...");
                }

            }

        } catch (Exception e) {

        }

    }

    /**
     * Export an Account Database to an existing text file
     * @param event
     */
    @FXML
    void exportFile(ActionEvent event) throws IOException {

        FileChooser fc = new FileChooser();
        fc.setTitle("Open Target File for Export");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targetFile = fc.showSaveDialog(stage);

        FileOutputStream fos = new FileOutputStream(targetFile);
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(fos));
        dos.flush();
        dos.writeUTF(accDB.printAccounts());
        dos.close();
        outputArea.appendText("File Exported...");
    }



    /**
     * Import an Account Database from a text file
     * Calls createAccount and createDate helper methods
     * @param event
     * @throws FileNotFoundException
     */
    @FXML
    void importFile(ActionEvent event) throws FileNotFoundException {

        FileChooser fc = new FileChooser();
        fc.setTitle("Open Source File for Import");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),new FileChooser.ExtensionFilter("All Files", "*.*"));

        Stage stage = new Stage();
        File sourceFile = fc.showOpenDialog(stage);

        Scanner scan = new Scanner(sourceFile);

        while (scan.hasNextLine()) {

            accDB.add(createAccount(scan.nextLine()));  //Each line from file is an account
        }


        outputArea.appendText("File Imported.\n");
        outputArea.appendText(accDB.printAccounts());

    }


    /**
     * Creates an Account  from each line of a CSV file
     * Helper Method for import method
     * @param line from CSV file
     * @return Account created from each line
     */
    private Account createAccount(String line) {


        String accType="", fname="", lname="", datestr="",accSpecific=""  ;
        double balanace = 0.0;

        StringTokenizer st = new StringTokenizer(line, ",");   //Split string into tokens by ,
        while (st.hasMoreTokens()) {

            accType = st.nextToken();
            fname = st.nextToken();
            lname = st.nextToken();
            balanace = Double.parseDouble(st.nextToken());
            datestr = st.nextToken();
            accSpecific = st.nextToken(); //Direct deposit, Loyal, withdrawals (type handled on obj creation)
        }

        Profile prof = new Profile();
        prof.setFname(fname);
        prof.setLname(lname);
        createDate(datestr);
        Account temp = null;

        if(accType.compareTo("S") == 0) {

            temp = new Savings(prof, balanace, createDate(datestr), Boolean.parseBoolean(accSpecific));
        
        }

        else if(accType.compareTo("C") == 0) {

            temp = new Checking(prof, balanace,createDate(datestr), Boolean.parseBoolean(accSpecific));

        }

        else if(accType.compareTo("M") == 0) {

            temp = new MoneyMarket(prof,balanace, createDate(datestr), Integer.parseInt(accSpecific));

        }

        return temp;
    }

    /**
     * Creates a Date from a  date string ("mm/dd/yyyy")
     * Helper method for import
     * @param datestr date in string format
     * @return Date object from string
     */
    private Date createDate(String datestr) {

        StringTokenizer stDate = new StringTokenizer(datestr, "/");
        int month=0, day=0, year=0;
        while (stDate.hasMoreTokens()) {
            month = Integer.parseInt(stDate.nextToken());
            day = Integer.parseInt(stDate.nextToken());
            year = Integer.parseInt(stDate.nextToken());
        }

        return new Date(year, month, day);
    }

    /**
     * Prints accounts in the database when the button is pressed.
     * @param event
     */
    @FXML
    void printAccounts(ActionEvent event) {

        outputArea.appendText("Printing Accounts...\n");
        outputArea.appendText(accDB.printAccounts());
        outputArea.appendText("End of Database...\n");
    }

    /**
     * Prints accounts by Name ordering when the button is pressed.
     * @param event
     */
    @FXML
    void printAccountsByName(ActionEvent event) {

        outputArea.appendText("Printing Accounts By Last Name...\n");
        outputArea.appendText(accDB.printByLastName());
        outputArea.appendText("End of Database...\n");
    }

    /**
     * Prints accounts by Date ordering when the button is pressed.
     * @param event
     */
    @FXML
    void printAccountsByDate(ActionEvent event) {

        outputArea.appendText("Printing Accounts By the Date Opened...\n");
        outputArea.appendText(accDB.printByDateOpen());
        outputArea.appendText("End of Database...\n");
    }


}