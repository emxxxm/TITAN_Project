package levelBuilder.move;

import levelBuilder.entity.CurrentLevel;
import levelBuilder.entity.Move;
import levelBuilder.game.LevelBuilder;

public class EnterLevelMove extends Move{

	protected CurrentLevel currentLevel;
	protected Integer lvNum;
	
	public EnterLevelMove(CurrentLevel cl, Integer val){
		super();
		
		this.currentLevel = cl;
		this.lvNum = val;
	}
	
	
	@Override
	public boolean execute(LevelBuilder lb) {
		
		if(!valid(lb)) return false;
		
		boolean valid = true;
		String mode="";
		
		int remainder = lvNum % 4;
		
		switch(remainder){
			case 1:
				mode = "Puzzle";
				break;
			case 2:
				mode = "Lightening";
				break;
			case 3:
				mode = "Elimination";
				break;
			case 0:
				mode = "Release";
				break;
			default:
				valid = false;
				break;
		}
		if(valid) currentLevel.put(lvNum, mode);
		return valid;
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		//TODO
		return false;
	}

	@Override
	public boolean valid(LevelBuilder lb) {
		return lvNum>0 && lvNum<=20;
	}

	@Override
	public boolean updateBoard() {
		// TODO Auto-generated method stub
		return false;
	}

}
