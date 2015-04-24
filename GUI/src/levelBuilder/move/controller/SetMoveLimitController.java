package levelBuilder.move.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilder.entity.Move;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.SetLimitsMove;
import levelBuilder.view.LBPanel;

public class SetMoveLimitController implements ActionListener{

	protected LevelBuilder lb;
//	protected LBPanel panel;
	
	public SetMoveLimitController(LevelBuilder lb){
		this.lb = lb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		Integer timeLimit = Integer.parseInt(lb.getLbPanel().getTimeLimit().getText());
		Integer moveLimit = Integer.parseInt(lb.getLbPanel().getMoveLimit().getText());
		Integer removeLimit = Integer.parseInt(lb.getLbPanel().getRemoveLimit().getText());
		Integer swapLimit = Integer.parseInt(lb.getLbPanel().getSwapLimit().getText());

		Move m = new SetLimitsMove(lb.getModel().getLimits(), timeLimit,moveLimit,removeLimit,swapLimit);
	
		if(m.execute(lb)){
			lb.pushMove(m);
		}
	}
	

}
