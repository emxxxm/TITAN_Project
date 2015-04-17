package sixesWild.model;

import java.util.ArrayList;

public class Board
{
	//This should be an ArrayList of square.
	protected ArrayList<Square> squares;
	protected int removeLeft;
	protected int swapLeft;
	protected int currScore;
	//Build a board from a given level.
	public Board(Level level)
	{
		//Construct tiles first.
		//Then, square, then board.
		for(int i=0; i<81; i++)
		{
			Tile newTile=new Tile(level.getTileNum().get(i), level.getTileMulti().get(i));
			Square newSquare=new Square(newTile, i/9, i%9, level.getSquareType().get(i));
			squares.add(newSquare);
		}
		this.removeLeft=level.getRemoveLimit();
		this.swapLeft=level.getSwapLimit();
		this.currScore=0;
	}
	
	
}
