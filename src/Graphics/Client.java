package Graphics;

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
    int port = 9090;
    String serverAddress = "127.0.0.1";
    InputStream fromServerStream;
    OutputStream toServerStream;
    DataInputStream reader;
    PrintWriter writer;
    public static Pane root=null;
    public static Scene scene =null;
    public static FXMLLoader fxmlLoader=null;

    public Client() {
        try {
            mSocket = new Socket(serverAddress, port);
            System.out.println("connect to server ....");
            // input stream (stream from server)
            fromServerStream = mSocket.getInputStream();
            // output stream (stream to server)
            toServerStream = mSocket.getOutputStream();
            reader = new DataInputStream(fromServerStream);
            writer = new PrintWriter(toServerStream, true);
            // first : read server message
            //String msg = reader.readLine();
            //System.out.println("Server :" + msg);
            //Manage other server message by a Thread
           // Thread t=new Thread(new ServerMessagesManager(reader));
           // t.start();

        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(Client.class.getResource("Fxml/MenuAsli.fxml"));
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

      //  new Client();
        launch(args);
    }
}