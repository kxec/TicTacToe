package Models;

public class Bot extends Player{

    private difficultyLevel level;

    public Bot(String name , String symbol ,difficultyLevel level) {
        super(name ,symbol);
        this.level = level;
    }


}
