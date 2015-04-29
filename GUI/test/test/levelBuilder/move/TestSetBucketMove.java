package test.levelBuilder.move;

import junit.framework.TestCase;
import levelBuilder.entity.Model;
import levelBuilder.entity.Position;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.DisableSquareMove;
import levelBuilder.move.SetBucketMove;
import levelBuilder.move.SetSixMove;
import levelBuilder.view.LBPanel;

public class TestSetBucketMove extends TestCase {
	Model m;
	LBPanel lbpanel;
	LevelBuilder lb;
	
	protected void setUp() {
		m = new Model();
		lbpanel = new LBPanel(m);
		lb = new LevelBuilder(m,lbpanel);
	}
	
	public void testInvalid(){
		DisableSquareMove disableMove = new DisableSquareMove(m.getDisableSquareList(), 1,1,1,1);
		assertTrue(disableMove.valid(lb));
		assertTrue(disableMove.execute(lb));
		
		SetBucketMove m1 = new SetBucketMove(m.getBucket(), new Position(1,1));
		
		assertFalse(m1.valid(lb));
		assertFalse(m1.execute(lb));
	}
	
	public void testValid(){
		SetBucketMove m1 = new SetBucketMove(m.getBucket(), new Position(1,1));
		assertTrue(m1.valid(lb));
		assertTrue(m1.execute(lb));
		
		assertEquals(1, m.getBucket().sizeof());
		
		assertTrue(m1.undo(lb));
		assertEquals(0,m.getBucket().sizeof());
	}
}
