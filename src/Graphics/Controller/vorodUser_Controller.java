package Graphics.Controller;

import Core.Bank;
import Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    public void validate(ActionEvent event) throws IOException {


        String ramzText=ramz.getText();
        String codemelliText=codemelli.getText();
        Stage stage;
        Parent root;

        if (ramzText.isEmpty()||codemelliText.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        } else {
            int x= Bank.getIndexUser(codemelliText);
            if (x==-1) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("حسابی با این مشخصات موجود نیست!");
                alert.showAndWait();
            }else {
                stage=(Stage) menuAsli.getScene().getWindow();
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(App.class.getResource("Fxml/EntekhabKhadamatUser.fxml"));
                root=fxmlLoader.load();

                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
    }
    }
    public void setAllButten(ActionEvent event)throws IOException {
        Stage stage;
        Parent root;

        if (event.getSource().equals(menuAsli)){
            stage=(Stage) menuAsli.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/MenuAsli.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
