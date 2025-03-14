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
            case MIN_PLAYERS:
                //filter based on min players
                return filterNum(game.getMinPlayers(), op, value);
            case MAX_PLAYERS:
                return filterNum(game.getMaxPlayers(), op, value);
            case MIN_TIME:
                return filterNum(game.getMinPlayTime(), op, value);
            case MAX_TIME:
                return filterNum(game.getMaxPlayTime(), op, value);
            case DIFFICULTY:
                return filterDouble(game.getDifficulty(), op, value);
            case RANK:
                return filterNum(game.getRank(), op, value);
            case RATING:
                return filterDouble(game.getRating(), op, value);
            case YEAR:
                return filterNum(game.getYearPublished(), op, value);
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
                return gameData.toLowerCase().replaceAll(" ", "").compareTo(value.toLowerCase()) > 0;
            case LESS_THAN:
                return gameData.toLowerCase().replaceAll(" ", "").compareTo(value.toLowerCase()) < 0;
            case GREATER_THAN_EQUALS:
                return gameData.toLowerCase().replaceAll(" ", "").compareTo(value.toLowerCase()) >= 0;
            case LESS_THAN_EQUALS:
                return gameData.toLowerCase().replaceAll(" ", "").compareTo(value.toLowerCase()) <= 0;
            case NOT_EQUALS:
                return !gameData.replaceAll(" ", "").equals(value);
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
                return gameData == intValue;
            case GREATER_THAN:
                return gameData > intValue;
            case LESS_THAN:
                return gameData < intValue;
            case GREATER_THAN_EQUALS:
                return gameData >= intValue;
            case LESS_THAN_EQUALS:
                return gameData <= intValue;
            case NOT_EQUALS:
                return gameData != intValue;
            default:
                return false;
        }
    }

    /**
     * Filter based on number (double).
     * @param gameData Name of board game.
     * @param op operation done.
     * @param value value to compare with the value of the board game.
     * @return if the filter done on the game is true or not.
     */
    public static boolean filterDouble(double gameData, Operations op, String value) {
        double intValue = Double.parseDouble(value);
        switch (op) {
            case EQUALS:
                return gameData == intValue;
            case GREATER_THAN:
                return gameData > intValue;
            case LESS_THAN:
                return gameData < intValue;
            case GREATER_THAN_EQUALS:
                return gameData >= intValue;
            case LESS_THAN_EQUALS:
                return gameData <= intValue;
            case NOT_EQUALS:
                return gameData != intValue;
            default:
                return false;
        }
    }
}
