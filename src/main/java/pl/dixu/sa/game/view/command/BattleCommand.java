package pl.dixu.sa.game.view.command;

import pl.dixu.sa.game.view.presenter.BattlePresenter;

public class BattleCommand implements Command {
    private BattlePresenter presenter;
    private BattlePresenterAnimation animation;

    public BattleCommand(BattlePresenter presenter, BattlePresenterAnimation animation) {
        this.presenter = presenter;
        this.animation = animation;
    }

    public void prepare(BattlePresenterAnimation animation) {
        this.animation = animation;
    }

    @Override
    public void executePresentation() {
        animation.animate(presenter);
    }
}
