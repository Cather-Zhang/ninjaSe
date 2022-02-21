package ninjase.model;

public class Obstacle {
	int rowPos;
	int colPos;
	boolean isRemoved;
	ObstacleType type;
	
	public Obstacle(ObstacleType type, int row, int col) {
		this.type = type;
		this.rowPos = row;
		this.colPos = col;
	}
	
	public ObstacleType getType() {return this.type;}
	
	public void setRow(int r) { this.rowPos = r;}
	public void setCol(int c) { this.colPos = c;}
	
	public int getRow() { return this.rowPos;}
	public int getCol() { return this.colPos;}
	
	public void move(MoveType dir) {
		switch (dir) {
		case Up:
			this.setRow(this.rowPos - 1);
			break;
		case Down:
			this.setRow(this.rowPos + 1);
			break;
		case Left:
			this.setCol(this.colPos - 1);
			break;
		case Right:
			this.setCol(this.colPos + 1);
			break;
		default: 			
		}
	}
}
