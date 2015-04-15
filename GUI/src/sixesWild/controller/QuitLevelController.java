package sixesWild.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWild.view.BoardView;
import sixesWild.view.SelectLevelView;

public class QuitLevelController implements ActionListener
{
	SelectLevelView prevView;
	BoardView currView;
	
	public QuitLevelController(SelectLevelView prevView, BoardView currView)
	{
		this.prevView=prevView;
		this.currView=currView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		prevView.setVisible(true);
		currView.setVisible(false);
	}
}
