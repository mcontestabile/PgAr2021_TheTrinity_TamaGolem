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

public class FightHandler {
    private int elements;
    private int commonStones;
    private int tamas;
    private int golemStones;
    private Player playerA;
    private Player playerB;
    private ArrayList<TamaElement> usedElements;
    private HashMap<TamaElement, Integer> numberOfElementAndStones;

    public FightHandler(int matchLevel, Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerA = playerB;
        elements = FightUtils.howManyElements(matchLevel);
        golemStones = FightUtils.howManyStones(elements);
        tamas = FightUtils.howManyTamagolems(elements, golemStones);
        commonStones = FightUtils.howManyCommonStones(tamas, elements, golemStones);
        usedElements = FightUtils.generateRandomElements(elements);
        numberOfElementAndStones = FightUtils.generateElementAndStonesMap(usedElements, FightUtils.howManyStonesForEachElement(tamas, elements, golemStones));
        addTamaGolems();
    }

    public void LetThemFight () {
        // invoco la funzione equilibrio con gli active golem
    }

    private void addTamaGolems() {
        for (int i = 0; i < tamas; i++) {
            String tamaName = UsefulStrings.TAMAGOLEM_NAME + i;
            TamaGolem t = new TamaGolem(FightUtils.ENERGY, golemStones, usedElements, tamaName);
            t.setName(tamaName);
            playerA.addTamaGolem(t);
            playerA.addTamaGolem(t);
        }
    }

    public int getElements() {
        return elements;
    }

    public int getCommonStones() {
        return commonStones;
    }

    public int getTamas() {
        return tamas;
    }

    public int getGolemStones() {
        return golemStones;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public ArrayList<TamaElement> getUsedElements() {
        return usedElements;
    }

    public HashMap<TamaElement, Integer> getNumberOfElementAndStones() {
        return numberOfElementAndStones;
    }
}