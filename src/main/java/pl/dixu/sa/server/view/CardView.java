package pl.dixu.sa.server.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CardView {

    public static final int CHARACTERS = 12;
    public static final int SIGNATURE_LINES = 3;

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
        for (String line : signatureView()) {
            System.out.println(line);
        }
    }


    public List<String> signatureView() {
        List<String> lines = new ArrayList<>();
        lines.add(name);
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
        List<String> dontShow = List.of("area", "enemy", "event", "maxHp", "actualHp");
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


}
