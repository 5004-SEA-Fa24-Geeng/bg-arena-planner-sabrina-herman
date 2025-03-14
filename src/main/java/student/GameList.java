package student;

import java.io.FileWriter;
import java.util.*;
import java.util.stream.Stream;

public class GameList implements IGameList {
    /** DASH between a range. */
    private static final String DASH = "-";

    /** Int for one item in range. */
    private static final int ONE_NUM = 1;

    /** Int for two items in range. */
    private static final int TWO_NUM = 2;

    /** First number index in range. */
    private static final int FIRST = 0;

    /** Second number index in range. */
    private static final int SECOND = 1;

    /** A list of board games. */
    private Set<String> listOfGames;

    /**
     * Constructor for the GameList.
     */
    public GameList() {
        listOfGames = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    }

    /**
     * Gets the contents of a list, as list of names (Strings) in ascending order
     * ignoring case.
     *
     * @return the list of game names in ascending order ignoring case.
     */
    @Override
    public List<String> getGameNames() {
        List<String> listVersionOfGames = List.copyOf(listOfGames);
        return listVersionOfGames;
    }

    /**
     * Removes all games in the list (clears it out completely).
     */
    @Override
    public void clear() {
        this.listOfGames.clear();
    }

    /**
     * Counts/returns the number of games in the list.
     *
     * @return the number of games in the list.
     */
    @Override
    public int count() {
        return listOfGames.size();
    }

    /**
     * Saves the list of games to a file.
     *
     * The contents of the file will be each game name on a new line. It will
     * overwrite the file if
     * it already exists.
     *
     * Saves them in the same order as getGameNames.
     *
     * @param filename The name of the file to save the list to.
     */
    @Override
    public void saveGame(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            for (String game : getGameNames()) {
                fw.write(game + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error while saving game");
        }
    }

    /**
     * Adds a game or games to the list.
     * @param str      the string to parse and add games to the list.
     * @param filtered the filtered list to use as a basis for adding.
     * @throws IllegalArgumentException if the string is not valid.
     */
    @Override
    public void addToList(String str, Stream<BoardGame> filtered) throws IllegalArgumentException {
        List<BoardGame> filteredList = filtered.toList();

        if (str.equalsIgnoreCase(ADD_ALL)) {
            for (BoardGame game: filteredList) {
                listOfGames.add(game.getName());
            }
            return;
        }

        //check for game name, that superseeds
        for (BoardGame game: filteredList) {
            if (game.getName().equals(str)) {
                listOfGames.add(str);
                return;
            }
        }

        String[] range = str.split(DASH);
        if (range.length == ONE_NUM) {
            BoardGame toAdd = filteredList.get(Integer.parseInt(range[FIRST]));
            listOfGames.add(toAdd.getName());
        } else if (range.length == TWO_NUM) {

            for (int i = Integer.parseInt(range[FIRST]); i < Integer.parseInt(range[SECOND]) + 1; i++) {
                listOfGames.add(filteredList.get(i).getName());
            }
        }
    }

    /**
     * Removes a game or games from the list.
     * @param str The string to parse and remove games from the list.
     * @throws IllegalArgumentException If the string is not valid.
     */
    @Override
    public void removeFromList(String str) throws IllegalArgumentException {
        if (listOfGames.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        if (str.equalsIgnoreCase(ADD_ALL)) {
            this.clear();
            return;
        }

        for (String game: listOfGames) {
            if (game.equalsIgnoreCase(str)) {
                listOfGames.remove(game);
                return;
            }
        }

        List<String> strList = getGameNames();
        List<String> toRemove = new ArrayList<>();

        String[] range = str.split(DASH);
        if (range.length == ONE_NUM) {
            int index = Integer.parseInt(range[FIRST]) - 1;
            String strToRemove = strList.get(index);
            listOfGames.remove(strToRemove);

        } else if (range.length == TWO_NUM) {
            for (int i = Integer.parseInt(range[FIRST]) - 1; i < Integer.parseInt(range[SECOND]); i++) {
                toRemove.add(strList.get(i));
            }
            listOfGames.removeAll(toRemove);
        }

    }


}
