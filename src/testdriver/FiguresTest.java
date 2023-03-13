package testdriver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Figures;

public class FiguresTest {
    @Test
    public void testGetType() {
        Figures puzzle = new Figures("0123456789", "Castle Puzzle", "Ravensburger", 19.99, 10, 6, "Jigsaw");
        Assertions.assertEquals("Jigsaw", puzzle.getType());
    }

    @Test
    public void testSetType() {
        Figures puzzle = new Figures("0123456789", "Castle Puzzle", "Ravensburger", 19.99, 10, 6, "Jigsaw");
        puzzle.setType("3D Puzzle");
        Assertions.assertEquals("3D Puzzle", puzzle.getType());
    }

    @Test
    public void testToString() {
        Figures puzzle = new Figures("1234", "Castle Puzzle", "Ravensburger", 19.99, 10, 6, "Jigsaw");
        String expected = "Category: Figures S_N: 0123456789 Name is Castle Puzzle Brand is Ravensburger Cost: 19.99 Stock: 10 Age restriction 6 puzzle type Jigsaw";
        Assertions.assertEquals(expected, puzzle.toString());
    }

    @Test
    public void testFormat() {
        Figures puzzle = new Figures("1234", "Castle Puzzle", "Ravensburger", 19.99, 10, 6, "Jigsaw");
        String expected = "1234;Castle Puzzle;Ravensburger;19.99;10;6;Jigsaw";
        Assertions.assertEquals(expected, puzzle.format());
    }
}