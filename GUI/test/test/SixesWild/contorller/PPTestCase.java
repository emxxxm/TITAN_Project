package test.SixesWild.contorller;

import java.awt.Component;
import java.awt.event.MouseEvent;

import sixesWild.model.Board;
import sixesWild.view.PlayPanel;
import sixesWild.view.SelectLevelView;

public class PPTestCase {
//	public MouseEvent createClicked (Board Board, PlayPanel view, int dx, int dy) {
//		MouseEvent me = new MouseEvent(Board, MouseEvent.MOUSE_PRESSED, 
//				System.currentTimeMillis(), 0, 
//				view.getX()+dx, view.getY()+dy, 0, false);
//		return me;
//	}
	public MouseEvent createClicked (Component game) {
	MouseEvent me = new MouseEvent(game, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false);
	return me;
	}
}
