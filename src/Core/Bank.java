package Core;

import javafx.scene.control.TextArea;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class Bank {

    static ArrayList<User> users = new ArrayList<>();

    public static int getIndexUser(String codemelli) {
        File file = new File("F:\\payanterm\\User:" + codemelli + ".txt");
        if (file.exists()) {
            return 1;
        } else {
            System.out.println("کاربر وجود ندارد!");
            return -1;
        }
    }

    public static int getIndexAcc(String codemelli, String accNum) {
        File file = new File("F:\\payanterm\\Acc:" + accNum + ".txt");
        if (file.exists()) {
            return 1;
        } else {
            System.out.println("حساب وجود ندارد!");
            return -1;
        }
    }

    public static int addUser(String name, String codemelli, String password, String phoneNum, String email) {
        User user = new User(name, Long.parseLong(codemelli), password, Integer.parseInt(phoneNum), email);
        users.add(user);
        FileManager.WriteUserToFile(user);
        return 1;
    }

    public static int addAcc(String codemelli, Account.AccType type, String pass) {
        int idex = getIndexUser(codemelli);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            return -1;
        }
        Account account = new Account(pass, type);
        users.get(idex).accounts.add(account);
        FileManager.WriteAccToFile(users.get(idex), account);
        return 1;
    }


    public static int mashahede(TextArea textArea, String AccNum, String codemelli) {
        File file = new File("F:\\payanterm\\tarakonesh:" + AccNum + ".txt");
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                while (br.readLine() != null) {
                    String line = br.readLine();
                    textArea.setText(line);
                }
                return 1;
            } catch (IOException e) {
                System.out.println("خطا در شناسایی جریان داده ها!!");
            }
        } else {
            System.out.println("حساب یا کاربر موجود نیست !");
            return -1;
        }
        return -1;
    }

//    public static int setAlias(String alias, String accNum,String codemelli) {
//      File file=new File("F:\\payanterm\\Acc:"+accNum+".txt");
//      if (file.exists()){
//
//      }
//    }

    public static int enteghalVajh(String mablagh, String accNumMaghsad, String accNumMabda, String codemelliMaghsad, String codemelliMada) {

        int idex = getIndexUser(codemelliMada);
        int idex1 = getIndexUser(codemelliMaghsad);
        int mabda = getIndexAcc(codemelliMada, accNumMabda);
        int maghsad = getIndexAcc(codemelliMaghsad, accNumMaghsad);
        if (idex == -1 || mabda == -1) {
            System.out.println("اطلاعات حساب مبدا درست نیست!");
            return -1;
        }
        if (idex1 == -1 || maghsad == -1) {
            System.out.println("اطلاعات حساب مقصد درست نیست!");
            return -1;
        } else {
            File file = new File("F:\\payanterm\\Acc:" + accNumMabda + ".txt");
            BufferedReader br = null;
            String mojodii = null;
            try {
                br = new BufferedReader(new FileReader(file));
                int line =1;
                while (br.readLine() != null) {
                    if (line != 5) {
                        String l = br.readLine();
                        line++;
                    } else if (line == 5) {
                        mojodii = br.readLine();
                        if (Integer.parseInt(mojodii) < Integer.parseInt(mablagh)) {
                            System.out.println("موجودی کافی در حساب مبدا برای انتقال وجه وجود ندارد!");
                            return -1;

                        } else {
                            users.get(idex).accounts.get(mabda).mojodi -= Integer.parseInt(mablagh);
                            users.get(idex1).accounts.get(maghsad).mojodi += Integer.parseInt(mablagh);
                            Date date = new Date();
                            Tarakonesh tarakoneshMaghsad = new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ, date);
                            Tarakonesh tarakoneshMabda = new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT, date);
                            users.get(idex1).accounts.get(maghsad).tarakoneshes.add(tarakoneshMaghsad);
                            users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakoneshMabda);
                            FileManager.WriteTarakoneshToFile(users.get(idex), users.get(idex).accounts.get(mabda), tarakoneshMabda);
                            FileManager.WriteTarakoneshToFile(users.get(idex1), users.get(idex1).accounts.get(maghsad), tarakoneshMaghsad);
                            return 1;
                        }
                    }
                }

            } catch (IOException e) {
                System.out.println("خطا در شناسایی جریان داده ها!!");
            }
        }return -1;
    }



    public static int pardakhtGhoboz(String shenaseGhabz, String ShenasePardakht, String mablagh, String codemelli, String accNum) {

        int idex = getIndexUser(codemelli);
        int mabda = getIndexAcc(codemelli, accNum);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            return -1;
        }
        if (mabda == -1) {
            System.out.println(" حسابی با این مشخصات موجود نیست!!");
            return 0;
        }else {
            File file = new File("F:\\payanterm\\Acc:" + accNum + ".txt");
            BufferedReader br = null;
            String mojodii = null;
            try {
                br = new BufferedReader(new FileReader(file));
                while (br.readLine() != null) {
                    int line = 1;
                    if (line == 5) {
                        mojodii = br.readLine();
                        if (Integer.parseInt(mojodii) < Integer.parseInt(mablagh)) {
                            System.out.println("موجودی کافی در حساب مبدا برای پرداخت قبوض وجود ندارد!");
                            return -1;

                        } else {
                            users.get(idex).accounts.get(mabda).mojodi -= Integer.parseInt(mablagh);
                            Date date = new Date();
                            Tarakonesh tarakonesh = new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT, date);
                            users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakonesh);
                            FileManager.WriteTarakoneshToFile(users.get(idex), users.get(idex).accounts.get(mabda), tarakonesh);
                            return 1;
                        }
                    }
                    if (line != 5) {
                        line++;
                        String l = br.readLine();

                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }


        }return -1;
    }
