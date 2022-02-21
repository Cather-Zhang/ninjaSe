package ninjase.boundary;

import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import ninjase.model.Board;
import ninjase.model.Model;
import ninjase.model.Obstacle;

public class BoardPanel extends JPanel {
	Model model;
	static final int size = 75;
	static final int offset = 10;
	
	public BoardPanel (Model m) {
		this.model = m;
	}
	
	public Rectangle computeRect (Obstacle o) {
		int row = o.getRow();
		int col = o.getCol();
		Rectangle rect = new Rectangle (model.getBoard().getOffsety() + col*size + offset, model.getBoard().getOffsetx() + row*size, size - 2*offset, size - 2*offset);
		return rect;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (model == null) { return;}

		
		int ninjaPosRow = this.model.getPlayer().getRowPos() * size;
		int ninjaPosCol = this.model.getPlayer().getColPos() * size;
		
		File pic = new File ("src\\ninjaPic.png");
		Image ninja = null;
		try {
			ninja = ImageIO.read(pic);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(ninja, model.getBoard().getOffsety() + ninjaPosCol + offset + 5, 
				model.getBoard().getOffsetx() + ninjaPosRow + offset + 5, 
				size - offset - 10, size - offset - 10, null);
		g.drawRect(model.getBoard().getOffsety() + ninjaPosCol + offset, 
				model.getBoard().getOffsetx() + ninjaPosRow + offset, 
				size - offset, size - offset);
	
		Board board = model.getBoard();
		for (Obstacle o : board) {			
			switch(o.getType()) {
			case Yellow: 
				g.setColor(Color.yellow);
				break;
			case Red: 
				g.setColor(Color.red);
				break;
			case Green: 
				g.setColor(Color.green);
				break;
			case Cyan: 
				g.setColor(Color.cyan);
				break;
			case Blue: 
				g.setColor(Color.blue);
				break;
			default: 
				g.setColor(Color.magenta);
				break;
			}
			Rectangle s = computeRect(o);
			g.fillRect(s.x , s.y + offset, size - offset, size - offset);

		}		
		
		g.setColor(Color.black);
		for (int row = 0; row < model.getBoard().getRowNum(); row ++) {
			for (int col = 0; col < model.getBoard().getColNum(); col ++) {
				g.drawRect(model.getBoard().getOffsety() + col*size + offset, 
						model.getBoard().getOffsetx() + row*size + offset, 
						size - offset, size - offset);
			}
		}
	}
}
