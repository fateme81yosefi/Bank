package Graphics.Controller;

import Core.Bank;
import Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Core.Account.AccType.*;

public class newaccount_Controller implements Initializable {
    public PasswordField ramz;
    public Button conti;/////////////////////
    public Button khadamatk;
    public TextField codemelli;
    public TextField noeAcc;

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
    public void validate(ActionEvent event) throws IOException {
        String ramz1=ramz.getText();
        String codemelliText=codemelli.getText();
        String noeHesab=noeAcc.getText();
        Stage stage;
        Parent root;
        if (ramz1.isEmpty()||codemelliText.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else {
            switch (noeHesab){
                case "GHARZOLHASANE_JARI": {
                    int x=Bank.addAcc(codemelliText, GHARZOLHASANE_JARI, ramz1);
                   if (x==-1){
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("کد ملی کاربر اشتباه است!");
                        alert.showAndWait();
                    }else {
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
                case "GHARZOLHASANE_PASANDAZ": {
                    int x=Bank.addAcc(codemelliText, GHARZOLHASANE_PASANDAZ, ramz1);
                    if (x==-1){
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("کد ملی کاربر اشتباه است!");
                        alert.showAndWait();
                    }else {
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
                case "SEPORDE_BOLANDMODAT": {
                    int x=Bank.addAcc(codemelliText, SEPORDE_BOLANDMODAT, ramz1);
                  if (x==-1){
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("کد ملی کاربر اشتباه است!");
                        alert.showAndWait();
                    }else {
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
                case "SEPORDE_KOTAHMODAT": {
                    int x=Bank.addAcc(codemelliText, SEPORDE_KOTAHMODAT, ramz1);
                    if (x==-1){
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("کد ملی کاربر اشتباه است!");
                        alert.showAndWait();
                    }else {
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
                default:{
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("نوع حساب را به درستی وارد کنید!");
                    alert.showAndWait();
                }
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}