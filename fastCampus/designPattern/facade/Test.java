package designPattern.facade;

public class Test {
    public static void main(String[] args) {
        //적용 전
        Ftp ftpClient = new Ftp("www.naver.com",22,"/Test/Ftp");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Reader reader = new Reader("testRead.txt");
        reader.fileConnect();
        reader.fileRead();

        Writer writer = new Writer("testWrite,txt");
        writer.fileConnect();
        writer.fileWrite();

        ftpClient.disConnect();
        reader.fileDisconnect();
        writer.fileDisconnect();

        //적용 후
        System.out.println();
        System.out.println("적용 후");
        SftpClient sftpClient = new SftpClient("www.naver.com",22,"/Test/Ftp","test.txt");

        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
    }
}
