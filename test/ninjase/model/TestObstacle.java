package ninjase.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestObstacle {

	@Test
	void testConstruction() {
		Obstacle o = new Obstacle(ObstacleType.Red, 1,2);
		assertEquals(ObstacleType.Red, o.type);
		assertEquals(1, o.rowPos);
		assertEquals(2, o.colPos);
	}
	

	
	@Test
	void testSetPos() {
		Obstacle o = new Obstacle(ObstacleType.Red, 1,2);
		o.setRow(5);
		o.setCol(6);
		assertEquals(5, o.rowPos);
		assertEquals(6, o.colPos);
	}

	@Test
	void testGetPos() {
		Obstacle o = new Obstacle(ObstacleType.Blue, 2,3);
		assertEquals(2, o.getRow());
		assertEquals(3, o.getCol());
	}
	
	@Test
	void testMoveLeft() {
		Obstacle o = new Obstacle(ObstacleType.Blue, 2,3);
		o.move(MoveType.Left);
		assertEquals(o.rowPos, 2);
		assertEquals(o.colPos, 2);
	}

	@Test
	void testMoveRight() {
		Obstacle o = new Obstacle(ObstacleType.Blue,2,3);
		o.move(MoveType.Right);
		assertEquals(o.rowPos, 2);
		assertEquals(o.colPos, 4);
	}
	
	@Test
	void testMoveUp() {
		Obstacle o = new Obstacle(ObstacleType.Blue,2,3);
		o.move(MoveType.Up);
		assertEquals(o.rowPos, 1);
		assertEquals(o.colPos, 3);
	}
	
	@Test
	void testMoveDown() {
		Obstacle o = new Obstacle(ObstacleType.Blue,2,3);
		o.move(MoveType.Down);
		assertEquals(o.rowPos, 3);
		assertEquals(o.colPos, 3);
	}
}
