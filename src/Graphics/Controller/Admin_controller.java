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

public class Admin_controller implements Initializable{
    public String admincod="926071874";
    public String adminpass="1212";
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
        if (event.getSource().equals(save)){
            stage=(Stage)save.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/adminkhadamat.fxml"));//vared kardan ramz by user
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


    public void validate(ActionEvent event) throws IOException {
        String code=fieldCode.getText();
        String pass=fieldPass.getText();
        if (code.isEmpty()||pass.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("please fill all required fields !");
            alert.showAndWait();
        }else {
            if (code.equals(admincod)&&pass.equals(adminpass)){
                {
                    Stage stage;
                    Parent root;
                    stage=(Stage)returnToMain.getScene().getWindow();
                    FXMLLoader fxmlLoader=new FXMLLoader();
                    fxmlLoader.setLocation(App.class.getResource("Fxml/MenuAsli.fxml"));//vared kardan ramz by user
                    root=fxmlLoader.load();

                    Scene scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
