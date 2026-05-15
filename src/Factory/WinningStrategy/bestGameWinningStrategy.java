package Factory.WinningStrategy;

import Models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bestGameWinningStrategy implements gameWinningStrategy
{
    private List<HashMap<String , Integer>> rowhm;
    private List<HashMap<String , Integer>> colhm;
    private HashMap<String , Integer> mainDiagonalhm;
    private HashMap<String , Integer> otherDiagonalhm;

    public  bestGameWinningStrategy(int dimension)
    {
        rowhm = new ArrayList<>();
        for(int i = 0 ; i < dimension ; i++) rowhm.add(new HashMap<>());

        colhm = new ArrayList<>();
        for(int j = 0 ; j < dimension ; j++) colhm.add(new HashMap<>());

        mainDiagonalhm = new HashMap<>();
        otherDiagonalhm = new HashMap<>();

    }


    public boolean checkWin(Move move) {

        int dimension = rowhm.size();
        int move_row = move.getMovecell().getPosition().getRow();
        int move_col = move.getMovecell().getPosition().getCol();
        String curr_ps = move.getMoveplayer().getSymbol();

        rowhm.get(move_row).put(curr_ps , rowhm.get(move_row).getOrDefault(curr_ps, 0) + 1);
        if( rowhm.get(move_row).get(curr_ps) == dimension) return true;

        colhm.get(move_col).put(curr_ps , colhm.get(move_col).getOrDefault(curr_ps, 0) + 1);
        if( colhm.get(move_col).get(curr_ps) == dimension) return true;

        if(move_row == move_col)
        {
            mainDiagonalhm.put(curr_ps , mainDiagonalhm.getOrDefault(curr_ps , 0) + 1);
            if(mainDiagonalhm.get(curr_ps) == dimension) return true;
        }

        if(move_row + move_col == dimension - 1)
        {
            otherDiagonalhm.put(curr_ps , otherDiagonalhm.getOrDefault(curr_ps , 0) + 1);
            return otherDiagonalhm.get(curr_ps) == dimension;
        }

        return false;
    }
}
