package pl.dixu.sa.game.view.presenter;

import pl.dixu.sa.game.battle.Player;
import pl.dixu.sa.game.cards.effect.TargetableEffect;
import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.view.model.CardAttributes;

import java.util.List;

//todo should be split into smaller
public abstract class BattlePresenter {

    protected BattleController battleLogicController;

    public abstract void spawn(CardAttributes character);

    public void setupBattle(BattleController controller) {
        this.battleLogicController = controller;
        onBattleSetup();
        showStartBattle();
    }

    public abstract void onBattleSetup();

    public abstract void showStartBattle();

    public abstract void showCardPlayed(Player player, Card card);

    public abstract void changeEnergy(int energy);

    public abstract void showDraw(List<? extends Card> cards);

    public abstract void showShuffle();

    public abstract void showNewCard(EventCard card);

    public abstract void showEndTurn();

    public abstract void playRound();

    public abstract int chooseTarget(TargetableEffect effect, List<Area> possibleTargets);
}
