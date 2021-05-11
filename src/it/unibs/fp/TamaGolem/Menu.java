package it.unibs.fp.TamaGolem;

import it.unibs.fp.Utilities.*;

import java.sql.SQLOutput;
import java.util.*;

public class Menu {
    private static final int MIN_ELEMENTS = 3;
    private static final int MAX_LOW_LEVEL = 5;
    private static final int MIN_MEDIUM_LEVEL = 6;
    private static final int MAX_MEDIUM_LEVEL = 8;
    private static final int MIN_DIFFICULT_LEVEL = 9;
    private static final int MAX_ELEMENTS = 10;

    private static final int LOW_LEVEL = 1;
    private static final int MEDIUM_LEVEL = 2;
    private static final int DIFFICULT_LEVEL = 3;

    private boolean start = true;
    private char homonymyAnswer;
    private boolean nameFix = true;

    ArrayList<TamaGolem> tamaGolems = new ArrayList<>();

    // This list contains the elements defined in Enum.
    private static final List<Elements> ELEMENTS = new List<Elements>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Elements> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Elements elements) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Elements> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Elements> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Elements get(int index) {
            return null;
        }

        @Override
        public Elements set(int index, Elements element) {
            return null;
        }

        @Override
        public void add(int index, Elements element) {

        }

        @Override
        public Elements remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Elements> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Elements> listIterator(int index) {
            return null;
        }

        @Override
        public List<Elements> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    ArrayList<Elements> usedElements = new ArrayList<>();

    private static final int SIZE = ELEMENTS.size();


    public void Menu() {
        System.out.println(UsefulStrings.WELCOME_MESSAGE);
        System.out.println(UsefulStrings.TITLE);

        while (start) {
            do {
                Player player1 = new Player(DataInput.readString(UsefulStrings.PLAYER_1_NAME_REQUEST));
                Player player2 = new Player(DataInput.readString(UsefulStrings.PLAYER_2_NAME_REQUEST));
                if (player1.getName().equals(player2.getName())) {
                    homonymyAnswer = DataInput.readChar(UsefulStrings.HOMONYMY_MESSAGE);
                    if (homonymyAnswer == 'S' || homonymyAnswer == 's') {
                        player2.homonymyFix();
                        System.out.println(UsefulStrings.HOMONYMY_FIXED_MESSAGE + player2.getName() + "\n");
                    } else nameFix = false;
                }
            } while (nameFix == false);

            int matchLevel = DataInput.readIntWIthMaxAndMin(UsefulStrings.getHowManyElements(), LOW_LEVEL, DIFFICULT_LEVEL);

            //TODO risolvere l'amichetto tamagolem (classe) in un intero, per trovare quello che ci serve.
            switch (matchLevel) {
                case LOW_LEVEL -> {
                    /*
                     * If the user's choice is low, the match level will be 3 ≤ ml ≤ 5.
                     */
                    int elements = howManyElements(LOW_LEVEL);
                    int stones = howManyStones(LOW_LEVEL);
                    int tamas = howManyTamagolems(elements, stones);
                    int commonStones = howManyCommonStones(tamas, elements, stones);
                    int stonesForEachElement = howManyStonesForEachElement(tamas, elements, stones);
                    Fight fight = new Fight();
                    fight.LetThemFight(tamaGolems, stones, commonStones, usedElements);
                }

                case MEDIUM_LEVEL -> {
                    /*
                     * If the user's choice is medium, the match level will be 6 ≤ ml ≤ 8.
                     */
                    int elements = howManyElements(MEDIUM_LEVEL);
                    int stones = howManyStones(elements);
                    int tamas = howManyTamagolems(elements, stones);
                    int commonStones = howManyCommonStones(tamas, elements, stones);
                    int stonesForEachElement = howManyStonesForEachElement(tamas, elements, stones);
                    Fight fight = new Fight();
                    fight.LetThemFight(tamaGolems, stones, commonStones, usedElements);
                }

                case DIFFICULT_LEVEL -> {
                    /*
                     * If the user's choice is high, the match level will be 9 ≤ ml ≤ 10.
                     */
                    int elements = howManyElements(DIFFICULT_LEVEL);
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
        int elementsToEstract;
        int addedElement;
        int elements = 0;

        if (level == LOW_LEVEL) {
            elementsToEstract = (int) (Math.random() * (MAX_LOW_LEVEL - MIN_ELEMENTS + 1) + MIN_ELEMENTS);

            for (int i = 0; i < elementsToEstract; i++) {
                addedElement = random.nextInt(SIZE);
                ELEMENTS.remove(addedElement);
                usedElements.add(ELEMENTS.get(addedElement));
            }

            elements = elementsToEstract;
        } else if (level == MEDIUM_LEVEL) {
            elementsToEstract = (int) (Math.random() * (MAX_MEDIUM_LEVEL - MIN_MEDIUM_LEVEL + 1) + MIN_MEDIUM_LEVEL);

            for (int i = 0; i < elementsToEstract; i++) {
                addedElement = random.nextInt(SIZE);
                ELEMENTS.remove(addedElement);
                usedElements.add(ELEMENTS.get(addedElement));
            }

            elements = elementsToEstract;
        } else if (level == DIFFICULT_LEVEL) {
            elementsToEstract = (int) (Math.random() * (MAX_ELEMENTS - MIN_DIFFICULT_LEVEL + 1) + MIN_DIFFICULT_LEVEL);

            for (int i = 0; i < elementsToEstract; i++) {
                addedElement = random.nextInt(SIZE);
                ELEMENTS.remove(addedElement);
                usedElements.add(ELEMENTS.get(addedElement));
            }

            elements = elementsToEstract;
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
        int stones = (elements + 1) / 3 + 1;
        return stones;
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
        int tamagolems = ((elements - 1) * (elements - 2)) / (2 * stones);
        return tamagolems;
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
        int commonStones = ((2 * tamagolems * stones) / elements) * elements;
        return commonStones;
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
        int stonesForEachElement = (2 * tamagolems * stones) / elements;
        return stonesForEachElement;
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
    public static int getMaxLowLevel() {
        return MAX_LOW_LEVEL;
    }

    /**
     * This method returns the minimum  number of elements
     * that can be involved in the match to consider
     * it of medium difficulty.
     *
     * @return MAX_ELEMENTS.
     */
    public static int getMinMediumLevel() {
        return MIN_MEDIUM_LEVEL;
    }

    /**
     * This method returns the maximum  number of elements
     * that can be involved in the match to consider
     * it of medium difficulty.
     *
     * @return MAX_ELEMENTS.
     */
    public static int getMaxMediumLevel() {
        return MAX_MEDIUM_LEVEL;
    }

    /**
     * This method returns the minimum  number of elements
     * that can be involved in the match to consider
     * it fight difficult.
     *
     * @return MIN_DIFFICULT_LEVEL.
     */
    public static int getMinDifficultLevel() {
        return MIN_DIFFICULT_LEVEL;
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
    public static List<Elements> getELEMENTS() {
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
    public static int getSIZE() {
        return SIZE;
    }
}
