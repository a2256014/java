package designPattern.facade;

public class Reader {

    private String fileName;

    public Reader(String fileName){
        this.fileName = fileName;
    }

    public void fileConnect(){
        String format = String.format("Reader %s connect",fileName);
        System.out.println(format);
    }

    public void fileRead(){
        String format = String.format("Reader %s read",fileName);
        System.out.println(format);
    }

    public void fileDisconnect(){
        String format = String.format("Reader %s disconnect",fileName);
        System.out.println(format);
    }
}
