package sixesWild.model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
 * If we drag outside the panel, we need to through an exception.
 */

public class AllLevel 
{
	ArrayList<Level> levels;
	int numLevels;
	
//	public static void main(String[] args) throws Exception
//	{
//		AllLevel als=new AllLevel("src/input.txt", "/home/mengwen/Desktop/stateInput.txt");
//	}
	//levelBuilderFilePath stores information gets from level builder. levelStateFilePath stores information about level lock unlock
	//and highest score.
	public AllLevel(String levelBuilderFilePath, String levelStateFilePath) throws Exception
	{
		/* 
 			public Level(int levelNum, boolean locked, int moveLimit, int timeLimit, int swapLimit, int removeLimit, int[] starGoals, 
			ArrayList<Integer> squareType, 
			ArrayList<Integer> tileNum,
			ArrayList<Integer> tileMulti) 
		 */
		//First read in the number of levels, then, use a for loop to create all the levels and store them in an array.
		//levels[0]=new Level(0, false, numLevels, numLevels, numLevels, numLevels, null, null, null, null);
		levels=new ArrayList<Level>();
		ArrayList<Integer> locked;
		ArrayList<Integer> starGoals;
		ArrayList<Integer> numFrequency;
		ArrayList<Integer> multiFrequency;
		ArrayList<Integer> squareType;
		ArrayList<Integer> tileNum;
		ArrayList<Integer> tileMulti;
		ArrayList<String> stateString = new ArrayList<String>();
		File lockFile = new File(levelStateFilePath);
		BufferedReader r = null;
		ArrayList<String> fileString = new ArrayList<String>();
		BufferedReader reader=null;
		try
		{
			//Initialize ArrayList and int here.
			starGoals = new ArrayList<Integer>();
			numFrequency = new ArrayList<Integer>();
			multiFrequency = new ArrayList<Integer>();
			squareType = new ArrayList<Integer>();
			tileNum = new ArrayList<Integer>();
			tileMulti = new ArrayList<Integer>();
			int levelNum;
			int moveLimit;
			int timeLimit;
			int swapLimit;
			int removeLimit;
			//First read in the first level to determine the number of levels.
			File file = new File(levelBuilderFilePath + "level" + 1);
			reader=new BufferedReader(new FileReader(file));
			String text=null;
			text=reader.readLine();
			while(text!=null)
			{
				fileString.add(text);
				text=reader.readLine();
			}
			numLevels=Integer.parseInt(fileString.get(0));
			System.out.println("numLevels is "+numLevels);
			levelNum=Integer.parseInt(fileString.get(1));
			moveLimit=Integer.parseInt(fileString.get(2));
			timeLimit=Integer.parseInt(fileString.get(3));
			swapLimit=Integer.parseInt(fileString.get(4));
			removeLimit=Integer.parseInt(fileString.get(5));
			String[] starGoalsArray=fileString.get(6).split(" ");
			String[] numFrequencyArray=fileString.get(7).split(" ");
			String[] multiFrequencyArray=fileString.get(8).split(" ");
			String[] squareTypeArray=fileString.get(9).split(" ");
			for(int i=0;i<starGoalsArray.length;i++)
			{
				starGoals.add(Integer.parseInt(starGoalsArray[i]));
			}
			for(int i=0;i<numFrequencyArray.length;i++)
			{
				numFrequency.add(Integer.parseInt(numFrequencyArray[i]));
			}
			for(int i=0;i<multiFrequencyArray.length;i++)
			{
				multiFrequency.add(Integer.parseInt(multiFrequencyArray[i]));
			}
			for(int i=0;i<squareTypeArray.length;i++)
			{
				squareType.add(Integer.parseInt(squareTypeArray[i]));
			}
			for(int i=0;i<squareTypeArray.length;i++)
			{				
				if(squareType.get(i)==1)
				{
					tileNum.add(this.getNewNum(numFrequency));
				}
				else
				{
					tileNum.add(0);
				}
			}
			for(int i=0;i<squareTypeArray.length;i++)
			{
				if(squareType.get(i)==1)
				{
					tileMulti.add(this.getNewMulti(multiFrequency));
				}
				else
				{
					tileMulti.add(0);
				}
			}
			levels.add(new Level(levelNum, 0, moveLimit, timeLimit, swapLimit, removeLimit, starGoals, numFrequency, multiFrequency, squareType, tileNum, tileMulti));
			for(int cnt=2; cnt<=numLevels; cnt++)
			{
				starGoals = new ArrayList<Integer>();
				numFrequency = new ArrayList<Integer>();
				multiFrequency = new ArrayList<Integer>();
				squareType = new ArrayList<Integer>();
				tileNum = new ArrayList<Integer>();
				tileMulti = new ArrayList<Integer>();
				System.out.println("cnt is "+cnt);
				System.out.println("In for loop");
				file = new File(levelBuilderFilePath + "level" + cnt);
				System.out.println(file);
				reader=new BufferedReader(new FileReader(file));
				fileString.clear();
				text=reader.readLine();
				while(text!=null)
				{
					fileString.add(text);
					text=reader.readLine();
				}
				levelNum=Integer.parseInt(fileString.get(1));
				System.out.println(levelNum+"~~~~~~~~~~~~~~~~");
				moveLimit=Integer.parseInt(fileString.get(2));
				System.out.println("moveLimit "+moveLimit);
				timeLimit=Integer.parseInt(fileString.get(3));
				swapLimit=Integer.parseInt(fileString.get(4));
				removeLimit=Integer.parseInt(fileString.get(5));
				starGoalsArray=fileString.get(6).split(" ");
				numFrequencyArray=fileString.get(7).split(" ");
				multiFrequencyArray=fileString.get(8).split(" ");
				System.out.println(fileString.get(9));
				squareTypeArray=fileString.get(9).split(" ");
				
				
				for(int i=0;i<starGoalsArray.length;i++)
				{
					starGoals.add(Integer.parseInt(starGoalsArray[i]));
				}
				for(int i=0;i<numFrequencyArray.length;i++)
				{
					numFrequency.add(Integer.parseInt(numFrequencyArray[i]));
				}
				for(int i=0;i<multiFrequencyArray.length;i++)
				{
					multiFrequency.add(Integer.parseInt(multiFrequencyArray[i]));
				}
				for(int i=0;i<squareTypeArray.length;i++)
				{
					//System.out.println(squareTypeArray[i]);
					squareType.add(Integer.parseInt(squareTypeArray[i]));
				}
				for(int i=0;i<squareTypeArray.length;i++)
				{				
					if(squareType.get(i)==1)
					{
						tileNum.add(this.getNewNum(numFrequency));
					}
					else
					{
						tileNum.add(0);
					}
				}
				for(int i=0;i<squareTypeArray.length;i++)
				{
					if(squareType.get(i)==1)
					{
						tileMulti.add(this.getNewMulti(multiFrequency));
					}
					else
					{
						tileMulti.add(0);
					}
				}
				System.out.println(fileString.get(9));
				System.out.println(levelNum);
				if(levelNum%4==0)
				{
					String[] sixPositionArray = fileString.get(10).split(" ");
					ArrayList<Integer> row = new ArrayList();
					ArrayList<Integer> col = new ArrayList();
					
					for(int i=0; i<sixPositionArray.length;i+=2)
					{
						row.add(Integer.parseInt(sixPositionArray[i]));
						col.add(Integer.parseInt(sixPositionArray[i+1]));
					}
					
					for(int i=0; i<row.size(); i++)
					{
						tileNum.set(row.get(i)*9+col.get(i), 6);
					}
				}
				levels.add(new Level(levelNum, 0, moveLimit, timeLimit, swapLimit, removeLimit, starGoals, numFrequency, multiFrequency, squareType, tileNum, tileMulti));
				System.out.println(cnt);
				
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			System.out.println("IOException!");
			e.printStackTrace();
		}
		//Read lock or unlock.
		try
		{
			locked = new ArrayList<Integer>();
			r = new BufferedReader(new FileReader(lockFile));
			String text=null;
			text=r.readLine();
			stateString.add(text);
			System.out.println(stateString.get(0));
			String[] lockArray=stateString.get(0).split(" ");
			for(int i=0;i<numLevels;i++)
			{
				locked.add(Integer.parseInt(lockArray[i]));
			}
			for(int i=0;i<numLevels;i++)
			{
				levels.get(i).setLocked(locked.get(i));
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			System.out.println("IOException!");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(reader!=null && r!=null)
				{
					reader.close();
					r.close();
				}
			}
			catch(IOException e)
			{
			}
		}
		Level l = levels.get(1);
		System.out.println("**********************************************************************");
		System.out.println(l.getLevelNum());
		for(int i=0; i<l.getSquareType().size();i++)
		{
			System.out.println(l.getSquareType().get(i));
		}
	}
	public int getNumLevels()
	{
		return this.numLevels;
	}
	
	public Level getGivenLevel(int levelNum)
	{		
		return levels.get(levelNum-1);
	}
	
	public int getNewNum(ArrayList<Integer> numFrequency)
	{
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
	public int getNewMulti(ArrayList<Integer> multiFrequency)
	{
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
