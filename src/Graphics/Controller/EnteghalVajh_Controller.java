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

public class EnteghalVajh_Controller implements Initializable {


    public TextField mablagh;
    public TextField shomareMaghsad;
    public PasswordField password;
    public Button conti;
    public Button khadamatPage;


    public void setAllButten(ActionEvent event)throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(khadamatPage)){
            stage=(Stage) khadamatPage.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/EntekhabKhadamatUser.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void setPassword(ActionEvent event){
        String p=password.getText();
    }
    public void setMablagh(ActionEvent event){
        String money=mablagh.getText();
    }
    public void setShomareMaghsad(ActionEvent event){
        String shomaremaghsad=shomareMaghsad.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}