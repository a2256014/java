package ch16.gameLevel;

public abstract class GameLevel {

    public abstract void run();
    public abstract void jump();
    public abstract void turn();
    public abstract void showLevelMessage();

    //Template Method
    final public void go(int count) {
        run();
        for(int i = 0; i<count; i++) {
            jump();
        }
        turn();
    }

}
