package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.view.model.Viewable;

import java.util.ArrayList;
import java.util.List;

public class BattleComponent implements Viewable {
    protected BattleMediator mediator;

    private static List<BattleComponent> components = new ArrayList<>();

    public BattleComponent() {
        components.add(this);
    }

    public void setMediator(BattleMediator mediator) {
        this.mediator = mediator;
    }

    public static void addMediatorToAllComponents(BattleMediator mediator) {
        for (BattleComponent component : components) {
            component.setMediator(mediator);
        }
    }
}
