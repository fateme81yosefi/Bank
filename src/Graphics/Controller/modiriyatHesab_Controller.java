package Graphics.Controller;

import Core.Bank;
import Graphics.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class modiriyatHesab_Controller implements Initializable {
    public TextField codemeli;
    public PasswordField ramz;
    public TextField phone;
    public TextField mojodi;
    public TextField name;
    public TextField email;
    public TextField alias;
    public Button newAcc;
    public Button conti;
    public Button khadamatUser;
    public Button profile;
    public TextField accNum;
    public TextField codemelli;
    public Button setAlias;

    public void validate(ActionEvent event) throws IOException {

        String codemelliText = codemelli.getText();
        String accNumText = accNum.getText();

        if (codemelliText.isEmpty() || accNumText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }

    }


    public void setAllButten(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(khadamatUser)) {
            stage = (Stage) khadamatUser.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/EntekhabKhadamatUser.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(newAcc)) {
            stage = (Stage) newAcc.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/newaccount.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(setAlias)) {
            stage = (Stage) setAlias.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/alias.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(profile)) {
            stage = (Stage) profile.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/moshahedeInfo.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

