package pl.dixu.sa.server.command;

import pl.dixu.sa.server.battle.Battle;
import pl.dixu.sa.server.view.BattlePresenter;

//sends Battle object to Presenter
public class StartBattleCommand implements Command{

    private Battle battle;
    private BattlePresenter presenter;

    StartBattleCommand(Battle battle, BattlePresenter presenter) {
        this.battle = battle;
        this.presenter = presenter;
    }

    @Override
    public void executePresentation() {
        presenter.startBattle(battle);
    }

}
