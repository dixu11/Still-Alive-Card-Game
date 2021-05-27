package pl.dixu.sa.server.command;

import pl.dixu.sa.server.battle.Hand;
import pl.dixu.sa.server.battle.Player;
import pl.dixu.sa.server.cards.general.Card;
import pl.dixu.sa.server.view.BattlePresenter;

public class PlayCardCommand implements Command{

    private BattlePresenter presenter;
    private Card card;
    private Player player;

   public PlayCardCommand(BattlePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void executeLogic() {

    }

    @Override
    public void executePresentation() {
        presenter.playCard(this);
    }

    public void prepare(Card card, Player player) {
        this.card = card;
        this.player = player;
    }

   public Card getCard() {
        return card;
    }

   public Player getPlayer() {
        return player;
    }
}
