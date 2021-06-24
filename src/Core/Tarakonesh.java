package Core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarakonesh {

    double mablagh;
    String time;

    public enum TarakoneshType{
        VARIZ,
        BARDASHT,
        VARIZ_VAM;
    }


    public Tarakonesh(){
    }

public static void setSimpleDateFormat(){

        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    }

}
