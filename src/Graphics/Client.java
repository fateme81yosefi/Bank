package Graphics;

import Core.Bank;

import Core.BankManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Application {
    public  Bank server;

    Socket client;
    int port=9090;
    String serverAddress="127.0.0.1";
    InputStream inputStream;
    OutputStream outputStream;
    DataInputStream reader;
    PrintWriter writer;

    public static Pane root=null;
    public static Scene scene =null;
    public static FXMLLoader fxmlLoader=null;

    public Client(Bank server, Socket client){
        this.server=server;
        this.client=client;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
        client=new Socket(serverAddress,port);
        inputStream=client.getInputStream();
        outputStream=client.getOutputStream();
        reader=new DataInputStream(inputStream);
        writer=new PrintWriter(outputStream,true);
        Thread t=new Thread(new BankManager(server,this));
        t.start();
        Socket client=new Socket();
        Client clientT=new Client(server,client);

        clientT.start(primaryStage);
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
