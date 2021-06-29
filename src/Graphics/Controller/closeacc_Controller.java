package Graphics.Controller;

import Core.Bank;
import Core.User;
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

public class closeacc_Controller  implements Initializable {
    public PasswordField ramz;
    public TextField shomareHasabMaghsad;
    public Button conti;///////
    public Button khadamatk;
    public TextField accNum;
    User login;
    public void validate(ActionEvent event) throws IOException {
        String ramz1=ramz.getText();
        String shomareHasabMaghsadText=shomareHasabMaghsad.getText();
        String accNum1=accNum.getText();


        if (ramz1.isEmpty()||shomareHasabMaghsadText.isEmpty()||accNum1.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else if(Bank.getIndexAcc()){

                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("حساب نامعتبراست!!!!");
                alert.showAndWait();
        }
    }
    public void setRamz(ActionEvent event) {
        String ramzText = ramz.getText();
    }
    public void setShomareHasabMaghsad(ActionEvent event) {
        String shomareHasabMaghsadText = shomareHasabMaghsad.getText();
    }
    public void setAccNum(ActionEvent event){
        String accNum1=accNum.getText();
    }

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
