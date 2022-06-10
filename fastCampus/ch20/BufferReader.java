package ch20;

import java.io.*;
import java.net.Socket;

public class BufferReader {
    public static void main(String[] args) {
        /*
        long millisecond = 0;
        try (FileInputStream fis = new FileInputStream("fastCampus/ch20/a.zip");
             FileOutputStream fos = new FileOutputStream("fastCampus/ch20/copy.zip");){
            millisecond = System.currentTimeMillis();

            int i;
            while ((i = fis.read())!=-1){
                fos.write(i);
            }
            millisecond = System.currentTimeMillis()-millisecond;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(millisecond);
        */
        long millisecond = 0;
        try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream("fastCampus/ch20/a.zip"));
             BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("fastCampus/ch20/copy.zip"))) {
            millisecond = System.currentTimeMillis();

            int i;
            while ((i = fis.read()) != -1) {
                fos.write(i);
            }
            millisecond = System.currentTimeMillis() - millisecond;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(millisecond);

        /*
        활용법
        Socket socket = new Socket();

        try {
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
    }
}
