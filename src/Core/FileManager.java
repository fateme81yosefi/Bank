package Core;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void serializeUser(User user){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("F:\\payanterm\\BankInfo");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeUser(){
        try {
            FileInputStream fileInputStream = new FileInputStream("F:\\payanterm\\BankInfo");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Bank.users = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}