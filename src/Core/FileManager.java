package Core;


import java.io.*;

public class FileManager {


    public static void WriteUserToFile(User user) {
        try {
            PrintWriter printWriter=new PrintWriter(new FileWriter("F:\\payanterm\\user.txt"));

            printWriter.println(user.name+"\n");
            printWriter.println(user.email+"\n");
            printWriter.println(String.valueOf(user.phoneNum)+"\n");
            printWriter.println(String.valueOf(user.codemelli)+"\n");
            System.out.println("کاربر با موفقیت در فایل ثبت شد");
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");        }
    }


    public static void WriteAccToFile(User user,Account account) {
        try {

            PrintWriter printWriter=new PrintWriter(new FileWriter("F:\\payanterm\\Acc.txt"));

            printWriter.println(user.name+"\n");
            printWriter.println(user.email+"\n");
            printWriter.println(String.valueOf(user.phoneNum)+"\n");
            printWriter.println(String.valueOf(user.codemelli)+"\n");
            printWriter.println(String.valueOf(account.accNumber)+"\n");
            printWriter.println(String.valueOf(account.mojodi)+"\n");
            printWriter.println(account.alias+"\n");
            printWriter.println(account.accType.name()+"\n");
            printWriter.close();
            System.out.println("حساب با موفقیت در فایل ثبت شد");
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }
    public static void WriteTarakoneshToFile(User user,Account account,Tarakonesh tarakonesh) {
        try {
            PrintWriter printWriter=new PrintWriter(new FileWriter("F:\\payanterm\\Tarakonesh.txt"));
            printWriter.println(user.name+"\n");
            printWriter.println(user.email+"\n");
            printWriter.println(String.valueOf(user.phoneNum)+"\n");
            printWriter.println(String.valueOf(user.codemelli)+"\n");
            printWriter.println(String.valueOf(account.accNumber)+"\n");
            printWriter.println(String.valueOf(account.mojodi)+"\n");
            printWriter.println(String.valueOf(account.alias)+"\n");
            printWriter.println(account.accType.name()+"\n");
            printWriter.println(String.valueOf(tarakonesh.mablagh)+"\n");
            printWriter.println(tarakonesh.tarakoneshType.name()+"\n");
            printWriter.println(tarakonesh.time.toString()+"\n");
            printWriter.close();
            System.out.println("تراکنش با موفقیت در فایل ثبت شد");
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }

}



