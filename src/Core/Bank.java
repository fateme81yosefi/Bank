package Core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import Graphics.Client;

import java.util.ArrayList;
import java.io.DataInputStream;

import javafx.scene.control.TextArea;


public class Bank extends Thread {

    ServerSocket mServer;
    int serverPort = 9090;
    ArrayList<Thread> threads = new ArrayList<Thread>();
    int limit = 40;
    DataInputStream reader;

    public static ArrayList<User> users = new ArrayList<>();

    public Bank() {
        try {

            mServer = new ServerSocket(serverPort);
            System.out.println("Server Created!");

            while (true) {

                Socket client = mServer.accept();

                System.out.println("Connected to New Client!");

               // Thread t = new Thread(new ClientManager(this,client));
               // threads.add(t);
                if (threads.size() > limit) {
                    currentThread().join();
                }
                // start thread
                //  t.start();
            }
        } catch (IOException | InterruptedException e) {}
    }


    public static int getIndexUser(String codemelli) {
        FileManager.deserializeUser();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).codemelli == Long.parseLong(codemelli)) {
                FileManager.serializeUser(users);
                return i;
            }
        }
        return -1;
    }


    public static int getIndexAcc(String codemelli, String accNum) {
        FileManager.deserializeUser();
        int g = getIndexUser(codemelli);
        for (int i = 0; i < users.get(g).accounts.size(); i++) {
            if (users.get(g).accounts.get(i).accNumber == Long.parseLong(accNum)) {
                FileManager.serializeUser(users);
                return i;
            }
        }
        FileManager.serializeUser(users);
        return -1;
    }


    public static int addUser(String name, String codemelli, String password, String phoneNum, String email) {
        FileManager.deserializeUser();
        User user = new User(name, Long.parseLong(codemelli), password, Long.parseLong(phoneNum), email);
        users.add(user);
        FileManager.serializeUser(users);
        return 1;
    }


    public static int addAcc(String codemelli, Account.AccType type, String pass) {
        FileManager.deserializeUser();
        int idex = getIndexUser(codemelli);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            FileManager.serializeUser(users);
            return -1;
        }
        Account account = new Account(pass, type);
        users.get(idex).accounts.add(account);
        FileManager.serializeUser(users);
        return 1;
    }


    public static int mashahede(TextArea textArea, String AccNum, String codemelli) {
        FileManager.deserializeUser();
        int idex = getIndexUser(codemelli);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            FileManager.serializeUser(users);
            return -1;
        }
        String forTextArea = null;
        String str=null;
        String str1=null;
        String str2=null;
        for (int i = 0; i < users.get(idex).accounts.size(); i++) {
            if (users.get(idex).accounts.get(i).accNumber == Long.parseLong(AccNum)) {
            for(Tarakonesh tarakonesh:users.get(idex).accounts.get(i).tarakoneshes){
                System.out.println(tarakonesh);
                str+=tarakonesh.toString();
            }
                str1=users.get(idex).toString();
                str2=users.get(idex).accounts.get(i).toString();
                forTextArea+=str1;
                forTextArea+=str2;
                forTextArea+=str;
                textArea.setText(forTextArea);
            } else {
                FileManager.serializeUser(users);
                return 0;
            }


            FileManager.serializeUser(users);
            return 1;
        }return 1;
    }


    public static int setAlias(String alias, String accNum, String codemelli) {
        FileManager.deserializeUser();
        int idex = getIndexUser(codemelli);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            FileManager.serializeUser(users);
            return -1;
        }
        for (int i = 0; i < users.get(idex).accounts.size(); i++) {
            if (users.get(idex).accounts.get(i).accNumber == Long.parseLong(accNum)) {
                users.get(idex).accounts.get(i).alias = alias;
                FileManager.serializeUser(users);
                return 1;
            }
        }
        FileManager.serializeUser(users);
        return 0;
    }


    public static int enteghalVajh(String mablagh, String accNumMaghsad, String accNumMabda, String codemelliMaghsad, String codemelliMada) {
        FileManager.deserializeUser();
        int idex = getIndexUser(codemelliMada);
        int idex1 = getIndexUser(codemelliMaghsad);
        int mabda = getIndexAcc(codemelliMada, accNumMabda);
        int maghsad = getIndexAcc(codemelliMaghsad, accNumMaghsad);

        if (users.get(idex).accounts.get(mabda).mojodi < Integer.parseInt(mablagh)) {
            System.out.println("موجودی کافی در حساب مبدا برای انتقال وجه وجود ندارد!");
            FileManager.serializeUser(users);
            return -1;
        }
        users.get(idex).accounts.get(mabda).mojodi -= Integer.parseInt(mablagh);
        users.get(idex1).accounts.get(maghsad).mojodi += Integer.parseInt(mablagh);
        Date date = new Date();
        Tarakonesh tarakoneshMaghsad = new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ, date,Double.parseDouble(mablagh));
        Tarakonesh tarakoneshMabda = new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT, date,Double.parseDouble(mablagh));
        users.get(idex1).accounts.get(maghsad).tarakoneshes.add(tarakoneshMaghsad);
        users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakoneshMabda);
        FileManager.serializeUser(users);
        return 1;
    }


    public static int pardakhtGhoboz(String shenaseGhabz, String ShenasePardakht, String mablagh, String codemelli, String accNum) {
        FileManager.deserializeUser();
        int idex = getIndexUser(codemelli);
        int mabda = getIndexAcc(codemelli, accNum);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            FileManager.serializeUser(users);
            return -1;
        }
        if (mabda == -1) {
            System.out.println(" حسابی با این مشخصات موجود نیست!!");
            FileManager.serializeUser(users);
            return 0;
        }
        if (Integer.parseInt(mablagh) > users.get(idex).accounts.get(mabda).mojodi) {
            System.out.println("موجودی کافی نیست !");
            FileManager.serializeUser(users);
            return 0;
        } else {
            users.get(idex).accounts.get(mabda).mojodi -= Integer.parseInt(mablagh);
            Date date = new Date();
            Tarakonesh tarakonesh = new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT, date,Double.parseDouble(mablagh));
            users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakonesh);
            FileManager.serializeUser(users);
            return 1;
        }
    }


    /////////////////////////IN METHOD CHECK BESHE FALSE/////////////////////////////////


    public static int darkhastVam(String mablagh, String month, String codemelli, String accNum) {
        FileManager.deserializeUser();
        int idex = getIndexUser(codemelli);
        int mabda = getIndexAcc(codemelli, accNum);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            FileManager.serializeUser(users);
            return -1;
        }
        if (mabda == -1) {
            System.out.println(" حسابی با این مشخصات موجود نیست!!");
            FileManager.serializeUser(users);
            return 0;
        }
        users.get(idex).accounts.get(mabda).mojodi += Integer.parseInt(mablagh);
        System.out.println("new mojodi:" + users.get(idex).accounts.get(mabda).mojodi);
        double mablaghBardashtiMahane = Integer.parseInt(mablagh) / Integer.parseInt(month);
        Date dateVamGerefte = new Date();
        Tarakonesh tarakonesh2 = new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ_VAM, dateVamGerefte,Double.parseDouble(mablagh));
        users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakonesh2);
        FileManager.serializeUser(users);
        return 1;
    }


    public static void checkVamTime(Date date, double mablaghBardashtiMahane, String codemelli, String accNum) {
        FileManager.deserializeUser();
        int idex = getIndexUser(codemelli);
        int mabda = getIndexAcc(codemelli, accNum);
        Date dateGozashteShode = new Date();
        long zamanGozashte = dateGozashteShode.getTime();
        long zamanVam = date.getTime();
        if (((zamanGozashte - zamanVam) * 1000) % (3600 * 24 * 30) == 0) {

            users.get(idex).accounts.get(mabda).mojodi -= mablaghBardashtiMahane;

            Tarakonesh tarakonesh = new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT_MAHANE_VAM, dateGozashteShode,mablaghBardashtiMahane);
            users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakonesh);

        }
        FileManager.serializeUser(users);
    }


    public static int closeAcc(String accNum, String accNumMaghsad, String pass, String codemelli, String codemelliMaghsad) {
        FileManager.deserializeUser();
        int idex = getIndexUser(codemelli);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            return -1;
        }

        int idex1 = getIndexUser(codemelliMaghsad);
        int mabda = getIndexAcc(codemelli, accNum);
        int maghsad = getIndexAcc(codemelliMaghsad, accNumMaghsad);
        if (users.get(idex).accounts.get(mabda).mojodi != 0) {
            if (idex1 == -1 || maghsad == -1) {
                System.out.println("اطلاعات حساب مقصد معتبر نیست !");
                FileManager.serializeUser(users);
                return 0;
            }
            String s = String.valueOf(users.get(idex).accounts.get(mabda).mojodi);
            enteghalVajh(s, accNumMaghsad, accNum,codemelliMaghsad, codemelli);
        } else {
            users.get(idex).accounts.remove(mabda);
        }
        FileManager.serializeUser(users);
        return 1;
    }


    ///////////////////////////////////////ADMIN METHODS/////////////////////////////////////////

    public static int printInfoUsers(TextArea textArea) {
        String forTextArea = null;
        String str2=null;
        String str1=null;
        String str=null;
        FileManager.deserializeUser();
        for (User user : users) {
            System.out.println(user);
            str1=user.toString();
            for (Account account:user.accounts){
                System.out.println(account);
                str2=account.toString();
                for (Tarakonesh tarakonesh: account.tarakoneshes){
                    System.out.println(tarakonesh);
                    str=tarakonesh.toString();
                    str2+=str;
                }
                str1+=str2;
            }
            forTextArea+=str1;
        }
        textArea.setText(forTextArea);
        FileManager.serializeUser(users);
        return 1;
    }


    public static int editUserInfo(String name, String codemelli, String password, String phoneNum, String email) {
        FileManager.deserializeUser();
        int idex = getIndexUser(codemelli);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            return -1;
        }
        users.get(idex).name = name;
        users.get(idex).password = password;
        users.get(idex).phoneNum = Integer.parseInt(phoneNum);
        users.get(idex).email = email;
        FileManager.serializeUser(users);
        return 1;
    }


    public static int editUserMojodi(String codemelli, String accNum, String newMojodi) {
        FileManager.deserializeUser();
        long newMojo = Long.parseLong(newMojodi);
        int idex = getIndexUser(codemelli);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            FileManager.serializeUser(users);
            return -1;
        }

        int indexAcc1 = getIndexAcc(codemelli, accNum);
        if (indexAcc1 == -1) {
            System.out.println("اکانتی با این شماره حساب موجود نیست!!");
            FileManager.serializeUser(users);
            return 0;
        }
        Date date = new Date();
        Tarakonesh tarakonesh = new Tarakonesh(Tarakonesh.TarakoneshType.EDIT_MOJODI_BY_ADMIN, date,Double.parseDouble(newMojodi));
        users.get(idex).accounts.get(indexAcc1).mojodi = newMojo;
        users.get(idex).accounts.get(indexAcc1).tarakoneshes.add(tarakonesh);
        FileManager.serializeUser(users);
        return 1;
    }


    public static int enteghalVajhByAdmin(String codemelliMada, String codemelliMaghsad, String accNumMabda, String accNumMaghsad, String mablagh) {
        FileManager.deserializeUser();
        int idex = getIndexUser(codemelliMada);
        int idex1 = getIndexUser(codemelliMaghsad);
        int mabda = getIndexAcc(codemelliMada, accNumMabda);
        int maghsad = getIndexAcc(codemelliMaghsad, accNumMaghsad);

        if (idex == -1 || idex1 == -1 || mabda == -1 || maghsad == -1) {
            System.out.println("شماره حساب ها یا کد ملی ها درست نیست !");
            FileManager.serializeUser(users);
            return 0;
        }
        if (users.get(idex).accounts.get(mabda).mojodi < Integer.parseInt(mablagh)) {
            System.out.println("موجودی کافی نیست ! ");
            FileManager.serializeUser(users);
            return -1;
        }
        users.get(idex).accounts.get(mabda).mojodi -= Integer.parseInt(mablagh);
        users.get(idex1).accounts.get(maghsad).mojodi += Integer.parseInt(mablagh);
        Date date = new Date();
        Tarakonesh tarakoneshMaghsad = new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ, date,Double.parseDouble(mablagh));
        Tarakonesh tarakoneshMabda = new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT, date,Double.parseDouble(mablagh));
        users.get(idex1).accounts.get(maghsad).tarakoneshes.add(tarakoneshMaghsad);
        users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakoneshMabda);
        FileManager.serializeUser(users);
        return 1;
    }


    public static int clossAccByAdmin(String codemelli, String accNum, String accNumMaghsad, String codemelliMaghsad) {
        FileManager.deserializeUser();
        int idex = getIndexUser(codemelli);
        int idex1 = getIndexUser(codemelliMaghsad);
        int mabda = getIndexAcc(codemelli, accNum);
        int maghsad = getIndexAcc(codemelliMaghsad, accNumMaghsad);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            FileManager.serializeUser(users);
            return -1;
        }

        int indexAcc = getIndexAcc(codemelli, accNum);
        if (indexAcc == -1) {
            System.out.println("اکانتی با این شماره حساب موجود نیست!!");
            FileManager.serializeUser(users);
            return 0;
        }
        if (users.get(idex).accounts.get(mabda).mojodi != 0) {
            if (idex1 == -1 || maghsad == -1) {
                System.out.println("اطلاعات حساب مقصد معتبر نیست !");
                FileManager.serializeUser(users);
                return 0;
            }
            String s = String.valueOf(users.get(idex).accounts.get(mabda).mojodi);
            enteghalVajh(s, accNumMaghsad, accNum, codemelliMaghsad, codemelli);
            users.get(idex).accounts.remove(indexAcc);
            FileManager.serializeUser(users);
            return 1;
        } else {
            users.get(idex).accounts.remove(indexAcc);
            FileManager.serializeUser(users);
            return 1;
        }
    }


    @Override
    public void run() {

    }
}