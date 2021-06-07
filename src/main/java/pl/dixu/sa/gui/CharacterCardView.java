package pl.dixu.sa.gui;


import pl.dixu.sa.game.CharacterCardData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterCardView implements Clickable {

    public static final int CARD_WIDTH = 80;
    public static final int CARD_HEIGHT = 150;

    private CharacterCardData card;

    public CharacterCardView(CharacterCardData card) {
        this.card = card;
    }

    public void render(Graphics g, Rectangle bounds) {
        g.setColor(Color.GRAY.brighter());
        g.drawRect(bounds.x, bounds.y, bounds.width ,bounds.height);
        printAsVerses(prepareTextLines(), g, bounds.x, bounds.y);
    }

    private List<String> prepareTextLines(){
        List<String> lines = new ArrayList<>();
        lines.add(card.getName());
        lines.add("Attack: " + card.getAttack());
        lines.add("Hp: " + card.getHp());
        return lines;
    }

    private void printAsVerses(List<String> lines, Graphics g, int offsetX, int offsetY) {
        int spacerY = 25;
        for (int i = 0; i < lines.size(); i++) {
            g.setColor(Color.BLACK);
            g.drawString(lines.get(i), offsetX + 10, offsetY + spacerY + spacerY * i);
        }

    }

    @Override
    public void reactToClick(int x, int y) {
        System.out.println("card clicked " + card.getName());
    }
}
