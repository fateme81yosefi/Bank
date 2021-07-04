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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class moshahedeInfoA_Controller implements Initializable {
    public Button conti;
    public Button khadamatk;
    public TextField codemelli;
    public TextField accNum;
    public TextArea PrintInfo;
    public void validate(ActionEvent event) throws IOException {

        String accNumTextabdaText=accNum.getText();
        String codemelliText=codemelli.getText();

        Stage stage;
        Parent root;

        if (accNumTextabdaText.isEmpty()||codemelliText.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else {
    int x= Bank.printInfoUsers(PrintInfo);
    if (x==1){
        System.out.println("مشاهده اطلاعات:");
    }else {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("مشکلی رخ داده! لطفا مجددا تلاش کنید!");
        alert.showAndWait();
    }
}
    }

            public void setAllButten(ActionEvent event)throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(khadamatk)){
            stage=(Stage) khadamatk.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(Client.class.getResource("Fxml/EntekhabKhadamatUser.fxml"));
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
