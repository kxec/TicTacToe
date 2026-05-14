package GameController;

import Models.Game;
import Models.Player;

import java.util.List;

public class GameController {

    public void startGame(List<Player> players , Integer dimension)
    {
        Game.getGameBuilder().setDimension(dimension).setPlayers(players);
    }

}
