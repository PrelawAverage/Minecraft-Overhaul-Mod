package net.prelaw.mc.entity.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum JumboVariant {

    DEFAULT(0),
    YELLOW(1),
    BLUE(2);

    private static final JumboVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(JumboVariant::getId)).toArray(JumboVariant[]::new);
    private final int id;

    JumboVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static JumboVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
