package pl.dixu.sa.game.view.model;

import pl.dixu.sa.game.cards.general.Area;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CardAttributes {

    public static final int CHARACTERS = 12;
    public static final int SIGNATURE_LINES = 4;

    private Map<String, String> attributes = new TreeMap<>();

    public CardAttributes() {
        attributes.put("enemy", "false");
    }

    public CardAttributes addAttribute(String name, String value) {
        attributes.put(name, value);
        return this;
    }

    public void consoleDisplay() {
        for (String line : signatureView()) {
            System.out.println(line);
        }
    }


    public List<String> signatureView() {
        List<String> lines = new ArrayList<>();
        lines.add(attributes.get("name"));
        for (String attribute : attributes.keySet()) {
            if (dontShowThisAttribute(attribute)) {
                continue;
            }
            lines.add(String.format("%s: %s", attribute, attributes.get(attribute)));
        }
        if (hasHp()) {
            lines.add(getHpCounter());
        }
        return lines;
    }

    public boolean dontShowThisAttribute(String attribute) {
        List<String> dontShow = List.of("area", "enemy", "event", "maxHp", "actualHp","name","id");
        List<String> dontShowIf0 = List.of("attack", "block","lvl");
        List<String> dontShowIfEnemy = List.of("cost");
        return dontShow.contains(attribute) ||
                (dontShowIf0.contains(attribute) && isZero(attribute)) ||
                (dontShowIfEnemy.contains(attribute) && isEnemy());
    }

    private boolean hasHp() {
        return attributes.containsKey("maxHp") && !isZero("maxHp");
    }

    private boolean isZero(String attribute) {
      return   attributes.get(attribute).equals("0");
    }



    public String getHpCounter() {
        return "hp: " + attributes.get("actualHp") + "/" + attributes.get("maxHp");
    }

    public boolean isEnemy() {
        return Boolean.parseBoolean(attributes.get("enemy"));
    }

    public boolean isEvent() {
        return Boolean.parseBoolean(attributes.get("event"));
    }

    public void add(Viewable viewable) {
        attributes.putAll(viewable.toAttributes().attributes);
    }

    public String asLine() {
        return name();
    }

    public String name() {
        return attributes.get("name");
    }

    public int getId() {
        return Integer.parseInt(attributes.get("id"));
    }

    public Area getArea() {
        return attributes.containsKey("area") ? Area.valueOf(attributes.get("area")): Area.UNKNOWN;
    }

    @Override
    public String toString() {
        return "CardAttributes{" +
                "attributes=" + attributes +
                '}';
    }
}
