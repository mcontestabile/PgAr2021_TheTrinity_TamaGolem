package it.unibs.fp.MainTamaGolem;

import it.unibs.fp.Utilities.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Fight {
    public void LetThemFight (ArrayList<TamaGolem> tamaGolems, int stones, int commonStones, ArrayList<Elements> elements, Player player1, Player player2) {
        player1.team = tamaGolems;
        player2.team = tamaGolems;

    }
}
