package it.unibs.fp.MainTamaGolem;

import it.unibs.fp.Utilities.UsefulStrings;

import java.util.ArrayList;
import java.util.Stack;

public class Player {
    public Stack<TamaGolem> team = new Stack<>();
    private String name;
    private TamaGolem activeGolem;

    public Player(String name) {
        this.name= name;
    }

    public void homonymyFix(){
        this.name = UsefulStrings.getHomonymyNames();
    }

    public Stack<TamaGolem> getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public TamaGolem getActiveGolem() {
        return activeGolem;
    }

    public void setName(String name) {
        this.name = name;
    }
}
