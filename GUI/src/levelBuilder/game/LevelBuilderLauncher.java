package levelBuilder.game;

import levelBuilder.entity.Model;
import levelBuilder.view.RequestScreen;
import levelBuilder.view.SplashScrn;

public class LevelBuilderLauncher {

	/** Launch GUI by installing window controller on exit. */ 
	public static void main (String args[]) {
		
		// create a model first
		//Model m = new Model();
		
		SplashScrn sixeswild = new SplashScrn();
		RequestScreen rs = new RequestScreen();
		
		// launch everything and go!
		rs.setVisible (true);
		
		//LevelBuilder lb = new LevelBuilder(m);
	}

}
