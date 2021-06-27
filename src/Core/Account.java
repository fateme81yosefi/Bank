package Core;

import java.util.ArrayList;

public class Account {
    String passwordAcc;
    long accNumber;
    String alias;
    double mojodi=0;
    public AccType accType;
    private static long createAccNum=1000000;
    public enum AccType {
        GHARZOLHASANE_JARI,
        GHARZOLHASANE_PASANDAZ,
        SEPORDE_BOLANDMODAT,
        SEPORDE_KOTAHMODAT;
    }
    ArrayList<Tarakonesh> tarakoneshes = new ArrayList<Tarakonesh>();

    public Account(String passwordAcc,AccType accType){
        this.accNumber=createAccNum;
        this.passwordAcc=passwordAcc;
        this.accType=accType;
        createAccNum++;
    }
}
