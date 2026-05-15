package Models;

public class Cell {
    private Player player;
    private Position position;
    private CellState cellstate;

    public Cell(Player player, Position position) {
        this.player = player;
        this.position = position;
        this.cellstate = CellState.EMPTY;
    }



    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setCellstate(CellState cellstate) {
        this.cellstate = cellstate;
    }

    public Player getPlayer() {
        return player;
    }

    public Position getPosition() {
        return position;
    }

    public CellState getCellstate() {
        return cellstate;
    }
}
