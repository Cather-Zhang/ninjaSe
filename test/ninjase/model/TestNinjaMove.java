package ninjase.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestNinjaMove {

	@Test
	void testConstruction() {
		Ninja n = new Ninja(3,1);
		assertEquals(n.rowPos, 3);
		assertEquals(n.colPos, 1);
	}
	
	@Test
	void testGetPos() {
		Ninja n = new Ninja(3,1);
		assertEquals(n.getColPos(), 1);
		assertEquals(n.getRowPos(), 3);
	}
	
	
	@Test
	void testSetPos() {
		Ninja n = new Ninja(0,0);
		n.setCol(3);
		n.setRow(4);
		assertEquals(n.rowPos, 4);
		assertEquals(n.colPos, 3);
	}
	
	@Test
	void testMoveLeft() {
		Ninja n = new Ninja(2,3);
		n.move(MoveType.Left);
		assertEquals(n.rowPos, 2);
		assertEquals(n.colPos, 2);
	}

	@Test
	void testMoveRight() {
		Ninja n = new Ninja(2,3);
		n.move(MoveType.Right);
		assertEquals(n.rowPos, 2);
		assertEquals(n.colPos, 4);
	}
	
	@Test
	void testMoveUp() {
		Ninja n = new Ninja(2,3);
		n.move(MoveType.Up);
		assertEquals(n.rowPos, 1);
		assertEquals(n.colPos, 3);
	}
	
	@Test
	void testMoveDown() {
		Ninja n = new Ninja(2,3);
		n.move(MoveType.Down);
		assertEquals(n.rowPos, 3);
		assertEquals(n.colPos, 3);
	}
	
}
