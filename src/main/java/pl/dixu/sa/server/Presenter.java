package pl.dixu.sa.server;

import pl.dixu.sa.server.cards.general.CardView;

public abstract class Presenter {

    public abstract void playGeneral(CardView general);

   public abstract void showEnemyEvent(CardView event);

    public abstract void showSpawnCharacter(CardView character);
}
