package test.levelBuilder.move;

import junit.framework.TestCase;
import levelBuilder.entity.Model;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.DisableSquareMove;
import levelBuilder.move.EnableSquareMove;
import levelBuilder.view.LBPanel;

public class TestDisableEnableMove extends TestCase {
	Model m;
	LBPanel lbpanel;
	LevelBuilder lb;
	
	protected void setUp() {
		m = new Model();
		lbpanel = new LBPanel(m);
		lb = new LevelBuilder(m,lbpanel);
	}
	
	public void testDisableInvalid(){
		DisableSquareMove m1 = new DisableSquareMove(m.getDisableSquareList(), -1, 1, 1,1);
		assertFalse(m1.valid(lb));
		assertFalse(m1.execute(lb));
		DisableSquareMove m2 = new DisableSquareMove(m.getDisableSquareList(), 10, 1, 1,1);
		assertFalse(m2.valid(lb));
		assertFalse(m2.execute(lb));
		DisableSquareMove m3 = new DisableSquareMove(m.getDisableSquareList(), 1, 10, 1,1);
		assertFalse(m3.valid(lb));
		assertFalse(m3.execute(lb));
		DisableSquareMove m4 = new DisableSquareMove(m.getDisableSquareList(), 1, -1, 1,1);
		assertFalse(m4.valid(lb));
		assertFalse(m4.execute(lb));
		DisableSquareMove m5 = new DisableSquareMove(m.getDisableSquareList(), 1, 1, 10,1);
		assertFalse(m5.valid(lb));
		assertFalse(m5.execute(lb));
		DisableSquareMove m6 = new DisableSquareMove(m.getDisableSquareList(), 1, 1, -1,1);
		assertFalse(m6.valid(lb));
		assertFalse(m6.execute(lb));
		DisableSquareMove m7 = new DisableSquareMove(m.getDisableSquareList(), 1, 1, 1,-1);
		assertFalse(m7.valid(lb));
		assertFalse(m7.execute(lb));
		DisableSquareMove m8 = new DisableSquareMove(m.getDisableSquareList(), 1, 1, 1,10);
		assertFalse(m8.valid(lb));
		assertFalse(m8.execute(lb));
		DisableSquareMove m9 = new DisableSquareMove(m.getDisableSquareList(), 2, 1, 1,1);
		assertFalse(m9.valid(lb));
		assertFalse(m9.execute(lb));
		DisableSquareMove m10 = new DisableSquareMove(m.getDisableSquareList(), 1, 1, 2,1);
		assertFalse(m10.valid(lb));
		assertFalse(m10.execute(lb));
		DisableSquareMove m11 = new DisableSquareMove(m.getDisableSquareList(), 3, 1, 2,1);
		assertFalse(m11.valid(lb));
		assertFalse(m11.execute(lb));
	}
	
	public void testDisableValid(){
		DisableSquareMove m1 = new DisableSquareMove(m.getDisableSquareList(), 3, 3, 2,3);
		assertTrue(m1.valid(lb));
		assertTrue(m1.execute(lb));
		
		DisableSquareMove m2 = new DisableSquareMove(m.getDisableSquareList(), 3, 3, 2,2);
		assertTrue(m2.valid(lb));
		assertFalse(m2.execute(lb));
		
		assertEquals(2, m.getDisableSquareList().sizeof());
		
		assertTrue(m1.undo(lb));
		assertEquals(0, m.getDisableSquareList().sizeof());
	}
	
	public void testEnableInvalid(){
		EnableSquareMove m1 = new EnableSquareMove(m.getDisableSquareList(), -1, 1, 1,1);
		assertFalse(m1.valid(lb));
		assertFalse(m1.execute(lb));
		EnableSquareMove m2 = new EnableSquareMove(m.getDisableSquareList(), 10, 1, 1,1);
		assertFalse(m2.valid(lb));
		assertFalse(m2.execute(lb));
		EnableSquareMove m3 = new EnableSquareMove(m.getDisableSquareList(), 1, 10, 1,1);
		assertFalse(m3.valid(lb));
		assertFalse(m3.execute(lb));
		EnableSquareMove m4 = new EnableSquareMove(m.getDisableSquareList(), 1, -1, 1,1);
		assertFalse(m4.valid(lb));
		assertFalse(m4.execute(lb));
		EnableSquareMove m5 = new EnableSquareMove(m.getDisableSquareList(), 1, 1, 10,1);
		assertFalse(m5.valid(lb));
		assertFalse(m5.execute(lb));
		EnableSquareMove m6 = new EnableSquareMove(m.getDisableSquareList(), 1, 1, -1,1);
		assertFalse(m6.valid(lb));
		assertFalse(m6.execute(lb));
		EnableSquareMove m7 = new EnableSquareMove(m.getDisableSquareList(), 1, 1, 1,-1);
		assertFalse(m7.valid(lb));
		assertFalse(m7.execute(lb));
		EnableSquareMove m8 = new EnableSquareMove(m.getDisableSquareList(), 1, 1, 1,10);
		assertFalse(m8.valid(lb));
		assertFalse(m8.execute(lb));
		EnableSquareMove m9 = new EnableSquareMove(m.getDisableSquareList(), 2, 1, 1,1);
		assertFalse(m9.valid(lb));
		assertFalse(m9.execute(lb));
		EnableSquareMove m10 = new EnableSquareMove(m.getDisableSquareList(), 1, 1, 2,1);
		assertFalse(m10.valid(lb));
		assertFalse(m10.execute(lb));
		EnableSquareMove m11 = new EnableSquareMove(m.getDisableSquareList(), 3, 1, 2,1);
		assertFalse(m11.valid(lb));
		assertFalse(m11.execute(lb));
		EnableSquareMove m12 = new EnableSquareMove(m.getDisableSquareList(), 3, 3, 1,1);
		assertFalse(m12.valid(lb));
		assertFalse(m12.execute(lb));
		
		DisableSquareMove mm1 = new DisableSquareMove(m.getDisableSquareList(), 3, 3, 2,3);
		assertTrue(mm1.valid(lb));
		assertTrue(mm1.execute(lb));
		EnableSquareMove mm2 = new EnableSquareMove(m.getDisableSquareList(), 3, 3, 2,4);
		assertFalse(mm2.valid(lb));
		assertFalse(mm2.execute(lb));
		EnableSquareMove mm3 = new EnableSquareMove(m.getDisableSquareList(), 3, 4, 2,3);
		assertFalse(mm3.valid(lb));
		assertFalse(mm3.execute(lb));
	}
	
	public void testEnableValid(){
		DisableSquareMove m1 = new DisableSquareMove(m.getDisableSquareList(), 3, 3, 2,3);
		assertTrue(m1.valid(lb));
		assertTrue(m1.execute(lb));
		EnableSquareMove m2 = new EnableSquareMove(m.getDisableSquareList(), 3, 3, 2,2);
		assertTrue(m2.valid(lb));
		assertTrue(m2.execute(lb));
		
		assertEquals(1, m.getDisableSquareList().sizeof());
		assertTrue(m2.undo(lb));
		assertEquals(2, m.getDisableSquareList().sizeof());
		
		
		
	}
}
