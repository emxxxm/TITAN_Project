package test.SixesWild.controller.moves;

import sixesWild.controller.moves.NormalMove;
import sixesWild.model.AllLevel;
import sixesWild.model.Board;
import sixesWild.model.Model;
import junit.framework.TestCase;

public class TestNormalMove extends TestCase{

	Model m;
//	BoardView bv;
	
	@Override
	protected void setUp() throws Exception{
		AllLevel allLevel = new AllLevel("src/", "src/stateInput.txt");
		m = new Model(allLevel, new Board(allLevel.getGivenLevel(1)));
		//		bv = new BoardView(m);
	}
	
	public void testNormalMoveInvalid(){
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(0, 0));

		NormalMove mv1 = new NormalMove(m, -1, 0, 0, 0);
		
		assertFalse(mv1.isValid());
		assertFalse(mv1.doMove());
		assertEquals(1, m.getBoard().getSelectedSquares().size());

		NormalMove mv2 = new NormalMove(m, 0, -1, 0, 0);
		
		assertFalse(mv2.isValid());
		assertFalse(mv2.doMove());
		assertEquals(1, m.getBoard().getSelectedSquares().size());
	
		m.getBoard().getSquare(1, 0).setType(0);
		NormalMove mv3 = new NormalMove(m, 1, 0, 0, 0);
		
		assertFalse(mv3.isValid());
		assertFalse(mv3.doMove());
		assertEquals(1, m.getBoard().getSelectedSquares().size());
	
		NormalMove mv4 = new NormalMove(m, 1, 1, 0, 0);
		
		assertFalse(mv4.isValid());
		assertFalse(mv4.doMove());
		assertEquals(1, m.getBoard().getSelectedSquares().size());
	
		NormalMove mv5 = new NormalMove(m, 0, 0, 0, 0);
		
		assertTrue(mv5.isValid());
		assertTrue(mv5.doMove());
		assertEquals(1, m.getBoard().getSelectedSquares().size());

	}
	
	public void testNormalMoveValid(){
		m.getBoard().getSquare(1, 1).getTile().setNum(3);
		m.getBoard().getSquare(1, 2).getTile().setNum(3);
	
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));
		NormalMove mv1 = new NormalMove(m, 1,2,1,1);
		
		assertTrue(mv1.isValid());
		assertTrue(mv1.doMove());
		assertEquals(2, m.getBoard().getSelectedSquares().size());

		NormalMove mv2 = new NormalMove(m, 2,2,1,2);
		
		assertTrue(mv2.isValid());
		assertTrue(mv2.doMove());
		assertEquals(3, m.getBoard().getSelectedSquares().size());
	
		
	}
	
	
}
