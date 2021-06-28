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

public class entehalvajhA_Controller  implements Initializable {
    public TextField codeMabda;
    public TextField codeMaghsad;
    public PasswordField passMabda;
    public PasswordField passMaghsad;
    public Button conti;
    public TextField Mablagh;
    public Button menuAdmin;

    public void validate(ActionEvent event) throws IOException {
        String codeMabdaText=codeMabda.getText();
        String codeMaghsadText=codeMaghsad.getText();
        String passMabdaText=passMabda.getText();
        String passMaghsadText=passMaghsad.getText();
        String mablaghText=Mablagh.getText();


        if (codeMabdaText.isEmpty()||codeMaghsadText.isEmpty()||passMabdaText.isEmpty()||passMaghsadText.isEmpty()||mablaghText.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }}
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
