package designPattern.aop;

import designPattern.proxy.Html;
import designPattern.proxy.IBrowser;

//proxy pattern 활용
public class AopBrowser implements IBrowser {

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after){
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {
        before.run();
        if(this.html == null){
            this.html = new Html(this.url);
            System.out.println("AopBrowser html loading from : "+this.url);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        after.run();
        System.out.println("AopBrowser html cache : " + this.url);
        return this.html;
    }
}
