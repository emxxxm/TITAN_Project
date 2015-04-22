package sixesWild.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

import sixesWild.model.Board;
import sixesWild.model.Model;
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
		
		//Create BoardView.
		Board b=new Board(m.getAllLevels().getGivenLevel(currLevel));
		m.setBoard(b);
		BoardView newBoardView=new BoardView(m);
		newBoardView.setVisible(true);
		
		newBoardView.getQuitButton().addActionListener(new QuitLevelController(start,newBoardView));
	}
}
