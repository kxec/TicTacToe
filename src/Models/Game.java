package Models;

import Exceptions.InvalidDimesionException;
import Exceptions.PlayerCountException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Move> moves;
    private List<Player> players;
    private Board board;
    private int currPlayeridx;
    private GameStatus status;
    private Player winner;

    public Game(List<Player> players , Board board) {
        this.moves = new ArrayList<>();
        this.players = players;
        this.board = board;
        this.currPlayeridx = 0;
        this.status = GameStatus.IN_PROGRESS;
    }


    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setCurrPlayeridx(int currPlayeridx) {
        this.currPlayeridx = currPlayeridx;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public int getCurrPlayeridx() {
        return currPlayeridx;
    }

    public GameStatus getStatus() {
        return status;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean checkDraw()
    {
        int d = board.getGrid().size();
        return moves.size() == (d * d);
    }

    public static GameBuilder getGameBuilder()
    {
        return new GameBuilder();
    }

    public static class GameBuilder{

        private List<Player> players;
        private Integer dimension;

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setDimension(Integer dimension) {
            this.dimension = dimension;
            return this;
        }

        public Game build () throws InvalidDimesionException, PlayerCountException {

                if (dimension < 3) throw new InvalidDimesionException("Hello , you have Entered wrong dimension");
                if (players.size() < dimension - 1 || players.size() > dimension - 1) throw new PlayerCountException("Hello , Please add Valid number of players");

                return new Game(players , new Board(dimension));
        }

    }

}
