package pl.dixu.sa.server.command;

import pl.dixu.sa.server.view.BattlePresenter;

public class AddEnergyCommand implements Command {

    private BattlePresenter presenter;
    private int energy;

    public AddEnergyCommand(BattlePresenter presenter, int energy) {
        this.presenter = presenter;
        this.energy = energy;
    }

    @Override
    public void executePresentation() {
        presenter.addEnergy(energy);
    } //todo refactor commands to events

}
