package pl.dixu.sa.game.cards.factory;
import pl.dixu.sa.game.cards.effect.GenerateHeroEffect;
import pl.dixu.sa.game.cards.effect.GeneratorStandardEffect;
import pl.dixu.sa.game.cards.effect.ShopSpawnEffect;
import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.battle.Deck;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.cards.general.Level;
import pl.dixu.sa.game.cards.general.CharacterCard;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CharacterCardFactory {

    public CharacterCard createBasicEnemy(int level) {
        Queue<Level> levels = new LinkedList<>();
        levels.add(new Level(1, 5, 3));
        levels.add(new Level(2, 2, 2));
        levels.add(new Level(3, 2, 2));
        levels.add(new Level(4, 6, 6));
        return new CharacterCard(Area.ENEMIES, levels, "Enemy")
                .addLevels(level);
    }

    public Deck<EventCard> createStartingGenerators() {
        Deck<EventCard> deck = new Deck<>();
        for (int i = 0; i < 9; i++) {
            deck.add(getAsShopCard(createGenerator()));
        }
        return deck;
    }

    public Deck<EventCard> createStartingDefenders() {
        Deck<EventCard> deck = new Deck<>();
        for (int i = 0; i < 20; i++) { //todo infinite? or what if runs off?
            deck.add(getAsShopCard(createDefender()));
        }
        return deck;
    }

    public CharacterCard createGeneral() {
        Queue<Level> levels = new LinkedList<>();
        levels.add(new Level(0, 10, 0));
        CharacterCard characterCard = new CharacterCard(Area.GENERAL, levels, "General",2);
        characterCard.addEffect(new GenerateHeroEffect());
        characterCard.levelUp();
        return characterCard;
    }

    public EventCard getAsShopCard(CharacterCard character) {
        Area area = character.getArea();
        ShopSpawnEffect effect = new ShopSpawnEffect(List.of(area,Area.getEmptyFor(area)), character);
        EventCard eventCard = new EventCard("Play " + character.getName(), 2);
        eventCard.addEffect(effect);
        return eventCard;
    }

    public CharacterCard createGenerator() {
        Queue<Level> levels = new LinkedList<>();
        levels.add(new Level(1));
        levels.add(new Level(2));
        levels.add(new Level(3));
        //add heal to max effect
        CharacterCard characterCard = new CharacterCard(Area.GENERATORS, levels, "Generator",2);
        characterCard.addEffect(new GeneratorStandardEffect(characterCard));
        characterCard.levelUp();
        return characterCard;
    }

    public CharacterCard createDefender() {
        Queue<Level> levels = new LinkedList<>();
        levels.add(new Level(1, 6, 0));
        levels.add(new Level(2, 3, 0));
        levels.add(new Level(3, 3, 0));
        //add heal to max effect
        CharacterCard characterCard = new CharacterCard( Area.DEFENDERS, levels, "Defender");
        return characterCard.addLevels(1);
    }

}
