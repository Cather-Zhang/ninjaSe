package ninjase.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Model {
	int level;
	Ninja ninja;
	Board board;
	int numMove;
	
	public void setLevel(int l) {this.level = l;}
	public int getLevel () {return this.level;}
	public int getNumMove() {return this.numMove;}
	public Ninja getPlayer() {return ninja;}
	public void setBoard (Board b) { board = b;}
	public Board getBoard() { return board;}	
	
	public Model(int level) {
		this.numMove = 0;
		switch (level) {
		case 1: // level 1, 5x4 with 3 pairs of obstacles		
			this.level = 1;
			ninja = new Ninja(1, 1);
			board = new Board(4, 5);
			L1BoardConfig();
			break;
		case 2: // level 2, 6x3 with 4 pairs of obstacles
			this.level = 2;
			ninja = new Ninja(0, 1);
			board = new Board(3, 7);
			L2BoardConfig();
			break;
		case 3: // level 3, 7x4 with 6 pairs of obstacles
			this.level = 3;
			ninja = new Ninja(6, 6);
			board = new Board(7, 7);
			L3BoardConfig();
			break;
		default: board = null;
		}
		this.setBoard(board);
	}
	
	public void reset(int level) {
		for (Iterator<Obstacle> obs =  this.board.iterator(); 
				obs.hasNext();) {
			obs.next();
			obs.remove();
		}
		
		this.numMove = 0;
		
		switch (level) {
		case 1: 
			this.level = 1;
			this.ninja.setRow(1);
			this.ninja.setCol(1);
			this.board.setBound(4, 5);
			L1BoardConfig();
			break;
			
		case 2: 
			this.level = 2;
			this.board.setBound(3, 7);
			this.ninja.setRow(0);
			this.ninja.setCol(1);
			L2BoardConfig();
			break;
			
		case 3: 
			this.level = 3;
			this.board.setBound(7, 7);
			this.ninja.setRow(6);
			this.ninja.setCol(6);
			L3BoardConfig();
			break;
		default: 
		}
	}

	public boolean tryMove(MoveType dir) {
		for (MoveType move: availableMoves()) {
			if(dir == move) {
				PlayerMove(dir);
				this.numMove ++;
				return true;
			}
		}
		return true;
	}
	
	public void PlayerMove(MoveType dir) {
		if (this.canMove(dir))
			this.ninja.move(dir);
		else if (this.canPush(dir))
			this.pushObs(dir);
		else if (this.canRemove(dir))
			this.removeObs(dir);
	}
	
	public boolean isWinGame() {
		if (this.board.getObstacles().isEmpty())
			return true;
		else return false;
	}
	
	public List<MoveType> availableMoves() {
		ArrayList<MoveType> moves = new ArrayList<>();
		
		if (this.canMove(MoveType.Up))
			moves.add(MoveType.Up);
		else if (this.canPush(MoveType.Up))
			moves.add(MoveType.Up);
		else if (this.canRemove(MoveType.Up))
			moves.add(MoveType.Up);
			
		if (this.canMove(MoveType.Down))
			moves.add(MoveType.Down);
		else if (this.canPush(MoveType.Down))
			moves.add(MoveType.Down);
		else if (this.canRemove(MoveType.Down))
			moves.add(MoveType.Down);
		
		
		if (this.canMove(MoveType.Left))
			moves.add(MoveType.Left);
		else if (this.canPush(MoveType.Left))
			moves.add(MoveType.Left);
		else if (this.canRemove(MoveType.Left))
			moves.add(MoveType.Left);
		
		if (this.canMove(MoveType.Right))
			moves.add(MoveType.Right);
		else if (this.canPush(MoveType.Right))
			moves.add(MoveType.Right);
		else if (this.canRemove(MoveType.Right))
			moves.add(MoveType.Right);
		
		return moves;
}

	public boolean canMove(MoveType dir) {
		int row = ninja.rowPos;
		int col = ninja.colPos;
		
		switch (dir) {	
		case Up: 
			return (board.isOccupied(row - 1, col) == false && (row != 0));
		case Down:
			return (board.isOccupied(row + 1, col) == false && (row < (board.numRow - 1)));
		case Left:
			return (board.isOccupied(row, col - 1) == false && (col != 0));
		case Right:
			return (board.isOccupied(row, col + 1) == false && (col < (board.numCol - 1)));
		default: 
			return false;
		}
	}
	
	public boolean canPush(MoveType dir) {
		int row = ninja.rowPos;
		int col = ninja.colPos;
		
		switch (dir) {	
		case Up: 
			return ((board.isOccupied(row - 1, col) 
					&& (row - 2) >= 0 && board.isOccupied(row - 2, col) == false));
		case Down:
			return ((board.isOccupied(row + 1, col)
					&& (row + 2) < (board.numRow) && board.isOccupied(row + 2, col) == false));
		case Left:
			return ((board.isOccupied(row, col - 1)
					&& (col - 2) >= 0 && board.isOccupied(row, col - 2) == false));
		case Right:
			return ((board.isOccupied(row, col + 1) 
					&& (col + 2) < (board.numCol) && board.isOccupied(row, col + 2) == false));
		default: 
			return false;
		}
	}
	
	public boolean canRemove(MoveType dir) {
		int row = ninja.rowPos;
		int col = ninja.colPos;
		
		switch (dir) {	
		case Up: 
			return (board.isOccupied(row - 2, col) 
					&& (board.getObstacle(row - 2, col).type 
							== board.getObstacle(row - 1, col).type));
		case Down:
			return (board.isOccupied(row + 2, col) 
					&& (board.getObstacle(row + 2, col).type 
							== board.getObstacle(row + 1, col).type));
		case Left:
			return (board.isOccupied(row, col - 2) 
					&& (board.getObstacle(row, col - 2).type 
							== board.getObstacle(row, col - 1).type));
		case Right:
			return (board.isOccupied(row, col + 2) 
					&& (board.getObstacle(row, col + 2).type 
							== board.getObstacle(row, col + 1).type));
		default: 
			return false;
		}
	}

	public void pushObs(MoveType dir) {
		int row = ninja.rowPos;
		int col = ninja.colPos;
		
		switch (dir) {	
		case Up: 
			ninja.setRow(row - 1);
			this.board.getObstacle(row - 1, col).move(MoveType.Up);
			break;

		case Down:
			ninja.setRow(row + 1);
			this.board.getObstacle(row + 1, col).move(MoveType.Down);
			break;
			
		case Left:
			ninja.setCol(col - 1);
			this.board.getObstacle(row, col - 1).move(MoveType.Left);
			break;
			
		case Right:
			ninja.setCol(col + 1);
			this.board.getObstacle(row, col + 1).move(MoveType.Right);
			break;
			
		default: 
		}
	}
	
	public void removeObs(MoveType dir) {
		int row = ninja.rowPos;
		int col = ninja.colPos;
		ObstacleType type;
		switch (dir) {	
		case Up: 
			ninja = ninja.move(MoveType.Up);
			type = this.board.getObstacle(row - 1, col).type;
			this.board.removeObstacleFromList(type);
			break;

		case Down:
			ninja = ninja.move(MoveType.Down);
			type = this.board.getObstacle(row + 1, col).type;
			this.board.removeObstacleFromList(type);
			break;
			
		case Left:
			ninja = ninja.move(MoveType.Left);
			type = this.board.getObstacle(row, col - 1).type;
			this.board.removeObstacleFromList(type);
			break;
			
		case Right:
			ninja = ninja.move(MoveType.Right);
			type = this.board.getObstacle(row, col + 1).type;
			this.board.removeObstacleFromList(type);
			break;
			
		default: 
		}
		
	}

	public void L1BoardConfig() {
		board.setOffsety(110);
		board.setOffsetx(120);
		board.add(new Obstacle(ObstacleType.Yellow, 0, 3));
		board.add(new Obstacle(ObstacleType.Yellow, 2, 2));
	}
	
	public void L2BoardConfig() {
		board.setOffsety(45);
		board.setOffsetx(130);
		board.add(new Obstacle(ObstacleType.Blue, 1, 1));
		board.add(new Obstacle(ObstacleType.Blue, 2, 6));
		board.add(new Obstacle(ObstacleType.Yellow, 0, 2));
		board.add(new Obstacle(ObstacleType.Yellow, 1, 3));
		board.add(new Obstacle(ObstacleType.Green, 0, 6));
		board.add(new Obstacle(ObstacleType.Green, 1, 6));
		board.add(new Obstacle(ObstacleType.Red, 1, 0));
		board.add(new Obstacle(ObstacleType.Red, 1, 2));
	}
	
	public void L3BoardConfig() {
		board.setOffsety(45);
		board.setOffsetx(0);
		board.add(new Obstacle(ObstacleType.Blue, 4, 1));
		board.add(new Obstacle(ObstacleType.Blue, 5, 5));
		board.add(new Obstacle(ObstacleType.Yellow, 3, 1));
		board.add(new Obstacle(ObstacleType.Yellow, 5, 4));
		board.add(new Obstacle(ObstacleType.Green, 6, 5));
		board.add(new Obstacle(ObstacleType.Green, 2, 2));
		board.add(new Obstacle(ObstacleType.Red, 3, 2));
		board.add(new Obstacle(ObstacleType.Red, 5, 6));
		board.add(new Obstacle(ObstacleType.Cyan, 2, 1));
		board.add(new Obstacle(ObstacleType.Cyan, 3, 3));
		board.add(new Obstacle(ObstacleType.Magenta, 3, 0));
		board.add(new Obstacle(ObstacleType.Magenta, 1, 5));
	}
}

