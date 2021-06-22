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

public class alias_Controller implements Initializable {
    public TextField aliass;
    public TextField shomareHesab;
    public Button khadamatk;
    public Button conti;

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

    public void setAliass(ActionEvent event) {
        String aliassText = aliass.getText();
    }

    public void setShomareHesab(ActionEvent event) {
        String shomareHesabText = shomareHesab.getText();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


