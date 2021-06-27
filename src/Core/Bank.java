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
            }break;
        }return -1;
    }
    public void reduce(double mojodi, double mablagh) {
        mojodi -= mablagh;
    }

    public void increase(double mojodi, double mablagh) {
        mojodi += mablagh;
    }

    public void addUser(String name, long codemelli, String password, int phoneNum, String email) {
        User user = new User(name, codemelli, password, phoneNum, email);
        users.add(user);
    }

    public void addAcc(Account account) {
        loginUser.accounts.add(account);
    }

    public void manageAcc() {
    }

    public void setAlias(String alias, long accNum) {
        logAcc.alias=alias;
    }

    public int enteghalVajh(double mablagh,long accNum) {
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
                logAcc1.tarakoneshes.add(tarakonesh1);
            return 1;
            }else return -1;
        }
    }

    public void pardakhtGhoboz() {
    }

    public void darkhastVam(double mablagh,int month) {
        logAcc.mojodi+=mablagh;

        double mablaghBardashtiMahane=mablagh/month;
        Date dateVamGerefte=new Date();
        long zamanVam=dateVamGerefte.getTime();
    }
    public void mohasebeTimeVam(){

      Date dateGozashteShode=new Date();
        long zamanGozashte=dateGozashteShode.getTime();
    }

    public void closeAcc(long accNum,String pass) {
        for (int i = 0; i < loginUser.accounts.size(); i++) {
            if (loginUser.accounts.get(i).accNumber==accNum && loginUser.accounts.get(i).passwordAcc==pass) {
              loginUser.accounts.remove(i);
            }
        } }

    public void setLogOutUser(){
        this.loginUser=null;
    }
}
