package Graphics.Controller;

import Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class vorodUser_Controller implements Initializable {

    public PasswordField codemelli;
    public PasswordField ramz;
    public Button conti;
    public Button menuAsli;

    public void setAllButten(ActionEvent event)throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(conti)){
            stage=(Stage) conti.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Graphics/Fxml/EntekhabKhadamatUser.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(menuAsli)){
            stage=(Stage) menuAsli.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Graphics/Fxml/MenuAsli.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void setCodemelli(ActionEvent event){
        String codemelliText=codemelli.getText();
    }
    public void setRamz(ActionEvent event){
        String ramzText=ramz.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
