package it.unibs.fp.MainTamaGolem;

import java.util.ArrayList;
import java.util.Stack;

public class TamaGolem {
    private int energy = 10;
    private int stones;
    private ArrayList<Elements> elements;
    private String name;

    public TamaGolem(int energy, int stones, ArrayList<Elements> elements, String name) {
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

    public ArrayList<Elements> getElements() {
        return elements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
