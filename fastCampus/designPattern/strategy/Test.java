package designPattern.strategy;


//base64 normal append = 전략 객체
//encoder = 전략 객체 사용
public class Test {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();

        //base 64
        EncodingStrategy base64 = new Base64Strategy();

        //normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);

        System.out.println("base64 : " + base64Result);
        System.out.println("normal : " + normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        System.out.println("append : " + encoder.getMessage(message));
    }
}
