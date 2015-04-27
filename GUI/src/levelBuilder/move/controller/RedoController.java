package levelBuilder.move.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilder.game.LevelBuilder;

public class RedoController implements ActionListener{

	protected LevelBuilder lb;
	
	public RedoController(LevelBuilder lb){
		this.lb = lb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Redo");
		lb.redoMove();
	}

}
