package sixesWild.controller.moves;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.Square;

public class RemoveMove extends AbsMove
{
	Model model;
	
	public RemoveMove(Model model)
	{
		this.model = model;
	}
	
	@Override
	public boolean isValid() {
		ArrayList<Square> selectedSquares = model.getBoard().getSelectedSquares();
		//If the number of selectedSquares equals 2, it is valid.
		if(selectedSquares.size()==1 && model.getBoard().getRemoveLeft()>0)
		{
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean doMove() 
	{
		ArrayList<Square> selectedSquares = model.getBoard().getSelectedSquares(); 
		//Decrease moveLeft.
		//According to row in decending order.
		Collections.sort(selectedSquares);
		if(this.isValid())
		{
			System.out.println("In isValid!");
			//Update score before updating squares.
			int addScore = 0;
			for(int i=0; i<selectedSquares.size(); i++)
			{
				addScore += 10*selectedSquares.get(i).getTile().getMulti();
			}
			System.out.println(addScore);
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
						model.getBoard().getSquare(j,col).getTile().setNum(getNewNum());
						model.getBoard().getSquare(j,col).getTile().setMulti(getNewMulti());
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
								System.out.println(model.getBoard().getSquare(k,col).getTile().getNum());	
								model.getBoard().getSquare(j,col).getTile().setNum(model.getBoard().getSquare(k,col).getTile().getNum());
								model.getBoard().getSquare(j,col).getTile().setMulti(model.getBoard().getSquare(k,col).getTile().getMulti());
								System.out.println("k is "+k);
								System.out.println(k++);
								j = k;
								break;								
							}
						}
						//If all the squares on top of the selected squares are not valid, drop a number in the selected square.
						if(k==-1)
						{
							model.getBoard().getSquare(j,col).getTile().setNum(getNewNum());
							model.getBoard().getSquare(j,col).getTile().setMulti(getNewMulti());
							break;
						}
					}					
				}
			}
			//Update remove move count here!
			if(model.getBoard().getRemoveLeft()>0)
			{
				model.getBoard().setRemoveLeft(-1);
			}
			return true;
		}
		else
		{
			//Update remove move count here!
			if(model.getBoard().getRemoveLeft()>0)
			{
				model.getBoard().setRemoveLeft(-1);
			}
			return false;
		}
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
		if(num<numFrequency.get(0))
		{
			numSet=1;
		}
		else if(num < numFrequency.get(0)+numFrequency.get(1))
		{
			numSet=2;
		}
		else if(num < numFrequency.get(0)+numFrequency.get(1)+numFrequency.get(2))
		{
			numSet=3;
		}
		else if(num < numFrequency.get(0)+numFrequency.get(1)+numFrequency.get(2)+numFrequency.get(3))
		{
			numSet=4;
		}
		else if(num < numFrequency.get(0)+numFrequency.get(1)+numFrequency.get(2)+numFrequency.get(3)+numFrequency.get(4))
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
		if(multi<multiFrequency.get(0))
		{
			multiSet=1;
		}
		else if(multi < multiFrequency.get(0)+multiFrequency.get(1))
		{
			multiSet=2;
		}
		else if(multi < multiFrequency.get(0)+multiFrequency.get(1)+multiFrequency.get(2))
		{
			multiSet=3;
		}
		return multiSet;
	}
	
}
