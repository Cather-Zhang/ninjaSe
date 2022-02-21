package ninjase.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Board implements Iterable<Obstacle>{
	ArrayList<Obstacle> obstacles = new ArrayList<>();
	int numRow;
	int numCol;
	int offsety;
	int offsetx;
	
	public Board(int numRows, int numCols) {
		this.numRow = numRows;
		this.numCol = numCols;
	}

	public void setBound(int r, int c) {
		this.numRow = r;
		this.numCol = c;
	}
	
	public void setOffsety(int offset) {this.offsety = offset;}
	public int getOffsety() {return this.offsety;}
	public void setOffsetx(int offset) {this.offsetx = offset;}
	public int getOffsetx() {return this.offsetx;}
	public void add(Obstacle o) {obstacles.add(o);}
	public int getRowNum() {return this.numRow;}
	public int getColNum() {return this.numCol;}
	public ArrayList<Obstacle> getObstacles() {return obstacles;}
	
	public Obstacle getObstacle(int r, int c) {
		for (Obstacle o: obstacles) {
			if (o.getRow() == r && o.getCol() == c)
				return o;
		}
		return null;
	}
	
	public boolean isOccupied (int r, int c) {
		boolean occupied = false;

		for (Obstacle o : this) {
			if (o.rowPos == r && o.colPos==c) {
				occupied = true;
				return occupied;
			}
		}
		return occupied;
	}
	
	public void removeObstacleFromList(ObstacleType type) {
		for (int i = 0; i < obstacles.size(); i ++) {
			if (type == obstacles.get(i).type) {					
				this.obstacles.remove(i);
				this.obstacles.remove(i);
				break;
			}
		}
	}
	
	@Override
	public Iterator<Obstacle> iterator() {
		return obstacles.iterator();
	}
}
