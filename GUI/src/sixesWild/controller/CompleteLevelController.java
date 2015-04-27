package sixesWild.controller;

import javax.swing.WindowConstants;

import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.view.BoardView;
import sixesWild.view.CompleteLevelView;
import sixesWild.view.SelectLevelView;

public class CompleteLevelController 
{
	Model m;
	BoardView bv;
	
	public CompleteLevelController(Model m, BoardView bv)
	{
		this.m = m;
		this.bv = bv;
	}
	
	public void process()
	{
		SelectLevelView slv = new SelectLevelView(m);
		CompleteLevelView clv = new CompleteLevelView(m);		
		//clv.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		if(m.getBoard() instanceof PuzzleBoard)
		{
			PuzzleBoard pb = (PuzzleBoard)(m.getBoard());
			//If there is not move left.
			if(pb.getMoveLeft() == 0)
			{
				clv.setVisible(true);
				bv.setVisible(false);
				//If the score is less than 1-star score.
				if(pb.getCurrScore() < pb.getStarScore().get(0))
				{
					//handle the loose condition.
				}
				else
				{
					//Handle unlock level here!!!!!!!
					
				}
			}
		}
		
		
	}
}
