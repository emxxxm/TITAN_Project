package sixesWild.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWild.view.BoardView;
import sixesWild.view.RecordView;
import sixesWild.view.SelectLevelView;

public class QuitRecordController implements ActionListener
{
	SelectLevelView prevView;
	RecordView currView;
	
	public QuitRecordController(SelectLevelView prevView, RecordView currView)
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