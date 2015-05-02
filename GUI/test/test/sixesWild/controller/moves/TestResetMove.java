package test.sixesWild.controller.moves;

import sixesWild.controller.moves.ResetMove;
import sixesWild.model.AllLevel;
import sixesWild.model.Board;
import sixesWild.model.EliminationBoard;
import sixesWild.model.LightningBoard;
import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.ReleaseBoard;
import junit.framework.TestCase;

public class TestResetMove extends TestCase {
	AllLevel allLevel;
	Model m;
	
	@Override
	protected void setUp() throws Exception{
		allLevel = new AllLevel("src/input.txt", "src/stateInput.txt");
		m = new Model(allLevel, new Board(allLevel.getGivenLevel(1)));
	}
	
	public void testResetInvalid(){
		PuzzleBoard pb = new PuzzleBoard(allLevel.getGivenLevel(1));
		m = new Model(allLevel, pb);
		pb.updateMoveLeft(pb.getMoveLeft()*(-1));
		
		ResetMove mv1 = new ResetMove(m);
		assertFalse(mv1.isValid());
		assertFalse(mv1.doMove());
		
		EliminationBoard eb = new EliminationBoard(allLevel.getGivenLevel(4));
		m = new Model(allLevel, eb);
		eb.updateMoveLeft(eb.getMoveLeft()*(-1));
		assertEquals(0,eb.getMoveLeft());
		
		ResetMove mv2 = new ResetMove(m);
		assertFalse(mv2.isValid());
		assertFalse(mv2.doMove());
	}
	
	public void testResetValid(){
		m = new Model(allLevel, new PuzzleBoard(allLevel.getGivenLevel(1)));
		ResetMove mv1 = new ResetMove(m);
		assertTrue(mv1.isValid());
		assertTrue(mv1.doMove());
		
		m = new Model(allLevel, new LightningBoard(allLevel.getGivenLevel(2)));
		ResetMove mv2 = new ResetMove(m);
		assertTrue(mv2.isValid());
		assertTrue(mv2.doMove());
		
		m = new Model(allLevel, new ReleaseBoard(allLevel.getGivenLevel(3)));
		ResetMove mv3 = new ResetMove(m);
		assertTrue(mv3.isValid());
		assertTrue(mv3.doMove());
		
		m = new Model(allLevel, new EliminationBoard(allLevel.getGivenLevel(4)));
		ResetMove mv4 = new ResetMove(m);
		assertTrue(mv4.isValid());
		assertTrue(mv4.doMove());
	}
}
