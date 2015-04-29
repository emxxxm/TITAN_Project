package test.levelBuilder.move;

import junit.framework.TestCase;
import levelBuilder.entity.Limits;
import levelBuilder.entity.Model;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.SetLimitsMove;
import levelBuilder.view.LBPanel;

public class TestSetLimitsMove extends TestCase{
	Model m;
	LBPanel lbpanel;
	LevelBuilder lb;
	
	protected void setUp() {
		m = new Model();
		lbpanel = new LBPanel(m);
		lb = new LevelBuilder(m,lbpanel);
	}
	
	public void testInvalid(){
//		Limits l = new Limits();
		SetLimitsMove setMove = new SetLimitsMove(m.getLimits(), 0, 0, 0, 0);
		assertFalse(setMove.valid(lb));
		assertFalse(setMove.execute(lb));
		setMove= new SetLimitsMove(m.getLimits(),-1,-2,5,3);
		assertFalse(setMove.valid(lb));
		assertFalse(setMove.execute(lb));
		
	}
	public void testValid(){
//		Limits l = new Limits();
		SetLimitsMove setMove = new SetLimitsMove(m.getLimits(), 100, 20, 2, 3);
		assertTrue(setMove.valid(lb));
		assertTrue(setMove.execute(lb));
		
		assertEquals(100, m.getLimits().getTimeLimits());
		
		assertTrue(setMove.undo(lb));
		assertEquals(0, m.getLimits().getTimeLimits());
		
		
		
	}
	
	
}
