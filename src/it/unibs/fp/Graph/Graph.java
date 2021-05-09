package it.unibs.fp.Graph;

import it.unibs.fp.Utilities.UsefulStrings;

import java.util.*;

public class Graph {
    /*
     * Setting the Map which contains in 'Node' the
     * Element we are considering and in 'List<Node>'
     * the closest two Elements.
     */
    private Map<Node, List<Node>> adjacentList;

    /**
     * Constructor, it creates the adjacent elements
     * for each element.
     * @param adjacentList those are the adjacent Elements.
     */
    public Graph(Map<Node, List<Node>> adjacentList) {
        this.adjacentList = adjacentList;
    }

    /**
     * This method returns the adjacent Elements.
     * @return
     */
    public Map<Node, List<Node>> getAdjacentList() {
        return adjacentList;
    }

    /**
     * This method adds a new node to the Graph.
     * It's very useful, because we create a new Graph every
     * time we choose randomly the element used in the fight.
     * Of course, this Graph will be used in the class Equilibrium.
     * @param node is the element we are considering.
     */
    public void addNode(Node node) {
        adjacentList.put(node, new LinkedList<Node>());
    }

    /**
     * This method adds elements to the list.
     * @param node this is the considered node.
     * @param newNode this is the node (element) we are adding.
     */
    public void addElementToTheList(Node node, Node newNode) {
        adjacentList.get(node).add(newNode);
    }


    /**
     * This method stes the adjacent elements.
     * @param adjacentList adjacent elements.
     */
    public void setAdjacentList(Map<Node, List<Node>> adjacentList) {
        this.adjacentList = adjacentList;
    }

    /**
     * This method explains the damage that the stronger element
     * inflicts to the weaker element.
     */
    public void printGraph() {
        for (Node node : adjacentList.keySet()) {
            System.out.printf(UsefulStrings.getStrongerElement(), node.keyNode(), adjacentList.get(node));
        }
    }

}
