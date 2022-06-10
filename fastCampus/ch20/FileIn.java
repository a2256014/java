package ch20;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;

public class FileIn {
    public static void main(String[] args) {
        FileReader fis = null;
        try {
            fis = new FileReader("fastCampus/ch20/test.txt");
            int i;
            while ((i=fis.read())!=-1){
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
