package it.unibs.fp.TamaGolem;

public class Tamagolem {
    private int energy = 10;
    private int stones;
    private int elementNumber;

    public Tamagolem (int energy, int stones, int elementNumber) {
        this.energy = energy;
        this.stones = stones;
        this.elementNumber = elementNumber;
    }

    public int getEnergy() {
        return energy;
    }

    public int getStones() {
        return stones;
    }

    public int getElementNumber() {
        return elementNumber;
    }
}
