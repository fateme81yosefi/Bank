package Graphics.Controller;

import Core.Bank;
import Core.User;
import Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginAcc_Controller {
    public PasswordField pass;
    public Button menu;
    public Button login;
    public TextField accNum;
    public User log;
    public void validate(ActionEvent event) throws IOException {
        String passText=pass.getText();
        String accNumText=accNum.getText();

        if (passText.isEmpty()||accNumText.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else if(Bank.getIndexAcc(accNumText,passText,log)==-1){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("حساب نامعتبراست!!!!");
            alert.showAndWait();
        }
    }

    public void setAccNum(ActionEvent event) {
        String accNumText = accNum.getText();
    }

    public void setPass(ActionEvent event) {
        String passText = pass.getText();
    }
    public void setAllButten(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(menu)) {
            stage = (Stage) menu.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/EntekhabKhadamatUser.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(login)) {
            stage = (Stage) login.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
          //  fxmlLoader.setLocation(App.class.getResource("Fxml/EntekhabKhadamatUser.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