/////////////////////////IN METHOD CHECK BESHE FALSE/////////////////////////////////

    public static int darkhastVam(String mablagh, String month, String codemelli, String accNum) {

        int idex = getIndexUser(codemelli);
        int mabda = getIndexAcc(codemelli, accNum);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            return -1;
        }
        if (mabda == -1) {
            System.out.println(" حسابی با این مشخصات موجود نیست!!");
            return 0;
        }
        users.get(idex).accounts.get(mabda).mojodi += Integer.parseInt(mablagh);
        double mablaghBardashtiMahane = Integer.parseInt(mablagh) / Integer.parseInt(month);
        Date dateVamGerefte = new Date();
        Tarakonesh tarakonesh2 = new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ_VAM, dateVamGerefte);
        users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakonesh2);
        FileManager.WriteTarakoneshToFile(users.get(idex), users.get(idex).accounts.get(mabda), tarakonesh2);
        return 1;
    }

    public static void checkVamTime(Date date, double mablaghBardashtiMahane, String codemelli, String accNum) {

        int idex = getIndexUser(codemelli);
        int mabda = getIndexAcc(codemelli, accNum);
        Date dateGozashteShode = new Date();
        long zamanGozashte = dateGozashteShode.getTime();
        long zamanVam = date.getTime();
        if (((zamanGozashte - zamanVam) * 1000) % (3600 * 24 * 30) == 0) {

            users.get(idex).accounts.get(mabda).mojodi -= mablaghBardashtiMahane;

            Tarakonesh tarakonesh = new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT_MAHANE_VAM, dateGozashteShode);
            users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakonesh);
            FileManager.WriteTarakoneshToFile(users.get(idex), users.get(idex).accounts.get(mabda), tarakonesh);
        }
    }


    public static int closeAcc(String accNum, String accNumMaghsad, String pass, String codemelli, String codemelliMaghsad) {

        int idex = getIndexUser(codemelli);
        int idex1 = getIndexUser(codemelliMaghsad);
        int mabda = getIndexAcc(codemelli, accNum);
        int maghsad = getIndexAcc(codemelliMaghsad, accNumMaghsad);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            return -1;
        }

        int indexAcc = getIndexAcc(codemelli, accNum);
        if (indexAcc == -1) {
            System.out.println("اکانتی با این شماره حساب موجود نیست!!");
            return 0;
        }
        if (users.get(idex).accounts.get(mabda).mojodi != 0) {
            if (idex1 == -1 || maghsad == -1) {
                System.out.println("اطلاعات حساب مقصد معتبر نیست !");
                return 0;
            }
            String s = String.valueOf(users.get(idex).accounts.get(mabda).mojodi);
            enteghalVajh(s, accNumMaghsad, accNum, codemelli, codemelliMaghsad);
            int x = FileManager.deleteAcc(accNum);
            if (x == -1) {
                System.out.println("چنین کاربری وجود ندارد !");
                return -1;
            } else {
                users.get(idex).accounts.remove(indexAcc);
                System.out.println("کاربر با موفقیت حذف شد");
                return 1;
            }
        } else {
            int x = FileManager.deleteAcc(accNum);
            users.get(idex).accounts.remove(indexAcc);
            if (x == -1) {
                System.out.println("چنین کاربری وجود ندارد !");
                return -1;
            } else {
                users.get(idex).accounts.remove(indexAcc);
                System.out.println("کاربر با موفقیت حذف شد");
                return 1;
            }
        }
    }


///////////////////////////////////////ADMIN METHODS/////////////////////////////////////////

//    public static int printInfoUsers(TextArea textArea) {
//
//  }

    public static int editUserInfo(String name, String codemelli, String password, String phoneNum, String email) {

        int idex = getIndexUser(codemelli);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            return -1;
        }else {
            User user=new User(name,Long.parseLong(codemelli),password,Integer.parseInt(phoneNum),email);
            FileManager.WriteUserToFile(user);
            return 1;
        }
    }

