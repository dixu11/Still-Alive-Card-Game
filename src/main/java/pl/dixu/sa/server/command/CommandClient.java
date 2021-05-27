package pl.dixu.sa.server.command;

import pl.dixu.sa.server.battle.Battle;
import pl.dixu.sa.server.battle.BattleMediator;
import pl.dixu.sa.server.battle.Player;
import pl.dixu.sa.server.cards.general.EventCard;
import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.view.PresenterFactory;
import pl.dixu.sa.server.view.PresenterThread;

//2 roles - assembly command and execute them
public class CommandClient {
    private PresenterThread presenter;
    private PresenterFactory presenterFactory;

    public CommandClient(PresenterThread presenter, PresenterFactory presenterFactory) {
        this.presenter = presenter;
        this.presenterFactory = presenterFactory;
    }

    public void spawnCharacter(CharacterCard card) {
        SpawnEventCommand command =new SpawnEventCommand(presenterFactory.getBattlePresenter());
        command.prepare(card);
        presenter.queuePresentationCommand(command);
    }

    public void playCard(EventCard card, Player player) {
        PlayCardCommand playCardCommand = new PlayCardCommand(presenterFactory.getBattlePresenter());
        playCardCommand.prepare(card,player);
        presenter.queuePresentationCommand(playCardCommand);
    }

    public void startBattle(Battle battle) {
        StartBattleCommand command = new StartBattleCommand(battle,presenterFactory.getBattlePresenter());
        presenter.queuePresentationCommand(command);
    }

   public void generateEnergy(int count) {
     //  factory.getGenerateEnergyCommand(); // todo
    }

}
