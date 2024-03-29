package Graphics.Controller;

import Core.Bank;
import Graphics.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class entehalvajhA_Controller  implements Initializable {
    public TextField codeMabda;
    public TextField codeMaghsad;
    public Button conti;
    public TextField Mablagh;
    public Button menuAdmin;
    public TextField accNumMabda;
    public TextField accNumMaghsad;

    public void validate(ActionEvent event) throws IOException {

        String codeMabdaText=codeMabda.getText();
        String codeMaghsadText=codeMaghsad.getText();
        String mablaghText=Mablagh.getText();
        String accNumMabdaText=accNumMabda.getText();
        String accNumMaghsadText=accNumMaghsad.getText();
        Stage stage;
        Parent root;

        if (codeMabdaText.isEmpty()||codeMaghsadText.isEmpty() ||mablaghText.isEmpty()||accNumMabdaText.isEmpty()||accNumMaghsadText.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else {
            int x= Bank.enteghalVajhByAdmin(codeMabdaText,codeMaghsadText,accNumMabdaText,accNumMaghsadText,mablaghText);
            if (x==0){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("شماره حسابی که وارد کردید اشتباه است!");
                alert.showAndWait();
            }else if (x==-1){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("کد ملی کاربر اشتباه است!");
                alert.showAndWait();
            }else {
                System.out.println("عملیات با موفقیت انجام شد");
                stage = (Stage) conti.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Client.class.getResource("Fxml/movafagh.fxml"));
                root = fxmlLoader.load();

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }
    public void setAllButten(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(menuAdmin)) {
            stage = (Stage) menuAdmin.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/adminkhadamat.fxml"));
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
