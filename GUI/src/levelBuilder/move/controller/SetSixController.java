package levelBuilder.move.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilder.entity.Move;
import levelBuilder.entity.Position;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.SetBucketMove;
import levelBuilder.move.SetSixMove;
import levelBuilder.view.LBPanel;

public class SetSixController implements ActionListener{

	protected LevelBuilder lb;
	protected LBPanel panel;
	public SetSixController(LevelBuilder lb){
		this.lb = lb;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Integer x = Integer.parseInt(lb.getLbPanel().getBucketRow().getText());
		Integer y = Integer.parseInt(lb.getLbPanel().getBucketCol().getText());
		
		Position pos = new Position(x,y);
		Move m = new SetSixMove(lb.getModel().getSix(), pos);
		
		if(m.execute(lb)){
			lb.pushMove(m);
		}
		
	}

	
}
