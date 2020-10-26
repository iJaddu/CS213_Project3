package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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
    void clearTextFields(ActionEvent event) {

    }

    @FXML
    void closeAccount(ActionEvent event) {

    }

    @FXML
    void openAccount(ActionEvent event) {

    }

    @FXML
    void deposit(ActionEvent event) {

    }

    @FXML
    void withdraw(ActionEvent event) {

    }

}
