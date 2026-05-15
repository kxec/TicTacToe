package GameController;

import Exceptions.InvalidDimesionException;
import Exceptions.PlayerCountException;
import Models.Game;
import Models.Move;
import Models.Player;

import java.util.List;

public class GameController {

    public Game startGame(List<Player> players , Integer dimension) throws InvalidDimesionException, PlayerCountException
    {
        return Game.getGameBuilder().setDimension(dimension).setPlayers(players).build();
    }

    public void displayCurrBoard(Game game)
    {
        game.getBoard().displayBoard();
    }

    public void makeMove(Game game)
    {
       Move currMove =  game.getPlayers().get(game.getCurrPlayeridx()).makeMove(game);
       game.getMoves().add(currMove);
    }


}
