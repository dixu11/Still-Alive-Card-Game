package pl.dixu.sa.server.command;

import pl.dixu.sa.server.battle.BattleMediator;
import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.view.BattlePresenter;

public class SpawnEventCommand implements Command {

    private BattlePresenter presenter;
    private CharacterCard character;
    private BattleMediator mediator;

    public SpawnEventCommand(BattlePresenter presenter, BattleMediator mediator) {
        this.presenter = presenter;
        this.mediator = mediator;
    }

    @Override
    public void executeLogic() {
        mediator.spawn(character);
    }

    @Override
    public void executePresentation() {
        presenter.spawn(character.toView());
    }

   public void prepare(CharacterCard character) {
        this.character = character;
    }

}
