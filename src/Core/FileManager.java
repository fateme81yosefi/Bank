package Core;

import java.io.*;

public class FileManager {

    public static void serializeUser(User user){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("file:src/BankInfo.txt");
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
            FileInputStream fileInputStream = new FileInputStream("file:src/BankInfo.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
             Bank.users.add(objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}