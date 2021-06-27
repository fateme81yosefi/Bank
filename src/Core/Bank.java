package Core;

import java.util.ArrayList;

public class Bank {
    ArrayList<User> users = new ArrayList<User>();

    public void reduce(double mojodi,double mablagh){mojodi-=mablagh;}
    public void increase(double mojodi,double mablagh){mojodi+=mablagh;}

    public void addUser(String name,long codemelli,String password, int phoneNum, String email){
        User user=new User(name, codemelli, password, phoneNum, email);
        users.add(user);
    }
    public void addAcc(String passwordAcc, Account.AccType accType){
        Account account=new Account(passwordAcc, accType);

    }
    public void manageAcc(){}
    public void setAlias(){}
    public void enteghalVajh(){}
    public void pardakhtGhoboz(){}
    public void darkhastVam(){}
    public void closeAcc(){}
}
