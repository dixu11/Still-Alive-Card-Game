package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.general.CharacterCard;

public class Shop extends BattleComponent{

    private Deck<CharacterCard> generators;
    private Deck<CharacterCard> defenders;

    Shop(Deck<CharacterCard> generators, Deck<CharacterCard> defenders) {
        this.generators = generators;
        this.defenders = defenders;
    }

    public CharacterCard peekFirstGenerator() {
        return generators.peekFirst();
    }

    public CharacterCard peekFirstDefender() {
        return defenders.peekFirst();
    }
}

//todo refactor - slots
