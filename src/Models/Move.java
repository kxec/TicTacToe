package Models;

public class Move {
    private Player moveplayer;
    private Cell movecell;

    public Move(Player moveplayer, Cell movecell) {
        this.moveplayer = moveplayer;
        this.movecell = movecell;
    }

    public void setMovecell(Cell movecell) {
        this.movecell = movecell;
    }

    public void setMoveplayer(Player moveplayer) {
        this.moveplayer = moveplayer;
    }

    public Player getMoveplayer() {
        return moveplayer;
    }

    public Cell getMovecell() {
        return movecell;
    }

}
