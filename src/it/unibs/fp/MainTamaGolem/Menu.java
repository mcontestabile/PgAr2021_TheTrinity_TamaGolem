package it.unibs.fp.MainTamaGolem;

import it.unibs.fp.Utilities.*;

import java.util.*;

public class Menu {

    private static final int EASY_LEVEL = 1;
    private static final int NORMAL_LEVEL = 2;
    private static final int HARD_LEVEL = 3;

    private static final int MIN_STONES = 0;

    Stack<TamaGolem> tamaGolems = new Stack<>();
    Stack<TamaGolem> tamaGolems1 = new Stack<>();
    Stack<TamaGolem> tamaGolems2 = new Stack<>();

    public List<Elements> elem;
    public ArrayList<Elements> usedElements = new ArrayList<>();
    private HashMap<Elements, Integer> numberOfElementAndStones = new HashMap();
    private HashMap<Elements, Integer> numberOfElementAndStones1 = new HashMap();
    private HashMap<Elements, Integer> numberOfElementAndStones2 = new HashMap<>();

    RandomEnum randomEnum = new RandomEnum();

    Player player1;
    Player player2;

    public void menu() {
        System.out.println(UsefulStrings.getWelcomeMessage());
        System.out.println(UsefulStrings.getTitle());
        pause(1000);

        boolean start = true;
        do {
            char homonymyAnswer;
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
                } else {
                    String p1Name = player1.getName();
                    do {
                        player2.setName(DataInput.readNotEmptyString(UsefulStrings.player2SecondNameRequest(player1.getName())));
                    } while ((player2.getName().equalsIgnoreCase(p1Name)));
                }
            }

            pause(500);

            int matchLevel = DataInput.readIntWithMaxAndMin(UsefulStrings.getSelectLevel(), EASY_LEVEL, HARD_LEVEL);

            int elements = 0;

            switch (matchLevel) {
                case EASY_LEVEL -> {
                    /*
                     * If the user's choice is low, the match level will be 3 ≤ ml ≤ 5.
                     */
                    elements = howManyElements(EASY_LEVEL);
                }
                case NORMAL_LEVEL -> {
                    /*
                     * If the user's choice is medium, the match level will be 6 ≤ ml ≤ 8.
                     */
                    elements = howManyElements(NORMAL_LEVEL);

                }
                case HARD_LEVEL -> {
                    /*
                     * If the user's choice is high, the match level will be 9 ≤ ml ≤ 10.
                     */
                    elements = howManyElements(HARD_LEVEL);

                }
            }

            int stones = howManyStones(elements);
            int tamas = howManyTamagolems(elements, stones);
            int commonStones = howManyCommonStones(tamas, elements, stones);

            pause(500);
            System.out.printf(UsefulStrings.getHowManyTamagolems(), tamas);
            System.out.printf(UsefulStrings.getHowManyStones(), stones);
            System.out.printf(UsefulStrings.getHowManyElements(), elements);
            pause(500);

            for (int i = 0; i < tamas; i++) {
                String tamaName = "Tamagolem " + i;
                TamaGolem t = new TamaGolem(UsefulStrings.getEnergy(), stones, usedElements, tamaName);
                t.setName(tamaName);
                tamaGolems.add(t);
            }

            tamaGolems1 = tamaGolems;
            tamaGolems2 = tamaGolems;

            //TODO metodo che genera l'equilibrio!!!

            assignCommonStones(usedElements, commonStones, numberOfElementAndStones);

            numberOfElementAndStones1 = numberOfElementAndStones;
            numberOfElementAndStones2 = numberOfElementAndStones;


            Fight fight = new Fight();
            fight.LetThemFight(tamaGolems1, tamaGolems2, stones, commonStones, usedElements, player1, player2, numberOfElementAndStones1, numberOfElementAndStones2);

            start = false;

        }
        while (start);
    }

    /**
     * This method returns an {@code int} type that rapresents the
     * element's number used in the fight.
     *
     * @param level the match's level.
     * @return the number of elements, that is an {@code int}.
     */
    private int howManyElements(int level) {
        Random random = new Random();
        int elementsToExtract;
        int addedElement;
        int elements = 0;

        elem = Arrays.asList(Elements.values());

        int min = 0;
        int max = 0;

        switch (level) {
            case EASY_LEVEL -> {
                min = UsefulStrings.getMinElements();
                max = UsefulStrings.getMaxEasyLevel();
            }

            case NORMAL_LEVEL -> {
                min = UsefulStrings.getMinNormalLevel();
                max = UsefulStrings.getMaxNormalLevel();
            }

            case HARD_LEVEL -> {
                min = UsefulStrings.getMinHardLevel();
                max = UsefulStrings.getMaxElements();
            }
        }

        elementsToExtract = (int) Math.floor(Math.random() * (max - min + 1) + min);

        Collections.shuffle(elem);

        for (int i = 0; i < elementsToExtract; i++) {
            System.out.println(elem.get(i));
        }

        elements = elementsToExtract;

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
     * This methods returns the {@code int} golems that will
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

    public HashMap<Elements, Integer> assignCommonStones(ArrayList<Elements> usedElements, int stonesForEachElement, HashMap<Elements, Integer> numberOfElementAndStones) {
        for (Elements e : usedElements) {
            numberOfElementAndStones.put(e, stonesForEachElement);
        }
        return numberOfElementAndStones;
    }

    public void chooseStones(Player player, int commonStones, HashMap<Elements, Integer> numberOfElementAndStones, ArrayList<Elements> usedElements, int stones, TamaGolem activeGolem) {
        System.out.printf(UsefulStrings.getSettingElements(), player.getName());

        String e;
        int choice;

        int availableStones = commonStones;

        while (availableStones > 0) {
            System.out.println(usedElements);

            do {
                e = DataInput.readNotEmptyString(UsefulStrings.getChooseElementName());
                choice = DataInput.readfIntWithMaxAndMin(UsefulStrings.getSettingStonesNumberForElement(), MIN_STONES, availableStones);
            } while (!usedElements.contains(e));

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

    public int getTamaGolemsNumber() {
        return tamaGolems.size();
    }
}

