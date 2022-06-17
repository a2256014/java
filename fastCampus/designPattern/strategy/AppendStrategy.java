package designPattern.strategy;

public class AppendStrategy implements EncodingStrategy{
    @Override
    public String encode(String text) {
        return "Append ABCD"+text;
    }
}
