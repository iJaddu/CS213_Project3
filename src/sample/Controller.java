package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.StringTokenizer;

public class Controller {

    @FXML
    private TextField firstNameOpen, firstNameClose, firstNameDeposit, firstNameWithdraw;

    @FXML
    private TextField lastNameOpen, lastNameClose, lastNameDeposit, lastNameWithdraw;

    @FXML
    private TextField monthOpen, monthClose;

    @FXML
    private TextField balanceOpen, balanceClose;

    @FXML
    private TextField dayOpen, dayClose;

    @FXML
    private TextField yearOpen, yearClose;

    @FXML
    private Button openAccountButton;

    @FXML
    private Button clearButtonOpen;

    @FXML
    private RadioButton accountType;

    @FXML
    private Button closeAccountButton;

    @FXML
    private Button clearButtonClose;

    @FXML
    private TextField amountDeposit, amountWithdraw;

    @FXML
    private Button depositButton;

    @FXML
    private Button withdrawButton;
    @FXML
    private Button importButton, exportButton;
    @FXML
    private TextArea outputArea;

    private TextField dateOpenedDeposit;


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
        monthOpen.clear();
        monthClose.clear();
        balanceOpen.clear();
        balanceClose.clear();
        dayOpen.clear();
        dayClose.clear();
        yearOpen.clear();
        yearClose.clear();
        amountDeposit.clear();
        amountWithdraw.clear();
        dateOpenedDeposit.clear();
        outputArea.clear();
    }

    @FXML
    void closeAccount(ActionEvent event) {

        //Profile profile = new Profile();
        //profile.setFname(firstNameClose.getText());
        //profile.setLname(lastNameClose.getText());
        
    }

    @FXML
    void openAccount(ActionEvent event) {

        //Profile profile = new Profile();
        //profile.setFname(firstNameOpen.getText());
        //profile.setLname(lastNameOpen.getText());

    }

    @FXML
    void deposit(ActionEvent event) {

        /*
        Profile profile = new Profile();
        profile.setFname(firstNameDeposit.getText());
        profile.setLname(lastNameDeposit.getText());

        Date date = new Date(0, 0, 0);
        StringTokenizer st = new StringTokenizer(dateOpenedDeposit.getText(), "/");

        while(st.hasMoreElements()) {
            date.setMonth(st.nextElement());
            date.setDay(st.nextElement());
            date.setYear(st.nextElement());

        }

        double depositAmount = Double.parseDouble(amountDeposit.getText()); // Temp
        */

    }

    @FXML
    void withdraw(ActionEvent event) {

        //Profile profile = new Profile();
        //profile.setFname(firstNameWithdraw.getText());
        //profile.setLname(lastNameWithdraw.getText());

    }
    @FXML
    void importFile(ActionEvent event) {

    }
    @FXML
    void exportFile(ActionEvent event) {

    }

}
