package ninjase.boundary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ninjase.model.Model;

class TestBoardPanel {

	@Test
	void testConstruction() {
		Model m = new Model(1);
		BoardPanel bp = new BoardPanel(m);
		assertEquals(bp.model.getBoard().getObstacles().size(), 2);
	}

}
