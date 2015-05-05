package levelBuilder.move;

import levelBuilder.entity.CurrentLevel;
import levelBuilder.entity.Model;
import levelBuilder.entity.Move;
import levelBuilder.game.LevelBuilder;

public class EnterLevelMove extends Move{

	protected Model model;
	protected Integer lvNum;
	protected Integer lvNum_undo;
	
	public EnterLevelMove(Model model, Integer val){
		super();
		
		this.model = model;
		this.lvNum = val;
		this.lvNum_undo = model.getCurLevel();
	}
	
	
	@Override
	public boolean execute(LevelBuilder lb) {
		
		if(!valid(lb)) return false;
		
		boolean valid = true;
		String mode="";
		model.setCurLevel(lvNum);
		int remainder = lvNum % 4;
		
		switch(remainder){
			case 1:
				mode = "Puzzle";
				break;
			case 2:
				mode = "Lightning";
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
		
		if(valid) model.getCurrentLevel().put(lvNum, mode);
		
		lb.getLbPanel().getLevelNumber().setText(""+lb.getModel().getCurLevel());
		lb.getLbPanel().getMode().setText(lb.getModel().getCurrentLevel().get(lvNum));

		return valid;
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		model.setCurLevel(lvNum_undo);

		lb.getLbPanel().getLevelNumber().setText(""+lb.getModel().getCurLevel());
		
		lb.getLbPanel().getMode().setText(lb.getModel().getCurrentLevel().get(lvNum_undo));
		return true;
	}

	@Override
	public boolean valid(LevelBuilder lb) {
		return lvNum>0 && lvNum<=20;
	}

//	@Override
//	public boolean updateBoard() {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
