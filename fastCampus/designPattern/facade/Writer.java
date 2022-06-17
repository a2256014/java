package designPattern.facade;

public class Writer {
    private String fileName;

    public Writer(String fileName){
        this.fileName = fileName;
    }

    public void fileConnect(){
        String format = String.format("Writer %s connect",fileName);
        System.out.println(format);
    }

    public void fileWrite(){
        String format = String.format("Writer %s write",fileName);
        System.out.println(format);
    }

    public void fileDisconnect(){
        String format = String.format("Writer %s disconnect",fileName);
        System.out.println(format);
    }
}
