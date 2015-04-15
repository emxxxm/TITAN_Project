package sixesWild.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWild.model.Model;
import sixesWild.view.BoardView;
import sixesWild.view.SelectLevelView;

public class StartLevelController implements ActionListener
{
	SelectLevelView start;
	Model m;
	
	public StartLevelController(SelectLevelView start, Model m)
	{
		this.start=start;
		this.m=m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		start.setVisible(false);
		
		//Create BoardView.
		BoardView gamePlayView=new BoardView(m);
		gamePlayView.setVisible(true);
		
		gamePlayView.getQuitButton().addActionListener(new QuitLevelController(start,gamePlayView));
	}
}
