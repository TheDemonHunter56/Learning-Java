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
@Test
public void testWinner() {
	Board b1 = new Board();
	b1.move(1, 0, 1);
	b1.move(-1, 1, 1);
	b1.move(1, 2, 1);
	assertEquals(0, b1.winner());
	
	b1.move(1, 0, 0);
	b1.move(1, 0, 2);
	assertEquals(1, b1.winner());
	
	Board b2 = new Board();
	b2.move(-1, 0, 0);
	b2.move(-1, 1, 1);
	b2.move(-1, 2, 2);
	assertEquals(-1, b2.winner());

	Board b3 = new Board();
	b3.move(1, 1, 1);
	b3.move(1, 0, 2);
	b3.move(1, 1, 2);
	b3.move(1, 2, 2);
	assertEquals(1, b3.winner());
}
@Test
public void testOver() {
	Board bWon = new Board();
	bWon.move(1, 0, 2);
	bWon.move(1, 1, 1);
	assertFalse(bWon.over());
	bWon.move(1, 2, 0);
	assertTrue(bWon.over());

	Board bFull = new Board();
	for (int r = 0; r < 3; r++) {
		int firstSpace = (r % 2) * 2 - 1;
		for (int c = 0; c < 3; c++) {
			int mult = c / 2 * 2 - 1;
			bFull.move(firstSpace * mult, r, c);
		}
	}
	assertTrue(bFull.over());
}
}
