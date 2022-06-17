package designPattern.proxy;

public class Browser implements IBrowser{
    private String url;

    public Browser(String url){
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("browser loading html from : "+this.url);
        return new Html(this.url);
    }
}
