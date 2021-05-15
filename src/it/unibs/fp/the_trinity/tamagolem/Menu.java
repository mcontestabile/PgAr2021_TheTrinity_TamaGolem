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
    // TODO we can delete tamaGolems stacks, in Player there are same list
    public List<TamaElement> elem;
    public ArrayList<TamaElement> usedElements = new ArrayList<>();
    private HashMap<TamaElement, Integer> numberOfElementAndStones = new HashMap<>();

    private Player player1;
    private Player player2;

    public void menu() {
        System.out.println(UsefulStrings.WELCOME_MESSAGE);
        System.out.println(UsefulStrings.TITLE);
        Time.pause(Time.HIGH_MILLIS_PAUSE);

        boolean end = false;
        do {
            setPlayersNames();

            // TODO crea un metodo che gestisce la partita, "spostando" li' il setup
            int matchLevel = DataInput.readIntWithMaxAndMin(UsefulStrings.SELECT_LEVEL, FightUtils.EASY_LEVEL, FightUtils.HARD_LEVEL);

            int elements = howManyElements(matchLevel);
            int stones = howManyStones(elements);
            int tamas = howManyTamagolems(elements, stones);
            int commonStones = howManyCommonStones(tamas, elements, stones);

            // stones for each element only for NORMAL_LEVEL and HARD_LEVEL?
            int stonesForEachElement = howManyStonesForEachElement(tamas, elements, stones);

            Time.pause(Time.LOW_MILLIS_PAUSE);
            System.out.printf(UsefulStrings.HOW_MANY_TAMAGOLEMS, tamas);
            System.out.printf(UsefulStrings.HOW_MANY_ELEMENTS, elements);
            System.out.printf(UsefulStrings.HOW_MANY_STONES, stones);
            Time.pause(Time.LOW_MILLIS_PAUSE);

            for (int i = 0; i < tamas; i++) {
                String tamaName = "Tamagolem " + i;
                TamaGolem t = new TamaGolem(FightUtils.ENERGY, stones, usedElements, tamaName);
                t.setName(tamaName);
                player1.addTamaGolem(t);
            }

            Equilibrium equilibrium = new Equilibrium(FightUtils.ENERGY, elements);

            assignCommonStones(usedElements, commonStones, numberOfElementAndStones);


            System.out.println(UsefulStrings.getStartFightMessage(player1.getName(), player2.getName(), howManyTamagolems(elements, stones), FightUtils.ENERGY, stones));

            chooseStones(player1, commonStones, numberOfElementAndStones, usedElements, stones, player1.getActiveGolem());

            FightHandler fight = new FightHandler();
            //fight.LetThemFight(tamaGolems1, tamaGolems2, stones, commonStones, usedElements, player1, player2, numberOfElementAndStones1, numberOfElementAndStones2);
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
        Time.pause(Time.LOW_MILLIS_PAUSE);
    }

    /**
     * This method returns an {@code int} type that rapresents the
     * element's number used in the fight.
     * @param level the match's level.
     * @return the number of elements, that is an {@code int}.
     */
    private int howManyElements(int level) {
        int elementsToExtract;
        elem = Arrays.asList(TamaElement.values());

        int min = 0;
        int max = 0;

        switch (level) {
            case FightUtils.EASY_LEVEL -> {
                min = FightUtils.MIN_ELEMENTS;
                max = FightUtils.MAX_EASY_LEVEL;
            }

            case FightUtils.NORMAL_LEVEL -> {
                min = FightUtils.MIN_NORMAL_LEVEL;
                max = FightUtils.MAX_NORMAL_LEVEL;
            }

            case FightUtils.HARD_LEVEL -> {
                min = FightUtils.MIN_HARD_LEVEL;
                max = FightUtils.MAX_ELEMENTS;
            }
        }

        elementsToExtract = (int) Math.floor(Math.random() * (max - min +1) + min);

        Collections.shuffle(elem);
        for (int i=0; i<elementsToExtract; i++) usedElements.add(elem.get(i));

        return elementsToExtract;
    }

    /**
     * This method calculates the stones involved in the match.
     *
     * @param elements are the elements involved in the match.
     * @return how many stones are involved in the match.
     */
    private int howManyStones(int elements) {
        return (int) (Math.ceil((elements + 1.0) / 3.0) + 1.0);
    }

    /**
     * This method calculates the tamagolems involved in the match.
     * This integer value is based on the elements.
     *
     * @param elements are the elements involved in the match.
     * @param stones   how many stones are involved in the match.
     * @return the tamagolems' number.
     */
    private int howManyTamagolems(int elements, int stones) {
        return (int) (Math.ceil(((elements - 1.0) * (elements - 2.0)) / (2.0 * stones)));
    }

    /**
     * This method calculates the common stones involved in the match.
     *
     * @param tamagolems the tamagolems' number.
     * @param elements   are the elements involved in the match.
     * @param stones     how many stones are involved in the match.
     * @return the common stones.
     */
    private int howManyCommonStones(int tamagolems, int elements, int stones) {
        return (int) (Math.ceil(((2.0 * tamagolems * stones) / elements)) * elements);
    }

    /**
     * This method calculates the common stones for each element involved in the match.
     *
     * @param tamagolems the tamagolems' number.
     * @param elements   are the elements involved in the match.
     * @param stones     how many stones are involved in the match.
     * @return the stones for each element.
     */
    private int howManyStonesForEachElement(int tamagolems, int elements, int stones) {
        return (int) (Math.ceil((2.0 * tamagolems * stones) / elements));
    }

    /**
     * This method returns the elements used during the fight.
     *
     * @return usedElements.
     */
    public ArrayList<TamaElement> getUsedElements() {
        return usedElements;
    }

    public HashMap<TamaElement, Integer> assignCommonStones(ArrayList<TamaElement> usedElements, int stonesForEachElement, HashMap<TamaElement, Integer> numberOfElementAndStones) {
        for (TamaElement e : usedElements) {
            numberOfElementAndStones.put(e, stonesForEachElement);
        }
        return numberOfElementAndStones;
    }

    public void chooseStones(Player player, int commonStones, HashMap<TamaElement, Integer> numberOfElementAndStones, ArrayList<TamaElement> usedElements, int stones, TamaGolem activeGolem) {
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

        /* Prima si poteva selezionare una pietra alla volta,
           il while sopra consente una scelta più dinamica (assegnare
           tutte le availableStones ad un solo elemento, oppure 2 ad un elemento).
        for (int availableStones = commonStones; availableStones > 0; availableStones--) {

            System.out.println(usedElements);

            do {
                e = DataInput.readNotEmptyString(UsefulStrings.getChooseElementName());
            //    int choice = DataInput.readfIntWithMaxAndMin(UsefulStrings.getSettingStonesNumberForElement(), MIN_STONES, availableStones);
            } while (!usedElements.contains(e));

         */
    }

    /*
    public int getTamaGolemsNumber() {
        return tamaGolems.size();
    }
     */

    private String getElementFromAbbreviation(ArrayList<TamaElement>elements, String abbreviation) {
        for (TamaElement t : elements)
            if (t.containsAbbreviation(abbreviation)) return t.name();
        return null;
    }
}

