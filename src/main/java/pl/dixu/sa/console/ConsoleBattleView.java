package pl.dixu.sa.console;

import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.view.model.CardAttributes;
import pl.dixu.sa.game.view.model.BattleView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pl.dixu.sa.game.view.model.CardAttributes.*;

public class ConsoleBattleView extends BattleView {

    private CardAttributes NO_SLOT;
    private CardAttributes EMPTY_SLOT;
    private CardAttributes ENEMIES_LEFT;
    private final String EMPTY_TITLE;
    private static final int COLUMNS = 6;
    private static String EMPTY_CHARACTER= ".";

    public ConsoleBattleView() {
        EMPTY_TITLE = emptyTitle();
        initSlotsSignature();
    }

    private void initSlotsSignature() {
        //todo refactor
        NO_SLOT = new CardAttributes() {
            @Override
            public List<String> signatureView() {
                return Stream.generate(() -> EMPTY_CHARACTER.repeat(CHARACTERS))
                        .limit(SIGNATURE_LINES)
                        .collect(Collectors.toList());
            }
        };
        EMPTY_SLOT = new CardAttributes() {
            @Override
            public List<String> signatureView() {
                return Stream.generate(() -> " ".repeat(CHARACTERS))
                        .limit(SIGNATURE_LINES)
                        .collect(Collectors.toList());
            }
        };

        ENEMIES_LEFT = new CardAttributes() {
            @Override
            public List<String> signatureView() {
               return List.of("6"); //todo refactor
            }
        };
    }

    @Override
    public void display() {
        //todo
        System.out.println("Prezentacja stanu gry\n");
        printLine(emptyLine(COLUMNS));
        printLine(List.of(EMPTY_TITLE,asTitle("Shop"), asTitle("Shop"), asTitle("Next event"),asTitle("Enemies left"), EMPTY_TITLE));
        printLine(emptyLine(COLUMNS));
        printSignatures(List.of(NO_SLOT, battle.shopCard1, battle.shopCard2, battle.enemyDraw, ENEMIES_LEFT, NO_SLOT));
        printLine(List.of(asTitle("Generator"), EMPTY_TITLE,EMPTY_TITLE,EMPTY_TITLE,EMPTY_TITLE, asTitle("Enemy")));
        printLine(emptyLine(COLUMNS));
        printSignatures(List.of(getCardByArea(Area.GENERATORS,0), NO_SLOT, NO_SLOT, NO_SLOT, NO_SLOT, getCardByArea(Area.ENEMIES,0)));
        printLine(emptyLine(COLUMNS));
        printLine(List.of(asTitle("Generator"), asTitle("General"),asTitle("Defender"),asTitle("Defender"),asTitle("Defender"), asTitle("Enemy")));
        printLine(emptyLine(COLUMNS));
        printSignatures(List.of(getCardByArea(Area.GENERATORS,1), getCardByArea(Area.GENERAL,0),
                getCardByArea(Area.DEFENDERS,0), getCardByArea(Area.DEFENDERS,1), getCardByArea(Area.DEFENDERS,2),
                getCardByArea(Area.ENEMIES,1)));
        printLine(emptyLine(COLUMNS));
        printLine(List.of(asTitle("Generator"), EMPTY_TITLE,EMPTY_TITLE,EMPTY_TITLE,EMPTY_TITLE, asTitle("Enemy")));
        printLine(emptyLine(COLUMNS));
        printSignatures(List.of(getCardByArea(Area.GENERATORS,2), NO_SLOT, NO_SLOT, NO_SLOT, NO_SLOT, getCardByArea(Area.ENEMIES,2)));
        printLine(emptyLine(COLUMNS));
        System.out.println();
    }

    private CardAttributes getCardByArea(Area area, int index) {
        List<CardAttributes> cards = battle.table.stream()
                .filter(c -> c.getArea() == area)
                .collect(Collectors.toList());
        return index < cards.size() ? cards.get(index) : EMPTY_SLOT;
    }

    private void printLine(List<String> titles){
        System.out.print(EMPTY_CHARACTER+" ");
        for (String title : titles) {
            System.out.print(title);
            System.out.printf(" %s ",EMPTY_CHARACTER);
        }
        System.out.println();
    }

    public void printSignatures( List<CardAttributes> views) {
        List<String> signature;
        for (int row = 0; row < SIGNATURE_LINES; row++) {
            System.out.print(EMPTY_CHARACTER+" ");
            for (int i = 0; i < views.size(); i++) {
                signature = views.get(i).signatureView();
                if (row >= signature.size()) {
                    System.out.print(EMPTY_CHARACTER.repeat(CHARACTERS));
                } else {
                    System.out.print(asTitle(signature.get(row)) );
                }
                System.out.printf(" %s ",EMPTY_CHARACTER);
            }
            System.out.println();
        }
    }

    private String asTitle(String text) {
        String shortened = text.substring(0, Math.min(text.length(), CHARACTERS));
        return " ".repeat(( CHARACTERS- text.length())/2) + shortened+" ".repeat(( CHARACTERS- text.length()+1)/2); //todo refactor + reuse
    }

    private String emptyTitle() {
        return EMPTY_CHARACTER.repeat(CHARACTERS);
    }

    public List<String> emptyLine(int length){
       return Stream.generate(()-> EMPTY_TITLE)
                .limit(length)
                .collect(Collectors.toList());
    }
}
