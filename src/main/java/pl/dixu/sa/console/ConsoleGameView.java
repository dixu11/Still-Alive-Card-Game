package pl.dixu.sa.console;

import pl.dixu.sa.server.cards.view.CardView;
import pl.dixu.sa.server.cards.view.GameView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pl.dixu.sa.server.cards.view.CardView.*;

public class ConsoleGameView extends GameView {

    private CardView NO_SLOT;
    private CardView EMPTY_SLOT;
    private final String EMPTY_TITLE;

    public ConsoleGameView() {
        EMPTY_TITLE = emptyTitle();
        initSlotsSignature();
    }

    private void initSlotsSignature() {
        //todo refactor
        NO_SLOT = new CardView("", "") {
            @Override
            public List<String> signatureView() {
                return Stream.generate(() -> "*".repeat(CHARACTERS))
                        .limit(SIGNATURE_LINES)
                        .collect(Collectors.toList());
            }
        };
        EMPTY_SLOT = new CardView("", "") {
            @Override
            public List<String> signatureView() {
                return Stream.generate(() -> "#".repeat(CHARACTERS))
                        .limit(SIGNATURE_LINES)
                        .collect(Collectors.toList());
            }
        };
    }

    @Override
    public void display() {
        //todo
        System.out.println("Prezentacja stanu gry\n");
        printLine(emptyLine(6));
        printLine(List.of(EMPTY_TITLE,asTitle("Shop"), asTitle("Shop"),asTitle("Event"), asTitle("Next event"), EMPTY_TITLE));
        printLine(emptyLine(6));
        printSignatures(List.of(NO_SLOT,game.shopCard1, game.shopCard2, EMPTY_SLOT, game.enemyDraw, NO_SLOT));
//        printLine(emptyLine(6));
        printLine(List.of(asTitle("Generator"), EMPTY_TITLE,EMPTY_TITLE,EMPTY_TITLE,EMPTY_TITLE, asTitle("Enemy")));
        printLine(emptyLine(6));
        printSignatures(List.of(EMPTY_SLOT, NO_SLOT, NO_SLOT, NO_SLOT, NO_SLOT, EMPTY_SLOT));
        printLine(emptyLine(6));
        printLine(List.of(asTitle("Generator"), asTitle("Hero"),asTitle("Defender"),asTitle("Defender"),asTitle("Defender"), asTitle("Enemy")));
        printLine(emptyLine(6));
        printSignatures(List.of(EMPTY_SLOT, game.general, EMPTY_SLOT, EMPTY_SLOT, EMPTY_SLOT, EMPTY_SLOT));
        printLine(emptyLine(6));
        printLine(List.of(asTitle("Generator"), EMPTY_TITLE,EMPTY_TITLE,EMPTY_TITLE,EMPTY_TITLE, asTitle("Enemy")));
        printLine(emptyLine(6));
        printSignatures(List.of(EMPTY_SLOT, NO_SLOT, NO_SLOT, NO_SLOT, NO_SLOT, EMPTY_SLOT));
        printLine(emptyLine(6));
    }

    private void printLine(List<String> titles){
        System.out.print("* ");
        for (String title : titles) {
            System.out.print(title);
            System.out.print(" * ");
        }
        System.out.println();
    }

    public void printSignatures( List<CardView> views) {
        List<String> signature;
        for (int row = 0; row < SIGNATURE_LINES; row++) {
            System.out.print("* ");
            for (int i = 0; i < views.size(); i++) {
                signature = views.get(i).signatureView();
                if (row >= signature.size()) {
                    System.out.print(" ".repeat(CHARACTERS));
                } else {
                    System.out.print(signature.get(row));
                }
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private String asTitle(String text) {
        return String.format("%-" + CHARACTERS + "s", text.substring(0, Math.min(text.length(), CHARACTERS)));
    }

    private String emptyTitle() {
        return "*".repeat(CHARACTERS);
    }

    public List<String> emptyLine(int length){
       return Stream.generate(()-> EMPTY_TITLE)
                .limit(length)
                .collect(Collectors.toList());
    }


}
