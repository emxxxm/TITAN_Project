//package test.SixesWild.contorller;
//
//import java.awt.event.MouseEvent;
//
//import sixesWild.model.Board;
//import sixesWild.view.BoardView;
//
//public class BoardTestCase extends TestCase {
//	public MouseEvent createPressed (Board game, BoardView view, int dx, int dy) {
//		MouseEvent me = new MouseEvent(game.getContainer(), MouseEvent.MOUSE_PRESSED, 
//				System.currentTimeMillis(), 0, 
//				view.getX()+dx, view.getY()+dy, 0, false);
//		return me;
//	}
//	
//	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
//	public MouseEvent createRightClick (Board game, BoardView view, int dx, int dy) {
//		MouseEvent me = new MouseEvent(game.getContainer(), MouseEvent.MOUSE_PRESSED, 
//				System.currentTimeMillis(), 0, 
//				view.getX()+dx, view.getY()+dy, 0, true);
//		return me;
//	}
//	
//	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
//	public MouseEvent createReleased (Solitaire game, Widget view, int dx, int dy) {
//		MouseEvent me = new MouseEvent(game.getContainer(), MouseEvent.MOUSE_RELEASED, 
//				System.currentTimeMillis(), 0, 
//				view.getX()+dx, view.getY()+dy, 0, false);
//		return me;
//	}
//	
//	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
//	public MouseEvent createClicked (Solitaire game, Widget view, int dx, int dy) {
//		MouseEvent me = new MouseEvent(game.getContainer(), MouseEvent.MOUSE_CLICKED, 
//				System.currentTimeMillis(), 0, 
//				view.getX()+dx, view.getY()+dy, 1, false);
//		return me;
//	}
//	
//	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
//	public MouseEvent createDoubleClicked (Solitaire game, Widget view, int dx, int dy) {
//		MouseEvent me = new MouseEvent(game.getContainer(), MouseEvent.MOUSE_CLICKED, 
//				System.currentTimeMillis(), 0, 
//				view.getX()+dx, view.getY()+dy, 2, false);
//		return me;
//	}
//
//}
