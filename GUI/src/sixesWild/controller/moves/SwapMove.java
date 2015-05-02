package sixesWild.controller.moves;

import java.util.ArrayList;
import java.util.Collections;

import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.ReleaseBoard;
import sixesWild.model.Square;

public class SwapMove extends AbsMove
{
	Model model;
	
	public SwapMove(Model model)
	{
		this.model = model;
	}
	
	@Override
	public boolean isValid() {
		ArrayList<Square> selectedSquares = model.getBoard().getSelectedSquares();
		//If the number of selectedSquares equals 2, it is valid.
		if(selectedSquares.size()==2 && model.getBoard().getSwapLeft()>0)
		{
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean doMove() 
	{
		// TODO Auto-generated method stub
		ArrayList<Square> selectedSquares = model.getBoard().getSelectedSquares(); 
		//Decrease SwapMove Left here.
		//According to row in decending order.
		if(isValid())
		{
			Square s1=selectedSquares.get(0);
			Square s2=selectedSquares.get(1);
			int numS1 = s1.getTile().getNum();
			int multiS1 = s1.getTile().getMulti();
			int numS2 = s2.getTile().getNum();
			int multiS2 = s2.getTile().getMulti();
			model.getBoard().getSquare(s1.getRow(), s1.getCol()).getTile().setNum(numS2);
			model.getBoard().getSquare(s1.getRow(), s1.getCol()).getTile().setMulti(multiS2);
			model.getBoard().getSquare(s2.getRow(), s2.getCol()).getTile().setNum(numS1);
			model.getBoard().getSquare(s2.getRow(), s2.getCol()).getTile().setMulti(multiS1);
			if(model.getBoard().getSwapLeft()>0)
			{
				model.getBoard().setSwapLeft(-1);
			}
			if(model.getBoard() instanceof ReleaseBoard)
			{
				ReleaseBoard rb = (ReleaseBoard)model.getBoard();
				rb.updateBucket(s1.getCol());
				rb.updateBucket(s2.getCol());
			}
			return true;
		}
		else
		{
			if(model.getBoard().getSwapLeft()>0)
			{
				model.getBoard().setSwapLeft(-1);
			}
			return false;
		}
	}
}

