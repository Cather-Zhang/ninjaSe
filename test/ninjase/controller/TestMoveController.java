package ninjase.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ninjase.boundary.NinjaSeApp;
import ninjase.model.Model;
import ninjase.model.MoveType;
import ninjase.model.ObstacleType;

class TestMoveController {

	@Test
	void testReset() {
		Model m = new Model(2);
		NinjaSeApp app = new NinjaSeApp(m);
		MoveController mc = new MoveController(m, app);
		assertEquals(mc.app.getUpButton().isEnabled(), false);
		assertEquals(mc.app.getDownButton().isEnabled(), true);
		assertEquals(mc.app.getLeftButton().isEnabled(), true);
		assertEquals(mc.app.getRightButton().isEnabled(), true);
		mc.move(MoveType.Down);
		assertEquals(mc.app.getUpButton().isEnabled(), true);
		assertEquals(mc.app.getDownButton().isEnabled(), false);
		assertEquals(mc.app.getLeftButton().isEnabled(), false);
		assertEquals(mc.app.getRightButton().isEnabled(), false);
	}
	
	@Test
	void testWin() {
		Model m = new Model(2);
		NinjaSeApp app = new NinjaSeApp(m);
		MoveController mc = new MoveController(m, app);
		m.getBoard().removeObstacleFromList(ObstacleType.Red);
		m.getBoard().removeObstacleFromList(ObstacleType.Blue);
		m.getBoard().removeObstacleFromList(ObstacleType.Yellow);
		m.getPlayer().setRow(2);
		m.getPlayer().setCol(6);
		mc.move(MoveType.Up);
		assertEquals(mc.app.getUpButton().isEnabled(), false);
		assertEquals(mc.app.getDownButton().isEnabled(), false);
		assertEquals(mc.app.getLeftButton().isEnabled(), false);
		assertEquals(mc.app.getRightButton().isEnabled(), false);
		}


}
