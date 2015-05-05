package test.SixesWild.controller.moves;

import sixesWild.controller.moves.UpdateTileMove;
import sixesWild.model.AllLevel;
import sixesWild.model.Board;
import sixesWild.model.EliminationBoard;
import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.ReleaseBoard;
import junit.framework.TestCase;

public class TestUpdateTileMove extends TestCase {
	AllLevel allLevel;
	Model m;
	
	@Override
	protected void setUp() throws Exception{
		allLevel = new AllLevel("src/", "src/stateInput.txt");
		m = new Model(allLevel, new Board(allLevel.getGivenLevel(1)));
	}
	
	public void testUpdateTileInvalidNoMove(){
		PuzzleBoard pb = new PuzzleBoard(allLevel.getGivenLevel(1));
		m = new Model(allLevel,pb);
		
		pb.updateMoveLeft(pb.getMoveLeft()*(-1));
		UpdateTileMove mv1 = new UpdateTileMove(m);
		assertFalse(mv1.isValid());
		assertFalse(mv1.doMove());
		
		EliminationBoard eb = new EliminationBoard(allLevel.getGivenLevel(4));
		m = new Model(allLevel,eb);
		eb.updateMoveLeft(eb.getMoveLeft()*(-1));
		UpdateTileMove mv2 = new UpdateTileMove(m);
		assertFalse(mv2.isValid());
		assertFalse(mv2.doMove());
	}
	
	public void testInvalidSix(){
		m.getBoard().getSquare(1, 1).getTile().setNum(1);
		m.getBoard().getSquare(1, 2).getTile().setNum(6);
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 2));
		
		UpdateTileMove mv1 = new UpdateTileMove(m);
		assertFalse(mv1.isValid());
		assertFalse(mv1.doMove());
		
	}
	
	public void testInvalidSumNotSix(){
		m.getBoard().getSquare(1, 1).getTile().setNum(4);
		m.getBoard().getSquare(1, 2).getTile().setNum(4);
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 2));

		UpdateTileMove mv1 = new UpdateTileMove(m);
		assertFalse(mv1.isValid());
		assertFalse(mv1.doMove());
	}
	
	public void testUpdateTileValid(){
		m = new Model(allLevel, new PuzzleBoard(allLevel.getGivenLevel(1)));
		m.getBoard().getSquare(0, 1).getTile().setNum(2);
		m.getBoard().getSquare(0, 2).getTile().setNum(1);
		m.getBoard().getSquare(1, 1).getTile().setNum(3);
		m.getBoard().getSquare(1, 2).getTile().setNum(3);
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 2));

		UpdateTileMove mv1 = new UpdateTileMove(m);
		assertTrue(mv1.isValid());
		assertTrue(mv1.doMove());
		assertEquals(2, m.getBoard().getSquare(1, 1).getTile().getNum());
		assertEquals(1, m.getBoard().getSquare(1, 2).getTile().getNum());
		
		m = new Model(allLevel, new EliminationBoard(allLevel.getGivenLevel(4)));
		m.getBoard().getSquare(0, 1).getTile().setNum(2);
		m.getBoard().getSquare(0, 2).getTile().setNum(1);
		m.getBoard().getSquare(1, 1).getTile().setNum(3);
		m.getBoard().getSquare(1, 2).getTile().setNum(3);
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 2));

		UpdateTileMove mv2 = new UpdateTileMove(m);
		assertTrue(mv2.isValid());
		assertTrue(mv2.doMove());
		assertEquals(2, m.getBoard().getSquare(1, 1).getTile().getNum());
		assertEquals(1, m.getBoard().getSquare(1, 2).getTile().getNum());
		
	}
	
	public void testUpdateTileValidRelease(){
		m = new Model(allLevel, new ReleaseBoard(allLevel.getGivenLevel(4)));
		m.getBoard().getSquare(0, 1).getTile().setNum(6);
		m.getBoard().getSquare(1, 1).getTile().setNum(3);
		m.getBoard().getSquare(1, 2).getTile().setNum(3);
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 2));

		m.getBoard().getSquare(2, 1).setType(2);
		UpdateTileMove mv1 = new UpdateTileMove(m);
		assertTrue(mv1.isValid());
		assertTrue(mv1.doMove());
		assertEquals(6, m.getBoard().getSquare(2, 1).getTile().getNum());
	
		m = new Model(allLevel, new ReleaseBoard(allLevel.getGivenLevel(3)));
		m.getBoard().getSquare(0, 1).getTile().setNum(3);
		m.getBoard().getSquare(0, 2).getTile().setNum(3);
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(0, 1));
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(0, 2));

//		m.getBoard().getSquare(2, 1).setType(2);
		UpdateTileMove mv2 = new UpdateTileMove(m);
		assertTrue(mv2.isValid());
		assertTrue(mv2.doMove());

	
	}
	
	public void testUpdateTileValidPuzzle(){
		PuzzleBoard pb = new PuzzleBoard(allLevel.getGivenLevel(1));
		m = new Model(allLevel, pb);
		int moveLeft = pb.getMoveLeft();
		
		m.getBoard().getSquare(1, 1).getTile().setNum(4);
		m.getBoard().getSquare(1, 2).getTile().setNum(3);
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 2));

		UpdateTileMove mv1 = new UpdateTileMove(m);
		assertFalse(mv1.isValid());
		assertFalse(mv1.doMove());
		
		assertEquals(moveLeft-1, pb.getMoveLeft());
	}
	
	public void testUpdateTileValidElimination(){
		EliminationBoard eb = new EliminationBoard(allLevel.getGivenLevel(4));
		m = new Model(allLevel, eb);
		int moveLeft = eb.getMoveLeft();
		
		m.getBoard().getSquare(1, 1).getTile().setNum(4);
		m.getBoard().getSquare(1, 2).getTile().setNum(3);
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 2));

		UpdateTileMove mv1 = new UpdateTileMove(m);
		assertFalse(mv1.isValid());
		assertFalse(mv1.doMove());
		
		assertEquals(moveLeft-1, eb.getMoveLeft());
	}
	
	public void testUpdateTileNotValieabove(){
		m.getBoard().getSquare(0, 0).setType(0);
		m.getBoard().getSquare(0, 1).setType(0);
		m.getBoard().getSquare(1, 0).getTile().setNum(3);
		m.getBoard().getSquare(1, 1).getTile().setNum(3);
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 0));
		m.getBoard().getSelectedSquares().add(m.getBoard().getSquare(1, 1));

		UpdateTileMove mv = new UpdateTileMove(m);
		assertTrue(mv.isValid());
		assertTrue(mv.doMove());
		
	}
}
