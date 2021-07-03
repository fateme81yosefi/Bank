package Core;


import javafx.scene.control.TextArea;

import java.io.*;

public class FileManager {


    public static void WriteUserToFile(User user) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("F:\\payanterm\\User:" + user.codemelli + ".txt"), true);
            printWriter.println(user.name + "\n");
            printWriter.println(user.email + "\n");
            printWriter.println(user.password + "\n");
            printWriter.println((user.phoneNum) + "\n");
            printWriter.println((user.codemelli) + "\n");
            System.out.println("کاربر با موفقیت در فایل ثبت شد");
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }


    public static void WriteAccToFile(User user, Account account) {
        try {

            PrintWriter printWriter = new PrintWriter(new FileWriter("F:\\payanterm\\Acc:" + account.accNumber + ".txt"), true);
            printWriter.println(user.name);
            printWriter.println(user.codemelli);
            printWriter.println(account.accNumber);
            printWriter.println(account.passwordAcc);
            printWriter.println(account.mojodi);
            printWriter.println(account.alias);
            printWriter.println(account.accType.name());
            printWriter.close();
            System.out.println("حساب با موفقیت در فایل ثبت شد");
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }

    public static void WriteTarakoneshToFile(User user, Account account, Tarakonesh tarakonesh) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("F:\\payanterm\\tarakonesh:" + account.accNumber + ".txt"), true);
            printWriter.println(user.codemelli);
            printWriter.println(account.accNumber);
            printWriter.println(tarakonesh.mablagh);
            printWriter.println(tarakonesh.tarakoneshType.name());
            printWriter.println(tarakonesh.time.toString());
            printWriter.close();
            System.out.println("تراکنش با موفقیت در فایل ثبت شد");
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }

    public static int deleteAcc(String accNum) {
        File file = new File("F:\\payanterm\\Acc:" + accNum + ".txt");
        if (file.exists()) {
            file.delete();
            return 1;
        } else return -1;
    }




}





