package levelBuilder.move;

import levelBuilder.entity.Move;
import levelBuilder.entity.StarGoals;
import levelBuilder.game.LevelBuilder;

public class SetStarGoalsMove extends Move{
	protected StarGoals starGoals;
	protected int one;
	protected int two;
	protected int three;
	
	public SetStarGoalsMove(StarGoals star, int one, int two, int three){
		this.starGoals = star;
		this.one = one;
		this.two = two;
		this.three = three;
	}

	@Override
	public boolean execute(LevelBuilder lb) {
		if(!valid(lb)) return false;
		
		return starGoals.setOne(one)&&starGoals.setTwo(two)&&starGoals.setThree(three);
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean valid(LevelBuilder lb) {
		return one>=0&&two>=one&&three>=two;
	}

	@Override
	public boolean updateBoard() {
		// TODO Auto-generated method stub
		return false;
	}

}
