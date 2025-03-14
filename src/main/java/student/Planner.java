package student;


import java.util.List;
import java.util.Set;
//import java.util.stream.Collectors;
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

    @Override
    public Stream<BoardGame> filter(String filter) {
        Stream<BoardGame> filteredStream = filterSingle(filter, games.stream());
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

    @Override
    public Stream<BoardGame> filter(String filter, GameData sortOn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public Stream<BoardGame> filter(String filter, GameData sortOn, boolean ascending) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }


}
