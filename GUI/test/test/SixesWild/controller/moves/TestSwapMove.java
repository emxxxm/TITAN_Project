package test.SixesWild.controller.moves;

import sixesWild.controller.moves.SwapMove;
import sixesWild.model.AllLevel;
import sixesWild.model.Board;
import sixesWild.model.Model;
import junit.framework.TestCase;

public class TestSwapMove extends TestCase {
	Model m;
	
	@Override
	protected void setUp() throws Exception{
		AllLevel allLevel = new AllLevel("src/input.txt", "src/stateInput.txt");
		m = new Model(allLevel, new Board(allLevel.getGivenLevel(1)));
	}
	
	public void testSwapInvalid(){
		int swapLimit = m.getBoard().getSwapLeft();
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));
		
		SwapMove mv1 = new SwapMove(m);
		assertFalse(mv1.isValid());
		assertFalse(mv1.doMove());
		assertEquals(swapLimit-1, m.getBoard().getSwapLeft());
		
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 2));
		m.getBoard().setSwapLeft(m.getBoard().getSwapLeft()*(-1));
		
		SwapMove mv2 = new SwapMove(m);
		assertFalse(mv2.isValid());
		assertFalse(mv2.doMove());
		assertEquals(0, m.getBoard().getSwapLeft());

	}
	
	public void testSwapValid(){
		int swapLimit = m.getBoard().getSwapLeft();

		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 2));
		
		SwapMove mv1 = new SwapMove(m);
		assertTrue(mv1.isValid());
		assertTrue(mv1.doMove());
		assertEquals(swapLimit-1, m.getBoard().getSwapLeft());

	}
}
