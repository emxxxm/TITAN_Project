package levelBuilder.view;

import levelBuilder.entity.Model;
import levelBuilder.view.RequestScreen;

public class RequestScreenDemo {
		
		/** Launch GUI by installing window controller on exit. */ 
		public static void main (String args[]) {
			Model m = new Model();
			SplashScrn sixeswild = new SplashScrn();
			RequestScreen rs = new RequestScreen(m);
			
			// launch everything and go!
			rs.setVisible (true);
		}
}
