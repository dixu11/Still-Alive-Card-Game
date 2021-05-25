package pl.dixu.sa.server.cards.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.dixu.sa.server.cards.general.EventCard;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class EventFactoryTest {

    private EventCardFactory eventFactory = new EventCardFactory(new CharacterCardFactory());

    @Test
    @DisplayName("Attack should have correct attributes")
    public void createAttack() {
        EventCard attack = eventFactory.createAttack();

        assertThat(attack).isEqualTo(attackCard());
    }

    @Test
    @DisplayName("Spawn enemy should have correct attributes")
    public void createSpawnEnemy() {
        EventCard card = eventFactory.createSpawnEnemyCard();

        assertThat(card).isEqualTo(spawnEnemyCard());
    }

    private EventCard attackCard() {
        return new EventCard(1,new ArrayList<>(),"Attack");
    }

    private EventCard spawnEnemyCard() {
        return new EventCard(0,new ArrayList<>(),"Enemy");
    }
}
