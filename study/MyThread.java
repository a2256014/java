public class MyThread extends Thread{
    String str;
    public MyThread(String str){
        this.str = str;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(str);

            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread1 : end");
    }
}
