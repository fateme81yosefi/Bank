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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class closeAccbyA_Controller  implements Initializable {
    public PasswordField pass;
    public TextField shomaremaghsad;
    public Button AdminMenu;//
    public Button conti;
    public TextField accNum;
    public TextField codemelli;
    public TextField codemelliMaghsad;

    public void validate(ActionEvent event) throws IOException {
        String ramz1=pass.getText();
        String shomareHasabMaghsadText=shomaremaghsad.getText();
        String accNum1=accNum.getText();
        String codemelliText=codemelli.getText();
        String codemelliMaghsadText=codemelliMaghsad.getText();
        Stage stage;
        Parent root;
        if (ramz1.isEmpty()||shomareHasabMaghsadText.isEmpty()||accNum1.isEmpty()||codemelliText.isEmpty()||codemelliMaghsadText.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else {
            int x= Bank.clossAccByAdmin(codemelliText,accNum1,shomareHasabMaghsadText,codemelliMaghsadText);
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
        if (event.getSource().equals(AdminMenu)) {
            stage = (Stage) AdminMenu.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/adminkhadamat.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void setRamz(ActionEvent event) {
        String passText = pass.getText();
    }
    public void setAccNum(ActionEvent event) {
        String accNum1=accNum.getText();
    }
    public void setShomaremaghsad(ActionEvent event) {
        String shomaremaghsadText = shomaremaghsad.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}