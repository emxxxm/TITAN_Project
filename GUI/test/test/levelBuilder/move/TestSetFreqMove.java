package test.levelBuilder.move;

import junit.framework.TestCase;
import levelBuilder.entity.Model;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.SetFreqMove;
import levelBuilder.view.LBPanel;

public class TestSetFreqMove extends TestCase {
	Model m;
	LBPanel lbpanel;
	LevelBuilder lb;
	
	protected void setUp() {
		m = new Model();
		lbpanel=new LBPanel(m);
		lb=new LevelBuilder(m,lbpanel);

	}
	
	public void testInvalid(){
		SetFreqMove invalid_zero_freq = new SetFreqMove(m.getNumFrequency(), 0.0,0.0,0.0,0.0,0.0,0.0);
		SetFreqMove invalid_larger_one = new SetFreqMove(m.getNumFrequency(), 1.0,1.0,0.8,0.8,0.8,0.8);
	
		assertFalse(invalid_zero_freq.valid(lb));
		assertFalse(invalid_larger_one.valid(lb));
		
		assertFalse(invalid_zero_freq.execute(lb));
		assertFalse(invalid_larger_one.execute(lb));
	}
	
	public void testValid(){
		SetFreqMove validMove = new SetFreqMove(m.getNumFrequency(),0.1,0.2,0.3,0.3,0.1,0.0);
		
		assertTrue(validMove.valid(lb));
		assertTrue(validMove.execute(lb));
	
		assertEquals(0.1, m.getNumFrequency().getFre1());
		assertEquals(0.2, m.getNumFrequency().getFre2());
		assertEquals(0.3, m.getNumFrequency().getFre3());
		assertEquals(0.3, m.getNumFrequency().getFre4());
		assertEquals(0.1, m.getNumFrequency().getFre5());
		assertEquals(0.0, m.getNumFrequency().getFre6());

		assertTrue(validMove.undo(lb));
		
		assertEquals(0.0, m.getNumFrequency().getFre1());
		assertEquals(0.0, m.getNumFrequency().getFre2());
		assertEquals(0.0, m.getNumFrequency().getFre3());
		assertEquals(0.0, m.getNumFrequency().getFre4());
		assertEquals(0.0, m.getNumFrequency().getFre5());
		assertEquals(0.0, m.getNumFrequency().getFre6());
		
		
	}
}
