package Core;

public class Account {
    String passwordAcc;
    Tarakonesh T;
    public enum AccType {
        GHARZOLHASANE_JARI,
        GHARZOLHASANE_PASANDAZ,
        SEPORDE_BOLANDMODAT,
        SEPORDE_KOTAHMODAT;
    }

    public Account(String passwordAcc){
        this.passwordAcc=passwordAcc;
    }
}
