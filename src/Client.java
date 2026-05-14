import GameController.GameController;
import Models.Game;
import Models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);

        System.out.println("Welcome to the Tic Tac Toe Game");
        System.out.println("Please Enter the Dimensions for the game :- ");
        int d = scn.nextInt();

        List<Player> players = new ArrayList<>();

        System.out.println("Do you want a bot in the game yes/no");
        scn.nextLine();

        String res = scn.nextLine();

        int humanPlayers = d - 1;

        if(res.equals("yes"))
        {
            System.out.println("Please name our Dearest Bot like Kenny , Maverick etc be sure to give him a Cool name");
            String name = scn.nextLine();
            System.out.println("Please help him in Selecting the symbol");
            String symbol = scn.nextLine();

            players.add(new Player(name , symbol));
            humanPlayers--;
        }

        while(humanPlayers > 0)
        {
            System.out.println("Please Enter Your name");
            String name = scn.nextLine();
            System.out.println("Please Enter your Symbol");
            String symbol = scn.nextLine();

            players.add(new Player(name , symbol));
            humanPlayers--;
        }

        GameController gm = new GameController();

        gm.startGame(players , d);


    }
}
