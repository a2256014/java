//각각의 Thread
public class MusicPlayer extends Thread{
    int type;
    MusicBox musicBox;
    public  MusicPlayer(int type,MusicBox musicBox){
        this.type=type;
        this.musicBox=musicBox;
    }
    @Override
    public void run() {
        switch (type) {
            case 1 -> musicBox.playMusicA();
            case 2 -> musicBox.playMusicB();
            case 3 -> musicBox.playMusicC();
            default -> {
            }
        }
    }
}
