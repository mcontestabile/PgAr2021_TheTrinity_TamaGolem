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
    public static final int EASY_LEVEL = 1;
    public static final int NORMAL_LEVEL = 2;
    public static final int HARD_LEVEL = 3;
    public static final int MIN_ELEMENTS = 3;
    public static final int MAX_EASY_LEVEL = 5;
    public static final int MIN_NORMAL_LEVEL = 6;
    public static final int MAX_NORMAL_LEVEL = 8;
    public static final int MIN_HARD_LEVEL = 9;
    public static final int MAX_ELEMENTS = 10;
    public static final int ENERGY = 10;

    // TODO da eliminare
    Menu menu = new Menu();

    public void LetThemFight (Stack<TamaGolem> tamaGolem1, Stack<TamaGolem> tamaGolem2, int stones, int commonStones, ArrayList<TamaElements> usedElements, Player player1, Player player2, HashMap<TamaElements, Integer> numberOfElementAndStones1, HashMap<TamaElements, Integer> numberOfElementAndStones2) {
        player1.team = tamaGolem1;
        player2.team = tamaGolem2;

        //System.out.printf(UsefulStrings.START_FIGHT_MESSAGE, player1.getName(), player2.getName(), UsefulStrings.getEnergy(), menu.getTamaGolemsNumber(),UsefulStrings.getEnergy() );
        //Ho messo .get(0) solo per silenziare, si prenderà il golem durante il match.
        menu.chooseStones(player1, commonStones, numberOfElementAndStones1, usedElements, stones, tamaGolem1.get(0));
        menu.chooseStones(player2, commonStones, numberOfElementAndStones2, usedElements, stones, tamaGolem2.get(0));
    }
}
