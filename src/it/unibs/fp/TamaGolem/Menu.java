package it.unibs.fp.TamaGolem;

import it.unibs.fp.Utilities.*;

import java.util.*;

public class Menu {
    private static final int MIN_ELEMENTS = 3;
    private static final int MAX_EASY_LEVEL = 5;
    private static final int MIN_NORMAL_LEVEL = 6;
    private static final int MAX_NORMAL_LEVEL = 8;
    private static final int MIN_HARD_LEVEL = 9;
    private static final int MAX_ELEMENTS = 10;

    private static final int EASY_LEVEL = 1;
    private static final int NORMAL_LEVEL = 2;
    private static final int HARD_LEVEL = 3;

    ArrayList<TamaGolem> tamaGolems = new ArrayList<>();

    // This list contains the elements defined in Enum.
    ArrayList<Elements> ELEMENTS = new ArrayList<>();

    ArrayList<Elements> usedElements = new ArrayList<>();

    private final int SIZE = ELEMENTS.size();

    public void menu() {
        System.out.println(UsefulStrings.WELCOME_MESSAGE);
        System.out.println(UsefulStrings.TITLE);
        pause(1200);

        boolean start = true;
        while (start) {
            char homonymyAnswer;
            boolean nameFix = true;
            do {
                Player player1 = new Player(DataInput.readNotEmptyString(UsefulStrings.PLAYER_1_NAME_REQUEST));
                Player player2 = new Player(DataInput.readNotEmptyString(UsefulStrings.PLAYER_2_NAME_REQUEST));
                if (player1.getName().equalsIgnoreCase(player2.getName())) {
                    homonymyAnswer = DataInput.readChar(UsefulStrings.HOMONYMY_MESSAGE);
                    if (homonymyAnswer == 'S' || homonymyAnswer == 's') {
                        String tmp = player2.getName();
                        do {
                            player2.homonymyFix();
                        } while (player2.getName().equals(tmp));
                        System.out.println(UsefulStrings.HOMONYMY_FIXED_MESSAGE + player2.getName() + "\".");
                    } else nameFix = false;
                    start = false;
                }
            } while (!nameFix);

            pause(800);

            int matchLevel;
            //int matchLevel = DataInput.readIntWIthMaxAndMin(UsefulStrings.HOW_MANY_ELEMENTS, EASY_LEVEL, HARD_LEVEL);
            do {
                matchLevel = DataInput.readInt(UsefulStrings.HOW_MANY_ELEMENTS);
                if (!(matchLevel > 0 && matchLevel < 4)) {
                    System.out.println(UsefulStrings.getErrorPhrase());
                    pause(600);
                }
            } while (!(matchLevel > 0 && matchLevel < 4));

            //TODO risolvere l'amichetto tamagolem (classe) in un intero, per trovare quello che ci serve.

            switch (matchLevel) {
                case EASY_LEVEL -> {
                    /*
                     * If the user's choice is low, the match level will be 3 ≤ ml ≤ 5.
                     */
                    int elements = howManyElements(EASY_LEVEL);
                    int stones = howManyStones(elements);
                    int tamas = howManyTamagolems(elements, stones);
                    int commonStones = howManyCommonStones(tamas, elements, stones);
                    Fight fight = new Fight();
                    fight.LetThemFight(tamaGolems, stones, commonStones, usedElements);
                }

                case NORMAL_LEVEL -> {
                    /*
                     * If the user's choice is medium, the match level will be 6 ≤ ml ≤ 8.
                     */
                    int elements = howManyElements(NORMAL_LEVEL);
                    int stones = howManyStones(elements);
                    int tamas = howManyTamagolems(elements, stones);
                    int commonStones = howManyCommonStones(tamas, elements, stones);
                    int stonesForEachElement = howManyStonesForEachElement(tamas, elements, stones);
                    Fight fight = new Fight();
                    fight.LetThemFight(tamaGolems, stones, commonStones, usedElements);
                }

                case HARD_LEVEL -> {
                    /*
                     * If the user's choice is high, the match level will be 9 ≤ ml ≤ 10.
                     */
                    int elements = howManyElements(HARD_LEVEL);
                    int stones = howManyStones(elements);
                    int tamas = howManyTamagolems(elements, stones);
                    int commonStones = howManyCommonStones(tamas, elements, stones);
                    int stonesForEachElement = howManyStonesForEachElement(tamas, elements, stones);
                    Fight fight = new Fight();
                    fight.LetThemFight(tamaGolems, stones, commonStones, usedElements);
                }
            }
        }
    }

