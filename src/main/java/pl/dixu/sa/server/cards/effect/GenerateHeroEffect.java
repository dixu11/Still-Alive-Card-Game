package pl.dixu.sa.server.cards.effect;

public class GenerateHeroEffect extends GenerateEffect{
    @Override
    protected int energyThisTurn() {
        int turn = mediator.getTurnNumber();
        if (turn == 1) {
            return 3;
        } else if (turn == 2) {
            return 2;
        } else {
            return 1;
        }
    }
}
