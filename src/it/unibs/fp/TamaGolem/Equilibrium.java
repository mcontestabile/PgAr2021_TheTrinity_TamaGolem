package it.unibs.fp.TamaGolem;


import it.unibs.fp.Graph.*;
import it.unibs.fp.Utilities.*;
import java.util.*;

/**
 * With generateRandomNode we get the nodes (elements) that will
 * fight in the Tamagolems' mathc. Then, we calculate the equilibrium
 * with the method equilibriumGraph, so that we have the match's
 * equilibrium. This method works following this steps:
 * 1st: As we get the stones, which contains the elements,
 *      we can start assigning the strongest and weakest
 *      elements in each interaction.
 * 2nd: As we know that the sum of strengths as it's stronger
 *      is equal to the sum of strengths as it's weak, at first we
 *      can find randomly, for each element, when it's stronger and
 *      its random strength's values.
 * 3rd: Then, as we had calculated also the sum of strengths as it's
 *      stronger in the previous step, we find the other values, which
 *      are the strengths as it's weak (negative value, that we set
 *      positive to the stronger elements when we have to assign the value).
 *      It's easier, because we have the the sum of strengths as it's
 *      stronger: for example, as SoSS=15 and these are 3 numbers, if
 *      we have 6 elements, the weak cases are 2, so x1+x2=15. We
 *      find randomly x1, and then find x2 making the algebraic sum.
 *      If we have x(n) elements, we make iterations of algebraic sums
 *      and random values until we finish.
 */
public class Equilibrium {
   // Graph graph;
    static int elements;

    private static final int MAX_STRENGH = 5;

    public Equilibrium (int elements, Graph graph) {
        this.elements = elements;
        //this.graph = graph;
    }

    /*
    private Graph equilibriumGraph() {
        //Return temporaneo per silenziare compilatore.
        return graph;
    }
     */

    private static Node generateRandomNode() {
        Random rand = new Random();

        int randomStone = rand.nextInt(elements);
        int elementsStrength = rand.nextInt(MAX_STRENGH) + 1;

        return new Node(Elements.values()[randomStone].toString(),elementsStrength);
    }
/*
    private static int generateRandomStronger () {
        Random rand = new Random();

        //int randomStronger = rand.nextInt(); getting the random elements
    }
*/
}
