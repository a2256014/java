package ch16.gameLevel;

public class Player {

    private GameLevel level;

    public Player(){
        level = new BeginnerLevel();
        level.showLevelMessage();
    }


    public GameLevel getLevel() {
        return level;
    }

    public void upgradeLevel( GameLevel level ) {
        this.level = level;
        level.showLevelMessage();
    }

    public void play(int count) {
        level.go(count);
    }

}