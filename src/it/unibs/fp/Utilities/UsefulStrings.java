package it.unibs.fp.Utilities;

public class UsefulStrings {
    private static final String STRONGER_ELEMENT = "L'elemento %s infligge un danno %d.\n";
    private static final String HOW_MANY_ELEMENTS = "Con quanti elementi si vuole giocare?\nSi consideri che il minimo è 3 e il massimo è 10.";

    public static String getStrongerElement() {
        return STRONGER_ELEMENT;
    }

    public static String getHowManyElements() {
        return HOW_MANY_ELEMENTS;
    }
}
