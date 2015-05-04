package levelBuilder.move;

import levelBuilder.entity.Move;
import levelBuilder.entity.StarGoals;
import levelBuilder.game.LevelBuilder;

public class SetStarGoalsMove extends Move{
	protected StarGoals starGoals;
	protected int one;
	protected int two;
	protected int three;
	
	protected int one_undo;
	protected int two_undo;
	protected int three_undo;
	
	public SetStarGoalsMove(StarGoals star, int one, int two, int three){
		this.starGoals = star;
		this.one = one;
		this.two = two;
		this.three = three;
		this.one_undo = star.getOne();
		this.two_undo = star.getTwo();
		this.three_undo = star.getThree();
	}

	@Override
	public boolean execute(LevelBuilder lb) {
		if(!valid(lb)) return false;
		
		lb.getLbPanel().getFirstStar().setText(""+one);
		lb.getLbPanel().getSecondStar().setText(""+two);
		lb.getLbPanel().getThirdStar().setText(""+three);

		return starGoals.setOne(one) && starGoals.setTwo(two) && starGoals.setThree(three);
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		lb.getLbPanel().getFirstStar().setText(""+one_undo);
		lb.getLbPanel().getSecondStar().setText(""+two_undo);
		lb.getLbPanel().getThirdStar().setText(""+three_undo);

		return starGoals.setOne(one_undo) && starGoals.setTwo(two_undo) && starGoals.setThree(three_undo);
	}

	@Override
	public boolean valid(LevelBuilder lb) {
		return one>=0 && two>=one && three>=two;

	}

//	@Override
//	public boolean updateBoard() {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
