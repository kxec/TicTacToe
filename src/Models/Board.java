package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Cell>> board;

    public Board(int dimension)
    {
        this.board = new ArrayList<>();

        for(int i = 0 ; i < dimension ; i++)
        {
            board.add(new ArrayList<>());

            for(int j = 0 ; j < dimension ; j++)
            {
            board.get(i).add(new Cell(null , new Position(i , j)));
            }
        }
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }
}
