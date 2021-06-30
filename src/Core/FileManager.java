package Core;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileManager {
    private static final String filePath = "F:\\payanterm\\BankInfo.txt";

    public static void WriteObjectToFile(User user) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
            System.out.println("کاربر با موفقیت در فایل ثبت شد");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public static void WriteObjectToFile(User user,Account account) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.writeObject(account);
            objectOutputStream.close();
            System.out.println("حساب با موفقیت در فایل ثبت شد");
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }
    public static void WriteObjectToFile(User user,Account account,Tarakonesh tarakonesh) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.writeObject(account);
            objectOutputStream.writeObject(tarakonesh);
            objectOutputStream.close();
            System.out.println("تراکنش با موفقیت در فایل ثبت شد");
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }

}



