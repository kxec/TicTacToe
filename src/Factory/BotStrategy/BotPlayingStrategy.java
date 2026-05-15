package Factory.BotStrategy;

import Models.Game;
import Models.Position;

public interface BotPlayingStrategy {

     Position playingAlgo(Game game);
}
