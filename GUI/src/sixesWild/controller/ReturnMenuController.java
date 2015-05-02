package sixesWild.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWild.view.CompleteLevelView;
import sixesWild.view.HelpView;
import sixesWild.view.SelectLevelView;

public class ReturnMenuController implements ActionListener
{
	SelectLevelView prevView;
	CompleteLevelView currView;
	
	public ReturnMenuController(SelectLevelView prevView, CompleteLevelView currView)
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
