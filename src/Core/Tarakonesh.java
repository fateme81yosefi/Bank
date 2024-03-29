package Core;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarakonesh implements Serializable {

    double mablagh;
    Date time;
    public TarakoneshType tarakoneshType;
    public enum TarakoneshType {
        VARIZ,
        BARDASHT,
        EDIT_MOJODI_BY_ADMIN,
        BARDASHT_MAHANE_VAM,
        VARIZ_VAM;
    }

    public Tarakonesh(TarakoneshType tarakoneshType,Date date,double mablagh) {
        this.tarakoneshType=tarakoneshType;
        this.time=date;
        this.mablagh=mablagh;
    }

    public static void setSimpleDateFormat() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    }


    @Override
    public String toString() {
        return "\ntarakoneshType:" + tarakoneshType + "\ntime: " + time +"\nmablagh: " + mablagh+"\n";
    }
}
