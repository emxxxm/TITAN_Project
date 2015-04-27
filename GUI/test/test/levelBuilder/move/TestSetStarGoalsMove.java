package test.levelBuilder.move;

import junit.framework.TestCase;
import levelBuilder.entity.Model;
import levelBuilder.entity.StarGoals;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.SetStarGoalsMove;
import levelBuilder.view.LBPanel;

public class TestSetStarGoalsMove extends TestCase{
	Model m;
	LBPanel lbpanel;
	LevelBuilder lb;
	
	protected void setUp() {
		m = new Model();
		lbpanel = new LBPanel(m);
		lb = new LevelBuilder(m,lbpanel);
	}
	
	public void testInvalid(){
		StarGoals starGoals = new StarGoals();
		SetStarGoalsMove newGoals = new SetStarGoalsMove(starGoals, -1,0,1);
		assertFalse(newGoals.valid(lb));
		assertFalse(newGoals.execute(lb));
		

		SetStarGoalsMove newGoals2 = new SetStarGoalsMove(starGoals, 200,10,30);
		assertFalse(newGoals2.valid(lb));
		assertFalse(newGoals2.execute(lb));
	}

	public void testValid(){
		StarGoals starGoals = new StarGoals();
		SetStarGoalsMove newGoals = new SetStarGoalsMove(starGoals,100, 200,300);
		assertTrue(newGoals.valid(lb));
		assertTrue(newGoals.execute(lb));
		
	}
	

}
