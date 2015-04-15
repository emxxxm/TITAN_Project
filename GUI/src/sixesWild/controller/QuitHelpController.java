package sixesWild.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWild.view.HelpView;
import sixesWild.view.RecordView;
import sixesWild.view.SelectLevelView;

public class QuitHelpController implements ActionListener
{
	SelectLevelView prevView;
	HelpView currView;
	
	public QuitHelpController(SelectLevelView prevView, HelpView currView)
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