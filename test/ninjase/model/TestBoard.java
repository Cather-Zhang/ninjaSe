package ninjase.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBoard {

	@Test
	void testConstruction() {
		Board b = new Board(4,2);
		assertEquals(2, b.numCol);
		assertEquals(4, b.numRow);
	}

	@Test
	void testAddObstacle() {
		Board b = new Board(4,2);
		b.add(new Obstacle(ObstacleType.Blue, 2,1));
		b.add(new Obstacle(ObstacleType.Red, 2,4));
		assertEquals(b.obstacles.get(0).colPos, 1);
		assertEquals(b.obstacles.get(1).colPos, 4);
	}
	
	@Test
	void testGetObstacles() {
		Board b = new Board(4,2);
		b.add(new Obstacle(ObstacleType.Blue, 2,1));
		b.add(new Obstacle(ObstacleType.Red, 2,4));
		assertEquals(b.getObstacles().get(0).colPos, 1);
		assertEquals(b.getObstacles().get(1).colPos, 4);
	}
	
	@Test
	void testIsOccupied() {
		Board b = new Board(4,2);
		b.add(new Obstacle(ObstacleType.Blue, 2,1));
		b.add(new Obstacle(ObstacleType.Blue, 3,2));
		b.add(new Obstacle(ObstacleType.Red, 4,1));
		b.add(new Obstacle(ObstacleType.Red, 0,0));
		
		assertTrue(b.isOccupied(2, 1));
		assertTrue(b.isOccupied(3, 2));
		assertFalse(b.isOccupied(0, 1));
	}
}
