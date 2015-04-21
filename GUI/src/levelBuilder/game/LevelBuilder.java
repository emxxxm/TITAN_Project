package levelBuilder.game;

import java.util.Enumeration;

import levelBuilder.entity.Model;
import levelBuilder.entity.Move;

public class LevelBuilder {
	protected Model model;
	
	//TODO 
	//protected Application app;

	protected java.util.Stack<Move> moves = new java.util.Stack<Move>();
	
	protected LevelBuilder(){
		
	}
	
	//TODO
	//protected boolean addModelElement()
	
	public boolean hasComplete(){
		//TODO
		return false;
	}
	
	public void initialize(){
		//TODO
		
	}
	
	public String getName(){
		//TODO shizheyangma?
		return "Level Builder";
	}
	
	/**
	 * Return all moves made so far within this game.
	 * <p>
	 * 
	 * @return Enumeration Move objects that make up the history of the game.
	 */
	public Enumeration<Move> getMoves() {
		return moves.elements();
	}
	
	protected Move popMove() {
		// Return null if the stack of moves is empty.
		if (moves.isEmpty())
			return null;

		// pop most recent.
		return (Move) moves.pop();
	}
	
	public boolean pushMove(Move m) {
		moves.push(m);
		return true;
	}

}

