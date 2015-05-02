package sixesWild.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import sixesWild.model.LightningBoard;
import sixesWild.model.Model;
import sixesWild.model.MyTimer;
import sixesWild.view.BoardView;
import sixesWild.view.SelectLevelView;

public class QuitLevelController implements ActionListener
{
	//SelectLevelView prevView;
	BoardView currView;
	Model m;
	MyTimer mt;
	
	
	public QuitLevelController(BoardView currView, Model m, MyTimer mt)
	{
		//this.prevView=prevView;
		this.currView=currView;
		this.m = m;
		this.mt=mt;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//prevView.setVisible(true);
		currView.setVisible(false);
		if(m.getBoard() instanceof LightningBoard)
		{
			LightningBoard lb = (LightningBoard)(m.getBoard());
			if(lb.getTimeLeft()!=0)
			{
				mt.cancel();			
			}
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		CompleteLevelController clc = new CompleteLevelController(m, currView);
		try {
			clc.processQuitClose();;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SelectLevelView slv = new SelectLevelView(m);
		slv.setVisible(true);
	}
}
