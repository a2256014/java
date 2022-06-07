//Thread 공유객체
public class MusicBox {
    public synchronized void playMusicA(){
        for(int i=0;i<10;i++){
            System.out.println("신나는 음악!");

            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized void playMusicB(){
        for(int i=0;i<10;i++){
            System.out.println("슬픈 음악!");

            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized void playMusicC(){
        for(int i=0;i<10;i++){
            System.out.println("우울한 음악!");

            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
