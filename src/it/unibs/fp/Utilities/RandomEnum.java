package it.unibs.fp.Utilities;

import it.unibs.fp.MainTamaGolem.Elements;

import java.util.Random;

public class RandomEnum {
    private final Elements[] elements = Elements.values();
    private final Random random = new Random();

    public final Elements random(){
        // Choose randomly an enum
        return elements[random.nextInt(elements.length)];
    }
}
