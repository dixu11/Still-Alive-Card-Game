package pl.dixu.sa.server.cards.general;

public class Card {

    private String name;
    private String dsc;

   public Card() { // for lombok
    }

    public Card(String name) {
        this.name = name;
    }

    public CardView toView() {
        return new CardView(name,dsc);
    }
}
