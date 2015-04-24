package levelBuilder.move.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilder.entity.Move;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.EnterLevelMove;

public class EnterLevelController implements ActionListener{
	protected LevelBuilder lb;
	//protected LBPanel panel;
	
	public EnterLevelController(LevelBuilder lb){
		this.lb = lb;
		//this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String val = lb.getLbPanel().getLevelNumber().getText();
		Integer i = Integer.parseInt(val);
		Move m = new EnterLevelMove(lb.getModel().getCurrentLevel(), i);
		
		if(m.execute(lb)){
//			System.out.println("sssssssss: "+val);
			lb.pushMove(m);
		}
		
		lb.getLbPanel().getMode().setText(lb.getModel().getCurrentLevel().get(i));
	}
	
}
