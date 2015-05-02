package sixesWild.model;

import java.util.Comparator;

public class Square implements Comparable
{
	protected Tile tile;
	protected int row;
	protected int col;
	//Is this correct? 
	protected int type;
	protected int isMarked = 0;
	
	public Square()
	{
		this.tile = null;
		this.row=0;
		this.col=0;
		this.type=0;
	}
	
	public Square(Tile tile, int row, int col, int type)
	{
		this.tile=tile;
		this.row=row;
		this.col=col;
		this.type=type;
	}
	
	public boolean isFilled()
	{
		if(this.type!=2)
		{
			return false;
		}
		if(this.getTile().getNum()==6)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean setMarked(int mark)
	{
		if(mark < 0)
		{
			return false;
		}
		this.isMarked = mark;
		return true;
	}
	
	public int getIsMarked()
	{
		return this.isMarked;
	}
	
	public int getType()
	{
		return this.type;
	}
	
	public Tile getTile()
	{
		return this.tile;
	}
	
	public int getRow()
	{
		return this.row;
	}
	
	public int getCol()
	{
		return this.col;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Square)
		{
			Square s = (Square)o; 
			if(s.getRow()==this.row && s.getCol()==this.col)
			{
				return true;
			}
		}
		return false;
		
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int inputRow = ((Square)o).getRow();
		return inputRow-this.row;
	}
}
