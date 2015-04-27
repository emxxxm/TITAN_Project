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
	//initialize
	//Make up some square types. 
	//Model is initialized at the start of the launch class in default package.
	public Model(AllLevel allLevels, Board board)
	{
		this.allLevels=allLevels;
		this.board=board;
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