package pl.dixu.sa.server.command;

import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.view.BattlePresenter;

public class SpawnEventCommand implements Command {

    private BattlePresenter presenter;
    private CharacterCard character;

    public SpawnEventCommand(BattlePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void executePresentation() {
        presenter.spawn(character.toView());
    }

   public void prepare(CharacterCard character) {
        this.character = character;
    }

}
