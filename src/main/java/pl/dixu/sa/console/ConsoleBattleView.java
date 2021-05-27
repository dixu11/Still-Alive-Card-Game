package pl.dixu.sa.console;

import pl.dixu.sa.server.view.CardView;
import pl.dixu.sa.server.view.BattleView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pl.dixu.sa.server.view.CardView.*;

public class ConsoleBattleView extends BattleView {

    private CardView NO_SLOT;
    private CardView EMPTY_SLOT;
    private CardView ENEMIES_LEFT;
    private final String EMPTY_TITLE;
    private static final int COLUMNS = 6;
    private static String EMPTY_CHARACTER= ".";

    public ConsoleBattleView() {
        EMPTY_TITLE = emptyTitle();
        initSlotsSignature();
    }

    private void initSlotsSignature() {
        //todo refactor
        NO_SLOT = new CardView("", "") {
            @Override
            public List<String> signatureView() {
                return Stream.generate(() -> EMPTY_CHARACTER.repeat(CHARACTERS))
                        .limit(SIGNATURE_LINES)
                        .collect(Collectors.toList());
            }
        };
        EMPTY_SLOT = new CardView("", "") {
            @Override
            public List<String> signatureView() {
                return Stream.generate(() -> " ".repeat(CHARACTERS))
                        .limit(SIGNATURE_LINES)
                        .collect(Collectors.toList());
            }
        };

        ENEMIES_LEFT = new CardView("", "") {
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
        printSignatures(List.of(EMPTY_SLOT, NO_SLOT, NO_SLOT, NO_SLOT, NO_SLOT, EMPTY_SLOT));
        printLine(emptyLine(COLUMNS));
        printLine(List.of(asTitle("Generator"), asTitle("General"),asTitle("Defender"),asTitle("Defender"),asTitle("Defender"), asTitle("Enemy")));
        printLine(emptyLine(COLUMNS));
        printSignatures(List.of(EMPTY_SLOT, battle.general, EMPTY_SLOT, EMPTY_SLOT, EMPTY_SLOT, EMPTY_SLOT));
        printLine(emptyLine(COLUMNS));
        printLine(List.of(asTitle("Generator"), EMPTY_TITLE,EMPTY_TITLE,EMPTY_TITLE,EMPTY_TITLE, asTitle("Enemy")));
        printLine(emptyLine(COLUMNS));
        printSignatures(List.of(EMPTY_SLOT, NO_SLOT, NO_SLOT, NO_SLOT, NO_SLOT, EMPTY_SLOT));
        printLine(emptyLine(COLUMNS));
        System.out.println();
    }

    private void printLine(List<String> titles){
        System.out.print(EMPTY_CHARACTER+" ");
        for (String title : titles) {
            System.out.print(title);
            System.out.printf(" %s ",EMPTY_CHARACTER);
        }
        System.out.println();
    }

    public void printSignatures( List<CardView> views) {
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