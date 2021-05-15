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

import java.util.*;

public class FightHandler {

    // TODO da eliminare
    Menu menu = new Menu();

    public void LetThemFight (Stack<TamaGolem> tamaGolem1, Stack<TamaGolem> tamaGolem2, int stones, int commonStones, ArrayList<TamaElement> usedElements, Player player1, Player player2, HashMap<TamaElement, Integer> numberOfElementAndStones1, HashMap<TamaElement, Integer> numberOfElementAndStones2) {
        //System.out.printf(UsefulStrings.START_FIGHT_MESSAGE, player1.getName(), player2.getName(), UsefulStrings.getEnergy(), menu.getTamaGolemsNumber(),UsefulStrings.getEnergy() );
        //Ho messo .get(0) solo per silenziare, si prenderà il golem durante il match.
        menu.chooseStones(player1, commonStones, numberOfElementAndStones1, usedElements, stones, tamaGolem1.get(0));
        menu.chooseStones(player2, commonStones, numberOfElementAndStones2, usedElements, stones, tamaGolem2.get(0));
    }
}