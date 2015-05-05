package test.SixesWild.contorller;


import java.awt.Component;
import java.awt.event.MouseEvent;

import sixesWild.view.SelectLevelView;
import junit.framework.TestCase;



public abstract class SWTestCase extends TestCase{	
	
	public MouseEvent createClicked (Component game) {
		MouseEvent me = new MouseEvent(game, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false);
		return me;
	}
	
	public MouseEvent createClicked (Component game, SelectLevelView view, int dx, int dy) {
		MouseEvent me = new MouseEvent(game, MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				view.getX()+dx, view.getY()+dy, 0, false);
		return me;
	}
	
}
