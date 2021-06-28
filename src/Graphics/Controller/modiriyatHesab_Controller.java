package Graphics.Controller;

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

public class modiriyatHesab_Controller  implements Initializable {
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
    public void validate(ActionEvent event) throws IOException {
        String codemeliText=codemeli.getText();
        String phone1=phone.getText();
        String name1=name.getText();
        String email1=email.getText();
        String ramz1=ramz.getText();
        String mojodiText1=mojodi.getText();

        if (codemeliText.isEmpty()||phone1.isEmpty()||name1.isEmpty()||email1.isEmpty()||ramz1.isEmpty()||mojodiText1.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }}
    public void setName(ActionEvent event){
        String nameText=name.getText();
    }
    public void setRamz(ActionEvent event){
        String ramzText=ramz.getText();
    }
    public void setMojodi(ActionEvent event){
        String mojodiText=mojodi.getText();
    }
    public void setCodemeli(ActionEvent event){
        String codemeliText=codemeli.getText();
    }
    public void setPhone(ActionEvent event){
        String phoneText=phone.getText();
    }
    public void setAlias(ActionEvent event){
        String aliasText=alias.getText();
    }
    public void setEmail(ActionEvent event){
        String emailText=email.getText();
    }

    public void setAllButten(ActionEvent event)throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(khadamatUser)){
            stage=(Stage) khadamatUser.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/EntekhabKhadamatUser.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(newAcc)){
            stage=(Stage) newAcc.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/newaccount.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

