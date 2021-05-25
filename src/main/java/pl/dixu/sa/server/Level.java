package pl.dixu.sa.server;

import pl.dixu.sa.server.effect.Effect;

import java.util.List;

public class Level {

    public static final int MAX_HP = Integer.MAX_VALUE;

    private int nr;
    private int plusMaxHp;
    private int plusAttack;
    private List<Effect> effects;

   public Level(int nr, int plusMaxHp, int plusAttack) {
        this.nr = nr;
        this.plusMaxHp = plusMaxHp;
        this.plusAttack = plusAttack;
    }

   public   int getNr() {
        return nr;
    }

    public int getPlusMaxHp() {
        return plusMaxHp;
    }

   public   int getPlusAttack() {
        return plusAttack;
    }

   public   List<Effect> getEffects() {
        return effects;
    }
}
