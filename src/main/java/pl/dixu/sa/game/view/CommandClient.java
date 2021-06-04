package pl.dixu.sa.game.view;

import pl.dixu.sa.game.battle.Player;
import pl.dixu.sa.game.cards.effect.TargetableEffect;
import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.cards.general.CharacterCard;
import pl.dixu.sa.game.view.command.*;
import pl.dixu.sa.game.view.model.CardAttributes;
import pl.dixu.sa.game.view.presenter.*;

import java.util.List;
import java.util.stream.Collectors;

//2 roles - assembly command and execute them
public class CommandClient {
    private PresenterThread presenter;
    private BattlePresenter battlePresenter;

    public CommandClient(PresenterThread presenter, PresenterFactory presenterFactory) {
        this.presenter = presenter;
        battlePresenter = presenterFactory.getBattlePresenter();
    }

    public void showSpawnCharacter(CharacterCard card) {
        presenter.queue(createCommand(p -> p.spawn(card.toAttributes())));
    }

    public void playRound() {
        presenter.queue(createCommand(BattlePresenter::playAction));
    }

    public void chooseTarget(TargetableEffect effect, List<Area> possibleTargets) {
        presenter.queue(createCommand(p -> p.chooseTarget(effect, possibleTargets)));
    }

    public void startBattle(BattleController controller) {
        presenter.queue(createCommand(p -> p.setupBattle(controller)));
    }

    public void showEnergyChange(int energy) {
        presenter.queue(createCommand(p -> p.changeEnergy(energy)));
    }

    public void showDraw(List<? extends Card> cards) {
        presenter.queue(createCommand(p -> p.showDraw(cards)));
    }

    public void showShuffle() {
        presenter.queue(createCommand(BattlePresenter::showShuffle));
    }

    public void showCardPlayed(Player owner, EventCard card) {
        presenter.queue(createCommand(p -> p.showCardPlayed(owner, card)));
    }

    public void showNewCard(EventCard card) {
        presenter.queue(createCommand(p -> p.showNewCard(card)));
    }

    public void showEndTurn() {
        presenter.queue(createCommand(p -> p.showEndTurn()));
    }

    public void showReceiveDmg(CharacterCard card, int dmg) {
        presenter.animate(createCommand(p-> p.showReceiveDmg(card,dmg)));
    }

    private BattleCommand createCommand(BattlePresenterAnimation animation) {
        return new BattleCommand(battlePresenter, animation);
    }

    private List<CardAttributes> toAttributes(List<? extends Card> cards) {
        return cards.stream()
                .map(c -> c.toAttributes())
                .collect(Collectors.toList());
    }
}
