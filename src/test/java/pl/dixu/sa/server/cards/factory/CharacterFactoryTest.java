package pl.dixu.sa.server.cards.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.dixu.sa.server.Area;
import pl.dixu.sa.server.cards.general.CharacterCard;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CharacterFactoryTest {

   private CharacterCardFactory factory = new CharacterCardFactory();

    @Test
    @DisplayName("Created enemy should have correct stats")
    public void createEnemy() {
        CharacterCard basicEnemy = factory.createBasicEnemy(4);

        assertThat(basicEnemy).isEqualTo(enemy4Level());
    }

    @Test
    @DisplayName("Created defender should have correct stats")
    public void createDefender() {
        CharacterCard basicDefender = factory.createDefender();

        assertThat(basicDefender).isEqualTo(defender1Level());
    }

    @Test
    @DisplayName("Created generator should have correct stats")
    public void createGenerator() {
        CharacterCard basicGenerator = factory.createGenerator();

        assertThat(basicGenerator).isEqualTo(generator1Level());
    }

    @Test
    @DisplayName("Created general should have correct stats")
    public void createGeneral() {
        CharacterCard basicGeneral = factory.createGeneral();

        assertThat(basicGeneral).isEqualTo(general0Level());
    }


    private CharacterCard enemy4Level() {
        return CharacterCard.builder()
                .area(Area.ENEMIES)
                .lvl(4)
                .attack(13)
                .maxHp(15)
                .actualHp(15)
                .block(0)
                .build();
    }

    private CharacterCard defender1Level() {
        return CharacterCard.builder()
                .area(Area.DEFENDERS)
                .lvl(1)
                .attack(0)
                .maxHp(6)
                .actualHp(6)
                .block(0)
                .build();
    }

    private CharacterCard generator1Level() {
        return CharacterCard.builder()
                .area(Area.GENERATORS)
                .lvl(1)
                .attack(0)
                .maxHp(0)
                .actualHp(0)
                .block(0)
                .build();
    }

    private CharacterCard general0Level() {
        return CharacterCard.builder()
                .area(Area.GENERAL)
                .lvl(0)
                .attack(0)
                .maxHp(10)
                .actualHp(10)
                .block(0)
                .build();
    }

}
