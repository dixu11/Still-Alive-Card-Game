package pl.dixu.sa.console.interaction;

import java.util.Arrays;

public enum DecisionType {
   PLAY_CARD(null),
    SHOP_BUY_1("q"),
    SHOP_BUY_2("w"),
    DRAW("e"),
    END_TURN("r"),
    CARD_INFO("t"),
    END_GAME("z"),
    INVALID(null);


   private String shortcut;

    DecisionType(String shortcut) {
        this.shortcut = shortcut;
    }

    public static DecisionType findByShortcut(String shortcut) {
        return Arrays.stream(values())
                .filter(d -> d.shortcut!=null&& d.shortcut.equals(shortcut))
                .findAny()
                .orElse(isNumber(shortcut) ? PLAY_CARD : INVALID);
    }

    public String getShortcut() {
        return shortcut;
    }

    private static boolean isNumber(String text) {
       return  text.matches("^[0-9]*$");
    }

}
