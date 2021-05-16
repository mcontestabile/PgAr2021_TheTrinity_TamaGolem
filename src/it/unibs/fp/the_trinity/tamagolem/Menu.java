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

import it.unibs.fp.the_trinity.utilities.DataInput;
import it.unibs.fp.the_trinity.utilities.Time;
import it.unibs.fp.the_trinity.utilities.UsefulStrings;

import java.util.*;

/**
 * The {@code Menu} class contains methods to ...
 *
 * @author Contestabile Martina
 * @author Iannella Simone
 */
public class Menu {
    private Player player1;
    private Player player2;

    public void menu() {
        System.out.println(UsefulStrings.WELCOME_MESSAGE);
        Time.pause(Time.MEDIUM_MILLIS_PAUSE);

        setPlayersNames();
        int matchLevel = DataInput.readIntWithMaxAndMin(UsefulStrings.SELECT_LEVEL, FightUtils.EASY_LEVEL, FightUtils.HARD_LEVEL);
        FightHandler fightHandler = new FightHandler(matchLevel, player1, player2);
        Equilibrium equilibrium = new Equilibrium(FightUtils.ENERGY, fightHandler.getElements());

        if (fightHandler.getTamas() == 1)
            System.out.print(UsefulStrings.ONE_TAMAGOLEM);
        else
            System.out.printf(UsefulStrings.HOW_MANY_TAMAGOLEMS, fightHandler.getTamas());
        Time.pause(Time.LOW_MILLIS_PAUSE);
        System.out.printf(UsefulStrings.HOW_MANY_ELEMENTS, fightHandler.getElements());
        Time.pause(Time.LOW_MILLIS_PAUSE);
        System.out.printf(UsefulStrings.HOW_MANY_STONES, fightHandler.getGolemStones());
        Time.pause(Time.LOW_MILLIS_PAUSE);
        System.out.println(UsefulStrings.getStartFightMessage(player1.getName(), player2.getName(), fightHandler.getTamas(), FightUtils.ENERGY, fightHandler.getGolemStones()));
        Time.pause(Time.HIGH_MILLIS_PAUSE);

        // TODO to remove
        System.out.println(fightHandler.getUsedElements());

        boolean end = false;
        do {
            // riempio le listedi elementi dei due golem attivi dei player
            // "invoco" un golem da ogni player
            // eseguo la funzione di equilibrium calcolare i danni
            // controllo se i golem sono ancora vivi, in tal caso passo al secondo turno
            // se uno dei due golem e' morto, controllo se ci sono ancora golem disponibili
            // in caso affermativo chiamo nuovamente il metodo per scegliere le pietre
            // se un player ha finito i golem la partita e' finita e decreto il vincitore
            // passo al turno successivo
        } while (!end);
    }

    // TODO add comments
    private void setPlayersNames() {
        char homonymAnswer;
        player1 = new Player(DataInput.readNotEmptyString(UsefulStrings.PLAYER_1_NAME_REQUEST));
        player2 = new Player(DataInput.readNotEmptyString(UsefulStrings.PLAYER_2_NAME_REQUEST));
        if (player1.getName().equalsIgnoreCase(player2.getName())) {
            homonymAnswer = DataInput.readChar(UsefulStrings.HOMONYM_MESSAGE);
            if (homonymAnswer == 'S' || homonymAnswer == 's') {
                String tmp = player2.getName();
                do {
                    player2.homonymFix();
                } while (player2.getName().equals(tmp));
                System.out.println(UsefulStrings.HOMONYM_FIXED_MESSAGE + player2.getName() + "\".");
            } else {
                String p1Name = player1.getName();
                do {
                    player2.setName(DataInput.readNotEmptyString(UsefulStrings.player2SecondNameRequest(player1.getName())));
                } while ((player2.getName().equalsIgnoreCase(p1Name)));
            }
        }
    }

    /**
     * This method returns the elements used during the fight.
     *
     * @return usedElements.
     */
    /*
    public ArrayList<TamaElement> getUsedElements() {
        return usedElements;
    }
     */

    /*
    public ArrayList<TamaElement> chooseGolemStones(Player player) {
        System.out.printf(UsefulStrings.SETTING_ELEMENTS, player.getName());

        String e;
        int choice = 0;

        int availableStones = commonStones;



        while (availableStones>0) {
            System.out.println(usedElements);

            boolean contains = false;
            do {
                e = DataInput.readNotEmptyString(UsefulStrings.CHOOSE_ELEMENT_NAME);
                String t = getElementFromAbbreviation(usedElements, e);
                if (t != null) {
                    contains = true;
                    e = t;
                    choice = DataInput.readIntWithMaxAndMin(UsefulStrings.getSettingStonesNumberForElement(e), 0, availableStones);
                }
            } while (!usedElements.contains(e) || !contains);


            int position = usedElements.indexOf(e);
            numberOfElementAndStones.replace(usedElements.get(position), availableStones - choice); //Se non funzia, piango

            availableStones--;
        }
    }
     */
    private String getElementFromAbbreviation(ArrayList<TamaElement> elements, String abbreviation) {
        for (TamaElement t : elements)
            if (t.containsAbbreviation(abbreviation)) return t.name();
        return null;
    }
}