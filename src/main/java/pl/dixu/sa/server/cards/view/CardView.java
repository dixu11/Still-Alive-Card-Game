package pl.dixu.sa.server.cards.view;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CardView {

    private String name;
    private String dsc;
    private Map<String, String> attributes = new TreeMap<>();

    CardView(String name, String dsc) {
        this.name = name;
        this.dsc = dsc;
        attributes.put("enemy", "false");
    }

    public CardView addAttribute(String name, String value) {
        attributes.put(name, value);
        return this;
    }

    public void consoleDisplay() {
        System.out.printf("Card: %s\n", name);
        for (String attribute : attributes.keySet()) {
            if (dontShowThisAttribute(attribute)) {
                continue;
            }
            System.out.printf("%s - %s\n", attribute, attributes.get(attribute));
        }
        System.out.println();
    }

    public boolean dontShowThisAttribute(String attribute) {
        List<String> dontShow = List.of("area","enemy");
        List<String> dontShowIf0 = List.of("attack", "block");
        List<String> dontShowIfEnemy = List.of("cost");
        return dontShow.contains(attribute) ||
                dontShowIf0.contains(attribute) ||
                (dontShowIfEnemy.contains(attribute)&& isEnemy());
    }

    public boolean isEnemy() {
        return Boolean.parseBoolean(attributes.get("enemy"));
    }
}
