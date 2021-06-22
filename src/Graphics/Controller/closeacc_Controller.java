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

public class closeacc_Controller  implements Initializable {
    public PasswordField ramz;
    public TextField mojodiFeli;
    public TextField shomareHasabMaghsad;
    public Button conti;///////
    public Button khadamatk;

    public void setRamz(ActionEvent event) {
        String ramzText = ramz.getText();
    }
    public void setMojodiFeli(ActionEvent event) {
        String mojodiFeliText = mojodiFeli.getText();
    }
    public void setShomareHasabMaghsad(ActionEvent event) {
        String shomareHasabMaghsadText = shomareHasabMaghsad.getText();
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
