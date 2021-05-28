package pl.dixu.sa.game.view.model;

public abstract class BattleView {
    protected BattleDTO battle;

    public BattleView(BattleDTO battle) {
        this.battle = battle;
    }

    public BattleView() {
    }

  public   void setBattle(BattleDTO battle) {
        this.battle = battle;
    }

    public abstract void display();
}
