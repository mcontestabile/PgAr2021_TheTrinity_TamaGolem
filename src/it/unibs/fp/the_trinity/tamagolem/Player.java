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

public class Player {
    public Stack<TamaGolem> team = new Stack<>();
    private String name;
    private TamaGolem activeGolem;

    public Player(String name) {
        this.name= name;
    }

    public void homonymFix(){
        this.name = UsefulStrings.getHomonymName();
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
