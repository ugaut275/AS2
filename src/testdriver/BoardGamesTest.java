package testdriver;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Board_Games;

public class BoardGamesTest {

    private Board_Games game;

    @Before
    public void setUp() {
        game = new Board_Games("1234", "Monopoly", "Hasbro", 19.99, 10, 8, 2, 6, "Hasbro");
    }

    @Test
    public void testSetAndGetMin() {
        game.setMin(3);
        assertEquals(3, game.getMin());
    }

    @Test
    public void testSetAndGetMax() {
        game.setMax(8);
        assertEquals(8, game.getMax());
    }

    @Test
    public void testSetAndGetDevelopers() {
        game.setDevelopers("Parker Brothers");
        assertEquals("Parker Brothers", game.getDevelopers());
    }

    @Test
    public void testGetRange() {
        assertEquals("2-6", game.getRange());
    }

    @Test
    public void testToString() {
        String expected = "Category: Board Games S_N: 1234 Name is Monopoly Brand is Hasbro Cost: 19.99 Stock: 10 Min Players 2";
        assertEquals(expected, game.toString());
    }

    @Test
    public void testFormat() {
        String expected = "1234;Monopoly;Hasbro;19.99;10;8;2-6;Hasbro";
        assertEquals(expected, game.format());
    }
}
