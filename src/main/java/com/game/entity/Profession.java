package com.game.entity;

import java.util.Arrays;

public enum Profession {
    WARRIOR("ВОИН"),
    ROGUE("НЕГОДЯЙ"),
    SORCERER("КОЛДУН"),
    CLERIC("КЛЕРИК"),
    PALADIN("ПАЛАДИН"),
    NAZGUL("НАЗГУЛ"),
    WARLOCK("ЧЕРНОКНИЖНИК"),
    DRUID("ДРУИД");

    private final String nameRus;

    Profession(String nameRus) {
        this.nameRus = nameRus;
    }

    public String getNameRus() {
        return nameRus;
    }

    public static Profession getProfession(String nameRus) {
        return Arrays.stream(Profession.values())
                .filter(profession -> profession.getNameRus().equals(nameRus))
                .findFirst()
                .orElse(null);
    }
}
