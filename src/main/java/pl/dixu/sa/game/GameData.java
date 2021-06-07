package pl.dixu.sa.game;

import java.util.List;
import java.util.Map;

public interface GameData {
    Map<Area, List<CharacterCardData>> getTable();
}
