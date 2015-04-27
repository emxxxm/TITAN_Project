package sixesWild.controller;

import sixesWild.controller.moves.ResetMove;
import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.view.BoardView;

public class ResetController
{
	Model model;
	BoardView bv;
	
	public ResetController(Model model, BoardView bv)
	{
		this.model=model;
		this.bv=bv;
	}
	
	public boolean process() {
		ResetMove m = new ResetMove(model);
		if(m.doMove())
		{
			bv.getPlayPanel().repaint();
			if(model.getBoard() instanceof PuzzleBoard)
			{
				bv.getMoveLeftLabel().setText("Move Left: "+((PuzzleBoard)(model.getBoard())).getMoveLeft());
			}
			return true;
		}
		return false;
	}

}
