package student;

public final class Filters {
    private Filters() { }

    /**
     * Filters board games.
     * @param game the Board Game.
     * @param column name of the type of data.
     * @param op operation done.
     * @param value value to compare with the value of the board game.
     * @return if the filter done on the game is true or not.
     */
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
                return false;
        }
    }

    /**
     * Filter based on string.
     * @param gameData Name of board game.
     * @param op operation done.
     * @param value value to compare with the value of the board game.
     * @return if the filter done on the game is true or not.
     */
    public static boolean filterString(String gameData, Operations op, String value) {
        switch (op) {
            case EQUALS:
                return gameData.replaceAll(" ", "").equals(value);
            case CONTAINS:
                return gameData.toLowerCase().replaceAll(" ", "").contains(value.toLowerCase().replaceAll(" ", ""));
            case GREATER_THAN:
                return gameData.replaceAll(" ", "").compareTo(value) > 0;
            default:
                return false;
        }
    }

    /**
     * Filter based on number.
     * @param gameData Name of board game.
     * @param op operation done.
     * @param value value to compare with the value of the board game.
     * @return if the filter done on the game is true or not.
     */
    public static boolean filterNum(int gameData, Operations op, String value) {
        int intValue = Integer.parseInt(value);
        switch (op) {
            case EQUALS:
                //return gameData.equals(value);
            default:
                //temp
                return false;
        }
    }
}
