package pl.dixu.sa.gui;

import pl.dixu.sa.game.Area;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AreaView implements Clickable {
    private Area area;
    private boolean horizontal;
    private int slots;
    private int x;
    private int y;
    private List<CharacterCardView> cards = new ArrayList<>();
    private CharacterCardView selected = null;

    public AreaView(Area area, boolean horizontal, int slots, int x, int y) {
        this.area = area;
        this.horizontal = horizontal;
        this.slots = slots;
        this.x = x;
        this.y = y;
    }

    private void add(CharacterCardView character) {
        cards.add(character);
    }

    public void addCharacters(List<CharacterCardView> characters) {
        cards.addAll(characters);
    }

    public void render(Graphics g) {
        for (int i = 0, cardsSize = cards.size(); i < cardsSize; i++) {
            CharacterCardView card = cards.get(i);
            card.render(g, getCardBounds(i));
        }
    }

    private Rectangle getCardBounds(int i) {

        int nextCardXSpace = 0;
        int nextCardYSpace = 0;
        int spacer = 10 * i;
        if (horizontal) {
            nextCardXSpace += i * CharacterCardView.CARD_WIDTH + spacer;
        } else {
            nextCardYSpace += i * CharacterCardView.CARD_HEIGHT + spacer;
        }
        return new Rectangle(x + nextCardXSpace, y + nextCardYSpace, CharacterCardView.CARD_WIDTH, CharacterCardView.CARD_HEIGHT);
    }

    @Override
    public void reactToClick(int x, int y) {
        System.out.println("Area clicked: " + area);
        for (int i = 0; i < cards.size(); i++) {
            if (getCardBounds(i).contains(x, y)) {
                CharacterCardView newSelected = cards.get(i);
                if (selected != null && selected != newSelected) {
                    selected.unselect();
                }
                this.selected = newSelected;
                newSelected.select();
                break;
            }
        }
    }

    public void clearSelection() {
        for (CharacterCardView card : cards) {
            card.unselect();
        }
    }

}
