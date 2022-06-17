package designPattern.singleton;

public class AClazz {
    private SocketClient socketClient = null;

    AClazz(){
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
