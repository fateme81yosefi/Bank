package Core;

import Graphics.App;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    Socket mSocket;
    int port=9090;
    String serverAddress="127.0.0.1";
    InputStream inputStream;
    OutputStream outputStream;
    DataInputStream reader;
    PrintWriter writer;
    App app=null;
    ///
    public Client(App app){
        this.app=app;
    }
    public Client(){}

    public void start() {
        try {
            mSocket=new Socket(serverAddress,port);
            inputStream=mSocket.getInputStream();
            outputStream=mSocket.getOutputStream();
            reader=new DataInputStream(inputStream);
            writer=new PrintWriter(outputStream,true);
            Thread t=new Thread(new Server(reader,app));
            t.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
