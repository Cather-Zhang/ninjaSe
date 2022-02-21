package ninjase.boundary;

import java.util.List;

import ninjase.model.MoveType;

public class UpdateButtons {
	public static void enableMoveButtons(NinjaSeApp app, List<MoveType> moves) {
		app.getUpButton().setEnabled(false);
		app.getDownButton().setEnabled(false);
		app.getLeftButton().setEnabled(false);
		app.getRightButton().setEnabled(false);
		
		for(MoveType mt: moves) {
			if (mt == MoveType.Up) 
				app.getUpButton().setEnabled(true);
			else if (mt == MoveType.Down) 
				app.getDownButton().setEnabled(true);
			else if (mt == MoveType.Left) 
				app.getLeftButton().setEnabled(true);
			else if (mt == MoveType.Right) 
				app.getRightButton().setEnabled(true);
		}
	}
	
	public static void enableLevelButtons(NinjaSeApp app) {
		app.getL1Button().setEnabled(true);
		app.getL2Button().setEnabled(true);
		app.getL3Button().setEnabled(true);
		
		switch (app.getModel().getLevel()) {
		case 1: 
			app.getL1Button().setEnabled(false);
			break;
		case 2: 
			app.getL2Button().setEnabled(false);
			break;
		case 3:
			app.getL3Button().setEnabled(false);
			break;
		}
	}
	
	public static void disableMoveBtn(NinjaSeApp app) {
		app.getUpButton().setEnabled(false);
		app.getDownButton().setEnabled(false);
		app.getLeftButton().setEnabled(false);
		app.getRightButton().setEnabled(false);
	}
}
