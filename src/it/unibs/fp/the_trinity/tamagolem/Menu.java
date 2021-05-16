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

import it.unibs.fp.the_trinity.utilities.CircularList;
import it.unibs.fp.the_trinity.utilities.DataInput;
import it.unibs.fp.the_trinity.utilities.Time;
import it.unibs.fp.the_trinity.utilities.UsefulStrings;

/**
 * The {@code Menu} class contains methods to ...
 *
 * @author Contestabile Martina
 * @author Iannella Simone
 */
public class Menu {
    private Player playerA;
    private Player playerB;

    public void menu() {
        int interaction;
        TamaElement a;
        TamaElement b;
        System.out.println(UsefulStrings.WELCOME_MESSAGE);
        System.out.println(UsefulStrings.TITLE);
        System.out.println(UsefulStrings.DOUBLE_LINE);
        Time.pause(Time.HIGH_MILLIS_PAUSE);
        boolean end = false;

        do {
            setPlayersNames();
            System.out.println(UsefulStrings.FRAME);
            int matchLevel = DataInput.readIntWithMaxAndMin(UsefulStrings.SELECT_LEVEL, FightUtils.EASY_LEVEL, FightUtils.HARD_LEVEL);
            FightHandler fightHandler = new FightHandler(matchLevel, playerA, playerB);

            Equilibrium equilibrium = new Equilibrium(FightUtils.ENERGY, fightHandler.getElements());

            Time.pause(Time.LOW_MILLIS_PAUSE);
            System.out.println(UsefulStrings.DOUBLE_LINE);
            System.out.printf(UsefulStrings.HOW_MANY_TAMAGOLEMS, fightHandler.getTamas());
            System.out.printf(UsefulStrings.HOW_MANY_ELEMENTS, fightHandler.getElements());
            System.out.printf(UsefulStrings.HOW_MANY_STONES, fightHandler.getGolemStones());
            Time.pause(Time.LOW_MILLIS_PAUSE);
            System.out.println(UsefulStrings.getStartFightMessage(playerA.getName(), playerB.getName(), fightHandler.getTamas(), FightUtils.ENERGY, fightHandler.getGolemStones()));
            Time.pause(Time.HIGH_MILLIS_PAUSE);

            do {
                fightHandler.getPlayerA().getActiveGolem().addElements(chooseGolemStones(fightHandler, playerA));
                fightHandler.getPlayerB().getActiveGolem().addElements(chooseGolemStones(fightHandler, playerB));
                do {
                    a = fightHandler.getPlayerA().getActiveGolem().nextElement();
                    b = fightHandler.getPlayerB().getActiveGolem().nextElement();
                    interaction = equilibrium.calculateInteraction(fightHandler.getUsedElements().indexOf(a), fightHandler.getUsedElements().indexOf(b));
                    System.out.println(a.toString() + " VS " + b.toString());
                    System.out.println(interaction);
                    if (interaction < 0)
                        System.out.println("New life of golem A " + fightHandler.getPlayerA().getActiveGolem().damageGolem(-interaction));
                    else if (interaction > 0)
                        System.out.println("New life of golem B " + fightHandler.getPlayerB().getActiveGolem().damageGolem(interaction));

                    ///fightHandler.letThemFight();

                    // ✓ riempio le liste di elementi dei due golem attivi dei player
                    // ✓ "invoco" un golem da ogni player
                    // ✓ eseguo la funzione di equilibrium per calcolare i danni
                    // ✓ controllo se i golem sono ancora vivi, in tal caso passo al secondo turno
                    // ✓ se uno dei due golem e' morto, controllo se ci sono ancora golem disponibili
                    // ✓ in caso affermativo chiamo nuovamente il metodo per scegliere le pietre
                    // se un player ha finito i golem la partita e' finita e decreto il vincitore
                    // passo al turno successivo
                    // chiedo se vogliono iniziare una nuova partita
                } while (fightHandler.getPlayerA().isActiveGolemAlive() && fightHandler.getPlayerB().isActiveGolemAlive());
            } while (fightHandler.getPlayerA().getActiveGolem() != null && fightHandler.getPlayerB().getActiveGolem() != null);
            // stampo il vincitore
            // chiedo se vuole iniziare una nuova partita
        } while (!end);
    }

    // TODO add comments
    private void setPlayersNames() {
        char homonymAnswer;
        playerA = new Player(DataInput.readNotEmptyString(UsefulStrings.PLAYER_1_NAME_REQUEST));
        playerB = new Player(DataInput.readNotEmptyString(UsefulStrings.PLAYER_2_NAME_REQUEST));
        if (playerA.getName().equalsIgnoreCase(playerB.getName())) {
            homonymAnswer = DataInput.readChar(UsefulStrings.HOMONYM_MESSAGE);
            if (homonymAnswer == 'S' || homonymAnswer == 's') {
                String tmp = playerB.getName();
                do {
                    playerB.homonymFix();
                } while (playerB.getName().equals(tmp));
                System.out.println(UsefulStrings.HOMONYM_FIXED_MESSAGE + playerB.getName() + "\".");
            } else {
                String p1Name = playerA.getName();
                do {
                    playerB.setName(DataInput.readNotEmptyString(UsefulStrings.player2SecondNameRequest(playerA.getName())));
                } while ((playerB.getName().equalsIgnoreCase(p1Name)));
            }
        }
        Time.pause(Time.LOW_MILLIS_PAUSE);
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

    public CircularList<TamaElement> chooseGolemStones(FightHandler fightHandler, Player player) {
        CircularList<TamaElement> chosenStones = new CircularList<>();
        System.out.println(UsefulStrings.DOUBLE_LINE);
        System.out.printf(UsefulStrings.SETTING_ELEMENTS, player.getName());
        TamaElement element = null;
        String choice;
        int golemStones = fightHandler.getGolemStones();

        while (golemStones > 0) {
            // TODO migliora la stampa degli elementi
            for (TamaElement e : fightHandler.getNumberOfElementAndStones().keySet())
                if (fightHandler.remainingStonesForElement(e) > 0)
                    System.out.println("-" + e.toString());

            boolean contains = false;
            do {
                choice = DataInput.readNotEmptyString(UsefulStrings.CHOOSE_ELEMENT_NAME).toUpperCase();
                TamaElement t = TamaElement.getElementFromAbbreviation(fightHandler.getUsedElements(), choice);

                if (t != null) {

                    contains = true;
                    element = t;
                    if (fightHandler.remainingStonesForElement(element) <= 0)
                        element = null;
                }
            } while (((!TamaElement.containsElement(choice) || !fightHandler.getUsedElements().contains(TamaElement.valueOf(choice))) && !contains));

            chosenStones.add(element == null ? TamaElement.valueOf(choice) : element);
            fightHandler.decreaseStonesOfElement(element);

            golemStones--;
        }

        return chosenStones;
    }


}

