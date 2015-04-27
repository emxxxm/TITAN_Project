package sixesWild.controller.moves;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.Square;

public class UpdateTileMove extends AbsMove
{
	Model model;
	
	public UpdateTileMove(Model model)
	{
		this.model = model;
	}
	
	@Override
	public boolean isValid() {
		ArrayList<Square> selectedSquares = model.getBoard().getSelectedSquares();
		//If the sum of all squares in selected squares is greater than 6, return false.
		int sum=0;
		if(model.getBoard() instanceof PuzzleBoard)
		{
			if(((PuzzleBoard)(model.getBoard())).getMoveLeft() <= 0)
			{
				return false;
			}
		}
		for(int i=0;i<selectedSquares.size();i++)
		{
			if(selectedSquares.get(i).getTile().getNum()==6)
			{
				return false;
			}
			sum+=selectedSquares.get(i).getTile().getNum();
		}
		if(sum!=6)
		{
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean doMove() 
	{
		// TODO Auto-generated method stub
		ArrayList<Square> selectedSquares = model.getBoard().getSelectedSquares(); 
		//Decrease moveLeft.
		//According to row in decending order.
		Collections.sort(selectedSquares);
		for(int i=0; i<selectedSquares.size();i++)
		{
			System.out.println(selectedSquares.get(i).getRow());
		}
		if(this.isValid())
		{
			//Update score before updating squares.
			int addScore = 0;
			for(int i=0; i<selectedSquares.size(); i++)
			{
				addScore += 10*selectedSquares.get(i).getTile().getMulti();
			}
			model.getBoard().setCurrScore(addScore);
			//Search all the squares in selected square.
			for(int i=0; i<selectedSquares.size(); i++)
			{
				int col = selectedSquares.get(i).getCol();
				System.out.println("Col is "+col);
				//Search all the squares in the same column with the current selected square.
				for(int j = selectedSquares.get(i).getRow(); j>=0; j--)
				{
					if(j==0)
					{
						System.out.println("In j == 0");
						model.getBoard().getSquare(j,col).getTile().setNum(this.getNewNum());
						model.getBoard().getSquare(j,col).getTile().setMulti(this.getNewMulti());
					}
					else
					{
						int k;
						//Find the next valid square.
						System.out.println("j is "+j);
						for(k=j-1; k>=0; k--)
						{
							System.out.println(k);
							if(model.getBoard().getSquare(k, col).getType()==1)
							{
								if(this.notSelected(model.getBoard().getSquare(k, col)))
								{
									System.out.println(model.getBoard().getSquare(k,col).getTile().getNum());	
									model.getBoard().getSquare(j,col).getTile().setNum(model.getBoard().getSquare(k,col).getTile().getNum());
									model.getBoard().getSquare(j,col).getTile().setMulti(model.getBoard().getSquare(k,col).getTile().getMulti());
									System.out.println("k is "+k);
									System.out.println(k++);
									j = k;
									break;
								}								
							}
						}
						//If all the squares on top of the selected squares are not valid, drop a number in the selected square.
						if(k==-1)
						{
							model.getBoard().getSquare(j,col).getTile().setNum(this.getNewNum());
							model.getBoard().getSquare(j,col).getTile().setMulti(this.getNewMulti());
							break;
						}
					}					
				}
			}
			if(model.getBoard() instanceof PuzzleBoard)
			{
				if(((PuzzleBoard)(model.getBoard())).getMoveLeft() > 0)
				{
					((PuzzleBoard)(model.getBoard())).updateMoveLeft(-1);
				}
			}
			return true;
		}
		else
		{
			if(model.getBoard() instanceof PuzzleBoard)
			{
				if(((PuzzleBoard)(model.getBoard())).getMoveLeft() > 0)
				{
					((PuzzleBoard)(model.getBoard())).updateMoveLeft(-1);
				}
			}
			return false;
		}
	}
	/**
	 * Check whether the square has been selected or not.
	 * @author Yihong Zhou, Mengwen Li
	 * @param s
	 * @return
	 */
	public boolean notSelected(Square s)
	{
		ArrayList<Square> ss = model.getBoard().getSelectedSquares();
		for(int i=0; i<ss.size(); i++)
		{
			if(s.equals(ss.get(i)))
			{
				return false;
			}
		}
		return true;
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
		int num = random.nextInt(100)+1;
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

	
