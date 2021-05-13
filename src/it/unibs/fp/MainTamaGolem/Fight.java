package it.unibs.fp.MainTamaGolem;

import it.unibs.fp.Utilities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Fight {
    Menu menu = new Menu();

    public void LetThemFight (Stack<TamaGolem> tamaGolems1, Stack<TamaGolem> tamaGolems2, int stones, int commonStones, ArrayList<Elements> usedElements, Player player1, Player player2, HashMap<Elements, Integer> numberOfElementAndStones1, HashMap<Elements, Integer> numberOfElementAndStones2) {
        player1.team = tamaGolems1;
        player2.team = tamaGolems2;

        //Ho messo .get(0) solo per silenziare, si prenderà il golem durante il match.
        menu.chooseStones(player1, commonStones, numberOfElementAndStones1, usedElements, stones, tamaGolems1.get(0));
        menu.chooseStones(player2, commonStones, numberOfElementAndStones2, usedElements, stones, tamaGolems2.get(0));
    }
}
