/*
 * Copyright (c) 2021, The Trinity and/or its affiliates. All rights reserved.
 * THE TRINITY PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package it.unibs.fp.the_trinity.tamagolem;

import java.util.ArrayList;

public class TamaGolem {
    private int energy;
    private int stones;
    // TODO should use a Circular List
    private ArrayList<TamaElement> elements;
    private String name;

    public TamaGolem(int energy, int stones, ArrayList<TamaElement> elements, String name) {
        this.energy = energy;
        this.stones = stones;
        this.elements = elements;
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public int getStones() {
        return stones;
    }

    public ArrayList<TamaElement> getElements() {
        return elements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO getElement method, that change position of Circular List
}
