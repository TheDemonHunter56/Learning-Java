package TicTacToe.TheSciGuidesWay.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import TicTacToe.TheSciGuidesWay.Board;

public class BoardTest {
    @Test
public void playerToString() {
    assertEquals("X", Board.playerToString(1));
    assertEquals("O", Board.playerToString(-1));
    assertEquals("-", Board.playerToString(0));
    assertThrows(RuntimeException.class, () -> Board.playerToString(2));
}
@Test
public void boardToString() {
	assertEquals("- - - \n- - - \n- - - \n", new Board().toString());
	Board b = new Board();
	b.move(1, 1, 1);
	assertEquals("- - - \n- X - \n- - - \n", b.toString());
	b = new Board();
	b.move(-1, 1, 1);
	assertEquals("- - - \n- O - \n- - - \n", b.toString());
}

@Test
public void testMove() {
	Board b = new Board();
	b.move(1, 2, 0);
	assertEquals(1, b.get(2, 0));
	b.move(-1, 1, 1);
	assertEquals(-1, b.get(1, 1));
	// check that you can't play in a space that's full already
	assertThrows(RuntimeException.class, () -> b.move(-1, 2, 0));
	// check that you can't give an int other than 1 or -1 as player
	assertThrows(RuntimeException.class, () -> b.move(0, 2, 2));
}
}
