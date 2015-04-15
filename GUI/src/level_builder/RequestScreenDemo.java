package level_builder;

import level_builder.RequestScreen;

public class RequestScreenDemo {
		
		/** Launch GUI by installing window controller on exit. */ 
		public static void main (String args[]) {
			RequestScreen rs = new RequestScreen();
			
			// launch everything and go!
			rs.setVisible (true);
		}
}
