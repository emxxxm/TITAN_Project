package levelBuilder.view;

import levelBuilder.view.RequestScreen;

public class RequestScreenDemo {
		
		/** Launch GUI by installing window controller on exit. */ 
		public static void main (String args[]) {
			SplashScrn sixeswild = new SplashScrn();
			RequestScreen rs = new RequestScreen();
			
			// launch everything and go!
			rs.setVisible (true);
		}
}
