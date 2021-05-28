package pl.dixu.sa.console;

import pl.dixu.sa.game.view.presenter.BattlePresenter;
import pl.dixu.sa.game.view.presenter.PresenterFactory;

public class ConsolePresenterFactory extends PresenterFactory {

    @Override
    protected BattlePresenter createBattlePresenter() {
        return new ConsoleBattlePresenter();
    }
}
