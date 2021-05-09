package it.unibs.fp.Graph;

public class Node {

    String name;
    int weight; /*
                 * We say that a graph has a weight when
                 * every edge has its numerical value, that
                 * is its weight.
                 */

    /**
     * Node's constructor.
     * @param name node's name.
     * @param weight node's weight.
     */
    public Node (String name,int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + weight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }

    public String keyNode() {
        return name;
    }

    /**
     * This method returns the node's weight.
     * @return nodes' weight.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * This method sets the node's name.
     * @param name node's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method sets the node's weight.
     * @param weight node's weight.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "L'elemento " + name + " crea un danno di punteggio pari a " + weight + ".";
    }


}

