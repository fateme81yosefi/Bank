package Core;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void serializeUser(ArrayList<User> users){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("file:src/BankInfo.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(users);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeUser(){
        try {
            FileInputStream fileInputStream = new FileInputStream("file:src/BankInfo.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
             Bank.users.add((User) objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}