package it.unibs.fp.TamaGolem;

import it.unibs.fp.Utilities.*;

import javax.swing.text.Element;
import java.util.*;

public class EntryPoint {
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

    // This list contains the elements defined in Enum.
    private static final List<Element> ELEMENTS = new List<Element>() {
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
        public Iterator<Element> iterator() {
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
        public boolean add(Element element) {
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
        public boolean addAll(Collection<? extends Element> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Element> c) {
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
        public Element get(int index) {
            return null;
        }

        @Override
        public Element set(int index, Element element) {
            return null;
        }

        @Override
        public void add(int index, Element element) {

        }

        @Override
        public Element remove(int index) {
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
        public ListIterator<Element> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Element> listIterator(int index) {
            return null;
        }

        @Override
        public List<Element> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    private static final int SIZE = ELEMENTS.size();


    public void Menu () {
        int matchLevel = DataInput.readIntWIthMaxAndMin(UsefulStrings.getHowManyElements(), LOW_LEVEL, DIFFICULT_LEVEL);

        //TODO risolvere l'amichetto tamagolem (classe) in un intero, per trovare quello che ci serve.
        switch (matchLevel) {
            case LOW_LEVEL -> {
                /*
                 * If the user's choice is low, the match level will be 3 ≤ ml ≤ 5.
                 */
                int elements = howManyElements(LOW_LEVEL);
                int stones = howManyStones(LOW_LEVEL);
                int commonStones = howManyCommonStones(tamagolems, elements, stones);
                int stonesForEachElement = howManyStonesForEachElement(tamagolems, elements, stones);
                Fight fight = new Fight();
                fight.LetThemFight(tamagolems, stones, commonStones, elements);
            }

            case MEDIUM_LEVEL -> {
                /*
                 * If the user's choice is medium, the match level will be 6 ≤ ml ≤ 8.
                 */
                int elements = howManyElements(MEDIUM_LEVEL);
                int stones = howManyStones(elements);
                int commonStones = howManyCommonStones(tamagolems, elements, stones);
                int stonesForEachElement = howManyStonesForEachElement(tamagolems, elements, stones);
                Fight fight = new Fight();
                fight.LetThemFight(tamagolems, stones, commonStones, elements);
            }

            case DIFFICULT_LEVEL -> {
                /*
                 * If the user's choice is high, the match level will be 9 ≤ ml ≤ 10.
                 */
                int elements = howManyElements(DIFFICULT_LEVEL);
                int stones = howManyStones(elements);
                int commonStones = howManyCommonStones(tamagolems, elements, stones);
                int stonesForEachElement = howManyStonesForEachElement(tamagolems, elements, stones);
                Fight fight = new Fight();
                fight.LetThemFight(tamagolems, stones, commonStones, elements);
            }
        }

    }

    private int howManyElements (int level) {
        Random random = new Random();
        int elementsToEstract;
        ArrayList<Element> usedElements = new ArrayList<>();
        int addedElement;
        int elements = 0;

        if (level == LOW_LEVEL) {
            elementsToEstract = (int)Math.random() * (MAX_LOW_LEVEL - MIN_ELEMENTS + 1) + MIN_ELEMENTS;

            for (int i = 0; i<elementsToEstract; i++) {
                addedElement = random.nextInt(SIZE);
                ELEMENTS.remove(addedElement);
                usedElements.add(ELEMENTS.get(addedElement));
            }

            return elementsToEstract;

            elements = elementsToEstract;
        }  else if (level == MEDIUM_LEVEL) {
            elementsToEstract = (int)Math.random() * (MAX_MEDIUM_LEVEL - MIN_MEDIUM_LEVEL + 1) + MIN_MEDIUM_LEVEL;

            for (int i = 0; i<elementsToEstract; i++) {
                addedElement = random.nextInt(SIZE);
                ELEMENTS.remove(addedElement);
                usedElements.add(ELEMENTS.get(addedElement));
            }

            elements = elementsToEstract;
        }  else if (level == DIFFICULT_LEVEL) {
            elementsToEstract = (int)Math.random() * (MAX_ELEMENTS - MIN_DIFFICULT_LEVEL + 1) + MIN_DIFFICULT_LEVEL;

            for (int i = 0; i<elementsToEstract; i++) {
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
    private int howManyCommonStones(Tamagolem tamagolems, int elements, int stones) {
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
