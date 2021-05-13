package it.unibs.fp.MainTamaGolem;

import it.unibs.fp.Utilities.*;

import java.util.ArrayList;
import java.util.Stack;

public class Fight {
    public void LetThemFight (Stack<TamaGolem> tamaGolems, int stones, int commonStones, ArrayList<Elements> elements, Player player1, Player player2) {
        player1.team = tamaGolems;
        player2.team = tamaGolems;

    }
}
