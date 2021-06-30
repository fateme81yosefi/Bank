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
    public TextField codemelli;
    public TextField codemelliMaghsad;

    public void validate(ActionEvent event) throws IOException {
        String code1=codemelli.getText();
        String code2=codemelliMaghsad.getText();
        String ramz1=ramz.getText();
        String shomareHasabMaghsadText=shomareHasabMaghsad.getText();
        String accNum1=accNum.getText();
        Stage stage;
        Parent root;

        if (ramz1.isEmpty()||shomareHasabMaghsadText.isEmpty()||accNum1.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else {
            int x=Bank.closeAcc(accNum1,shomareHasabMaghsadText,ramz1,code1,code2);
            if (x==0){
                System.out.println("اطلاعات حساب مقصد نامعتبر است!");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("اطلاعات حساب مقصد نامعتبر است!");
                alert.showAndWait();
            }else if (x==-1){
                System.out.println("کاربر با این مشخصات نداریم!");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("کاربر با این مشخصات نداریم!");
                alert.showAndWait();
            }
            else {
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
