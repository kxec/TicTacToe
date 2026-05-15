package Models;

import Factory.BotStrategy.BotPlayingStrategy;
import Factory.BotStrategy.EasyBotPlayingStrategy;



public class Bot extends Player{

    private difficultyLevel level;

    public Bot(String name , String symbol ,difficultyLevel level) {
        super(name ,symbol);
        this.level = level;
    }

    public Position decideMove(Game game)
    {
        BotPlayingStrategy strategy;

       if(level == difficultyLevel.EASY)
            strategy = new EasyBotPlayingStrategy();
       else
           strategy = new EasyBotPlayingStrategy();

        Position decidedPos = strategy.playingAlgo(game);

        if(!this.validMove(game , decidedPos))
        {
            return decideMove(game);
        }

        return decidedPos;
    }


}
