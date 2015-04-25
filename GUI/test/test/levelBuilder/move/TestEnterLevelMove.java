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
			
		CurrentLevel testCurrentLevel = new CurrentLevel();

		EnterLevelMove invalid_zeroth_level = new EnterLevelMove(testCurrentLevel, 0);
		EnterLevelMove invalid_neg_one = new EnterLevelMove(testCurrentLevel, -1);
		EnterLevelMove invalid_thirty = new EnterLevelMove(testCurrentLevel, 30);
		
		assertFalse(invalid_zeroth_level.valid(lb));
		assertFalse(invalid_neg_one.valid(lb));
		assertFalse(invalid_thirty.valid(lb));
		
		assertNull(testCurrentLevel.get(0));
		assertNull(testCurrentLevel.get(-1));
		assertNull(testCurrentLevel.get(30));
		
		assertFalse(invalid_zeroth_level.execute(lb));
		assertFalse(invalid_neg_one.execute(lb));
		assertFalse(invalid_thirty.execute(lb));
	}
	
	public void testValid() {
		
		CurrentLevel testCurrentLevel = new CurrentLevel();

		EnterLevelMove validLevelP= new EnterLevelMove(testCurrentLevel, 1);
		EnterLevelMove validLevelL= new EnterLevelMove(testCurrentLevel, 2);
		EnterLevelMove validLevelE= new EnterLevelMove(testCurrentLevel, 3);
		EnterLevelMove validLevelR= new EnterLevelMove(testCurrentLevel, 4);
		EnterLevelMove validLevelP2= new EnterLevelMove(testCurrentLevel, 5);
		
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
		
		assertEquals("Puzzle", testCurrentLevel.get(1));
		assertEquals("Lightning", testCurrentLevel.get(2));
		assertEquals("Elimination", testCurrentLevel.get(3));
		assertEquals("Release", testCurrentLevel.get(4));
		assertEquals("Puzzle", testCurrentLevel.get(5));
		
		//when rebuilt a level, the former is overwritten by the new one
		EnterLevelMove validLevelP_rebuilt= new EnterLevelMove(testCurrentLevel, 1);
		validLevelP_rebuilt.execute(lb);
		assertEquals(5,testCurrentLevel.size());
	
	}
}
