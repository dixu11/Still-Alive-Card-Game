package pl.dixu.sa.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Battle implements GameData {

    private Map<Area, List<CharacterCard>> table = new HashMap<>();

    public Battle() {
        startBattle();
    }

    public void startBattle() {
        //prepare
        List<CharacterCard> player = new ArrayList<>(List.of(
                new CharacterCard("Defender 1", 4, 4),
                new CharacterCard("Defender 2", 3, 6),
                new CharacterCard("Defender 3", 2, 8)
        ));
        table.put(Area.PLAYER, player);

        List<CharacterCard> enemy = new ArrayList<>(List.of(
                new CharacterCard("Enemy 1", 4, 4),
                new CharacterCard("Enemy 2", 3, 6),
                new CharacterCard("Enemy 3", 2, 8)
        ));
        table.put(Area.ENEMY, enemy);


    }

    @Override
    public Map<Area, List<CharacterCardData>> getTable() {
        return table.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> new ArrayList<>(e.getValue())));
    }
}
