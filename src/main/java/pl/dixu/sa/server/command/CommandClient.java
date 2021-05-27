package pl.dixu.sa.server.command;

import pl.dixu.sa.server.battle.Battle;
import pl.dixu.sa.server.battle.Player;
import pl.dixu.sa.server.cards.general.EventCard;
import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.view.BattlePresenter;
import pl.dixu.sa.server.view.PresenterFactory;
import pl.dixu.sa.server.view.PresenterThread;

//2 roles - assembly command and execute them
public class CommandClient {
    private PresenterThread presenter;
    private BattlePresenter battlePresenter;

    public CommandClient(PresenterThread presenter, PresenterFactory presenterFactory) {
        this.presenter = presenter;
        battlePresenter = presenterFactory.getBattlePresenter();
    }

    public void spawnCharacter(CharacterCard card) {
        SpawnEventCommand command =new SpawnEventCommand(battlePresenter);
        command.prepare(card);
        presenter.queue(command);
    }

    public void playCard(EventCard card, Player player) {
        PlayCardCommand playCardCommand = new PlayCardCommand(battlePresenter);
        playCardCommand.prepare(card,player);
        presenter.queue(playCardCommand);
    }

    public void startBattle(Battle battle) {
        StartBattleCommand command = new StartBattleCommand(battle,battlePresenter);
        presenter.queue(command);
    }

    public void addEnergy(int energy) {
        AddEnergyCommand command = new AddEnergyCommand(battlePresenter, energy);
        presenter.queue(command);

    }
}
