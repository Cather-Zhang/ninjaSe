package ninjase.controller;

import java.util.List;

import ninjase.boundary.NinjaSeApp;
import ninjase.boundary.UpdateButtons;
import ninjase.model.Model;
import ninjase.model.MoveType;

public class ResetController {
	NinjaSeApp app;
	Model model;
	
	public ResetController (Model model, NinjaSeApp app) {
		this.app = app;
		this.model = model;
	}
	
	public void reset(int level) {
		
		model.reset(level);
		List<MoveType> moves = model.availableMoves();
		UpdateButtons.enableMoveButtons(app, moves);
		UpdateButtons.enableLevelButtons(app);
		app.getActualMoves().setText("" + app.getModel().getNumMove());
		app.getWinMessage().setText("");
		app.repaint();
	}
}
