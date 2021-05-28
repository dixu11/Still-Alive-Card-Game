package pl.dixu.sa.game.view.presenter;

public abstract class PresenterFactory {

    private BattlePresenter battlePresenter;

    public PresenterFactory() {
        battlePresenter = createBattlePresenter();
    }

    protected abstract BattlePresenter createBattlePresenter();

    public BattlePresenter getBattlePresenter() {
        return battlePresenter;
    }
}
