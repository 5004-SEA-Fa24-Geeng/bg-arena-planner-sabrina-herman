package student;


import java.util.Comparator;

public final class Sorting {
    private Sorting() {
    }

    /**
     * Sorts the games according to the column.
     * @param gameData column name
     * @param ascending in ascending or descending order.
     * @return A comparator to sort the board games
     */
    public static Comparator<BoardGame> getSorting(GameData gameData, boolean ascending) {
        switch (gameData) {
            case NAME:
                return (o1, o2) -> {
                    int compare = o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
                    return ascending ? compare : -compare;
                };
            case ID:

            default:
                throw new IllegalArgumentException("Invalid");
        }
    }

}
