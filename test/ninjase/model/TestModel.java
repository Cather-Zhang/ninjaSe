package ninjase.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TestModel {


	@Test
	void testSetPlayer() {
		Model m = new Model(1);
		m.ninja.setRow(2);
		m.ninja.setCol(1);
		assertEquals(m.ninja.colPos, 1);
	}
	
	@Test 
	void testSetBoard() {
		Model m = new Model(1);
		Board b = new Board (4,5);
		m.setBoard(b);
		assertEquals(m.board.numRow, 4);
	}
	
	@Test
	void testGetPlayer() {
		Model m = new Model(1);
		m.ninja.setRow(2);
		m.ninja.setCol(1);
		assertEquals(m.getPlayer().colPos, 1);
	}

	@Test 
	void testGetBoard() {
		Model m = new Model(1);
		Board b = new Board (4,5);
		m.setBoard(b);
		assertEquals(m.getBoard().numRow, 4);
	}
	
	
	
	@Test
	void testInitLevelOne() {
		Model m = new Model(1);
		assertEquals(m.board.obstacles.size(), 2);
	}
	
	@Test
	void testInitLevelTwo() {
		Model m = new Model(2);
		assertEquals(m.board.obstacles.size(), 8);
	}
	
	@Test
	void testInitLevelThree() {
		Model m = new Model(3);

		assertEquals(m.board.obstacles.size(), 12);
	}
	
	@Test 
	void testGetAvailableMovesL3One() {
		Model m = new Model(3);
		List<MoveType> moves = m.availableMoves();
		assertEquals(moves.size(), 2);
	}
	
	@Test
	void testGetAvailableMovesL3Two() {
		Model m = new Model(3);
		m.ninja.setRow(2);
		m.ninja.setCol(6);
		List<MoveType> moves = m.availableMoves();
		assertEquals(moves.size(), 3);
		assertEquals(moves.get(0), MoveType.Up);
	}
	
	@Test
	void testGetAvailableMovesL3Three() {
		Model m = new Model(3);
		m.ninja.setRow(2);
		m.ninja.setCol(0);
		List<MoveType> moves = m.availableMoves();
		assertEquals(moves.size(), 2);
		assertEquals(moves.get(1), MoveType.Down);
	}
	
	@Test
	void testGetAvailableMovesL3Four() {
		Model m = new Model(3);
		m.ninja.setRow(3);
		m.ninja.setCol(4);
		List<MoveType> moves = m.availableMoves();
	
		assertEquals(moves.size(), 3);
		assertEquals(moves.get(2), MoveType.Right);
	}
	
	@Test
	void testGetAvailableMovesL1One() {
		Model m = new Model(1);
		List<MoveType> moves = m.availableMoves();
		assertEquals(moves.size(), 4);
	}
	
	@Test
	void testGetAvailableMovesL1Two() {
		Model m = new Model(1);
		m.ninja.setRow(3);
		m.ninja.setCol(4);
		List<MoveType> moves = m.availableMoves();
		assertEquals(moves.size(), 2);
		assertEquals(moves.get(1), MoveType.Left);
	}
	
	@Test
	void testGetAvailableMovesL1Three() {
		Model m = new Model(1);
		m.ninja.setRow(2);
		m.ninja.setCol(0);
		List<MoveType> moves = m.availableMoves();
		assertEquals(moves.size(), 3);
		assertEquals(moves.get(0), MoveType.Up);
	}
	
	@Test
	void testGetAvailableMovesL1Four() {
		Model m = new Model(1);
		m.ninja.setRow(2);
		m.ninja.setCol(2);
		List<MoveType> moves = m.availableMoves();
		assertEquals(moves.size(), 4);
	}
	
	
	@Test
	void testGetAvailableMovesL2Two() {
		Model m = new Model(2);
		m.ninja.setRow(2);
		m.ninja.setCol(5);
		List<MoveType> moves = m.availableMoves();
		assertEquals(moves.size(), 2);
		assertEquals(moves.get(0), MoveType.Up);
	}
	
	@Test
	void testGetAvailableMovesL2Three() {
		Model m = new Model(2);
		m.ninja.setRow(0);
		m.ninja.setCol(1);
		List<MoveType> moves = m.availableMoves();
		assertEquals(moves.size(), 3);
	}
	
	
	@Test 
	void testGetAvailableMoveRemove() {
		Model m = new Model(1);
		Board b = new Board (4,5);
		b.add(new Obstacle(ObstacleType.Yellow, 1, 2));
		b.add(new Obstacle(ObstacleType.Yellow, 2, 2));
		b.add(new Obstacle(ObstacleType.Blue, 0, 0));
		b.add(new Obstacle(ObstacleType.Blue, 0, 1));
		b.add(new Obstacle(ObstacleType.Green, 0, 3));
		b.add(new Obstacle(ObstacleType.Green, 0, 4));
		m.setBoard(b);
		m.ninja.setRow(0);
		m.ninja.setCol(2);
		List<MoveType> moves = m.availableMoves();
		assertEquals(moves.size(), 3);
		assertEquals(moves.get(0), MoveType.Down);
	}
	
	@Test 
	void testDefault() {
		Model m = new Model(0);
		assertEquals(m.getBoard(), null);	
	}
	
	@Test
	void testPushRight() {
		Model m = new Model(1);
		m.ninja.setRow(2);
		m.ninja.setCol(1);
		assertEquals(m.board.getObstacle(2, 3), null);
		m.PlayerMove(MoveType.Right);
		assertEquals(m.ninja.getRowPos(), 2);
		assertEquals(m.ninja.getColPos(), 2);
		assertEquals(m.board.getObstacle(2, 2), null);
		assertEquals(m.board.getObstacle(2, 3).type, ObstacleType.Yellow);
	}
	
	@Test
	void testPushLeft() {
		Model m = new Model(1);
		m.ninja.setRow(2);
		m.ninja.setCol(3);
		assertEquals(m.board.getObstacle(2, 1), null);
		m.PlayerMove(MoveType.Left);
		assertEquals(m.ninja.getRowPos(), 2);
		assertEquals(m.ninja.getColPos(), 2);
		assertEquals(m.board.getObstacle(2, 2), null);
		assertEquals(m.board.getObstacle(2, 1).type, ObstacleType.Yellow);
	}
	
	@Test
	void testPushDown() {
		Model m1 = new Model(1);
		m1.ninja.setRow(1);
		m1.ninja.setCol(2);
		assertEquals(m1.board.getObstacle(3, 2), null);
		m1.PlayerMove(MoveType.Down);
		assertEquals(m1.ninja.getRowPos(), 2);
		assertEquals(m1.ninja.getColPos(), 2);
		assertEquals(m1.board.getObstacle(2, 2), null);
		assertEquals(m1.board.getObstacle(3, 2).type, ObstacleType.Yellow);
	}
	
	@Test
	void testPushUp() {
		Model m1 = new Model(1);
		m1.ninja.setRow(3);
		m1.ninja.setCol(2);
		assertEquals(m1.board.getObstacle(1, 2), null);
		m1.PlayerMove(MoveType.Up);
		assertEquals(m1.ninja.getRowPos(), 2);
		assertEquals(m1.ninja.getColPos(), 2);
		assertEquals(m1.board.getObstacle(2, 2), null);
		assertEquals(m1.board.getObstacle(1, 2).type, ObstacleType.Yellow);
	}
	
	@Test 
	void testRemoveUp() {
		Model m1 = new Model(1);
		Board b = new Board (4,5);
		b.add(new Obstacle(ObstacleType.Yellow, 0, 3));
		b.add(new Obstacle(ObstacleType.Green, 0, 4));
		b.add(new Obstacle(ObstacleType.Blue, 1, 0));
		b.add(new Obstacle(ObstacleType.Blue, 2, 0));
		m1.ninja.setRow(3);
		m1.ninja.setCol(0);
		m1.setBoard(b);
		assertEquals(m1.board.obstacles.size(), 4);
		m1.PlayerMove(MoveType.Up);
		System.out.println(m1.board.obstacles.size());
		assertEquals(m1.ninja.rowPos, 2);
		assertEquals(m1.board.obstacles.size(), 2);
	}
	
	@Test 
	void testRemoveDown() {
		Model m1 = new Model(1);
		Board b = new Board (4,5);
		b.add(new Obstacle(ObstacleType.Yellow, 0, 3));
		b.add(new Obstacle(ObstacleType.Green, 0, 4));
		b.add(new Obstacle(ObstacleType.Blue, 1, 0));
		b.add(new Obstacle(ObstacleType.Blue, 2, 0));
		m1.setBoard(b);
		assertEquals(m1.board.obstacles.size(), 4);
		m1.ninja.setRow(0);
		m1.ninja.setCol(0);
		m1.PlayerMove(MoveType.Down);
		assertEquals(m1.board.obstacles.size(), 2);
		assertEquals(m1.ninja.rowPos, 1);
	}
	@Test 
	void testRemoveLeft() {
		Model m1 = new Model(1);
		Board b = new Board (4,5);
		b.add(new Obstacle(ObstacleType.Yellow, 3, 0));
		b.add(new Obstacle(ObstacleType.Green, 2, 0));
		b.add(new Obstacle(ObstacleType.Blue, 0, 2));
		b.add(new Obstacle(ObstacleType.Blue, 0, 1));
		m1.setBoard(b);
		assertEquals(m1.board.obstacles.size(), 4);
		m1.ninja.setRow(0);
		m1.ninja.setCol(3);
		m1.PlayerMove(MoveType.Left);
		assertEquals(m1.board.obstacles.size(), 2);
		assertEquals(m1.ninja.colPos, 2);
	}
	@Test 
	void testRemoveRight() {
		Model m1 = new Model(1);
		Board b = new Board (4,5);		
		b.add(new Obstacle(ObstacleType.Yellow, 3, 0));
		b.add(new Obstacle(ObstacleType.Green, 2, 0));
		b.add(new Obstacle(ObstacleType.Blue, 0, 2));
		b.add(new Obstacle(ObstacleType.Blue, 0, 1));
		m1.setBoard(b);
		assertEquals(m1.board.obstacles.size(), 4);
		m1.ninja.setRow(0);
		m1.ninja.setCol(0);
		m1.PlayerMove(MoveType.Right);
		assertEquals(m1.board.obstacles.size(), 2);
		assertEquals(m1.ninja.colPos, 1);
	}
	
	
	@Test
	void testWin() {
		Model m = new Model(1);
		assertFalse(m.isWinGame());
	}
}
