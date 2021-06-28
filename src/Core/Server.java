package Core;

import Graphics.App;

import java.io.DataInputStream;

public class Server implements Runnable{
    DataInputStream reader;
    App app;
    public Server(DataInputStream reader, App app){
        this.app=app;
        this.reader=reader;
    }
    @Override
    public void run() {

    }
}
