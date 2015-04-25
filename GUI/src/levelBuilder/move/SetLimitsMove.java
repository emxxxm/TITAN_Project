package levelBuilder.move;

import levelBuilder.entity.Limits;
import levelBuilder.entity.Move;
import levelBuilder.game.LevelBuilder;

public class SetLimitsMove extends Move{
	
	protected Limits limit;
	protected int timeLimit;
	protected int moveLimit;
	protected int removeLimit;
	protected int swapLimit;
	
	public SetLimitsMove(Limits l, int time, int move, int remove, int swap){
		this.limit = l;
		this.timeLimit = time;
		this.moveLimit = move;
		this.removeLimit = remove;
		this.swapLimit = swap;
	}

	@Override
	public boolean execute(LevelBuilder lb) {

		if(!valid(lb)) return false;
		
		limit.setTimeLimits(timeLimit);
		limit.setMoveLimits(moveLimit);
		limit.setRemoveLimits(removeLimit);
		limit.setSwapLimits(swapLimit);
		return true;
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean valid(LevelBuilder lb) {
		return timeLimit>=0 && moveLimit>0 && removeLimit>=0 && swapLimit>=0;
	}

	@Override
	public boolean updateBoard() {
		// TODO Auto-generated method stub
		return false;
	}

}
