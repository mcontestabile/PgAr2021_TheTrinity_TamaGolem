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

import it.unibs.fp.the_trinity.utilities.UsefulStrings;
import java.util.Stack;

/**
 * @author Iannella Simone
 */
public class Player {
    private Stack<TamaGolem> team = new Stack<>();
    private String name;

    public Player(String name) {
        this.name= name;
    }

    public void homonymFix(){
        this.name = UsefulStrings.getHomonymName();
    }

    public void addTamaGolem(TamaGolem golem) {
        team.push(golem);
    }

    /**
     * This methods returns the {@code TamaGolem} golems that will
     * fight in the match.
     *
     * @return tamagolems.
     */
    public Stack<TamaGolem> getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public TamaGolem getActiveGolem() {
        return team.pop();
    }

    public void setName(String name) {
        this.name = name;
    }
}
