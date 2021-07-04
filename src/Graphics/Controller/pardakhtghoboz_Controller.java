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

public class pardakhtghoboz_Controller  implements Initializable {
    public TextField shenaseghabz;
    public TextField shenasePardakht;
    public Button conti;/////////////////
    public Button khadamatk;
    public TextField accNum;
    public TextField codemelli;
    public TextField mablagh;

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

    public void validate(ActionEvent event) throws IOException {
        String shenaseghabzText=shenaseghabz.getText();
        String shenasePardakhtText=shenasePardakht.getText();
        String accNumText=accNum.getText();
        String codemelliText=codemelli.getText();
        String mablaghText=mablagh.getText();
        Stage stage;
        Parent root;

        if (shenaseghabzText.isEmpty()||shenasePardakhtText.isEmpty()||accNumText.isEmpty()||
                codemelliText.isEmpty()||mablaghText.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمام فیلد ها را پر کنید!");
            alert.showAndWait();
        }else {
            int x= Bank.pardakhtGhoboz(shenaseghabzText,shenasePardakhtText,mablaghText,codemelliText,accNumText);
            if (x==0){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("موجودی کافی نیست!!");
                alert.showAndWait();
            }else if (x==-1){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("حسابی با این مشخصات موجود نیست!");
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

