package GameController;

import Exceptions.InvalidDimesionException;
import Exceptions.PlayerCountException;
import Factory.WinningStrategy.bestGameWinningStrategy;
import Factory.WinningStrategy.gameWinningStrategy;
import Models.Game;
import Models.GameStatus;
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

    public void makeMove(Game game , gameWinningStrategy gws)
    {
        Player curr_player = game.getPlayers().get(game.getCurrPlayeridx());
        System.out.println(curr_player.getName() + " is making the move");
       Move currMove =  curr_player.makeMove(game);
       game.getMoves().add(currMove);
       boolean hasWon = gws.checkWin(currMove);
       if(hasWon)
       {
           game.setStatus(GameStatus.WIN);
           game.setWinner(currMove.getMoveplayer());
       }
    }

    public gameWinningStrategy getWinningStrategy(int d)
    {
        return new bestGameWinningStrategy(d);
    }

    public boolean checkDraw(Game game)
    {
        return game.checkDraw();
    }


}
