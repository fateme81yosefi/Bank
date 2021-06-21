package Graphics.Controller;

import Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class editUserInfoA_Controller implements Initializable {
    public TextField name;
    public TextField phone;
    public TextField email;
    public TextField mojodi;
    public TextField pass;
    public TextField codemelli;
    public Button conti;
    public Button adminmenu;

    public void setName(ActionEvent event){
        String nameText=name.getText();
    }
    public void setRamz(ActionEvent event){
        String ramzText=pass.getText();
    }
    public void setMojodi(ActionEvent event){
        String mojodiText=mojodi.getText();
    }
    public void setCodemeli(ActionEvent event){
        String codemeliText=codemelli.getText();
    }
    public void setPhone(ActionEvent event){
        String phoneText=phone.getText();
    }
    public void setEmail(ActionEvent event){
        String emailText=email.getText();
    }

    public void setAllButten(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(adminmenu)) {
            stage = (Stage) adminmenu.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Graphics/Fxml/adminKhadamat.fxml"));
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


