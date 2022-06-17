package designPattern.observer;

public class Test {
    public static void main(String[] args) {
        Button button = new Button("button");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("message1 전달");
        button.click("message2 전달");
        button.click("message3 전달");
    }
}
