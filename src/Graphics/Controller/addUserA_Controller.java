package Graphics.Controller;

import Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class addUserA_Controller  implements Initializable {

        public TextField name;
        public TextField codemeli;
        public TextField phone;
        public TextField email;
        public Button conti;
        public PasswordField ramz;
        public Button menuAdmin;

    public void setRamz(ActionEvent event) {
        String ramzText = ramz.getText();
    }
    public void setEmail(ActionEvent event) {
        String emailText = email.getText();
    }
    public void setPhone(ActionEvent event) {
        String phoneText = phone.getText();
    }
    public void setCodemeli(ActionEvent event) {
        String codemeliText = codemeli.getText();
    }
    public void setName(ActionEvent event) {
        String nameText= name.getText();
    }
    public void setAllButten(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(menuAdmin)) {
            stage = (Stage) menuAdmin.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Graphics/Fxml/adminkhadamat.fxml"));
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


