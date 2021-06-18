package Controller;

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

public class Admin_controller implements Initializable{

    public TextField fieldCode;
    public PasswordField fieldPass;
    public Button returnToMain;
    public Button save;

    public void setAllButten(ActionEvent event)throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(returnToMain)){
            stage=(Stage)returnToMain.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/MenuAsli.fxml"));//vared kardan ramz by user
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


    public void setRamz(ActionEvent event) {
        String ramzText = fieldPass.getText();
    }
    public void setFieldCode(ActionEvent event) {
        String fieldCodeText = fieldCode.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
