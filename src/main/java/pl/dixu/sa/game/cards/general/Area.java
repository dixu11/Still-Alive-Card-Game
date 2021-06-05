package pl.dixu.sa.game.cards.general;

public enum Area {
    GENERATORS(3),
    GENERAL(1),
    DEFENDERS(3),
    ENEMIES(3),
    EMPTY_GENERATORS(0),
    EMPTY_DEFENDERS(0),
    EMPTY_ENEMIES(0),
    UNKNOWN(0);

    private int slots;

    Area(int slots) {
        this.slots = slots;
    }

    public int getSlots() {
        return slots;
    }

    public static Area getEmptyFor(Area area) {
        return switch (area) {
            case ENEMIES -> EMPTY_ENEMIES;
            case DEFENDERS -> EMPTY_DEFENDERS;
            case GENERATORS -> EMPTY_GENERATORS;
            default -> UNKNOWN;
        };
    }
}
