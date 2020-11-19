import java.net.*;
import java.io.*;
class Worker extends Thread {
    Socket s;

    public Worker(Socket param) {
        s = param;
        start();
    }

    public void run() {
        try {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            while (true) {
                //Nhan yeu cau tu Client
                int ch = is.read();
                //Kiem tra dieu kien de thoat
                if (ch == '@') break;
                //Xu li yeu cau
                String kq = "Khong biet";
                switch (ch) {
                    case 'O':
                        kq = "Khong";
                        System.out.println("Da tra b " + kq);
                        break;
                    case '1':
                        kq = "Mot";
                        System.out.println("Da tra b " + kq);
                        break;
                    case '2':
                        kq = "Hai";
                        System.out.println("Da tra b " + kq);
                        break;
                    case '3':
                        kq = "Ba";
                        System.out.println("Da tra b " + kq);
                        break;
                    case '4':
                        kq = "Bon";
                        System.out.println("Da tra b " + kq);
                        break;
                    case '5':
                        kq = "Nam";
                        System.out.println("Da tra b " + kq);
                        break;
                    case '6':
                        kq = "Sau";
                        System.out.println("Da tra b " + kq);
                        break;
                    case '7':
                        kq = "Bay";
                        System.out.println("Da tra b " + kq);
                        break;
                    case '8':
                        kq = "Tam";
                        System.out.println("Da tra b " + kq);
                        break;
                    case '9':
                        kq = "Chin";
                        System.out.println("Da tra b " + kq);
                        break;

                }
                //Gui ket qua cho Client
                byte b[] = kq.getBytes();
                os.write(b);
            }
            //Dong ket noi
            s.close();
            System.out.println("Client o dia chi: " + s.getInetAddress().toString() + " da thoat");
        } catch (IOException e) {
            System.out.println("Co bi khi tao long doc va gui du lieu");
        }
    }
}

public class ServerDocSo {
    public static void main(String[] args) {
        try {
            //tao Server Socket cong 7000
            ServerSocket ss = new ServerSocket(7000);
            System.out.println("Da tao xong Server Socket");
            while (true) {
                //Chap nhan cho ...
                Socket s = ss.accept();
                System.out.println("Co 1 Client noi ket o dia chi " + s.getInetAddress().toString());
                Worker wk = new Worker(s);
            }//end of while
        }
        catch (IOException e) {
            System.out.println("Khong khoi tao duoc Server");
        }
        }
    }
