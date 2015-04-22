package sixesWild.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Model 
{	
	//Tile keeps the num and the multi.
	//Square keeps a tile and Board has an ArrayList of squares.
	//This is the skeleton for entity.
	protected AllLevel allLevels;
	protected Board board;
//	
//	//These are for temperary use, will be changed later.
//	protected ArrayList<Integer> squareType;
//	protected ArrayList<Integer> squareNum;
//	protected ArrayList<Integer> squareMulti;
//	protected ArrayList<Color> squareCol;
	//initialize
	//Make up some square types. 
	//Model is initialized at the start of the launch class in default package.
	public Model(AllLevel allLevels, Board board)
	{
		this.allLevels=allLevels;
		this.board=board;
//		levels
//		this.setSquareType();
//		this.setSquareNum();
//		this.setSquareMulti();
//		this.setSquareColor();
	}
	
	public AllLevel getAllLevels()
	{
		return allLevels;
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public void setBoard(Board newBoard)
	{
		this.board=newBoard;
		return;
	}
}
	
/*	public void setSquareType()
//	{
//		Random r = new Random();
//		squareType=new ArrayList<Integer>(81);
//		for(int i=0;i<81;i++)
//		{
//			int k=r.nextInt(30);
//			if(k<20)
//			{
//				squareType.add(1);
//			}
//			else if(k<25)
//			{
//				squareType.add(2);
//			}
//			else
//			{
//				squareType.add(0);
//			}
//			
//		}
//		return;
//	}
//	
//	public ArrayList<Integer> getSquareType()
//	{
//		return this.squareType;
//	}
//	
//	//Make up some numbers in tile.
//	public void setSquareNum()
//	{
//		Random r = new Random();
//		squareNum=new ArrayList<Integer>(81);
//		for(int i=0;i<81;i++)
//		{
//			squareNum.add(r.nextInt(6)+1);
//		}
//		return;
//	}
//	
//	public ArrayList<Integer> getSquareNum()
//	{
//		return this.squareNum;
//	}
//	
//	//Make up some multi for tiles.
//	public void setSquareMulti()
//	{
//		Random r = new Random();
//		squareMulti=new ArrayList<Integer>(81);
//		for(int i=0;i<81;i++)
//		{
//			squareMulti.add(r.nextInt(2)+1);
//		}
//		return;
//	}
//	
//	public ArrayList<Integer> getSquareMulti()
//	{
//		return this.squareMulti;
//	} 
//	
//	
//	//Function to temperately generate colors. There colors will be further read in from levelBuilder.
//	public void setSquareColor()
//	{
//		//Add 6 colors to represent 6 numbers, the other 2 colors represents the dead square and the bucket.
//		ArrayList<Color> c=new ArrayList<Color>(8);
//		
//		Random rand=new Random();
//		for(int i=0;i<8;i++)
//		{
//			float r=rand.nextFloat();
//			float g=rand.nextFloat();
//			float b=rand.nextFloat();
//			
//			c.add(new Color(r,g,b));
//		}
//		
//		squareCol = new ArrayList<Color>(81);
//		
//		for(int i=0;i<81;i++)
//		{
//			//If the square is a background.
//			if(squareType.get(i) == 0)
//			{
//				squareCol.add(c.get(6));
//			}
//			//If the square is a bucket.
//			else if(squareType.get(i) == 2)
//			{
//				squareCol.add(c.get(7));
//			}
//			else
//			{
//				if(squareNum.get(i)==1)
//				{
//					squareCol.add(c.get(0));
//				}
//				else if(squareNum.get(i)==2)
//				{
//					squareCol.add(c.get(1));
//				}
//				else if(squareNum.get(i)==3)
//				{
//					squareCol.add(c.get(2));
//				}
//				else if(squareNum.get(i)==4)
//				{
//					squareCol.add(c.get(3));
//				}
//				else if(squareNum.get(i)==5)
//				{
//					squareCol.add(c.get(4));
//				}
//				else
//				{
//					squareCol.add(c.get(5));
//				}
//			}
//		}
//				
//		return;
//	}
//	
//	public ArrayList<Color> getSquareCol()
//	{
//		return this.squareCol;
//	}
}*/
