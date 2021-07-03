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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class alias_Controller implements Initializable {
    public TextField aliass;
    public TextField shomareHesab;
    public Button khadamatk;
    public Button conti;
    public TextField codemelli;

    public void validate(ActionEvent event) throws IOException {
        String aliassText=aliass.getText();
        String shomareHesabText=shomareHesab.getText();
        String codemelliText=codemelli.getText();
        Stage stage;
        Parent root;
        if (aliassText.isEmpty()||shomareHesabText.isEmpty()||codemelliText.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else {
//            int x= Bank.setAlias(aliassText,shomareHesabText,codemelliText);
//            if (x==0){
//                Alert alert=new Alert(Alert.AlertType.ERROR);
//                alert.setHeaderText(null);
//                alert.setContentText("شماره حسابی که وارد کردید اشتباه است!");
//                alert.showAndWait();
//            }else if (x==-1){
//                Alert alert=new Alert(Alert.AlertType.ERROR);
//                alert.setHeaderText(null);
//                alert.setContentText("کد ملی کاربر اشتباه است!");
//                alert.showAndWait();
//            }else {
//                System.out.println("new Alias:"+aliassText+"عملیات با موفقیت انجام شد");
//                stage = (Stage) conti.getScene().getWindow();
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(App.class.getResource("Fxml/movafagh.fxml"));
//                root = fxmlLoader.load();
//
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//            }
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


