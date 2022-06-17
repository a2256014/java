package designPattern.proxy;

public class Test {
    public static void main(String[] args) {
        Browser browser = new Browser("www.naver.com");
        browser.show();

        IBrowser browser1 = new BrowserProxy("www.naver.com/proxy");
        browser1.show();
        browser1.show();
        browser1.show();
        browser1.show();


    }
}
