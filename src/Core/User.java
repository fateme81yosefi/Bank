package Core;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    String name;
    long codemelli;
    transient String password;
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
    @Override
    public String toString() {
        return "Name:" + name + "\ncodemelli: " + codemelli + "\nphoneNum: " + phoneNum+ "\nemail: " + email;
    }
}
