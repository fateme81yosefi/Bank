package Core;

import java.util.ArrayList;
import java.util.Date;

public class Bank {

     static ArrayList<User> users = new ArrayList<User>();


    public static int getIndexUser(String codemelli) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).codemelli==Long.parseLong(codemelli))return i;
        }
        return -1;
    }

    public static int getIndexAcc(String codemelli,String accNum) {
        int g=getIndexUser(codemelli);
        for (int i = 0; i < users.get(g).accounts.size(); i++) {
            if (users.get(g).accounts.get(i).accNumber==Long.parseLong(accNum)) {
                return i;
            }
        }return -1;
    }

    public void addUser(String name, String codemelli, String password, String phoneNum, String email) {
        User user = new User(name, Long.parseLong(codemelli), password, Integer.parseInt(phoneNum), email);
        users.add(user);
    }

    public void addAcc(String codemelli, Account.AccType type,String pass) {
        int idex=getIndexUser(codemelli);
        Account account=new Account(pass,type);
        users.get(idex).accounts.add(account);
    }


    public void mashahede(String AccNum,String codemelli){
        int idex=getIndexUser(codemelli);
        for (int i = 0; i < users.get(idex).accounts.size(); i++) {
            if (users.get(idex).accounts.get(i).accNumber==Long.parseLong(AccNum)) {
                System.out.println(users.get(idex).accounts.get(i).accNumber+" , "+users.get(idex).accounts.get(i).mojodi+" , "+
                                   " , "+users.get(idex).accounts.get(i).accType);
                for (int v=0;v<users.get(idex).accounts.size();v++){
                    for (int a=0;a<users.get(idex).accounts.get(v).tarakoneshes.size();a++){
                        System.out.println("tarakonesh "+a+" account "+v+" :"+users.get(idex).accounts.get(v).tarakoneshes.get(a));
                    }
                }

            }
        }
    }
    public void manageAcc(){
////////////SWITCH CASE /////////
        }


    public void setAlias(String alias, String accNum,String codemelli) {
        int idex=getIndexUser(codemelli);
        for (int i = 0; i < users.get(idex).accounts.size(); i++) {
            if (users.get(idex).accounts.get(i).accNumber==Long.parseLong(accNum)) {
                users.get(idex).accounts.get(i).alias=alias;
            }
        }
    }

    public int enteghalVajh(String mablagh,String accNumMaghsad,String accNumMabda , String codemelliMada, String codemelliMaghsad) {
        int idex=getIndexUser(codemelliMada);
        int idex1=getIndexUser(codemelliMaghsad);
        int mabda=getIndexAcc(codemelliMada,accNumMabda);
        int maghsad=getIndexAcc(codemelliMaghsad,accNumMaghsad);
        if (idex==-1||idex1==-1||mabda==-1||maghsad==-1){
            System.out.println("شماره حساب یا کد ملی ها درست نیست !");
            return 0;
        }
        if (users.get(idex).accounts.get(mabda).mojodi<Integer.parseInt(mablagh)){
            System.out.println("موجودی کافی در حساب مبدا برای انتقال وجه وجود ندارد!");
            return -1;
        }
        users.get(idex).accounts.get(mabda).mojodi-=Integer.parseInt(mablagh);
        users.get(idex1).accounts.get(maghsad).mojodi+=Integer.parseInt(mablagh);
        Date date=new Date();
        Tarakonesh tarakoneshMaghsad=new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ,date);
        Tarakonesh tarakoneshMabda=new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT,date);
        users.get(idex1).accounts.get(maghsad).tarakoneshes.add(tarakoneshMaghsad);
        users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakoneshMabda);
            return 1;
            }


    public int pardakhtGhoboz(String shenaseGhabz,String ShenasePardakht,String mablagh,String codemelli,String accNum) {
        int idex=getIndexUser(codemelli);
        int mabda=getIndexAcc(codemelli,accNum);

        if (Integer.parseInt(mablagh)>users.get(idex).accounts.get(mabda).mojodi) {
            System.out.println("موجودی کافی نیست !");
            return 0;
        }
        else{
            users.get(idex).accounts.get(mabda).mojodi-=Integer.parseInt(mablagh);
            Date date=new Date();
            Tarakonesh tarakonesh=new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT,date);
            users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakonesh);
            return 1;
    }
    }
