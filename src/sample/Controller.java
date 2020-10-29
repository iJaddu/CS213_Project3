package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.StringTokenizer;

public class Controller {
    AccountDatabase accDB = new AccountDatabase();

    @FXML
    private TextField firstNameOpen, lastNameOpen, balanceOpen, firstNameClose, lastNameClose, balanceClose, firstNameDeposit, firstNameWithdraw, lastNameDeposit, lastNameWithdraw, amountDeposit, amountWithdraw, monthOpen, dayOpen, yearOpen, monthClose, dayClose, yearClose;

    @FXML
    private Button openAccountButton, closeAccountButton, clearButtonOpen, accountType, clearButtonClose, depositButton, withdrawButton, importButton, exportButton;

    @FXML
    private RadioButton CheckingRadioButton, SavingsRadioButton, MMRadioButton;

    @FXML
    private CheckBox directDepositOpen, loyalCustomerOpen, directDepositClose, loyalCustomerClose;

    @FXML
    private TextArea outputArea;

    @FXML
    private ToggleGroup acctype;


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
    }


    @FXML
    void mmButtonOnClickedOpen(ActionEvent event){
        loyalCustomerOpen.setDisable(true);
        directDepositOpen.setDisable(true);
    }

    @FXML
    void savingsButtonOnClickedOpen(ActionEvent event){
        directDepositOpen.setDisable(true);
        loyalCustomerOpen.setDisable(false);
    }

    @FXML
    void checkingButtonOnClickedOpen(ActionEvent event){
        loyalCustomerOpen.setDisable(true);
        directDepositOpen.setDisable(false);
    }

    @FXML
    void mmButtonOnClickedClose(ActionEvent event){
        loyalCustomerClose.setDisable(true);
        directDepositClose.setDisable(true);
    }

    @FXML
    void savingsButtonOnClickedClose(ActionEvent event){
        directDepositClose.setDisable(true);
        loyalCustomerClose.setDisable(false);
    }

    @FXML
    void checkingButtonOnClickedClose(ActionEvent event){
        loyalCustomerClose.setDisable(true);
        directDepositClose.setDisable(false);
    }




    @FXML
    void closeAccount(ActionEvent event) {

        try{
            Profile prof = new Profile();
            prof.setFname(firstNameClose.getText());
            prof.setLname(lastNameClose.getText());
            Date tempDate = new Date(1, 1, 1);

            if(MMRadioButton.isSelected()){
                MoneyMarket temp = new MoneyMarket(prof, 0.0, tempDate, 0);
                boolean x = accDB.remove(temp);

            }else if(SavingsRadioButton.isSelected()){
                Savings temp = new Savings(prof, 0.0, tempDate);
                boolean x = accDB.remove(temp);

            }else if(CheckingRadioButton.isSelected()){
                Checking temp = new Checking(prof, 0.0, tempDate);
                boolean x = accDB.remove(temp);
            }else{
                //print error
            }


        }catch (Exception e){

        }


    }

    @FXML
    void openAccount(ActionEvent event) {
        try{

            Profile prof = new Profile();
            prof.setFname(firstNameClose.getText());
            prof.setLname(lastNameClose.getText());

            int year = Integer.parseInt(yearOpen.getText());
            int month = Integer.parseInt(monthOpen.getText());
            int day = Integer.parseInt(dayOpen.getText());
            Date tempDate = new Date(year, month, day);

            boolean a = tempDate.isValid();
            // PRINT ERROR IF NOT

            double amount = Double.parseDouble(balanceOpen.getText());


            if(MMRadioButton.isSelected()){
                int withdraw = 0;
                MoneyMarket temp = new MoneyMarket(prof, amount, tempDate, withdraw);
                boolean x = accDB.add(temp);

            }else if(SavingsRadioButton.isSelected()){
                boolean loyalty = loyalCustomerOpen.isSelected();
                Savings temp = new Savings(prof, amount, tempDate, loyalty);
                boolean x = accDB.add(temp);

            }else if(CheckingRadioButton.isSelected()){
                boolean dDeposit = directDepositOpen.isSelected();
                Checking temp = new Checking(prof, amount, tempDate, dDeposit);
                boolean x = accDB.add(temp);
            }

        }catch (Exception e){

        }

    }

    @FXML
    void deposit(ActionEvent event) {
        try{
            Profile prof = new Profile();
            prof.setFname(firstNameDeposit.getText());
            prof.setLname(lastNameDeposit.getText());
            Date tempDate = new Date(1, 1, 1);


            double depositAmount = Double.parseDouble(amountDeposit.getText()); // Temp

            if(MMRadioButton.isSelected()){
                MoneyMarket temp = new MoneyMarket(prof, 0.0, tempDate, 0);
                boolean x = accDB.deposit(temp, depositAmount);

            }else if(SavingsRadioButton.isSelected()){
                Savings temp = new Savings(prof, 0.0, tempDate);
                boolean x = accDB.deposit(temp, depositAmount);

            }else if(CheckingRadioButton.isSelected()){
                Checking temp = new Checking(prof, 0.0, tempDate);
                boolean x = accDB.deposit(temp, depositAmount);
            }


        }catch (Exception e){

        }

    }

    @FXML
    void withdraw(ActionEvent event) {
        try{
            Profile prof = new Profile();
            prof.setFname(firstNameWithdraw.getText());
            prof.setLname(lastNameWithdraw.getText());
            Date tempDate = new Date(1, 1, 1);
            double withdrawalAmount = Double.parseDouble(amountWithdraw.getText());


            if(MMRadioButton.isSelected()){
                MoneyMarket temp = new MoneyMarket(prof, 0.0, tempDate);
                int x = accDB.withdrawal(temp, withdrawalAmount);
                // IF X == -1 PRINT INSUFFICIENT FUNDS, IF X==0 THEN SUCCESSFUL WITHDRAWAL, IF X==(any other number) PRINT ACCOUNT DOESN'T EXIST

            }else if(SavingsRadioButton.isSelected()){
                Savings temp = new Savings(prof, 0.0, tempDate);
                int x = accDB.withdrawal(temp, withdrawalAmount);
                // IF X == -1 PRINT INSUFFICIENT FUNDS, IF X==0 THEN SUCCESSFUL WITHDRAWAL, IF X==(any other number) PRINT ACCOUNT DOESN'T EXIST

            }else if(CheckingRadioButton.isSelected()){
                Checking temp = new Checking(prof, 0.0, tempDate);
                int x = accDB.withdrawal(temp, withdrawalAmount);
                // IF X == -1 PRINT INSUFFICIENT FUNDS, IF X==0 THEN SUCCESSFUL WITHDRAWAL, IF X==(any other number) PRINT ACCOUNT DOESN'T EXIST

            }

        }catch (Exception e){

        }

    }

    @FXML
    void exportFile(ActionEvent event) {

    }

    @FXML
    void importFile(ActionEvent event) {

    }


}
