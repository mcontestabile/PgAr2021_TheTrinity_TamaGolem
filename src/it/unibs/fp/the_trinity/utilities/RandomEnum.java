package it.unibs.fp.the_trinity.utilities;

import it.unibs.fp.the_trinity.tamagolem.TamaElements;
import java.util.Random;

public class RandomEnum {
    private static final TamaElements[] ELEMENTS = TamaElements.values();
    private static final Random rand = new Random();

    public static TamaElements random(){
        // Choose randomly an enum
        return ELEMENTS[rand.nextInt(ELEMENTS.length)];
    }
}
