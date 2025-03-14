package student;


import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


public class Planner implements IPlanner {

    /** A Set of Board Games.*/
    private Set<BoardGame> games;

    /**
     * Constructor to Planner.
     * @param games The set of board games.
     */
    public Planner(Set<BoardGame> games) {
        this.games = games;
    }

    /**
     * Assumes the results are sorted in ascending order, and that the steam is sorted by the name
     * of the board game (GameData.NAME).
     * @param filter The filter to apply to the board games.
     * @return A stream of board games that match the filter.
     */
    @Override
    public Stream<BoardGame> filter(String filter) {
        Stream<BoardGame> filteredStream = filterSingle(filter, games.stream()).sorted(
                Sorting.getSorting(GameData.NAME, true));
        return filteredStream;

    }


    private Stream<BoardGame> filterSingle(String filter, Stream<BoardGame> filteredGames) {
        // handle getting operation, game attribute to filter on
        Operations operator = Operations.getOperatorFromStr(filter);
        if (operator == null) {
            return filteredGames;
        }
        // remove spaces
        filter = filter.replaceAll(" ", "");

        String[] parts = filter.split(operator.getOperator());
        if (parts.length != 2) {
            return filteredGames;
        }
        GameData column;
        try {
            column = GameData.fromString(parts[0]);
        } catch (IllegalArgumentException e) {
            return filteredGames;
        }
        String value;
        try {
            value = parts[1].trim();
        } catch (IllegalArgumentException e) {
            return filteredGames;
        }
        System.out.println("Operator is: " + operator);
        System.out.println("Game is: " + column);
        System.out.println(column + " is " + value);
        List<BoardGame> filteredGameList = filteredGames.filter(game -> Filters.filter(game,
                column, operator, value)).toList();
        return filteredGameList.stream();
    }

    /**
     * Filters the board games by the passed in text filter. Assumes the results are sorted in
     * ascending order.
     *
     * @param filter The filter to apply to the board games.
     * @param sortOn The column to sort the results on.
     * @return A stream of board games that match the filter.
     */
    @Override
    public Stream<BoardGame> filter(String filter, GameData sortOn) {
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
        //return this.games.stream();
    }

    /**
     * Filters the board games by the passed in text filter.
     *
     * @param filter The filter to apply to the board games.
     * @param sortOn The column to sort the results on.
     * @param ascending Whether to sort the results in ascending order or descending order.
     * @return A stream of board games that match the filter.
     */
    @Override
    public Stream<BoardGame> filter(String filter, GameData sortOn, boolean ascending) {
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    /**
     * Resets the collection to have no filters applied.
     */
    @Override
    public void reset() {
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }


}
