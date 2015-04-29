package test.levelBuilder.move;

import junit.framework.TestCase;
import levelBuilder.entity.CurrentLevel;
import levelBuilder.entity.Model;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.EnterLevelMove;
import levelBuilder.view.LBPanel;

public class TestEnterLevelMove extends TestCase {
	Model m;
	LBPanel lbpanel;
	LevelBuilder lb;
	
	protected void setUp() {
		m = new Model();
		lbpanel=new LBPanel(m);
		lb=new LevelBuilder(m,lbpanel);

	}

	public void testInvalid() {
			
//		CurrentLevel testCurrentLevel = new CurrentLevel();

		EnterLevelMove invalid_zeroth_level = new EnterLevelMove(m, 0);
		EnterLevelMove invalid_neg_one = new EnterLevelMove(m, -1);
		EnterLevelMove invalid_thirty = new EnterLevelMove(m, 30);
		
		assertFalse(invalid_zeroth_level.valid(lb));
		assertFalse(invalid_neg_one.valid(lb));
		assertFalse(invalid_thirty.valid(lb));
		
		assertNull(m.getCurrentLevel().get(0));
		assertNull(m.getCurrentLevel().get(-1));
		assertNull(m.getCurrentLevel().get(30));
		
		assertFalse(invalid_zeroth_level.execute(lb));
		assertFalse(invalid_neg_one.execute(lb));
		assertFalse(invalid_thirty.execute(lb));
	}
	
	public void testValid() {
		
//		CurrentLevel testCurrentLevel = new CurrentLevel();

		EnterLevelMove validLevelP= new EnterLevelMove(m, 1);
		EnterLevelMove validLevelL= new EnterLevelMove(m, 2);
		EnterLevelMove validLevelE= new EnterLevelMove(m, 3);
		EnterLevelMove validLevelR= new EnterLevelMove(m, 4);
		EnterLevelMove validLevelP2= new EnterLevelMove(m, 5);
		
		assertTrue(validLevelP.valid(lb));
		assertTrue(validLevelL.valid(lb));
		assertTrue(validLevelE.valid(lb));
		assertTrue(validLevelR.valid(lb));
		assertTrue(validLevelP2.valid(lb));
		
		assertTrue(validLevelP.execute(lb));
		assertTrue(validLevelL.execute(lb));
		assertTrue(validLevelE.execute(lb));
		assertTrue(validLevelR.execute(lb));
		assertTrue(validLevelP2.execute(lb));		
		
		assertEquals("Puzzle", m.getCurrentLevel().get(1));
		assertEquals("Lightning", m.getCurrentLevel().get(2));
		assertEquals("Elimination", m.getCurrentLevel().get(3));
		assertEquals("Release", m.getCurrentLevel().get(4));
		assertEquals("Puzzle", m.getCurrentLevel().get(5));
		
		//when rebuilt a level, the former is overwritten by the new one
		EnterLevelMove validLevelP_rebuilt= new EnterLevelMove(m, 1);
		validLevelP_rebuilt.execute(lb);
		assertEquals(5,m.getCurrentLevel().size());
		
		assertTrue(validLevelP_rebuilt.undo(lb));
		assertEquals(5, m.getCurLevel());
	
	}
}
