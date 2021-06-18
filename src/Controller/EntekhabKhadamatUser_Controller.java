package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EntekhabKhadamatUser_Controller implements Initializable {

    public Button Alias;
    public Button AfzodanKarbar;//
    public Button SafheAsli;//
    public Button BastanHesab;//
    public Button PardakhtGhoboz;//
    public Button DarkhastVam;//
    public Button EnteghalVajh;//
    public Button MoshahedeEtelaat;//
    public Button ModiriyatHesab;//
    public Button BazKardanHesabJadid;//
    public void setAllButten(ActionEvent event)throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(EnteghalVajh)){
            stage=(Stage) EnteghalVajh.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/EnteghalVajh.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(ModiriyatHesab)){
            stage=(Stage) ModiriyatHesab.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/EnteghalVajh.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(BazKardanHesabJadid)){
            stage=(Stage) BazKardanHesabJadid.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/newaccount.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(MoshahedeEtelaat)){
            stage=(Stage) MoshahedeEtelaat.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/moshahedeInfo.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(PardakhtGhoboz)){
            stage=(Stage) PardakhtGhoboz.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/moshahedeInfo.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();}
            if (event.getSource().equals(SafheAsli)){
                stage=(Stage) SafheAsli.getScene().getWindow();
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(App.class.getResource("Fxml/MenuAsli.fxml"));
                root=fxmlLoader.load();

                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        if (event.getSource().equals(DarkhastVam)){
            stage=(Stage) DarkhastVam.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/MenuAsli.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(BastanHesab)){
            stage=(Stage) BastanHesab.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/claseacc.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(AfzodanKarbar)){
            stage=(Stage) AfzodanKarbar.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/claseacc.fxml"));
            root=fxmlLoader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(Alias)){
            stage=(Stage) Alias.getScene().getWindow();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/claseacc.fxml"));
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
