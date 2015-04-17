package sixesWild.model;

import java.awt.Color;
import java.util.ArrayList;

public class Level 
{
	//Highest score stores in the same place with lock state.
	protected int levelNum;
	//Mode can be calculated by levelNum.
	//true represents locked.
	protected boolean locked;
	protected int moveLimit;
	protected int timeLimit;
	protected int swapLimit;
	protected int removeLimit;
	protected int[] starGoals;
	//Represents the type of the square,
	//0: Disable
	//1: Normal
	//2: Bucket
	//The position of 6 in tileNum should be on the same col with buckets in squareType.
	protected ArrayList<Integer> squareType;
	protected ArrayList<Integer> tileNum;
	protected ArrayList<Integer> tileMulti;
	
	public Level(int levelNum, 
			boolean locked, 
			int moveLimit, 
			int timeLimit, 
			int swapLimit, 
			int removeLimit, 
			int[] starGoals, 
			ArrayList<Integer> squareType, 
			ArrayList<Integer> tileNum,
			ArrayList<Integer> tileMulti)
	{
		this.levelNum=levelNum;
		this.locked=locked;
		this.moveLimit=moveLimit;
		this.timeLimit=timeLimit;
		this.swapLimit=swapLimit;
		this.removeLimit=removeLimit;
		this.starGoals=starGoals;
		this.squareType=squareType;
		this.tileNum=tileNum;
		this.tileMulti=tileMulti;
	}
	//Getters.
	public int getRemoveLimit()
	{
		return this.removeLimit;
	}
	
	public int getMoveLimit()
	{
		return this.moveLimit;
	}
	
	public int getTimeLimit()
	{
		return this.timeLimit;
	}
	
	public int getSwapLimit()
	{
		return this.swapLimit;
	}
	
	public ArrayList<Integer> getTileNum()
	{
		return this.tileNum;
	}
	
	public ArrayList<Integer> getTileMulti()
	{
		return this.tileMulti;
	}
	
	public ArrayList<Integer> getSquareType() 
	{
		// TODO Auto-generated method stub
		return this.squareType;
	}
	
	public boolean isLocked()
	{
		return !locked;
	}

	//Store the unlock state in a seperate file.
	public void setLocked(boolean newState)
	{
		this.locked=newState;
		return;
	}
	
	public boolean changeBucketType(int row, int col)
	{
		
		return true;
	}
	
	
}
