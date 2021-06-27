package Core;

import java.util.ArrayList;

public class User {

    String name;
    long codemelli;
    String password;
    int phoneNum;
    String email;

    ArrayList<Account> accounts = new ArrayList<Account>();

    public User(String name,long codemelli,String password, int phoneNum, String email){
        this.name=name;
        this.codemelli=codemelli;
        this.password=password;
        this.phoneNum=phoneNum;
        this.email=email;
    }
}
