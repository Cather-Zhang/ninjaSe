package ninjase;

import ninjase.boundary.NinjaSeApp;
import ninjase.model.Model;

public class Main {
	public static void main(String[] args) {
		NinjaSeApp app = new NinjaSeApp(new Model(1));
		app.setVisible(true);
	}
}
