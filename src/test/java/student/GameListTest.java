package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.util.HashSet;



class GameListTest {

    private HashSet<BoardGame> games;

    @BeforeEach
    void setUp() {
        games = new HashSet<>();
        //add a bunch of games
    }

    @Test
    void getGameNames() {
    }

    @Test
    void clear() {
    }

    @Test
    void count() {
    }

    @Test
    void saveGame() {
    }

    @Test
    void testAddSingleGameToListByIndex() {
        IGameList list1 = new GameList();
        list1.addToList("1", games.stream());
        assertEquals(1, list1.count());
        //System.out.println(list1.getGameNames());
    }

    @Test
    void testAddRangeOfGamesToList() {
        IGameList list1 = new GameList();
        list1.addToList("1-3", games.stream());
    }
    @Test
    void removeFromList() {
    }
}