package it.unibs.fp.Utilities;

import it.unibs.fp.MainTamaGolem.*;

import java.util.Random;

public class RandomEnum {
    private static final Elements[] ELEMENTS = Elements.values();
    private static Random rand = new Random();

    public static Elements random(){
        // Choose randomly an enum
        return ELEMENTS[rand.nextInt(ELEMENTS.length)];
    }
}
