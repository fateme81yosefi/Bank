package Core;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void serializeUser(ArrayList<User> users){
        try {
            File file = new File("E:\\BankInfo.txt");
            FileOutputStream fileOutputStream=new FileOutputStream(file);
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
            File file = new File("E:\\BankInfo.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
             Bank.users=(ArrayList<User>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}