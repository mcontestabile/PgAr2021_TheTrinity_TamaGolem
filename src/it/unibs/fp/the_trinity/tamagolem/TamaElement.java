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

public enum TamaElement {
    ASFALTO("A", 0),
    SINDONE_DI_TORINO("S", 1),
    HENRICOBACTER("H", 2),
    CADREGA("C", 3),
    MEMORY_FOAM("M", 4),
    LIQUORE_DI_ZEKE("L", 5),
    PAPILLOMA("P", 6),
    ERBA("E", 7),
    TAPPETO_DI_KEYSHAN("T", 8),
    DOGECOIN("D", 8);

    private String abbreviation;
    private int index;

    TamaElement(String abbreviation, int index) {
        this.abbreviation = abbreviation;
        this.index = index;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getIndex() {
        return index;
    }
}
