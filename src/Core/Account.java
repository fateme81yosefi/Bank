package Core;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    transient String passwordAcc;
    long accNumber;
    String alias;
    long mojodi=0;
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

    @Override
    public String toString() {
        return "accNumber:" + accNumber + "\nalias: " + alias + "\nmojodi: " + mojodi+ "\nAccType: " + accType;
    }
}
