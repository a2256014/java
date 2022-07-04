package ch20;

import java.io.InputStreamReader;

public class In_p {
    public static void main(String[] args) {
        /*
        System.out.println("input");

        try {
            int i = System.in.read();
            System.out.println(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            int i;
            while ((i = isr.read()) != '\n'){
                System.out.print((char) i);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
