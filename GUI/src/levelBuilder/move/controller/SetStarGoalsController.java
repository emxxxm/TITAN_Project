package levelBuilder.move.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilder.entity.Move;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.SetStarGoalsMove;
import levelBuilder.view.LBPanel;

public class SetStarGoalsController implements ActionListener{

	protected LevelBuilder lb;
//	protected LBPanel panel;
	
	public SetStarGoalsController(LevelBuilder lb){
		this.lb = lb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		Integer star1 = Integer.parseInt(lb.getLbPanel().getFirstStar().getText());
		Integer star2 = Integer.parseInt(lb.getLbPanel().getSecondStar().getText());
		Integer star3 = Integer.parseInt(lb.getLbPanel().getThirdStar().getText());
		
		Move m = new SetStarGoalsMove(lb.getModel().getStarGoals(), star1, star2, star3);
	
		if(m.execute(lb)){
			lb.pushMove(m);
		}
	}

}
