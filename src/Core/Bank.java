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

    public static int getIndexAcc(String codemelli,String accNum, String pass) {
        int g=getIndexUser(codemelli);
        for (int i = 0; i < users.get(g).accounts.size(); i++) {
            if (users.get(g).accounts.get(i).accNumber==Long.parseLong(accNum) && users.get(g).accounts.get(i).passwordAcc.equals(pass)) {
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


    public void mashahede(long AccNum,User loginUser){
        for (int i = 0; i < loginUser.accounts.size(); i++) {
            if (loginUser.accounts.get(i).accNumber==AccNum) {
                logAcc1=loginUser.accounts.get(i);
                ///////PRINT INFO /////////
            }
        }
    }
    public void manageAcc(){
////////////SWITCH CASE /////////
        }


    public void setAlias(String alias, long accNum,Account logAcc) {
        logAcc.alias=alias;
    }

    public int enteghalVajh(double mablagh,long accNum,Account logAcc,User loginUser) {
        if (mablagh>logAcc.mojodi)return 0;
        else{
            logAcc.mojodi-=mablagh;
            int x=getIndexAcc1(accNum);
            if (x!=-1){
                (loginUser.accounts.get(x).mojodi)+=mablagh;
                Date date=new Date();
                Tarakonesh tarakonesh=new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT,date);
                 logAcc.tarakoneshes.add(tarakonesh);
                Tarakonesh tarakonesh1=new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ,date);
                loginUser.accounts.get(x).tarakoneshes.add(tarakonesh1);
            return 1;
            }else return -1;
        }
    }

    public int pardakhtGhoboz(long shenaseGhabz,long ShenasePardakht,double mablagh,Account logAcc) {
        if (mablagh>logAcc.mojodi)return 0;
        else{
            logAcc.mojodi-=mablagh;
            Date date=new Date();
            Tarakonesh tarakonesh=new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT,date);
            logAcc.tarakoneshes.add(tarakonesh);
            return 1;
    }
    }
/////////////////////////IN METHOD CHECK BESHE FALSE/////////////////////////////////

    public void darkhastVam(double mablagh,int month,Account logAcc) {
             logAcc.mojodi+=mablagh;
        double mablaghBardashtiMahane=mablagh/month;
           Date dateVamGerefte=new Date();
                Tarakonesh tarakonesh2=new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ_VAM,dateVamGerefte);
                logAcc.tarakoneshes.add(tarakonesh2);


    }
    public void checkVamTime(Date date, double mablaghBardashtiMahane,Account logAcc){
        Date dateGozashteShode=new Date();
        long zamanGozashte=dateGozashteShode.getTime();
        long zamanVam=date.getTime();
        if (((zamanGozashte-zamanVam)*1000)%(3600*24*30)==0){
            logAcc.mojodi-=mablaghBardashtiMahane;
            Tarakonesh tarakonesh=new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT_MAHANE_VAM,dateGozashteShode);
            logAcc.tarakoneshes.add(tarakonesh);

        }
    }
///////////////////////////////////////////////////////////////////////////////////////
    public void closeAcc(long accNum,long accNumMaghsad,String pass,User loginUser) {
        for (int i = 0; i < loginUser.accounts.size(); i++) {
            if (loginUser.accounts.get(i).accNumber==accNum && loginUser.accounts.get(i).passwordAcc==pass) {
                if (loginUser.accounts.get(i).mojodi==0)
                loginUser.accounts.remove(i);
              else {
                    int e=getIndexAcc1(accNumMaghsad);
                    loginUser.accounts.get(i).mojodi+=loginUser.accounts.get(i).mojodi;
                    Date date=new Date();
                    Tarakonesh tarakonesh=new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ,date);
                    loginUser.accounts.get(i).tarakoneshes.add(tarakonesh);
                    loginUser.accounts.get(i).mojodi=0;
                    loginUser.accounts.remove(i);
                }
            }
        } }

    public void setLogOutUser(){
        this.loginUser=null;
    }
    public void setLogOutAcc(){
        this.logAcc=null;
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
        int indexAcc1=getIndexAcc1(Long.parseLong(accNum));
        Date date=new Date();
        Tarakonesh tarakonesh=new Tarakonesh(Tarakonesh.TarakoneshType.EDIT_MOJODI_BY_ADMIN,date);
        users.get(idex).accounts.get(indexAcc1).mojodi=newMojo;
        users.get(idex).accounts.get(indexAcc1).tarakoneshes.add(tarakonesh);
    }

    public void enteghalVajhByAdmin(String codemelli,String accNumMabda,String accNumMaghsad,String mablagh){
        int idex=getIndexUser(codemelli);
        int mabda=getIndexAcc1(Long.parseLong(accNumMabda));
        int maghsad=getIndexAcc1(Long.parseLong(accNumMaghsad));
        users.get(idex).accounts.get(mabda).mojodi-=Integer.parseInt(mablagh);
        users.get(idex).accounts.get(maghsad).mojodi+=Integer.parseInt(mablagh);
        Date date=new Date();
        Tarakonesh tarakoneshMaghsad=new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ,date);
        Tarakonesh tarakoneshMabda=new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT,date);
        users.get(idex).accounts.get(maghsad).tarakoneshes.add(tarakoneshMaghsad);
        users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakoneshMabda);
    }
    public void clossAccByAdmin(String codemelli,String accNum){
        int idex=getIndexUser(codemelli);
        int indexAcc=getIndexAcc1(Long.parseLong(accNum));
        users.get(idex).accounts.remove(indexAcc);
    }

    public void creatAccByAdmin(String codemelli, String accNum, String pass, Account.AccType Type){
        int idex=getIndexUser(codemelli);
        int indexAcc=getIndexAcc1(Long.parseLong(accNum));
        Account account=new Account(pass,Type);
        users.get(idex).accounts.add(account);
    }
}