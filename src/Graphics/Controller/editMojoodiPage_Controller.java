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

public class editMojoodiPage_Controller  implements Initializable {
    public TextField mojodiJadid;
    public Button conti;
    public Button adminMenu;//
    public TextField accNum;
    public TextField codemelli;

    public void validate(ActionEvent event) throws IOException {
        String mablagh1=mojodiJadid.getText();
        String accNumText=accNum.getText();
        String codemelliText=codemelli.getText();
        Stage stage;
        Parent root;

        if (mablagh1.isEmpty()||accNumText.isEmpty()||codemelliText.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else {
      int x=Bank.editUserMojodi(codemelliText,accNumText,mablagh1);
      if (x==-1){
          Alert alert=new Alert(Alert.AlertType.ERROR);
          alert.setHeaderText(null);
          alert.setContentText("اطلاعات وارده معتبر نیست!");
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
        if (event.getSource().equals(adminMenu)) {
            stage = (Stage) adminMenu.getScene().getWindow();
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
