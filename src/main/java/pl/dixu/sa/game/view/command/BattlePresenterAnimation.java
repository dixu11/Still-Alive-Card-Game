package pl.dixu.sa.game.view.command;

import pl.dixu.sa.game.view.presenter.BattlePresenter;

@FunctionalInterface
public interface BattlePresenterAnimation {
    void animate(BattlePresenter presenter);
}
