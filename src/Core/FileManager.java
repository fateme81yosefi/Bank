package Core;


import java.io.*;

public class FileManager {


    public static void WriteUserToFile(User user) {
        try {
            FileWriter fileWriter=new FileWriter("F:\\payanterm\\user.txt");
            fileWriter.write(user.name);
            fileWriter.write(user.email);
            fileWriter.write(String.valueOf(user.phoneNum));
            fileWriter.write(String.valueOf(user.codemelli));
            System.out.println("کاربر با موفقیت در فایل ثبت شد");
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");        }
    }


    public static void WriteAccToFile(User user,Account account) {
        try {
            FileWriter fileWriter=new FileWriter("F:\\payanterm\\Acc.txt");
            fileWriter.write(user.name);
            fileWriter.write(user.email);
            fileWriter.write(String.valueOf(user.phoneNum));
            fileWriter.write(String.valueOf(user.codemelli));
            fileWriter.write(String.valueOf(account.accNumber));
            fileWriter.write(String.valueOf(account.mojodi));
            fileWriter.write(String.valueOf(account.alias));
            fileWriter.write(account.accType.name());
            fileWriter.close();
            System.out.println("حساب با موفقیت در فایل ثبت شد");
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }
    public static void WriteTarakoneshToFile(User user,Account account,Tarakonesh tarakonesh) {
        try {
            FileWriter fileWriter=new FileWriter("F:\\payanterm\\Tarakonesh.txt");
            fileWriter.write(user.name);
            fileWriter.write(user.email);
            fileWriter.write(String.valueOf(user.phoneNum));
            fileWriter.write(String.valueOf(user.codemelli));
            fileWriter.write(String.valueOf(account.accNumber));
            fileWriter.write(String.valueOf(account.mojodi));
            fileWriter.write(String.valueOf(account.alias));
             fileWriter.write(account.accType.name());
            fileWriter.write(String.valueOf(tarakonesh.mablagh));
            fileWriter.write(tarakonesh.tarakoneshType.name());
            fileWriter.write(tarakonesh.time.toString());
            fileWriter.close();
            System.out.println("تراکنش با موفقیت در فایل ثبت شد");
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }

}



