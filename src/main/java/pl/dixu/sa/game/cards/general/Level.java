package pl.dixu.sa.game.cards.general;

import pl.dixu.sa.game.cards.effect.Effect;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private int nr;
    private int plusMaxHp;
    private int plusAttack;
    private List<Effect> effects = new ArrayList<>();

    public Level(int nr, int plusMaxHp, int plusAttack) {
        this.nr = nr;
        this.plusMaxHp = plusMaxHp;
        this.plusAttack = plusAttack;
    }

    public Level(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }

    public int getPlusMaxHp() {
        return plusMaxHp;
    }

    public int getPlusAttack() {
        return plusAttack;
    }
}
