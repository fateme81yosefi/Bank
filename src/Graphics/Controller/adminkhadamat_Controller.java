package Graphics.Controller;

import Graphics.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminkhadamat_Controller implements Initializable {
    public Button moshahedeEtelaatK;
    public Button closeAcc;
    public Button createNewAcc;
    public Button EditInfoUser;
    public Button editMojodi;
    public Button enteghalVajh;
    public Button creatNewUser;

    public void setAllButten(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(EditInfoUser)) {
            stage = (Stage) EditInfoUser.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/editUserInfoA.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(moshahedeEtelaatK)) {
            stage = (Stage) moshahedeEtelaatK.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/moshahedeInfoA.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(editMojodi)) {
            stage = (Stage) editMojodi.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/editMojoodiPage.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(enteghalVajh)) {
            stage = (Stage) enteghalVajh.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/entehalvajhA.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(closeAcc)) {
            stage = (Stage) closeAcc.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/closeAccbyA.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(createNewAcc)) {
            stage = (Stage) createNewAcc.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/newaccountA.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(creatNewUser)) {
            stage = (Stage) creatNewUser.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/addUserA.fxml"));
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
