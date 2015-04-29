package test.levelBuilder.move;

import junit.framework.TestCase;
import levelBuilder.entity.BonusFrequency;
import levelBuilder.entity.Model;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.SetBonusFreqMove;
import levelBuilder.view.LBPanel;

public class TestSetBonusFreqMove extends TestCase{
	Model m;
	LBPanel lbpanel;
	LevelBuilder lb;
	
	protected void setUp() {
		m = new Model();
		lbpanel = new LBPanel(m);
		lb = new LevelBuilder(m,lbpanel);
	}
	
	public void testInvalid(){
//		BonusFrequency bf = new BonusFrequency();
		SetBonusFreqMove setBnsFrq = new SetBonusFreqMove(m.getBonusFrequency(), -1,-2);
		assertFalse(setBnsFrq.valid(lb));
		assertFalse(setBnsFrq.execute(lb));
		
		setBnsFrq = new SetBonusFreqMove(m.getBonusFrequency(), 100, 200);
		assertFalse(setBnsFrq.valid(lb));
		assertFalse(setBnsFrq.execute(lb));
	}
	
	public void testValid(){
//		BonusFrequency bf = new BonusFrequency();
		SetBonusFreqMove setBnsFrq = new SetBonusFreqMove(m.getBonusFrequency(), 0.1,0.2);
		assertTrue(setBnsFrq.valid(lb));
		assertTrue(setBnsFrq.execute(lb));
		
		assertEquals(0.1, m.getBonusFrequency().getx2());
		
		assertTrue(setBnsFrq.undo(lb));
		assertEquals(0.0, m.getBonusFrequency().getx2());
	}
}
