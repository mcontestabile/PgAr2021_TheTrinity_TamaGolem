package it.unibs.fp.MainTamaGolem;

import it.unibs.fp.Utilities.*;
import java.util.*;

public class Menu {

    private static final int EASY_LEVEL = 1;
    private static final int NORMAL_LEVEL = 2;
    private static final int HARD_LEVEL = 3;

    private static final int MIN_STONES = 0;

    Stack<TamaGolem> tamaGolems = new Stack<>();
    ArrayList<Elements> usedElements = new ArrayList<>();
    private HashMap<Elements, Integer> numberOfElementAndStones1 = new HashMap();
    private HashMap<Elements, Integer> numberOfElementAndStones2 = new HashMap<>();

    RandomEnum randomEnum = new RandomEnum();

    Player player1;
    Player player2;

    public void menu() {
        System.out.println(UsefulStrings.getWelcomeMessage());
        System.out.println(UsefulStrings.getTitle());
        pause(1200);

        boolean start = true;
        while (start) {
            char homonymyAnswer;
            boolean nameFix = false;
            do {
                player1 = new Player(DataInput.readNotEmptyString(UsefulStrings.getPlayer1NameRequest()));
                player2 = new Player(DataInput.readNotEmptyString(UsefulStrings.getPlayer2NameRequest()));
                if (player1.getName().equalsIgnoreCase(player2.getName())) {
                    homonymyAnswer = DataInput.readChar(UsefulStrings.getHomonymyMessage());
                    if (homonymyAnswer == 'S' || homonymyAnswer == 's') {
                        String tmp = player2.getName();
                        do {
                            player2.homonymyFix();
                        } while (player2.getName().equals(tmp));
                        System.out.println(UsefulStrings.getHomonymyFixedMessage() + player2.getName() + "\".");
                    } else { ;
                        String p1Name = player1.getName();
                        do {
                            player2.setName(DataInput.readNotEmptyString(UsefulStrings.player2SecondNameRequest(player1.getName())));
                        } while ((player2.getName().equalsIgnoreCase(p1Name)));
                    }
                    nameFix = true;
                }
            } while (!nameFix);

            pause(800);

            int matchLevel = DataInput.readIntWithMaxAndMin(UsefulStrings.getHowManyElements(), EASY_LEVEL, HARD_LEVEL);

            switch (matchLevel) {
                case EASY_LEVEL -> {
                    /*
                     * If the user's choice is low, the match level will be 3 ≤ ml ≤ 5.
                     */
                    int elements = howManyElements(EASY_LEVEL);
                    int stones = howManyStones(elements);
                    int tamas = howManyTamagolems(elements, stones);
                    int commonStones = howManyCommonStones(tamas, elements, stones);

                    System.out.printf(UsefulStrings.getHowManyTamagolems(), tamas);
                    for (int i = 0; i<tamas; i++) {
                        String tamaName = "Tamagolem " + i;
                        TamaGolem t = new TamaGolem(UsefulStrings.getEnergy(), stones, usedElements, tamaName);
                        t.setName(tamaName);
                        tamaGolems.add(t);
                    }

                    //Metodo che genera l'equilibrio!!!
                    Fight fight = new Fight();
                    fight.LetThemFight(tamaGolems, stones, commonStones, usedElements, player1, player2);

                    start = false;
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

                    System.out.printf(UsefulStrings.getHowManyTamagolems(), tamas);
                    for (int i = 0; i<tamas; i++) {
                        String tamaName = "Tamagolem" + i;
                        TamaGolem t = new TamaGolem(UsefulStrings.getEnergy(), stones, usedElements, tamaName);
                        t.setName(tamaName);
                        tamaGolems.add(t);
                    }

                    //Metodo che genera l'equilibrio!!!
                    Fight fight = new Fight();
                    fight.LetThemFight(tamaGolems, stones, commonStones, usedElements, player1, player2);

                    start = false;
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

                    System.out.printf(UsefulStrings.getHowManyTamagolems(), tamas);
                    for (int i = 0; i<tamas; i++) {
                        String tamaName = "Tamagolem" + i;
                        TamaGolem t = new TamaGolem(UsefulStrings.getEnergy(), stones, usedElements, tamaName);
                        t.setName(tamaName);
                        tamaGolems.add(t);
                    }

                    //Metodo che genera l'equilibrio!!!
                    Fight fight = new Fight();
                    fight.LetThemFight(tamaGolems, stones, commonStones, usedElements, player1, player2);

                    start = false;
                }
                default -> throw new IllegalStateException("Unexpected value: " + matchLevel);
            }
        }
    }

    private int howManyElements(int level) {
        Random random = new Random();
        int elementsToExtract;
        int addedElement;
        int elements = 0;

        if (level == EASY_LEVEL) {
            elementsToExtract = (int) Math.floor(Math.random() * (UsefulStrings.getMaxEasyLevel() - UsefulStrings.getMinElements() + 1) + UsefulStrings.getMinElements());

            for (int i = 0; i < elementsToExtract; i++) {
                usedElements.add(randomEnum.random());
            }

            elements = elementsToExtract;

        } else if (level == NORMAL_LEVEL) {
            elementsToExtract = (int) Math.floor(Math.random() * (UsefulStrings.getMaxNormalLevel() - UsefulStrings.getMinNormalLevel() + 1) + UsefulStrings.getMinNormalLevel());

            for (int i = 0; i < elementsToExtract; i++) {
                usedElements.add(randomEnum.random());
            }

            elements = elementsToExtract;

        } else if (level == HARD_LEVEL) {
            elementsToExtract = (int) Math.floor(Math.random() * (UsefulStrings.getMaxElements() - UsefulStrings.getMinHardLevel() + 1) + UsefulStrings.getMinHardLevel());

            for (int i = 0; i < elementsToExtract; i++) {
                usedElements.add(randomEnum.random());
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
     * This methods returns the golems that will
     * fight in the match.
     *
     * @return tamagolems.
     */
    public Stack<TamaGolem> getTamagolems() {
        return tamaGolems;
    }

    /**
     * This method returns the elements used during the fight.
     *
     * @return usedElements.
     */
    public ArrayList<Elements> getUsedElements() {
        return usedElements;
    }

    private void pause(int millisPause) {
        try {
            Thread.sleep(millisPause);
        } catch (InterruptedException ignored) {
        }
    }

    public void assignCommonStones (ArrayList<Elements> usedElements, int commonStones) {
        for (Elements e : usedElements) {
            numberOfElementAndStones1.put(e, commonStones);
        }
    }

    public void chooseStones (Player player, int commonStones, HashMap<Elements, Integer> numberOfElementAndStones, ArrayList<Elements> usedElements, int stones) {
        System.out.printf(UsefulStrings.getSettingElements(), player);

        String e;

        for (int availableStones = commonStones; availableStones > 0; availableStones--) {

            System.out.println(usedElements);

            do {
                e = DataInput.readNotEmptyString(UsefulStrings.getChooseElementName());
                int choice = DataInput.readIntWIthMaxAndMin(UsefulStrings.getSettingStonesNumberForElement(), MIN_STONES, availableStones);
            } while (!usedElements.contains(e));

            int position = usedElements.indexOf(e);

            numberOfElementAndStones.replace(usedElements.get(position), availableStones-1); //Se non funzia, piango
        }
    }
}
