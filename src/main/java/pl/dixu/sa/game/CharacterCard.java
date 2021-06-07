package pl.dixu.sa.game;

public class CharacterCard implements CharacterCardData {

    private String name;
    private int attack;
    private int hp;

    public CharacterCard(String name, int attack, int hp) {
        this.name = name;
        this.attack = attack;
        this.hp = hp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getHp() {
        return hp;
    }


}
