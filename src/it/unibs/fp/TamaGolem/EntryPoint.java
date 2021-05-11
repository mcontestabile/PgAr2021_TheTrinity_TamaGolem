package it.unibs.fp.TamaGolem;

import it.unibs.fp.Utilities.*;
import java.util.*;

public class EntryPoint {
    int elements;
    private static final int MIN_ELEMENTS = 3;
    private static final int MAX_LOW_LEVEL = 5;
    private static final int MIN_MEDIUM_LEVEL = 6;
    private static final int MAX_MEDIUM_LEVEL = 8;
    private static final int MIN_DIFFICULT_LEVEL = 9;
    private static final int MAX_ELEMENTS = 10;

    private static final int LOW_LEVEL = 1;
    private static final int MEDIUM_LEVEL = 2;
    private static final int DIFFICULT_LEVEL = 3;

    ArrayList<Tamagolem> tamagolems = new ArrayList<>();

    public void Menu () {
        int matchLevel = DataInput.readIntWIthMaxAndMin(UsefulStrings.getHowManyElements(), LOW_LEVEL, DIFFICULT_LEVEL);

        switch (matchLevel) {
            case LOW_LEVEL -> {
                /*
                 * If the user's choice is low, the match level will be 3 ≤ ml ≤ 5.
                 */
                int elements = howManyElements(LOW_LEVEL);
                int stones = howManyStones(elements);
            }

            case MEDIUM_LEVEL -> {
                /*
                 * If the user's choice is medium, the match level will be 6 ≤ ml ≤ 8.
                 */
                int elements = howManyElements(MEDIUM_LEVEL);
                int stones = howManyStones(elements);
            }

            case DIFFICULT_LEVEL -> {
                /*
                 * If the user's choice is high, the match level will be 9 ≤ ml ≤ 10.
                 */
                int elements = howManyElements(DIFFICULT_LEVEL);
                int stones = howManyStones(elements);
            }
        }

    }

    private int howManyElements (int level) {
        int elements = 0;

        if (level == LOW_LEVEL)
            elements = (int)Math.floor(Math.random() * (MAX_LOW_LEVEL - MIN_ELEMENTS + 1) + MIN_ELEMENTS);
        else if (level == MEDIUM_LEVEL)
            elements = (int)Math.floor(Math.random() * (MAX_MEDIUM_LEVEL - MIN_MEDIUM_LEVEL +1) + MIN_MEDIUM_LEVEL);
        else if (level == DIFFICULT_LEVEL)
            elements = (int)Math.floor(Math.random() * (MAX_ELEMENTS - MIN_DIFFICULT_LEVEL + 1) + MIN_DIFFICULT_LEVEL);

        return elements;
    }

    /**
     * This method calculates the stones involved in the match.
     * @param elements are the elements involved in the match.
     * @return how many stones are involved in the match.
     */
    private int howManyStones (int elements) {
        int stones = (elements + 1) / 3 + 1;
        return stones;
    }

    /**
     * This method calculates the tamagolems involved in the match.
     * This integer value is based on the elements.
     * @param elements are the elements involved in the match.
     * @param stones how many stones are involved in the match.
     * @return the tamagolems' number.
     */
    private int howManyTamagolems (int elements, int stones) {
        int tamagolems = ((elements - 1) * (elements - 2)) / (2 * stones);
        return tamagolems;
    }

    /**
     * This method calculates the common stones involved in the match.
     * @param tamagolems the tamagolems' number.
     * @param elements are the elements involved in the match.
     * @param stones how many stones are involved in the match.
     * @return the common stones.
     */
    private int commonStones (int tamagolems, int elements, int stones) {
        int commonStones = ((2 * tamagolems * stones) / elements) * elements;
        return commonStones;
    }

    /**
     * This method calculates the common stones for each element involved in the match.
     * @param tamagolems the tamagolems' number.
     * @param elements are the elements involved in the match.
     * @param stones how many stones are involved in the match.
     * @return the stones for each element.
     */
    private int howManyStonesForEachElement (int tamagolems, int elements, int stones) {
        int stonesForEachElement  = (2 * tamagolems * stones) / elements;
        return stonesForEachElement;
    }
}
