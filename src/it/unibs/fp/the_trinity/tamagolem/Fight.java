/*
 * Copyright (c) 2021, The Trinity and/or its affiliates. All rights reserved.
 * THE TRINITY PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package it.unibs.fp.the_trinity.tamagolem;

import it.unibs.fp.the_trinity.utilities.UsefulStrings;
import java.util.*;

public class Fight {
    Menu menu = new Menu();

    public void LetThemFight (Stack<TamaGolem> tamaGolems1, Stack<TamaGolem> tamaGolems2, int stones, int commonStones, ArrayList<TamaElements> usedElements, Player player1, Player player2, HashMap<TamaElements, Integer> numberOfElementAndStones1, HashMap<TamaElements, Integer> numberOfElementAndStones2) {
        player1.team = tamaGolems1;
        player2.team = tamaGolems2;

        System.out.printf(UsefulStrings.getStartFightMessage(), player1.getName(), player2.getName(), UsefulStrings.getEnergy(), menu.getTamaGolemsNumber(),UsefulStrings.getEnergy() );
        //Ho messo .get(0) solo per silenziare, si prenderà il golem durante il match.
        menu.chooseStones(player1, commonStones, numberOfElementAndStones1, usedElements, stones, tamaGolems1.get(0));
        menu.chooseStones(player2, commonStones, numberOfElementAndStones2, usedElements, stones, tamaGolems2.get(0));
    }
}
