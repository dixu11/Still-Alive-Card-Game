package pl.dixu.sa.server.cards.factory;
import pl.dixu.sa.server.cards.effect.GenerateHeroEffect;
import pl.dixu.sa.server.cards.effect.GeneratorStandardEffect;
import pl.dixu.sa.server.cards.general.Area;
import pl.dixu.sa.server.battle.Deck;
import pl.dixu.sa.server.cards.general.Level;
import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.effect.BattleEffect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CharacterCardFactory {

    public CharacterCard createBasicEnemy(int lvl) {
        CharacterCard basicEnemy = createBasicEnemy();
        for (int i = 0; i < lvl; i++) {
            basicEnemy.levelUp();
        }
        return basicEnemy;
    }

    public CharacterCard createGeneral() {
        Queue<Level> levels = new LinkedList<>();
        levels.add(new Level(0,10,0));
        CharacterCard characterCard = new CharacterCard(0, Area.GENERAL, levels, "General");
        characterCard.addEffect(new GenerateHeroEffect());
        characterCard.levelUp();
        return characterCard;
    }

    public Deck<CharacterCard> createStartingGenerators() {
        Deck<CharacterCard> deck = new Deck<>();
        deck.add(createGenerator());
        deck.add(createGenerator());
        deck.add(createGenerator());
        return deck;
    }

    public Deck<CharacterCard> createStartingDefenders() {
        Deck<CharacterCard> deck = new Deck<>();
        deck.add(createDefender());
        deck.add(createDefender());
        deck.add(createDefender());
        return deck;
    }

    public CharacterCard createGenerator() {
        Queue<Level> levels = new LinkedList<>();
        levels.add(new Level(1,0,0));
        levels.add(new Level(2,0,0));
        levels.add(new Level(3,0,0));
        //add heal to max effect
        CharacterCard characterCard = new CharacterCard(0, Area.GENERATORS, levels,"Generator");
        characterCard.addEffect(new GeneratorStandardEffect(characterCard));
        characterCard.levelUp();
        return characterCard;
    }

    public CharacterCard createDefender() {
        Queue<Level> levels = new LinkedList<>();
        levels.add(new Level(1,6,0));
        levels.add(new Level(2,3,0));
        levels.add(new Level(3,3,0));
        //add heal to max effect
        CharacterCard characterCard = new CharacterCard(0, Area.DEFENDERS,  levels,"Defender");
        characterCard.levelUp();
        return characterCard;
    }

    private CharacterCard createBasicEnemy() {
        Queue<Level> levels = new LinkedList<>();
        levels.add(new Level(1,5,3));
        levels.add(new Level(2,2,2));
        levels.add(new Level(3,2,2));
        levels.add(new Level(4,6,6));
        return new CharacterCard(0,Area.ENEMIES,levels,"Enemy");
    }

}
