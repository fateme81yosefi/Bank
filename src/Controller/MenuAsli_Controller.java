package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuAsli_Controller implements Initializable {

    public Button bettenAdmin;
    public Button buttenUser;
    public Button about;
    public Button exit;
    public Label label;

    public void setAllButten(ActionEvent event)throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(buttenUser)){
            stage=(Stage) buttenUser.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/EnterPage.fxml"));//vared kardan ramz by user
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(bettenAdmin)){
            stage=(Stage) buttenUser.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/Admin.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(about)){
            stage=(Stage) about.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/aboutUs.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(exit)){
            System.exit(0);
        }
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
