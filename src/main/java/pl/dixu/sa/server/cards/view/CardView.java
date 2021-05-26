package pl.dixu.sa.server.cards.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CardView {

    public static final int CHARACTERS = 10;

    private String name;
    private String dsc;
    private Map<String, String> attributes = new TreeMap<>();

    public CardView(String name, String dsc) {
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


    //todo refactor
    public List<String> signatureView() {
        List<String> lines = new ArrayList<>();
        lines.add(String.format("%-"+CHARACTERS+"s",name.substring(0,Math.min(name.length(), CHARACTERS))));
        if (isEvent() && !isEnemy()) {
            lines.add(String.format("%-"+CHARACTERS+"s","Cost: " + attributes.get("cost")) );
        }
        if (!isEvent()) {
            lines.add(String.format("%-"+CHARACTERS+"s","Lvl: " + attributes.get("lvl")) );
            lines.add(String.format("%-"+CHARACTERS+"s", "Hp: " + attributes.get("actualHp") + "/" + attributes.get("maxHp")));
        }
        if ( attributes.containsKey("atk") && !attributes.get("atk").equals("0")) {
            lines.add(String.format("%-"+CHARACTERS+"s", "Atk: " + attributes.get("atk")));
        }
        return lines;
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

    public boolean isEvent(){
       return Boolean.parseBoolean(attributes.get("event"));
    }

}
