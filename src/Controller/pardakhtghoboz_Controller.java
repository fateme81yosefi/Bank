package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class pardakhtghoboz_Controller {
    public TextField shenaseghabz;
    public TextField shenasePardakht;
    public Button conti;/////////////////
    public Button khadamatk;

    public void setAllButten(ActionEvent event)throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(khadamatk)){
            stage=(Stage) khadamatk.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/EntekhabKhadamatUser.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void setShenaseghabz(ActionEvent event){
        String shenaseghabzText=shenaseghabz.getText();
    }
    public void setShenasePardakht(ActionEvent event){
        String shenasePardakhtText=shenasePardakht.getText();
    }

}

