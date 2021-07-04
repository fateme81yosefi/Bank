package Graphics.Controller;

import Graphics.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class movafagh_Controller {

    public Button menuUser;
    public Button exit;
    public void setAllButten(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(menuUser)) {
            stage = (Stage) menuUser.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/EntekhabKhadamatUser.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(exit)) {
            System.exit(0);
        }
    }
}
