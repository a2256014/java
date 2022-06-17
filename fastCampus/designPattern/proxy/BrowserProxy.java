package designPattern.proxy;

public class BrowserProxy implements IBrowser{
    private String url;
    private Html html;

    public BrowserProxy(String url){
        this.url = url;
    }
    @Override
    public Html show() {
        if(this.html == null){
            this.html = new Html(this.url);
            System.out.println("BrowserProxy loading html from : "+ this.url);
        }
        System.out.println("BrowserProxy use cache html : "+ this.url);
        return this.html;
    }
}
