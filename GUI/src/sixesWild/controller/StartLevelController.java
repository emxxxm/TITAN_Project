package sixesWild.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.TimerTask;
import java.util.logging.Level;

import sixesWild.model.Board;
import sixesWild.model.EliminationBoard;
import sixesWild.model.LightningBoard;
import sixesWild.model.Model;
import sixesWild.model.MyTimer;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.ReleaseBoard;
import sixesWild.view.BoardView;
import sixesWild.view.SelectLevelView;

public class StartLevelController implements ActionListener
{
	SelectLevelView start;
	Model m;
	int currLevel;
	
	public StartLevelController(SelectLevelView start, Model m, int currLevel)
	{
		this.start=start;
		this.m=m;
		this.currLevel=currLevel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		start.setVisible(false);
		
		Board b;
		System.out.println("CURRENTLEVEL is "+currLevel);
		//Create BoardView.
		switch(this.currLevel%4){
			//Level 1, puzzle.
			case 1: 
				b = new PuzzleBoard(m.getAllLevels().getGivenLevel(currLevel)); 
				break;
			//Level 2, lightning.
			case 2: 			
				b = new LightningBoard(m.getAllLevels().getGivenLevel(currLevel));
				break;
			//Level 3, elimination.
			case 3:
				b = new EliminationBoard(m.getAllLevels().getGivenLevel(currLevel));
				break;
			//Level 4, release.
			default:
				b = new ReleaseBoard(m.getAllLevels().getGivenLevel(currLevel));
		}
		m.setBoard(b);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		BoardView newBoardView=new BoardView(m);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		newBoardView.setVisible(true);
		MyTimer t = MyTimer.getInstance();	
		if(b instanceof LightningBoard)
		{			
			if(((LightningBoard)(m.getBoard())).getTimeLeft()!=0)
			{
				TimerTask task = new TimerTask() {

					@Override
					public void run() {
						// HACK. Should be in a model someplace
						int val = ((LightningBoard)(m.getBoard())).getTimeLeft();
						val -= 1;
						System.out.println(val);
						newBoardView.getTimeLabel().setText("Time Left: " + val);
						if(val == 0)
						{			
							t.cancel();
						}
						((LightningBoard)(m.getBoard())).setTimeLeft(-1);
						CompleteLevelController clc = new CompleteLevelController(m, newBoardView);
						try {
							clc.process();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				};
				t.schedule(task, 1000);
			}
			

		}
		
		newBoardView.getQuitButton().addActionListener(new QuitLevelController(newBoardView,m,t));
	}
}
