package Core;


import javafx.scene.control.TextArea;
import jdk.nashorn.internal.ir.IdentNode;

import java.io.*;

public class FileManager {


    public static void WriteUserToFile(User user) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("F:\\payanterm\\user.txt"));

            printWriter.println(user.name + "\n");
            printWriter.println(user.email + "\n");
            printWriter.println(String.valueOf(user.phoneNum) + "\n");
            printWriter.println(String.valueOf(user.codemelli) + "\n");
            System.out.println("کاربر با موفقیت در فایل ثبت شد");
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }


    public static void WriteAccToFile(User user, Account account) {
        try {

            PrintWriter printWriter = new PrintWriter(new FileWriter("F:\\payanterm\\Acc.txt"));

            printWriter.println(user.name + "\n");
            printWriter.println(String.valueOf(user.codemelli) + "\n");
            printWriter.println(String.valueOf(account.accNumber) + "\n");
            printWriter.println(String.valueOf(account.mojodi) + "\n");
            printWriter.println(account.alias + "\n");
            printWriter.println(account.accType.name() + "\n");
            printWriter.close();
            System.out.println("حساب با موفقیت در فایل ثبت شد");
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }

    public static void WriteTarakoneshToFile(User user, Account account, Tarakonesh tarakonesh) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("F:\\payanterm\\Tarakonesh.txt"));

            printWriter.println(String.valueOf(user.codemelli) + "\n");
            printWriter.println(String.valueOf(account.accNumber) + "\n");
            printWriter.println(String.valueOf(tarakonesh.mablagh) + "\n");
            printWriter.println(tarakonesh.tarakoneshType.name() + "\n");
            printWriter.println(tarakonesh.time.toString() + "\n");
            printWriter.close();
            System.out.println("تراکنش با موفقیت در فایل ثبت شد");
        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException exception) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
    }

    public static int readFile(String codemelli) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\payanterm\\user.txt"));
            int x = 0;
            while (bufferedReader.readLine() != null) {
                x++;
                String reading = bufferedReader.readLine();
                if (x % 4 == 0) {
                    if (reading.equals(codemelli)) return x;
                }
            }
        } catch (IOException e) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
        return -1;
    }

    public static int readFileAcc(String codemelli, String accNum) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\payanterm\\Acc.txt"));
            int x = 0;
            while (bufferedReader.readLine() != null) {
                x++;
                String reading = bufferedReader.readLine();
                int u = readFile(codemelli);
                if (u == -1) {
                    bufferedReader.close();
                    return -1;
                } else {
                    if (x % 5 == 0) {
                        if (reading.equals(accNum)) {
                            bufferedReader.close();
                            return 1;
                        } else {
                            bufferedReader.close();
                            return -1;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
        return -1;
    }

    public static void readVPrintInfo(TextArea textArea, String s) {
        textArea.setText(s);
    }

    public static int readFileTarakonesh(TextArea textArea, String codemelli, String accNum) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\payanterm\\Tarakonesh.txt"));
            int x = 0;
            while (bufferedReader.readLine() != null) {
                x++;
                String reading = bufferedReader.readLine();
                int u = readFile(codemelli);
                if (u == -1) {
                    bufferedReader.close();
                    return -1;
                } else {
                    if (x % 5 == 0) {
                        if (reading.equals(accNum)) {
                            int indexUser = Bank.getIndexUser(codemelli);
                            int indexAcc = Bank.getIndexAcc(codemelli, accNum);
                            int tedadghabliha = 0;
                            for (int i = 1; i < indexUser; i++) {
                                int acc = Bank.getIndexAcc(codemelli, accNum);
                                int a = Bank.users.get(i).accounts.get(acc).tarakoneshes.size() * 3 + 2;
                                tedadghabliha += a;
                            }
                            while (tedadghabliha < Bank.users.get(indexUser).accounts.get(indexAcc).tarakoneshes.size() * 3 + 2) {
                                String s = bufferedReader.readLine();
                                readVPrintInfo(textArea, s);
                                tedadghabliha++;
                            }
                            bufferedReader.close();
                            return 1;
                        } else {
                            bufferedReader.close();
                            return -1;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }
        return -1;
    }

    public static int setAliass(String alias, String accNum, String codemelli) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\payanterm\\Acc.txt"));
            int x = readFileAcc(codemelli, accNum);
            if (x == -1) {
                bufferedReader.close();
                return -1;
            } else {
                int index = Bank.getIndexUser(codemelli);
                int indexAcc = Bank.getIndexAcc(codemelli, accNum);
                int o = 0;
                int v = 0;
                for (int i = 1; i < index; i++) {
                    for (int j = 1; j < Bank.users.get(i).accounts.size(); j++) {
                        v = Bank.users.get(i).accounts.size() * 4;
                    }
                    o += v;
                    o += 2 * (index - 1);
                }
                while (true) {
                    int l = 0;
                    if (!(bufferedReader.readLine() != null)) {
                        l++;
                        if (l == o + 5) {
                            PrintWriter p = new PrintWriter(new FileWriter("F:\\payanterm\\Acc.txt"));
                            p.println(alias);
                            p.close();
                            bufferedReader.close();
                            return 1;
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("فایل یافت نشد!");
        } catch (IOException e) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }

        return 0;
    }

    public static int printUsers(TextArea textArea) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\payanterm\\user.txt"));
            while (bufferedReader.readLine() != null) {
                String s = bufferedReader.readLine();
                readVPrintInfo(textArea,s);
            }
            bufferedReader.close();
            return 1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("خطا در شناسایی جریان داده ها!!");
        }return -1;
    }
}





