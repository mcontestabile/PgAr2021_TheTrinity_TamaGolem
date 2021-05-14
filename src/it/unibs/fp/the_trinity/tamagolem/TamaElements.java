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

public enum TamaElements {
    ASFALTO("A"),
    SINDONE("S"),
    HENRICOBACTER("H"),
    CADREGA("C"),
    MEMORY_FOAM("M"),
    LIQUORE_DI_ZEKE("L"),
    PAPILLOMA("P"),
    ERBA("E"),
    TAPPETO_DI_KEYSHAN("T"),
    DOGECOIN("D");

    private String abbreviation;

    TamaElements(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
