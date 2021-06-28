package Core;

import java.util.ArrayList;
import java.util.Date;

public class Bank {

    ArrayList<User> users = new ArrayList<User>();

    User loginUser=null;
    Account logAcc=null;
    Account logAcc1=null;

    public void getIndexUser(long codemelli, String pass) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).password.equals(pass) && users.get(i).codemelli==(codemelli)) {
               loginUser=users.get(i);
            }
        }
    }
    public void getIndexAcc(long accNum, String pass) {
        for (int i = 0; i < loginUser.accounts.size(); i++) {
            if (loginUser.accounts.get(i).accNumber==accNum && loginUser.accounts.get(i).passwordAcc==pass) {
                logAcc=loginUser.accounts.get(i);
            }
        }
    }

    public int getIndexAcc1(long accNum) {
        for (int i = 0; i < loginUser.accounts.size(); i++) {
            if (loginUser.accounts.get(i).accNumber==accNum ) {
                logAcc1=loginUser.accounts.get(i);
                return i;
            }
        }return -1;
    }

    public void addUser(String name, long codemelli, String password, int phoneNum, String email) {
        User user = new User(name, codemelli, password, phoneNum, email);
        users.add(user);
    }

    public void addAcc(Account account,User loginUser) {
        loginUser.accounts.add(account);
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
}