//    public static int editUserMojodi(String codemelli, String accNum, String newMojodi) {
//        if (accNum.equals("-1")) return -1;
//
//        int x = FileManager.editMojodi(newMojodi, accNum, codemelli);
//
//        long newMojo = Long.parseLong(newMojodi);
//        int idex = getIndexUser(codemelli);
//        if (idex == -1) {
//            System.out.println("کاربری با این کد ملی موجود نیست!");
//            return -1;
//        }
//
//        int indexAcc1 = getIndexAcc(codemelli, accNum);
//        if (indexAcc1 == -1) {
//            System.out.println("اکانتی با این شماره حساب موجود نیست!!");
//            return 0;
//        }
//        Date date = new Date();
//        Tarakonesh tarakonesh = new Tarakonesh(Tarakonesh.TarakoneshType.EDIT_MOJODI_BY_ADMIN, date);
//        users.get(idex).accounts.get(indexAcc1).mojodi = newMojo;
//        users.get(idex).accounts.get(indexAcc1).tarakoneshes.add(tarakonesh);
//        if (x == -1) return -1;
//        else return 1;
//    }

    public static int enteghalVajhByAdmin(String codemelliMada, String codemelliMaghsad, String accNumMabda, String accNumMaghsad, String mablagh) {

        int idex = getIndexUser(codemelliMada);
        int idex1 = getIndexUser(codemelliMaghsad);
        int mabda = getIndexAcc(codemelliMada, accNumMabda);
        int maghsad = getIndexAcc(codemelliMaghsad, accNumMaghsad);
        if (idex == -1 || mabda == -1) {
            System.out.println("اطلاعات حساب مبدا درست نیست!");
            return -1;
        }
        if (idex1 == -1 || maghsad == -1) {
            System.out.println("اطلاعات حساب مقصد درست نیست!");
            return -1;
        } else {
            File file = new File("F:\\payanterm\\Acc:" + accNumMabda + ".txt");
            BufferedReader br = null;
            String mojodii = null;
            try {
                br = new BufferedReader(new FileReader(file));
                int line =1;
                while (br.readLine() != null) {
                    if (line != 5) {
                        String l = br.readLine();
                        line++;
                    } else if (line == 5) {
                        mojodii = br.readLine();
                        if (Integer.parseInt(mojodii) < Integer.parseInt(mablagh)) {
                            System.out.println("موجودی کافی در حساب مبدا برای انتقال وجه وجود ندارد!");
                            return -1;

                        } else {
                            users.get(idex).accounts.get(mabda).mojodi -= Integer.parseInt(mablagh);
                            users.get(idex1).accounts.get(maghsad).mojodi += Integer.parseInt(mablagh);
                            Date date = new Date();
                            Tarakonesh tarakoneshMaghsad = new Tarakonesh(Tarakonesh.TarakoneshType.VARIZ, date);
                            Tarakonesh tarakoneshMabda = new Tarakonesh(Tarakonesh.TarakoneshType.BARDASHT, date);
                            users.get(idex1).accounts.get(maghsad).tarakoneshes.add(tarakoneshMaghsad);
                            users.get(idex).accounts.get(mabda).tarakoneshes.add(tarakoneshMabda);
                            FileManager.WriteTarakoneshToFile(users.get(idex), users.get(idex).accounts.get(mabda), tarakoneshMabda);
                            FileManager.WriteTarakoneshToFile(users.get(idex1), users.get(idex1).accounts.get(maghsad), tarakoneshMaghsad);
                            return 1;
                        }
                    }
                }

            } catch (IOException e) {
                System.out.println("خطا در شناسایی جریان داده ها!!");
            }
        }return -1;
    }

    public static int clossAccByAdmin(String codemelli, String accNum, String accNumMaghsad, String codemelliMaghsad) {
        int idex = getIndexUser(codemelli);
        int idex1 = getIndexUser(codemelliMaghsad);
        int mabda = getIndexAcc(codemelli, accNum);
        int maghsad = getIndexAcc(codemelliMaghsad, accNumMaghsad);
        if (idex == -1) {
            System.out.println("کاربری با این کد ملی موجود نیست!");
            return -1;
        }

        int indexAcc = getIndexAcc(codemelli, accNum);
        if (indexAcc == -1) {
            System.out.println("اکانتی با این شماره حساب موجود نیست!!");
            return 0;
        }
        File file = new File("F:\\payanterm\\Acc:" + accNum + ".txt");
        BufferedReader br = null;
        String mojodii = null;
        try {
            br = new BufferedReader(new FileReader(file));
            int line = 1;
            while (br.readLine() != null) {
                if (line != 5) {
                    String l = br.readLine();
                    line++;
                } else if (line == 5) {
                    mojodii = br.readLine();
                    if (Integer.parseInt(mojodii) !=0) {
                        if (idex1 == -1 || maghsad == -1) {
                            System.out.println("اطلاعات حساب مقصد معتبر نیست !");
                            return 0;
                    } else {
                            String s = String.valueOf(users.get(idex).accounts.get(mabda).mojodi);
                            enteghalVajh(s, accNumMaghsad, accNum, codemelli, codemelliMaghsad);
                            int x = FileManager.deleteAcc(accNum);
                            if (x == -1) {
                                System.out.println("چنین کاربری وجود ندارد !");
                                return -1;
                            } else {
                                users.get(idex).accounts.remove(indexAcc);
                                System.out.println("کاربر با موفقیت حذف شد");
                                return 1;
                            }
                        }
                }


                }
            }
        }catch (IOException e){
            System.out.println();
        }return -1;
}
}