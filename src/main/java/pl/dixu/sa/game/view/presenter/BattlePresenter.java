package pl.dixu.sa.game.view.presenter;

import pl.dixu.sa.game.battle.Player;
import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.view.model.CardAttributes;

import java.util.List;

//todo should be split into smaller
public abstract class BattlePresenter {

    protected BattleController battle;

    public abstract void spawn(CardAttributes character);

    public void startBattle(BattleController battle) {
        this.battle = battle;
        showStartBattle();
    }

    public abstract void showStartBattle();

    public abstract void playCard(Player player, Card card);

    public abstract void addEnergy(int energy);

    public abstract void showDraw(List<CardAttributes> cards);

    public abstract void showShuffle();

}