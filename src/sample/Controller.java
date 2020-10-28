package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.StringTokenizer;

public class Controller {

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
            if(MMRadioButton.isSelected()){

            }else if(SavingsRadioButton.isSelected()){

            }else if(CheckingRadioButton.isSelected()){

            }

            Profile profile = new Profile();
            profile.setFname(firstNameClose.getText());
            profile.setLname(lastNameClose.getText());

        }catch (Exception e){

        }


    }

    @FXML
    void openAccount(ActionEvent event) {
        try{
            if(MMRadioButton.isSelected()){

            }else if(SavingsRadioButton.isSelected()){

            }else if(CheckingRadioButton.isSelected()){

            }

            Profile profile = new Profile();
            profile.setFname(firstNameClose.getText());
            profile.setLname(lastNameClose.getText());

            int year = Integer.parseInt(yearOpen.getText());
            int month = Integer.parseInt(monthOpen.getText());
            int day = Integer.parseInt(dayOpen.getText());
            Date date = new Date(year, month, day);




            double depositAmount = Double.parseDouble(amountDeposit.getText()); // Temp



        }catch (Exception e){

        }

    }

    @FXML
    void deposit(ActionEvent event) {
        try{
            Profile profile = new Profile();
            profile.setFname(firstNameDeposit.getText());
            profile.setLname(lastNameDeposit.getText());

        }catch (Exception e){

        }

    }

    @FXML
    void withdraw(ActionEvent event) {
        try{
            Profile profile = new Profile();
            profile.setFname(firstNameWithdraw.getText());
            profile.setLname(lastNameWithdraw.getText());
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
