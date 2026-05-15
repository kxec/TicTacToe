package Factory.BotStrategy;

import Models.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {


    public  Position playingAlgo(Game game) {

        Board currBoard = game.getBoard();
        List<List<Cell>> grid = currBoard.getGrid();

        for(List<Cell> gridRow : grid)
        {
            for(Cell cell : gridRow)
            {
                if(cell.getCellstate() ==  CellState.EMPTY)
                    return cell.getPosition();
            }
        }

        return null;
    }
}