/////////////////////////IN METHOD CHECK BESHE FALSE/////////////////////////////////

    public void darkhastVam(String mablagh,String month,String codemelli,String accNum) {
        int idex=getIndexUser(codemelli);
        int mabda=getIndexAcc(codemelli,accNum);
        users.get(idex).accounts.get(mabda).mojodi+=Integer.parseInt(mablagh);
        double mablaghBardashtiMahane=Integer.parseInt(mablagh)/Integer.parseInt(month);
           Date dateVamGerefte=new Date();
                Tarakonesh tarakonesh2=new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ_VAM,dateVamGerefte);
                users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakonesh2);

    }
    /////////////////////////////////////IN BUGE DARE/////////////////////////////////////////////////////
    public void checkVamTime(Date date, double mablaghBardashtiMahane,String codemelli,String accNum){
        int idex=getIndexUser(codemelli);
        int mabda=getIndexAcc(codemelli,accNum);
        Date dateGozashteShode=new Date();
        long zamanGozashte=dateGozashteShode.getTime();
        long zamanVam=date.getTime();
        if (((zamanGozashte-zamanVam)*1000)%(3600*24*30)==0){

            users.get(idex).accounts.get(mabda).mojodi-=mablaghBardashtiMahane;

            Tarakonesh tarakonesh=new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT_MAHANE_VAM,dateGozashteShode);
            users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakonesh);

        }
    }



    public void closeAcc(String accNum,String accNumMaghsad,String pass,String codemelli,String codemelliMaghsad) {
        int idex=getIndexUser(codemelli);
        int idex1=getIndexUser(codemelliMaghsad);
        int mabda=getIndexAcc(codemelli,accNum);
        int maghsad=getIndexAcc(codemelliMaghsad,accNumMaghsad);
        if (users.get(idex).accounts.get(mabda).mojodi!=0){
            String s=String.valueOf(users.get(idex).accounts.get(mabda).mojodi);
            enteghalVajh(s,accNumMaghsad,accNum,codemelli,codemelliMaghsad);
        }else users.get(idex).accounts.remove(mabda);
        }


///////////////////////////////////////ADMIN METHODS/////////////////////////////////////////

    public void printInfoUser(){
    for(User user:users){
        System.out.println(user.name+" , "+user.codemelli+" , "+user.password+" , "
                          +user.email+" , "+user.phoneNum+" , "+user.accounts);
    }
    }

    public void editUserInfo(String name,  String codemelli, String password, int phoneNum, String email){
        int idex=getIndexUser(codemelli);
        users.get(idex).name=name;
        users.get(idex).password=password;
        users.get(idex).phoneNum=phoneNum;
        users.get(idex).email=email;
    }

    public void editUserMojodi(String codemelli,String accNum,String newMojodi){
        long newMojo=Long.parseLong(newMojodi);
        int idex=getIndexUser(codemelli);
        int indexAcc1=getIndexAcc(codemelli,accNum);
        Date date=new Date();
        Tarakonesh tarakonesh=new Tarakonesh(Tarakonesh.TarakoneshType.EDIT_MOJODI_BY_ADMIN,date);
        users.get(idex).accounts.get(indexAcc1).mojodi=newMojo;
        users.get(idex).accounts.get(indexAcc1).tarakoneshes.add(tarakonesh);
    }

    public void enteghalVajhByAdmin(String codemelliMada,String codemelliMaghsad,String accNumMabda,String accNumMaghsad,String mablagh){
        int idex=getIndexUser(codemelliMada);
        int idex1=getIndexUser(codemelliMaghsad);
        int mabda=getIndexAcc(codemelliMada,accNumMabda);
        int maghsad=getIndexAcc(codemelliMaghsad,accNumMaghsad);
        users.get(idex).accounts.get(mabda).mojodi-=Integer.parseInt(mablagh);
        users.get(idex1).accounts.get(maghsad).mojodi+=Integer.parseInt(mablagh);
        Date date=new Date();
        Tarakonesh tarakoneshMaghsad=new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ,date);
        Tarakonesh tarakoneshMabda=new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT,date);
        users.get(idex1).accounts.get(maghsad).tarakoneshes.add(tarakoneshMaghsad);
        users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakoneshMabda);
    }
    public void clossAccByAdmin(String codemelli,String accNum){
        int idex=getIndexUser(codemelli);
        int indexAcc=getIndexAcc(codemelli,accNum);
        users.get(idex).accounts.remove(indexAcc);
    }

    public void creatAccByAdmin(String codemelli, String accNum, String pass, Account.AccType Type){
        int idex=getIndexUser(codemelli);
        Account account=new Account(pass,Type);
        users.get(idex).accounts.add(account);
    }
}