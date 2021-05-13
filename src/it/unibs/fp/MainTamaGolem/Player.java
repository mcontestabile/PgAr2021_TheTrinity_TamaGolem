package it.unibs.fp.MainTamaGolem;

import it.unibs.fp.Utilities.UsefulStrings;

import java.util.ArrayList;

public class Player {
    public ArrayList<TamaGolem> team;
    private String name;
    private TamaGolem activeGolem;

    public Player(String name) {
        team = new ArrayList<TamaGolem>();
        this.name= name;
    }

    public void homonymyFix(){
        this.name = UsefulStrings.getHomonymyNames();
    }

    public ArrayList<TamaGolem> getTeam() {
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
