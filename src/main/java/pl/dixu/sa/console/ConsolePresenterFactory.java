package pl.dixu.sa.console;

import pl.dixu.sa.server.view.BattlePresenter;
import pl.dixu.sa.server.view.PresenterFactory;

public class ConsolePresenterFactory extends PresenterFactory {

    @Override
    protected BattlePresenter createBattlePresenter() {
        return new ConsoleBattlePresenter();
    }
}
