package test.SixesWild.controller.moves;

import sixesWild.controller.moves.RemoveMove;
import sixesWild.controller.moves.UpdateTileMove;
import sixesWild.model.AllLevel;
import sixesWild.model.Board;
import sixesWild.model.Model;
import sixesWild.model.ReleaseBoard;
import junit.framework.TestCase;

public class TestRemoveMove extends TestCase {

	AllLevel allLevel;
	Model m;
	
	@Override
	protected void setUp() throws Exception{
		allLevel = new AllLevel("src/", "src/stateInput.txt");
		m = new Model(allLevel, new Board(allLevel.getGivenLevel(1)));
	}
	
	public void testRemoveInvalid(){
		int removeLimit = m.getBoard().getRemoveLeft();
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(0, 0));
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 0));
//		System.out.println("remove left "+m.getBoard().getRemoveLeft());

		RemoveMove mv1 = new RemoveMove(m);
		assertFalse(mv1.isValid());
		assertFalse(mv1.doMove());
		assertEquals(2, m.getBoard().getSelectedSquares().size());
		assertEquals(removeLimit-1, m.getBoard().getRemoveLeft());
		
		m.getBoard().getSelectedSquares().remove(0);
		
		m.getBoard().setRemoveLeft(m.getBoard().getRemoveLeft()*(-1));

		RemoveMove mv2 = new RemoveMove(m);
		assertFalse(mv2.isValid());
		assertFalse(mv2.doMove());
		assertEquals(1, m.getBoard().getSelectedSquares().size());
		assertEquals(0,m.getBoard().getRemoveLeft());
	}
	
	public void testRemoveMoveNotValieabove(){
		m.getBoard().getSquare(0, 0).setType(0);
//		m.getBoard().getSquare(0, 1).setType(0);
		m.getBoard().getSquare(1, 0).getTile().setNum(3);
//		m.getBoard().getSquare(1, 1).getTile().setNum(3);
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 0));
//		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));

		RemoveMove mv = new RemoveMove(m);
		assertTrue(mv.isValid());
		assertTrue(mv.doMove());
		
	}
	
	public void testRemoveRelease(){
		ReleaseBoard rb = new ReleaseBoard(allLevel.getGivenLevel(4));
		m = new Model(allLevel, rb);
		m.getBoard().getSquare(0, 1).getTile().setNum(6);
		m.getBoard().getSquare(1, 1).getTile().setNum(3);
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));
		m.getBoard().getSquare(2, 1).setType(2);

		RemoveMove mv = new RemoveMove(m);
		assertTrue(mv.isValid());
		assertTrue(mv.doMove());
		assertEquals(6, m.getBoard().getSquare(2, 1).getTile().getNum());
	}
	
	public void testRemoveValid(){
		int removeLimit = m.getBoard().getRemoveLeft();
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 0));
		System.out.println("remove left "+m.getBoard().getRemoveLeft());

	
		RemoveMove mv1 = new RemoveMove(m);
		assertTrue(mv1.isValid());
		assertTrue(mv1.doMove());
		assertEquals(1, m.getBoard().getSelectedSquares().size());
		assertEquals(removeLimit-1, m.getBoard().getRemoveLeft());
	}
}
