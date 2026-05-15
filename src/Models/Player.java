package Models;

import java.util.Scanner;

public class Player {

    private  String name;
    private String symbol;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void setName(String name , String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public Move makeMove(Game game)
    {
        Position pos = this.decideMove(game);

        Cell move_cell = game.getBoard().getGrid().get(pos.getRow()).get(pos.getCol());

        move_cell.setPosition(pos);
        move_cell.setPlayer(this);
        move_cell.setCellstate(CellState.FILLED);

        return new Move(this , move_cell);

    }

    public Position decideMove(Game game)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Please enter the row index of your move");
        int r = scn.nextInt();

        while(r < 0 || r >= game.getBoard().getGrid().size())
        {
            System.out.println("Please Enter a valid row");
            r = scn.nextInt();
        }

        System.out.println("Please enter the column index of your move");
        int c = scn.nextInt();

        while(c < 0 || c >= game.getBoard().getGrid().size())
        {
            System.out.println("Please Enter a valid column");
            c = scn.nextInt();
        }

        Position decidedPos = new Position(r , c);

        if(!this.validMove(game , decidedPos))
            {
                return decideMove(game);
            }

        return decidedPos;
    }

    public boolean validMove(Game game , Position decidedPos)
    {
        Cell decidedPosCell = game.getBoard().getGrid().get(decidedPos.getRow()).get(decidedPos.getCol());

        return decidedPosCell.getCellstate() == CellState.EMPTY;
    }

}
