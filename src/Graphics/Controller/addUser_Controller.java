package Graphics.Controller;

import Core.Bank;
import Graphics.App;
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

public class addUser_Controller implements Initializable {
    public TextField codemeli;
    public TextField phone;
    public TextField name;
    public TextField email;
    public Button conti;
    public Button khadamatk;
    public PasswordField ramz;

    public void validate(ActionEvent event) throws IOException {
        String codemeliText=codemeli.getText();
        String phone1=phone.getText();
        String name1=name.getText();
        String email1=email.getText();
        String ramz1=ramz.getText();
        Stage stage;
        Parent root;

        if (codemeliText.isEmpty()||phone1.isEmpty()||name1.isEmpty()||email1.isEmpty()||ramz1.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else {
            Bank.addUser(name1,codemeliText,ramz1,phone1,email1);
            System.out.println("عملیات با موفقیت انجام شد");
            stage = (Stage) conti.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/movafagh.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void setAllButten(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(khadamatk)) {
            stage = (Stage) khadamatk.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/EntekhabKhadamatUser.fxml"));
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




