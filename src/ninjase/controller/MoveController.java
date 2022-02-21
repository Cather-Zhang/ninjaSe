package ninjase.controller;

import java.util.List;

import ninjase.boundary.NinjaSeApp;
import ninjase.boundary.UpdateButtons;
import ninjase.model.Model;
import ninjase.model.MoveType;

public class MoveController {
	Model model;
	NinjaSeApp app;
	
	public MoveController (Model m, NinjaSeApp app) {
		this.model = m;
		this.app = app;
	}
	
	public boolean move(MoveType dir) {
		List<MoveType> moves = model.availableMoves();
		UpdateButtons.enableMoveButtons(app, moves);
		if(model.tryMove(dir)) {
			UpdateButtons.enableMoveButtons(app, model.availableMoves());
			app.getActualMoves().setText("" + app.getModel().getNumMove());
			if (model.isWinGame()) {
				app.getWinMessage().setText("Ninja-Se escaped successfully!");
				UpdateButtons.disableMoveBtn(app);
			}
			
			app.repaint();
		}	
		return true;
	}
}
