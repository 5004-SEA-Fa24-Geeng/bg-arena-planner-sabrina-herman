package student;


import java.util.Comparator;

public final class Sorting {
    private Sorting() {
    }

    public static Comparator<BoardGame> getSorting(GameData gameData, boolean ascending) {
        switch (gameData) {
            case NAME:
                return Comparator.comparing(BoardGame::getName);
            default:
                throw new IllegalArgumentException("Invalid");
        }
    }

}
