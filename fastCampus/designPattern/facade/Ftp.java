package designPattern.facade;

public class Ftp {

    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path){
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect(){
        System.out.println("Ftp Host : "+host+" Port : "+port+" connect");
    }

    public void moveDirectory(){
        System.out.println("Ftp path : " + path + "로 이동");
    }

    public void disConnect(){
        System.out.println("Ftp disconnect");
    }
}
