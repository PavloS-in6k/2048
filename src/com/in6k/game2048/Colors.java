package com.in6k.game2048;

import java.util.HashMap;
import java.util.Map;

public class Colors {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\033[30m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String PURPLE = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\033[37m";

    public static final String BACKGROUND_BLACK = "\033[30m";
    public static final String BACKGROUND_RED = "\033[31m";
    public static final String BACKGROUND_GREEN = "\033[32m";
    public static final String BACKGROUND_YELLOW = "\033[33m";
    public static final String BACKGROUND_BLUE = "\033[34m";
    public static final String BACKGROUND_PURPLE = "\033[35m";
    public static final String BACKGROUND_CYAN = "\033[36m";
    public static final String BACKGROUND_WHITE = "\033[37m";

    public static Map<Integer, String> COLOR_MAP;

    static {
        COLOR_MAP = new HashMap<>();
        COLOR_MAP.put(2, BLACK);
        COLOR_MAP.put(4, CYAN);
        COLOR_MAP.put(8, BLUE);
        COLOR_MAP.put(16, GREEN);
        COLOR_MAP.put(32, PURPLE);
        COLOR_MAP.put(64, RED);
        COLOR_MAP.put(128, YELLOW);
        COLOR_MAP.put(256, BACKGROUND_CYAN);
        COLOR_MAP.put(512, BACKGROUND_BLUE);
        COLOR_MAP.put(1024, BACKGROUND_GREEN);
        COLOR_MAP.put(2048, BACKGROUND_PURPLE);
    }
}
