package Core;

import java.util.ArrayList;

public class Bank {

    ArrayList<User> users = new ArrayList<User>();

    User loginUser=null;
    Account logAcc=null;

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

    public void enteghalVajh() {
    }

    public void pardakhtGhoboz() {
    }

    public void darkhastVam() {
    }

    public void closeAcc() {
    }

    public void setLogOutUser(){
        this.loginUser=null;
    }
}
