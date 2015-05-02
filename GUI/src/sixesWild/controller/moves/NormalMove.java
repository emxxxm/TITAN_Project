package sixesWild.controller.moves;

import java.util.ArrayList;

import sixesWild.model.Model;
import sixesWild.model.Square;
/**
 * This move provides basic selecting function.
 * @author Yihong Zhou, Mengwen Li
 *
 */
public class NormalMove extends AbsMove
{
	protected Model model;
	protected int newRow;
	protected int newCol;
	protected int lastRow;
	protected int lastCol;
	
	public NormalMove(Model model, int newRow, int newCol, int lastRow, int lastCol)
	{
		this.model=model;
		this.newCol=newCol;
		this.newRow=newRow;
		this.lastCol=lastCol;
		this.lastRow=lastRow;
	}
	@Override
	public boolean isValid() 
	{
		//Handle the condition that the mouse moves out of bound.
		if(newCol == -1 || newRow == -1)
		{
			return false;
		}
		//If the new square is on the same col with the last col, return true.
		if(newRow==lastRow || newCol==lastCol)
		{
			//If the square type is not ordinary square.
			if(model.getBoard().getSquare(newRow, newCol).getType()!=1)
			{
				return false;
			}
			return true;
		}
		//System.out.println("The square recorded: "+s.get(0).getTile().getNum());
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(this.isValid())
		{
			//Have to check whether this square has existed in the selected squares.
			//System.out.println(newRow + " "+ newCol);
			int i=0;
			for(i=0;i<model.getBoard().getSelectedSquares().size();i++)
			{
				if(model.getBoard().getSquare(newRow, newCol).equals(model.getBoard().getSelectedSquares().get(i)))
				{
					break;
				}
			}
			if(i == model.getBoard().getSelectedSquares().size())
			{
				model.getBoard().addSelectedSquare(model.getBoard().getSquare(newRow, newCol));
			}
			if(this.isValid())
			{
				return true;
			}
			return false;
		}
		else
		{
			return false;
		}
	}

}
