import java.net.*;
import java.io.*;
public class ClientDocSo {
    public static void main(String[] args) {
        try {
            //noi den server
            Socket s = new Socket("127.0.0.1", 7000);
            //Lay 2 stream nhap xuat is - os
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            while (true) {
                //Nhap ki tu tu ban phim
                System.out.print("Nhap 1 ky tu so: ");
                int ch = System.in.read();
                //Gui qua server
                os.write(ch);
                System.in.skip(2); //Bo 2 ki tu
                //Kiem tra dieu kien de thoat
                if (ch == '@') break;
                //Nhan ket qua tra ve
                byte b[] = new byte[50];
                int n = is.read(b);
                //Hien thi ket qua
                String ketqua = new String(b, 0, n);
                System.out.println("Nhan duoc: " + ketqua);
            }
            //Dong ket noi
            s.close();
        }
        catch (IOException e) {
            System.out.println("Co bi khi thực thi");

        }
    }
}
