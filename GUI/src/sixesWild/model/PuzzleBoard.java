package sixesWild.model;

public class PuzzleBoard extends Board {
	protected int moveLimit;
	protected int moveLeft;

	public PuzzleBoard(Level l) {
		super(l);
		this.moveLimit = l.getMoveLimit();
		this.moveLeft = l.getMoveLimit();
	}

	public int getMoveLimit() {
		return this.moveLimit;
	}

	public int getMoveLeft() {
		return this.moveLeft;
	}

	/**
	 * Updates the number of moves left in Puzzle mode with input delta
	 * representing the move change.
	 * 
	 * @author Mengwen Li, Yihong Zhou.
	 * @param delta
	 * @return
	 */
	public boolean updateMoveLeft(int delta) {
		int newValue = moveLeft + delta;
		if (newValue < 0 || delta > 0) {
			return false;
		}
		this.moveLeft = newValue;
		return true;
	}

}
