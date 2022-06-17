package designPattern.aop;

import designPattern.proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Test {
    public static void main(String[] args) {
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser browser = new AopBrowser("www.naver.com/aop",
                //Runnable run 하나만 있어서 람다식 가능 (헷갈릴 여지가 없음)
                //before
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                //after
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        browser.show();
        System.out.println("loading time : " + end.get());

        browser.show();
        System.out.println("loading time : " + end.get());
    }
}
