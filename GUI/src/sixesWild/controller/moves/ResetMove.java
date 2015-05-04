package sixesWild.controller.moves;

import java.util.ArrayList;
import java.util.Random;

import sixesWild.model.EliminationBoard;
import sixesWild.model.LightningBoard;
import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.ReleaseBoard;
import sixesWild.model.Square;

public class ResetMove extends AbsMove
{
	Model model;
	
	public ResetMove(Model model)
	{
		this.model = model;
	}
	
	@Override
	public boolean isValid() {
		if(model.getBoard() instanceof PuzzleBoard)
		{
			PuzzleBoard pb = (PuzzleBoard)model.getBoard();
			if(pb.getMoveLeft()>0)
			{
				return true;
			}
		}
		else if(model.getBoard() instanceof LightningBoard || model.getBoard() instanceof ReleaseBoard)
		{
			return true;
		}
		else
		{
			EliminationBoard eb = (EliminationBoard)model.getBoard();
			if(eb.getMoveLeft() > 0)
			{
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean doMove() 
	{
		// TODO Auto-generated method stub
		if(isValid())
		{
			if(model.getBoard() instanceof PuzzleBoard)
			{
//				if(((PuzzleBoard)(model.getBoard())).getMoveLeft() > 0)
//				{
					((PuzzleBoard)(model.getBoard())).updateMoveLeft(-1);
//				}
			}
			if(model.getBoard() instanceof EliminationBoard)
			{
//				if(((EliminationBoard)(model.getBoard())).getMoveLeft() > 0)
//				{
					((EliminationBoard)(model.getBoard())).updateMoveLeft(-1);
//				}
			}
			if(model.getBoard() instanceof ReleaseBoard)
			{
				for(int i=0; i<model.getBoard().getSquareType().size(); i++)
				{
					if(model.getBoard().getSquareType().get(i)==1 && model.getBoard().getSquare(i/9, i%9).getTile().getNum()!=6)
					{
						model.getBoard().getSquare(i/9, i%9).getTile().setNum(getNewNum());
						model.getBoard().getSquare(i/9, i%9).getTile().setMulti(getNewMulti());
					}
				}
			}
			else
			{
				for(int i=0; i<model.getBoard().getSquareType().size(); i++)
				{
					if(model.getBoard().getSquareType().get(i)==1)
					{
						model.getBoard().getSquare(i/9, i%9).getTile().setNum(getNewNum());
						model.getBoard().getSquare(i/9, i%9).getTile().setMulti(getNewMulti());
					}
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Get the falling number according to the numFrequency.
	 * @author Mengwen Li, Yihong Zhou
	 * @param numFrequency
	 * @return
	 */
	public int getNewNum()
	{
		int currLevel = model.getBoard().getCurrLevel();
		ArrayList<Integer> numFrequency = model.getAllLevels().getGivenLevel(currLevel).getNumFrequency();
		Random random = new Random();
		System.out.println(numFrequency.get(0)+" "+numFrequency.get(1)+" "+numFrequency.get(2));
		int num = random.nextInt(100)+1;
		System.out.println(num);
		int numSet=0;
		if(num<=numFrequency.get(0))
		{
			numSet=1;
		}
		else if(num <= numFrequency.get(0)+numFrequency.get(1))
		{
			numSet=2;
		}
		else if(num <= numFrequency.get(0)+numFrequency.get(1)+numFrequency.get(2))
		{
			numSet=3;
		}
		else if(num <= numFrequency.get(0)+numFrequency.get(1)+numFrequency.get(2)+numFrequency.get(3))
		{
			numSet=4;
		}
		else if(num <= numFrequency.get(0)+numFrequency.get(1)+numFrequency.get(2)+numFrequency.get(3)+numFrequency.get(4))
		{
			numSet=5;
		}
		else
		{
			numSet=6;
		}
		return numSet;
	}
	
	/**
	 * Get the falling multi according to the multiFrequency.
	 * @author Mengwen Li, Yihong Zhou
	 * @param numFrequency
	 * @return
	 */
	public int getNewMulti()
	{
		int currLevel = model.getBoard().getCurrLevel();
		ArrayList<Integer> multiFrequency = model.getAllLevels().getGivenLevel(currLevel).getMultiFrequency();
		Random random = new Random();
		int multi = random.nextInt(100)+1;
		int multiSet=0;
		if(multi<=multiFrequency.get(0))
		{
			multiSet=1;
		}
		else if(multi <= multiFrequency.get(0)+multiFrequency.get(1))
		{
			multiSet=2;
		}
		else if(multi <= multiFrequency.get(0)+multiFrequency.get(1)+multiFrequency.get(2))
		{
			multiSet=3;
		}
		return multiSet;
	}
}