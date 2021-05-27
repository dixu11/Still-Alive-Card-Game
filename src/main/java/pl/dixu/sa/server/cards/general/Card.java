package pl.dixu.sa.server.cards.general;

import pl.dixu.sa.server.view.CardView;

public class Card {

    private String name;
    private String dsc; //todo

   public Card() { // for lombok
    }

    public Card(String name) {
        this.name = name;
    }

    public CardView toView() {
        return new CardView(name,dsc);
    }
}
