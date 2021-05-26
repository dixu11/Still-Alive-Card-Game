package pl.dixu.sa.console;

import pl.dixu.sa.server.cards.general.Card;
import pl.dixu.sa.server.cards.view.CardView;
import pl.dixu.sa.server.cards.view.GameView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleGameView extends GameView {

    private CardView empty;
    private final String EMPTY_TITLE;

    public ConsoleGameView() {
        EMPTY_TITLE = emptyTitle();
        initEmptySignature();
    }

    private void initEmptySignature() {
        empty = new CardView("", "") {
            @Override
            public List<String> signatureView() {
                return Stream.generate(() -> "*".repeat(CardView.CHARACTERS))
                        .limit(5)
                        .collect(Collectors.toList());
            }
        };
    }

    @Override
    public void display() {
        //todo
        System.out.println("Prezentacja stanu gry\n");
        List<String> titles1 = List.of(asTitle("Generators"), asTitle("General"), asTitle("Defenders"), EMPTY_TITLE, EMPTY_TITLE);
        List<CardView> row1 = List.of(game.shopCard1, empty, game.shopCard2, game.general, game.enemyDraw);
        printLine(titles1);
        printLine(emptyLine(5));
        printSignatures(row1);
        printLine(emptyLine(5));

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
        for (int row = 0; row < views.size(); row++) {
            System.out.print("* ");
            for (int i = 0; i < views.size(); i++) {
                signature = views.get(i).signatureView();
                if (row >= signature.size()) {
                    System.out.print(" ".repeat(CardView.CHARACTERS));
                } else {
                    System.out.print(signature.get(row));
                }
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private String asTitle(String text) {
        return String.format("%-" + CardView.CHARACTERS + "s", text.substring(0, Math.min(text.length(), CardView.CHARACTERS)));
    }

    private String emptyTitle() {
        return "*".repeat(CardView.CHARACTERS);
    }

    public List<String> emptyLine(int length){
       return Stream.generate(()-> EMPTY_TITLE)
                .limit(length)
                .collect(Collectors.toList());
    }


}
