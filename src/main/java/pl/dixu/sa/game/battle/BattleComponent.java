package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.view.CommandClient;
import pl.dixu.sa.game.view.model.CardAttributes;
import pl.dixu.sa.game.view.model.Viewable;

import java.util.ArrayList;
import java.util.List;

//provides mediator for all components
public class BattleComponent implements Viewable {

    protected BattleMediator mediator;
    protected CommandClient client;

    private static List<BattleComponent> allBattleComponentsInGame = new ArrayList<>();

    public BattleComponent() {
        allBattleComponentsInGame.add(this);
    }

    public static void addMediatorToAllComponents(BattleMediator mediator) {
        for (BattleComponent component : allBattleComponentsInGame) {
            component.setMediator(mediator);
        }
    }

    public static void addClientToAllComponents(CommandClient client) {
        for (BattleComponent component : allBattleComponentsInGame) {
            component.setClient(client);
        }
    }


    public void setMediator(BattleMediator mediator) {
        this.mediator = mediator;
    }

    public void setClient(CommandClient client) {
        this.client = client;
    }

}
