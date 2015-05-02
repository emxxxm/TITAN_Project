package sixesWild.model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
		File file=new File(levelBuilderFilePath);
		BufferedReader reader=null;
		try
		{
			reader=new BufferedReader(new FileReader(file));
			String text=null;
			text=reader.readLine();
			while(text!=null)
			{
				fileString.add(text);
				text=reader.readLine();
			}
			System.out.println(fileString.get(0));
			numLevels=Integer.parseInt(fileString.get(0));	
			for(int cnt=0; cnt<numLevels; cnt++)
			{
				starGoals = new ArrayList<Integer>();
				numFrequency = new ArrayList<Integer>();
				multiFrequency = new ArrayList<Integer>();
				squareType = new ArrayList<Integer>();
				tileNum = new ArrayList<Integer>();
				tileMulti = new ArrayList<Integer>();
				//Assume the data block for 1 level takes 5 lines.
				int levelNum=Integer.parseInt(fileString.get(1+11*cnt));
				int moveLimit=Integer.parseInt(fileString.get(2+11*cnt));
				int timeLimit=Integer.parseInt(fileString.get(3+11*cnt));
				int swapLimit=Integer.parseInt(fileString.get(4+11*cnt));
				int removeLimit=Integer.parseInt(fileString.get(5+11*cnt));
				String[] starGoalsArray=fileString.get(6+11*cnt).split(" ");
				String[] numFrequencyArray=fileString.get(7+11*cnt).split(" ");
				String[] multiFrequencyArray=fileString.get(8+11*cnt).split(" ");
				String[] squareTypeArray=fileString.get(9+11*cnt).split(" ");
				String[] tileNumArray=fileString.get(10+11*cnt).split(" ");
				String[] tileMultiArray=fileString.get(11+11*cnt).split(" ");
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
				for(int i=0;i<tileNumArray.length;i++)
				{				
					tileNum.add(Integer.parseInt(tileNumArray[i]));
				}
				for(int i=0;i<tileMultiArray.length;i++)
				{
					tileMulti.add(Integer.parseInt(tileMultiArray[i]));
				}
				System.out.println(squareType.size());
				//Lock is read in from other file later. It is set to false for now.
				levels.add(new Level(levelNum, 0, moveLimit, timeLimit, swapLimit, removeLimit, starGoals, numFrequency, multiFrequency, squareType, tileNum, tileMulti));
			}
			System.out.println("Here");
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
	}
	
	public int getNumLevels()
	{
		return this.numLevels;
	}
	
	public Level getGivenLevel(int levelNum)
	{
		return levels.get(levelNum-1);
	}
}
