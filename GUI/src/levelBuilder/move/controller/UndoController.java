package levelBuilder.move.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilder.entity.Move;
import levelBuilder.game.LevelBuilder;

public class UndoController implements ActionListener{
	protected LevelBuilder lb;
	
	public UndoController(LevelBuilder lb){
		this.lb = lb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Undo");
		lb.undoMove();
	}

}
