package student;

public final class Filters {
    private Filters() {}

    public static boolean filter(BoardGame game, GameData column, Operations op, String value) {

        switch (column) {
            case NAME:
                //filter the name
                return filterString(game.getName(), op, value);
            case MAX_PLAYERS:
                //temp
                return false;
                //filter based on max players
            default:
                //temp
                return false;
        }
    }

    public static boolean filterString(String gameData, Operations op, String value) {
        switch (op) {
            case EQUALS:
                return gameData.equals(value);
            default:
                //temp
                return false;
        }
    }

    public static boolean filterNum(int gameData, Operations op, String value) {
        int int_value = Integer.parseInt(value);
        switch (op) {
            case EQUALS:
                //return gameData.equals(value);
            default:
                //temp
                return false;
        }
    }
}
