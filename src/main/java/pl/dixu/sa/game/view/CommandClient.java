package pl.dixu.sa.game.view;

import pl.dixu.sa.game.battle.Battle;
import pl.dixu.sa.game.battle.Player;
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

    public void spawnCharacter(CharacterCard card) {
        presenter.queue(createCommand(p->p.spawn(card.toAttributes())));
    }

    public void startBattle(Battle battle) {
        presenter.queue(createCommand(p->p.startBattle(battle)));
    }

    public void addEnergy(int energy) {
        presenter.queue(createCommand(p->p.addEnergy(energy)));
    }

    public void showDraw(List<? extends Card> cards) {
        presenter.queue(createCommand(p->p.showDraw(cards)));
    }

    public void showShuffle() {
        presenter.queue(createCommand(BattlePresenter::showShuffle));
    }

    public void showCardPlayed(Player owner, EventCard card) {
        presenter.queue(createCommand(p-> p.showCardPlayed(owner,card)));
    }

    public void showNewCard(EventCard card) {
        presenter.queue(createCommand(p-> p.showNewCard(card)));
    }

    public void showEndTurn() {
        presenter.queue(createCommand(p -> p.showEndTurn()));
    }

    private BattleCommand createCommand(BattlePresenterAnimation animation) {
        return new BattleCommand(battlePresenter,animation);
    }

    public void playRound(BattleController battleController) {
        presenter.queue(createCommand(presenter1 -> presenter1.playRound(battleController)));
    }

    private List<CardAttributes> toAttributes(List<? extends Card> cards) {
        return cards.stream()
                .map(c -> c.toAttributes())
                .collect(Collectors.toList());
    }
}
