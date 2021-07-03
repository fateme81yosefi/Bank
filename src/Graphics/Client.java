package Graphics;

import Core.Bank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Application {
    Socket mSocket;
    int port=9090;
    String serverAddress="127.0.0.1";
    InputStream inputStream;
    OutputStream outputStream;
    DataInputStream reader;
    PrintWriter writer;

    public static Pane root=null;
    public static Scene scene =null;
    public static FXMLLoader fxmlLoader=null;

    public Client(){
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
        mSocket=new Socket(serverAddress,port);
        inputStream=mSocket.getInputStream();
        outputStream=mSocket.getOutputStream();
        reader=new DataInputStream(inputStream);
        writer=new PrintWriter(outputStream,true);
        Thread t=new Thread(new Bank(reader,this));
        t.start();

        Client client=new Client();
        client.start(primaryStage);
        fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(Client.class.getResource("Fxml/MenuAsli.fxml"));

            root=fxmlLoader.load();
        }catch (IOException exception){
            exception.printStackTrace();
        }
        if (root !=null){
    scene=new Scene(root);
}
primaryStage.setTitle("Bank System");
primaryStage.setScene(scene);
primaryStage.setResizable(false);
primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
