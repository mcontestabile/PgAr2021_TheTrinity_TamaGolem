package it.unibs.fp.MainTamaGolem;

public enum Elements {
    ASFALTO("A"), SINDONE("S"), HENRICOBACTER("H"), CADREGA("C"), MEMORY_FOAM("M"), LIQUORE_DI_ZEKE("L"), PAPILLOMA("P"), ERBA("E"), TAPPETO_DI_KEYSHAN("T"), DOGECOIN("D");

    private String abbreviation;

    Elements (String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
