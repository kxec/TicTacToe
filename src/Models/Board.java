package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Cell>> grid;

    public Board(int dimension)
    {
        this.grid = new ArrayList<>();

        for(int i = 0 ; i < dimension ; i++)
        {
            grid.add(new ArrayList<>());

            for(int j = 0 ; j < dimension ; j++)
            {
            grid.get(i).add(new Cell(null , new Position(i , j)));
            }
        }
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void displayBoard()
    {
        for (List<Cell> cells : grid) {
            for (Cell currCell : cells) {
                if (currCell.getPlayer() == null)
                    System.out.print("[  ] ");

                else
                    System.out.print("[ " + currCell.getPlayer().getSymbol() + " ] ");
            }

            System.out.println();
        }
    }

}
