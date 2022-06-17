package designPattern.singleton;

public class Test {
    public static void main(String[] args) {
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두 소켓은 같은가? : " + aClient.equals(bClient));
    }
}
