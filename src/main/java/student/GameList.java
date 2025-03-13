package student;

import java.io.FileWriter;
import java.util.*;
//import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameList implements IGameList {
    /** A list of board games */
    private Set<String> listOfGames;

    /**
     * Constructor for the GameList.
     */
    public GameList() {
        //throw new UnsupportedOperationException("Unimplemented constructor 'GameList'");
        listOfGames = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    }

    @Override
    public List<String> getGameNames() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getGameNames'");
        //return listOfGames.stream().collect(Collectors.toList());
        List<String> listVersionOfGames = List.copyOf(listOfGames);
        return listVersionOfGames;
    }

    @Override
    public void clear() {
        //throw new UnsupportedOperationException("Unimplemented method 'clear'");
        this.listOfGames.clear();
    }

    @Override
    public int count() {
        //throw new UnsupportedOperationException("Unimplemented method 'count'");
        return listOfGames.size();
    }

    @Override
    public void saveGame(String filename) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'saveGame'");
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

    @Override
    public void addToList(String str, Stream<BoardGame> filtered) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'addToList'");
        //listOfGames HashSet, str op, Stream<BoardGame> filtered
        //subtract one if single
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

        String[] range = str.split("-");
        if (range.length == 1) {
            BoardGame toAdd = filteredList.get(Integer.parseInt(range[0]));
            listOfGames.add(toAdd.getName());
        } else if (range.length == 2) {

            for (int i = Integer.parseInt(range[0]); i < Integer.parseInt(range[1]) + 1; i++) {
                listOfGames.add(filteredList.get(i).getName());
            }
        }

        //BoardGame toAdd = filteredList.get(Integer.parseInt(str));
        //listOfGames.add(toAdd.getName());
    }

    @Override
    public void removeFromList(String str) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'removeFromList'");

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

        String[] range = str.split("-");
        if (range.length == 1) {
            int index = Integer.parseInt(range[0]) - 1;
            String strToRemove = strList.get(index);
            listOfGames.remove(strToRemove);

        } else if (range.length == 2) {
            for (int i = Integer.parseInt(range[0]) - 1; i < Integer.parseInt(range[1]); i++) {
                toRemove.add(strList.get(i));
            }
            listOfGames.removeAll(toRemove);
        }

    }


}