    private int howManyElements(int level) {
        Random random = new Random();
        int elementsToExtract;
        int addedElement;
        int elements = 0;

        if (level == EASY_LEVEL) {
            elementsToExtract = (int) Math.floor(Math.random() * (MAX_EASY_LEVEL - MIN_ELEMENTS + 1) + MIN_ELEMENTS);

            for (int i = 0; i < elementsToExtract; i++) {
                addedElement = random.nextInt(SIZE);
                usedElements.add(ELEMENTS.get(addedElement));
                ELEMENTS.remove(addedElement);
            }

            elements = elementsToExtract;

        } else if (level == NORMAL_LEVEL) {
            elementsToExtract = (int) Math.floor(Math.random() * (MAX_NORMAL_LEVEL - MIN_NORMAL_LEVEL + 1) + MIN_NORMAL_LEVEL);

            for (int i = 0; i < elementsToExtract; i++) {
                addedElement = random.nextInt(SIZE);
                usedElements.add(ELEMENTS.get(addedElement));
                ELEMENTS.remove(addedElement);
            }

            elements = elementsToExtract;

        } else if (level == HARD_LEVEL) {
            elementsToExtract = (int) Math.floor(Math.random() * (MAX_ELEMENTS - MIN_HARD_LEVEL + 1) + MIN_HARD_LEVEL);

            for (int i = 0; i < elementsToExtract; i++) {
                addedElement = random.nextInt(SIZE);
                usedElements.add(ELEMENTS.get(addedElement));
                ELEMENTS.remove(addedElement);
            }

            elements = elementsToExtract;
        }

        return elements;
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
     * This method returns the minimum  number of elements
     * that can be involved in the match to consider
     * it of low difficulty.
     *
     * @return MAX_ELEMENTS.
     */
    public static int getMinElements() {
        return MIN_ELEMENTS;
    }

    /**
     * This method returns the maximum  number of elements
     * that can be involved in the match to consider
     * it of low difficulty.
     *
     * @return MAX_ELEMENTS.
     */
    public static int getMaxEasyLevel() {
        return MAX_EASY_LEVEL;
    }

    /**
     * This method returns the minimum  number of elements
     * that can be involved in the match to consider
     * it of medium difficulty.
     *
     * @return MAX_ELEMENTS.
     */
    public static int getMinNormalLevel() {
        return MIN_NORMAL_LEVEL;
    }

    /**
     * This method returns the maximum  number of elements
     * that can be involved in the match to consider
     * it of medium difficulty.
     *
     * @return MAX_ELEMENTS.
     */
    public static int getMaxNormalLevel() {
        return MAX_NORMAL_LEVEL;
    }

    /**
     * This method returns the minimum  number of elements
     * that can be involved in the match to consider
     * it fight difficult.
     *
     * @return MIN_DIFFICULT_LEVEL.
     */
    public static int getMinHardLevel() {
        return MIN_HARD_LEVEL;
    }

    /**
     * This method returns the maximum  number of elements
     * that can be involved in the match.
     *
     * @return MAX_ELEMENTS.
     */
    public static int getMaxElements() {
        return MAX_ELEMENTS;
    }

    /**
     * This methods returns the golems that will
     * fight in the match.
     *
     * @return tamagolems.
     */
    public ArrayList<TamaGolem> getTamagolems() {
        return tamaGolems;
    }

    /**
     * This method returns the enum.
     *
     * @return ELEMENTS.
     */
    public List<Elements> getELEMENTS() {
        return ELEMENTS;
    }

    /**
     * This method returns the elements used during the fight.
     *
     * @return usedElements.
     */
    public ArrayList<Elements> getUsedElements() {
        return usedElements;
    }

    /**
     * This method returns the enum's size.
     *
     * @return SIZE.
     */
    public int getSIZE() {
        return SIZE;
    }

    private void pause(int millisPause) {
        try {
            Thread.sleep(millisPause);
        } catch (InterruptedException ignored) {
        }
    }
}
