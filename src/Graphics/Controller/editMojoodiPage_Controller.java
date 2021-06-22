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

public class editMojoodiPage_Controller  implements Initializable {
    public TextField mojodiJadid;
    public Button conti;
    public Button adminMenu;//

    public void setAllButten(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(adminMenu)) {
            stage = (Stage) adminMenu.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/adminkhadamat.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void setMojodiJadid(ActionEvent event) {
        String mojodiJadidText = mojodiJadid.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
