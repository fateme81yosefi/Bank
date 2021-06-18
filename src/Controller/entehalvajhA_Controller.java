package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class entehalvajhA_Controller {
    public TextField codeMabda;
    public TextField codeMaghsad;
    public PasswordField passMabda;
    public PasswordField passMaghsad;
    public Button conti;
    public TextField Mablagh;
    public Button menuAdmin;


    public void setAllButten(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(menuAdmin)) {
            stage = (Stage) menuAdmin.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/adminkhadamat.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void setCodeMabda(ActionEvent event) {
        String codeMabdaText = codeMabda.getText();
    }
    public void setCodeMaghsad(ActionEvent event) {
        String codeMaghsadText = codeMaghsad.getText();
    }
    public void setPassMabda(ActionEvent event) {
        String passMabdaText = passMabda.getText();
    }
    public void setPassMaghsad(ActionEvent event) {
        String passMaghsadText = passMaghsad.getText();
    }
    public void setMablagh(ActionEvent event) {
        String mablaghText = Mablagh.getText();
    }

}
