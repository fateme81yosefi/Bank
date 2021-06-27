package Core;

import java.util.ArrayList;

public class Account {
    String passwordAcc;
    public enum AccType {
        GHARZOLHASANE_JARI,
        GHARZOLHASANE_PASANDAZ,
        SEPORDE_BOLANDMODAT,
        SEPORDE_KOTAHMODAT;
    }
    ArrayList<Tarakonesh> tarakoneshes = new ArrayList<Tarakonesh>();

    public Account(String passwordAcc,AccType accType){
        this.passwordAcc=passwordAcc;

    }
}
