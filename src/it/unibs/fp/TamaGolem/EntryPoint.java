package it.unibs.fp.TamaGolem;

import it.unibs.fp.Utilities.DataInput;
import it.unibs.fp.Utilities.UsefulStrings;

import java.util.ArrayList;

public class EntryPoint {
    int elements;
    private static final int MIN_ELEMENTS = 3;
    private static final int MAX_ELEMENTS = 10;
    ArrayList<Tamagolem> tamagolems = new ArrayList<Tamagolem>();

    public void Menu () {
        elements = howManyElements();
    }

    public int howManyElements () {
        int elements = DataInput.readIntWIthMaxAndMin(UsefulStrings.getHowManyElements(), MIN_ELEMENTS, MAX_ELEMENTS);
        return elements;
    }
}
