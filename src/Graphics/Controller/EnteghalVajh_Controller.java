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
    public TextField codemelliMabda;
    public TextField accNumMabda;
    public TextField codemelliMaghsad;

    public void validate(ActionEvent event) throws IOException {
        String mablagh1=mablagh.getText();
        String shomareMaghsadText=shomareMaghsad.getText();
        String passwordText=password.getText();
        String codemelliMabdaText=codemelliMabda.getText();
        String codemelliMaghsadText=codemelliMaghsad.getText();
        String accNumMabdaText=accNumMabda.getText();
        Stage stage;
        Parent root;
        if (mablagh1.isEmpty()||passwordText.isEmpty()||shomareMaghsadText.isEmpty()||
            codemelliMabdaText.isEmpty()||codemelliMaghsadText.isEmpty()||accNumMabdaText.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else {
            int x= Bank.enteghalVajh(mablagh1,shomareMaghsadText,accNumMabdaText,codemelliMaghsadText,codemelliMabdaText);
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
                fxmlLoader.setLocation(App.class.getResource("Fxml/movafagh.fxml"));
                root = fxmlLoader.load();

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        }

    }

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
    /////////////////FOR CONTI//////////////////////////////////////


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}