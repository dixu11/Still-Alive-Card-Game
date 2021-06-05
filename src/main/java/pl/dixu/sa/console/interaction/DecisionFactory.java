package pl.dixu.sa.console.interaction;

import pl.dixu.sa.game.view.model.CardAttributes;

public class DecisionFactory {

    public ConsoleDecision createDecision(String input){
        return null;
    }

    public ConsoleDecision playCard(String input, CardAttributes attributes) {
        return new PlayCardDecision(input,attributes);
    }


}
