package Graphics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static Pane root=null;
    public static Scene scene =null;
    public static FXMLLoader fxmlLoader=null;
    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource("Fxml/MenuAsli.fxml"));
        try {
            root=fxmlLoader.load();
        }catch (IOException exception){
            exception.printStackTrace();
        }
if (root !=null){
    scene=new Scene(root);
}

primaryStage.setScene(scene);
primaryStage.setResizable(false);
primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
