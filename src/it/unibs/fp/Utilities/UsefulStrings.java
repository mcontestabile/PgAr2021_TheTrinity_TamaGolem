package it.unibs.fp.Utilities;

public class UsefulStrings {
    private static final String STRONGER_ELEMENT = "L'elemento %s infligge un danno %d.\n";
    private static final String HOW_MANY_ELEMENTS = "Qual è il livello della partita? Scegli fra le seguenti opzioni:\n» Basso (1).\n» Intermedio (2).\n» Difficile (3).";

    public static String getStrongerElement() {
        return STRONGER_ELEMENT;
    }

    public static String getHowManyElements() {
        return HOW_MANY_ELEMENTS;
    }

}
