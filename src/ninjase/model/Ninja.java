package ninjase.model;


public class Ninja {
	int rowPos;
	int colPos;
	
	public Ninja(int r, int c) {
		this.rowPos = r;
		this.colPos = c;
	}
	
	public void setRow (int r) {this.rowPos = r;}
	public void setCol (int c) {this.colPos = c;}
	
	public int getRowPos () { return this.rowPos;}
	public int getColPos () { return this.colPos;}
	
	public Ninja move(MoveType dir) {
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
		return this;
	}
}
