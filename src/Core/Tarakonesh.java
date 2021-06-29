package Core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarakonesh {

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

    public Tarakonesh(TarakoneshType tarakoneshType,Date date) {
        this.tarakoneshType=tarakoneshType;
        this.time=date;
    }

    public static void setSimpleDateFormat() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    }

}
