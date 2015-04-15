package sixesWild.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWild.view.HelpView;
import sixesWild.view.RecordView;
import sixesWild.view.SelectLevelView;

public class DisplayHelpController implements ActionListener
{
	SelectLevelView start;
	//Model m;
	
	public DisplayHelpController(SelectLevelView start)
	{
		this.start=start;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		start.setVisible(false);
		
		//Create BoardView.
		HelpView hv=new HelpView();
		hv.setVisible(true);
		
		hv.getQuitButton().addActionListener(new QuitHelpController(start,hv));
	}
}