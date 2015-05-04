package levelBuilder.move.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilder.entity.Move;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.SetBonusFreqMove;

public class SetBonusFreqController implements ActionListener{

	protected LevelBuilder lb;
//	protected LBPanel panel;
	
	public SetBonusFreqController(LevelBuilder lb){
		this.lb=lb;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		double x2Freq = Double.parseDouble(lb.getLbPanel().getx2().getText());
		double x3Freq = Double.parseDouble(lb.getLbPanel().getx3().getText());
		
		Move m = new SetBonusFreqMove(lb.getModel().getBonusFrequency(),x2Freq,x3Freq);
		
		if(m.execute(lb)){
			lb.pushMove(m);
		}
	}

}
