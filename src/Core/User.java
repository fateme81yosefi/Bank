package Core;

public class User {
    String name;
    long codemelli;
    String password;
    int phoneNum;
    String email;

    public User(String name,long codemelli,String password, int phoneNum, String email){
        this.name=name;
        this.codemelli=codemelli;
        this.password=password;
        this.phoneNum=phoneNum;
        this.email=email;
    }
}
