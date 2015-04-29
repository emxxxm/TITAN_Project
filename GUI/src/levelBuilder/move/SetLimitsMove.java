package levelBuilder.move;

import levelBuilder.entity.Limits;
import levelBuilder.entity.Move;
import levelBuilder.game.LevelBuilder;

public class SetLimitsMove extends Move {

	protected Limits limit;
	protected int timeLimit;
	protected int moveLimit;
	protected int removeLimit;
	protected int swapLimit;

	protected int timeLimit_undo;
	protected int moveLimit_undo;
	protected int removeLimit_undo;
	protected int swapLimit_undo;

	public SetLimitsMove(Limits l, int time, int move, int remove, int swap) {
		this.limit = l;
		this.timeLimit = time;
		this.moveLimit = move;
		this.removeLimit = remove;
		this.swapLimit = swap;
		this.timeLimit_undo = l.getTimeLimits();
		this.moveLimit_undo = l.getMoveLimits();
		this.removeLimit_undo = l.getRemoveLimits();
		this.swapLimit_undo = l.getSwapLimits();
	}

	@Override
	public boolean execute(LevelBuilder lb) {

		if (!valid(lb))
			return false;
		if (lb.getMode() == "Lightning") {
			lb.getLbPanel().getTimeLimit().setText("" + timeLimit);
			limit.setTimeLimits(timeLimit);
		} else {
			lb.getLbPanel().getTimeLimit().setText("");
			System.out.println("Time limit is not available in current mode");
		}
		
		lb.getLbPanel().getMoveLimit().setText("" + moveLimit);
		lb.getLbPanel().getRemoveLimit().setText("" + removeLimit);
		lb.getLbPanel().getSwapLimit().setText("" + swapLimit);

		limit.setMoveLimits(moveLimit);
		limit.setRemoveLimits(removeLimit);
		limit.setSwapLimits(swapLimit);
		return true;
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		lb.getLbPanel().getTimeLimit().setText("" + timeLimit_undo);
		lb.getLbPanel().getMoveLimit().setText("" + moveLimit_undo);
		lb.getLbPanel().getRemoveLimit().setText("" + removeLimit_undo);
		lb.getLbPanel().getSwapLimit().setText("" + swapLimit_undo);

		return limit.setTimeLimits(timeLimit_undo)
				&& limit.setMoveLimits(moveLimit_undo)
				&& limit.setRemoveLimits(removeLimit_undo)
				&& limit.setSwapLimits(swapLimit_undo);
	}

	@Override
	public boolean valid(LevelBuilder lb) {
		return timeLimit >= 0 && moveLimit > 0 && removeLimit >= 0
				&& swapLimit >= 0;
	}

	@Override
	public boolean updateBoard() {
		// TODO Auto-generated method stub
		return false;
	}

}
