package sixesWild.controller.moves;

import java.util.ArrayList;

import sixesWild.model.Model;
import sixesWild.model.Square;

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
//		System.out.print(row+" ");
//		System.out.print(col+"\n");
		ArrayList<Square> s=model.getBoard().getSelectedSquares();
		int i=0;
//		//Check whether the square has already been added.
//		for(i=0;i<s.size();i++)
//		{
//			if(model.getBoard().getSquare(newRow, col).equals(s.get(i)))
//			{
//				return false;
//			}
//		}
		//If the new square is on the same col with the last col, return true.
		if(newRow==lastRow || newCol==lastCol)
		{
			return true;
		}
		
		//Check for validation here!!
		//System.out.println("The square recorded: "+s.get(0).getTile().getNum());
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(this.isValid())
		{
			model.getBoard().addSelectedSquare(model.getBoard().getSquare(newRow, newCol));
			return true;
		}
		else
		{
			return false;
		}
	}

}
