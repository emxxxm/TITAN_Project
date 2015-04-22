package sixesWild.model;

import java.util.ArrayList;

public class Board
{
	//This should be an ArrayList of square.
	protected ArrayList<Square> squares;
	protected ArrayList<Square> selectedSquares;
	protected int currLevel;
	protected int removeLeft;
	protected int swapLeft;
	protected int currScore;
	//Build a board from a given level.
	public Board(Level level)
	{
		//Construct tiles first.
		//Then, square, then board.
		squares = new ArrayList<Square>();
		selectedSquares = new ArrayList<Square>();
		System.out.println("Board: "+level.getSquareType().size());
		for(int i=0; i<level.getSquareType().size(); i++)
		{
			Tile newTile=new Tile(level.getTileNum().get(i), level.getTileMulti().get(i));
			Square newSquare=new Square(newTile, i/9, i%9, level.getSquareType().get(i));
			squares.add(newSquare);
		}
		this.currLevel = level.getLevelNum();
		this.removeLeft=level.getRemoveLimit();
		this.swapLeft=level.getSwapLimit();
		this.currScore=0;
	}
	public Square getSquare(int row, int col)
	{
		return squares.get(9*row+col);
	}
	public ArrayList<Square> getSelectedSquares()
	{
		return this.selectedSquares;
	}
	
	public void addSelectedSquare(Square s)
	{
		this.selectedSquares.add(s);
		return;
	}
	
	public int getCurrLevel()
	{
		return this.currLevel;
	}
	
	public int getRemoveLeft()
	{
		return this.removeLeft;
	}
	
	public int getSwapLeft()
	{
		return this.swapLeft;
	}
	
	public int getCurrScore()
	{
		return this.currScore;
	}
	
	public ArrayList<Integer> getSquareType()
	{
		ArrayList<Integer> squareType = new ArrayList<Integer>();
		for(int i=0;i<squares.size();i++)
		{
			squareType.add(squares.get(i).getType());
		}
		return squareType;
	}
	
	public ArrayList<Integer> getTileNum()
	{
		ArrayList<Integer> tileNum = new ArrayList<Integer>();
		for(int i=0;i<squares.size();i++)
		{
			tileNum.add(squares.get(i).getTile().getNum());
		}
		return tileNum;
	}
	
	public ArrayList<Integer> getTileMulti()
	{
		ArrayList<Integer> tileMulti = new ArrayList<Integer>();
		for(int i=0;i<squares.size();i++)
		{
			tileMulti.add(squares.get(i).getTile().getMulti());
		}
		return tileMulti;
	}
}
