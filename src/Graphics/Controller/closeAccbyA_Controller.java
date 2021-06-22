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

public class closeAccbyA_Controller  implements Initializable {
    public PasswordField pass;
    public TextField codemelli;
    public TextField shomaremaghsad;
    public Button AdminMenu;//
    public Button conti;

    public void setAllButten(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(AdminMenu)) {
            stage = (Stage) AdminMenu.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/adminkhadamat.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void setRamz(ActionEvent event) {
        String passText = pass.getText();
    }
    public void setCodemelli(ActionEvent event) {
        String codemelliText = codemelli.getText();
    }
    public void setShomaremaghsad(ActionEvent event) {
        String shomaremaghsadText = shomaremaghsad.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}