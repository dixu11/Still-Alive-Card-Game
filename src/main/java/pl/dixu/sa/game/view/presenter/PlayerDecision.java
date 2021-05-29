package pl.dixu.sa.game.view.presenter;

@FunctionalInterface
public interface PlayerDecision { //todo "Player" or "Human"?

    void execute(PlayerController player);

}
