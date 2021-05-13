package it.unibs.fp.MainTamaGolem;

import it.unibs.fp.Utilities.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Fight {
    private HashMap<Elements, Integer> numberOfStones = new HashMap();
    private static final int MIN_STONES = 0;
    public void LetThemFight (ArrayList<TamaGolem> tamaGolems, int stones, int commonStones, ArrayList<Elements> elements, Player player1, Player player2) {
        player1.team = tamaGolems;
        player2.team = tamaGolems;

    }

    public void chooseStones (int stones, ArrayList<Elements> elements) {
        for (Elements e: elements) {
            int number = DataInput.readIntWIthMaxAndMin(UsefulStrings.getHowManyStones(), MIN_STONES, stones);
            numberOfStones.put(e, number);
            stones -= number;
        }
    }
}
