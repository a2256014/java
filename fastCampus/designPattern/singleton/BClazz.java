package designPattern.singleton;

public class BClazz {
    private SocketClient socketClient = null;

    BClazz(){
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
