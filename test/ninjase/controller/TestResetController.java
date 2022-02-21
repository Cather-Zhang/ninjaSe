package ninjase.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ninjase.boundary.NinjaSeApp;
import ninjase.model.Model;

class TestResetController {

	@Test
	void testReset() {
		Model m = new Model(3);
		NinjaSeApp app = new NinjaSeApp(m);
		ResetController rc = new ResetController(m, app);
		assertEquals(rc.app.getUpButton().isEnabled(), true);
		assertEquals(rc.app.getDownButton().isEnabled(), false);
		assertEquals(rc.app.getLeftButton().isEnabled(), true);
		assertEquals(rc.app.getRightButton().isEnabled(), false);
		rc.reset(2);
		assertEquals(rc.app.getUpButton().isEnabled(), false);
		assertEquals(rc.app.getDownButton().isEnabled(), true);
		assertEquals(rc.app.getLeftButton().isEnabled(), true);
		assertEquals(rc.app.getRightButton().isEnabled(), true);
	}

}
