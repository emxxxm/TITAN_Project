package sixesWild.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWild.model.Model;
import sixesWild.view.BoardView;
import sixesWild.view.RecordView;
import sixesWild.view.SelectLevelView;

public class DisplayRecordController implements ActionListener
{
	SelectLevelView start;
	Model m;
	
	public DisplayRecordController(SelectLevelView start, Model m)
	{
		this.start=start;
		this.m = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		start.setVisible(false);
		
		//Create BoardView.
		RecordView rv=new RecordView(m);
		rv.setVisible(true);
		
		rv.getQuitButton().addActionListener(new QuitRecordController(start,rv));
	}
}