package levelBuilder.entity;

import levelBuilder.game.LevelBuilder;

public abstract class Move {
	protected Move(){}
	
	public abstract boolean execute(LevelBuilder lb);
	
	public abstract boolean undo(LevelBuilder lb);
	
	public abstract boolean valid(LevelBuilder lb);
	
	public abstract boolean updateBoard();
	
	public String toString() {
		return "[Move " + this.getClass().getName() + "]";
	}
	

}
