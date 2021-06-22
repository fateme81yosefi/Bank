package Graphics.Controller;

import Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class dakhastvam_Controller   implements Initializable {
    public TextField mablagh;
    public TextField dorepardakht;
    public Button khadamatk;
    public Button conti;

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
    public void setMablagh(ActionEvent event) {
        String mablaghText = mablagh.getText();
    }
    public void setDorepardakht(ActionEvent event) {
        String dorepardakhtText = dorepardakht.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

