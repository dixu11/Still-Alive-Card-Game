package pl.dixu.sa.server.command;

import pl.dixu.sa.server.battle.BattleMediator;
import pl.dixu.sa.server.view.PresenterFactory;

//communicate commands with view and logic
public class BattleCommandFactory {

    private BattleMediator mediator;
    private PresenterFactory presenterFactory;

   public BattleCommandFactory( PresenterFactory presenterFactory) {
       this.presenterFactory = presenterFactory;
   }

    public SpawnEventCommand getSpawnCharacterCommand() {
        return new SpawnEventCommand(presenterFactory.getBattlePresenter(), mediator);
    }

   public void setMediator(BattleMediator mediator) {
        this.mediator = mediator;
    }

    public StartBattleCommand getStartBattleCommand() {
        return new StartBattleCommand(mediator.getBattle(),presenterFactory.getBattlePresenter());
    }
}
