package pl.dixu.sa.gui;


import pl.dixu.sa.game.Area;
import pl.dixu.sa.game.GameData;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GameView implements Clickable{

    private GameData data;
    private Map<Area, AreaView> areas;

    public GameView(GameData data) {
        this.data = data;
        areas = new HashMap<>();

        AreaView player = new AreaView(Area.PLAYER, true, 4, 50, 200);
        AreaView enemy = new AreaView(Area.ENEMY, false, 3, 600, 50);

        areas.put(Area.PLAYER, player);
        areas.put(Area.ENEMY, enemy);

        data.getTable()
                .entrySet()
                .stream()
                .forEach(e -> areas.get(e.getKey())
                        .addCharacters(e.getValue().stream().map(characterData -> new CharacterCardView(characterData))
                                .collect(Collectors.toList())));
    }

    public void render(Graphics g) {
        for (AreaView areaView : areas.values()) {
            areaView.render(g);
        }
    }

    @Override
    public void reactToClick(int x, int y) {
        for (AreaView areaView : areas.values()) {
            areaView.reactToClick(x,y);
        }
    }
}
